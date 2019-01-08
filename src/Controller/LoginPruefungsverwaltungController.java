package Controller;

import java.util.List;

import DatabaseService.DatabaseService;
import Models.Nutzer;
import Models.Pruefung;
import Models.Student;
import Views.LoginPruefungsverwaltung;
import Views.LoginStudent;
import Views.PruefungView;
import Views.PruefungsverwaltungView;

public class LoginPruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der LoginPruefungsverwaltung-View
	// aufgerufen werden können

	private LoginPruefungsverwaltung view;
	private LoginStudent viewS;

	Pruefung pruefung;
	Nutzer nutzers;

	private List<String> benutzernameListe;
	private List<String> passwoerterListe;

	// Zugriff auf die Datenbank
	DatabaseService db = DatabaseService.getInstance();

	// Konstruktor Professor
	public LoginPruefungsverwaltungController(LoginPruefungsverwaltung view) {
		this.view = view;
	}

	// Konstruktor Student
	public LoginPruefungsverwaltungController(LoginStudent viewS) {
		this.viewS = viewS;
	}

	// Get Benutzer und passwort von textfeld in view von Professor
	public String getBenutzername() {
		try {
			return view.getTFBenutzername().getText();
		} catch (Exception e) {
			return null;
		}
	}

	public String getPasswort() {

		try {
			char[] passwort = view.getTFPasswort().getPassword();
			return String.valueOf(passwort);
		} catch (Exception e) {
			return null;
		}

	}

	public void einloggenDozent() {

		if (getBenutzername() == null || getBenutzername().length() == 0) {
			view.getFehlerLabel().setText("Benutzername oder Passwort darf nicht leer sein!");

		} else if (getPasswort() == null || getPasswort().length() == 0) {
			view.getFehlerLabel().setText("Benutzername oder Passwort darf nicht leer sein!");
		} else {

			try {

				this.db = DatabaseService.getInstance(getBenutzername(), getPasswort());

				PruefungsverwaltungView view = new PruefungsverwaltungView();

			} catch (Exception e) {
				view.getFehlerLabel().setText(
						"Anmeldung fehlgeschlagen! Überprüfe die Verbindung zum FH-Netzwerk!");
			}
		}

	}

	// Get Benutzer und passwort von textfeld in view von Student
	public String getBenutzernameS() {
		try {
			return viewS.getTFBenutzername().getText();
		} catch (Exception e) {
			return null;
		}
	}

	public String getPasswortS() {
		try {
			char[] passwort = viewS.getTFPasswort().getPassword();
			return String.valueOf(passwort);
		} catch (Exception e) {
			return null;
		}
	}

	public int getMatrikelNr() {
		try {
			return Integer.parseInt(viewS.getTFMatrikelNr().getText());
		} catch (Exception e) {
			return 0;
		}
	}

	public void einloggenStudent() {

		if (getBenutzernameS() == null || getBenutzernameS().length() == 0) {
			viewS.getFehlerLabel().setText("Benutzername oder Passwort darf nicht leer sein!");

		} else if (getPasswortS() == null || getPasswortS().length() == 0) {
			viewS.getFehlerLabel().setText("Benutzername oder Passwort darf nicht leer sein!");
		} else if (getMatrikelNr() == 0) {
			viewS.getFehlerLabel().setText("Matrikelnummer darf nicht leer sein!");
		} else {

			try {
				List<Student> studenten = db.readLogin(getMatrikelNr());
				Student student = null;

				if (studenten.size() >= 0) {

					for (Student s : studenten) {
						if (s.getPruefung().isFreigegeben() == true) {
							student = s;
						} else {
							viewS.getFehlerLabel().setText("Die Ihnen zugeteilte Prüfung wurde noch nicht freigegeben!");
						}
					}

					PruefungView pruefungViewS = new PruefungView(student);
					student.setEingeloggt(true);
					db.persistNutzer(student);
					viewS.getLoginStudentFrame().dispose();

				} else {
					viewS.getFehlerLabel().setText("Kein Teilnehmer mit dieser Matrikelnummer gefunden!");
				}
				
			}catch(NullPointerException ex){
				viewS.getFehlerLabel().setText("Die Prüfung ist noch nicht freigegeben!");
			}
			
			catch (Exception e) {
				viewS.getFehlerLabel().setText("Anmeldung fehlgeschlagen! Überprüfe die Verbindung zum FH-Netzwerk!");
			}
		}

	}
}
