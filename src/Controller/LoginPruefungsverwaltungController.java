package Controller;

import java.util.List;

import DatabaseService.DatabaseService;
import Models.Admin;
import Models.Nutzer;
import Models.Pruefung;
import Models.Student;
import Views.LoginPruefungsverwaltung;
import Views.LoginStudent;
import Views.PruefungView;
import Views.PruefungsverwaltungView;

//Victoria Meier
public class LoginPruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der LoginPruefungsverwaltung-View
	// aufgerufen werden können

	private LoginPruefungsverwaltung view;
	private LoginStudent viewS;

	Pruefung pruefung;
	Nutzer nutzers;

	private Admin admin;
	private List<String> benutzernameListe;
	private List<String> passwoerterListe;

	// Zugriff auf die Datenbank
	DatabaseService db;

	// Konstruktor Professor
	public LoginPruefungsverwaltungController(LoginPruefungsverwaltung view) {
		this.view = view;
	}

	// Konstruktor Student
	public LoginPruefungsverwaltungController(LoginStudent viewS) {
		this.viewS = viewS;
	}

	// Get Benutzer und passwort von textfeld in view von Professor

	public void einloggenDozent() {

		String url = null;
		String user = null;
		String pw = null;

		try {
			url = view.getUrlTextField().getText();
		} catch (Exception e) {
			viewS.getFehlerLabel().setText("Bitte URL korrekt ausfüllen");
		}

		try {
			user = view.getUserTextField().getText();
		} catch (Exception e) {
			viewS.getFehlerLabel().setText("Bitte Benutzername korrekt ausfüllen");
		}

		try {
			pw = view.getDbPasswortTextField().getText();
		} catch (Exception e) {
			viewS.getFehlerLabel().setText("Bitte Passwort korrekt ausfüllen");
		}

		if (einloggenDatenbank(url, user, pw, view.getNeueTabellenChkBox().isSelected())) {
			
			this.admin = db.readAdmin();

			if (getPasswort() == null || getPasswort().length() == 0) {
				view.getFehlerLabel().setText("Benutzername oder Passwort darf nicht leer sein!");
			} else if (getPasswort().equals(this.admin.getPasswort()) == false) {
				view.getFehlerLabel().setText("Das angegebene Passwort ist nicht korrekt!");
			} else {

				try {

					this.db = DatabaseService.getInstance();
					view.getFrame().dispose();

					PruefungsverwaltungView view = new PruefungsverwaltungView();

				} catch (Exception e) {
					view.getFehlerLabel()
							.setText("Anmeldung fehlgeschlagen! Überprüfe die Verbindung zum FH-Netzwerk!");
				}
			}
		} else {
			view.getFehlerLabel().setText("Datenbankanmeldung fehlgeschlagen");
		}

	}

	// Get Benutzer und passwort von textfeld in view von Student

	public void einloggenStudent() {

		String url = null;
		String user = null;
		String pw = null;

		try {
			url = viewS.getUrlTextField().getText();
		} catch (Exception e) {
			viewS.getFehlerLabel().setText("Bitte URL korrekt ausfüllen");
		}

		try {
			user = viewS.getBenutzernameTextField().getText();
		} catch (Exception e) {
			viewS.getFehlerLabel().setText("Bitte Benutzername korrekt ausfüllen");
		}

		try {
			pw = viewS.getPasswortTextField().getText();
		} catch (Exception e) {
			viewS.getFehlerLabel().setText("Bitte Passwort korrekt ausfüllen");
		}

		if (einloggenDatenbank(url, user, pw, false)) {

			if (getMatrikelNr() == 0) {
				viewS.getFehlerLabel().setText("Matrikelnummer nicht gefunden - bitte prüfen!");
			} else {

				try {
					List<Student> studenten = db.readLogin(getMatrikelNr());
					Student student = null;

					if (studenten.size() >= 0) {

						for (Student s : studenten) {
							if (s.getPruefung().isFreigegeben() == true && s.isHatAbgegeben() == false) {
								student = s;
							} else {
								viewS.getFehlerLabel()
										.setText("Die Ihnen zugeteilte Prüfung wurde noch nicht freigegeben!");
							}
						}

						PruefungView pruefungViewS = new PruefungView(student);
						student.setEingeloggt(true);
						db.persistNutzer(student);
						viewS.getLoginStudentFrame().dispose();

					} else {
						viewS.getFehlerLabel().setText("Kein Teilnehmer mit dieser Matrikelnummer gefunden!");
					}

				} catch (NullPointerException ex) {
					viewS.getFehlerLabel().setText("Anmeldung fehlgeschlagen!");
				}

				catch (Exception e) {
					viewS.getFehlerLabel()
							.setText("Anmeldung fehlgeschlagen! Überprüfe die Verbindung zum FH-Netzwerk!");
				}
			}

		} else {
			viewS.getFehlerLabel().setText("Datenbankanmeldung fehlgeschlagen");
		}
	}

	public boolean einloggenDatenbank(String url, String user, String pw, boolean neu) {

		String driver = "oracle.jdbc.OracleDriver";

		try {

			this.db = DatabaseService.getInstance(driver, url, user, pw, neu);

		} catch (Exception e) {
			return false;

		}

		if(neu) {
			
			Admin admin = Admin.getInstance();
			db.persistAdmin(admin);
			
		}
		
		return true;

	}

	public String getPasswort() {

		try {
			char[] passwort = view.getTFPasswort().getPassword();
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

}
