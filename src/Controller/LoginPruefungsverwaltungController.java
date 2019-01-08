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
	
	
	String passwort = "examo";

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

	public String getPasswort() {

		try {
			char[] passwort = view.getTFPasswort().getPassword();
			return String.valueOf(passwort);
		} catch (Exception e) {
			return null;
		}

	}

	public void einloggenDozent() {
		
		if (getPasswort() == null || getPasswort().length() == 0) {
			view.getFehlerLabel().setText("Benutzername oder Passwort darf nicht leer sein!");
		} else if(getPasswort().equals(this.passwort) == false){
			view.getFehlerLabel().setText("Das angegebene Passwort ist nicht korrekt!");
		}else {

			try {

				this.db = DatabaseService.getInstance();
				view.getFrame().dispose();

				PruefungsverwaltungView view = new PruefungsverwaltungView();

			} catch (Exception e) {
				view.getFehlerLabel().setText(
						"Anmeldung fehlgeschlagen! Überprüfe die Verbindung zum FH-Netzwerk!");
			}
		}

	}

	// Get Benutzer und passwort von textfeld in view von Student

	public int getMatrikelNr() {
		try {
			return Integer.parseInt(viewS.getTFMatrikelNr().getText());
		} catch (Exception e) {
			return 0;
		}
	}

	public void einloggenStudent() {


		if (getMatrikelNr() == 0) {
			viewS.getFehlerLabel().setText("Matrikelnummer nicht gefunden - bitte prüfen!");
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
