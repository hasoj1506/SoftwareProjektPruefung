package Controller;

import java.util.List;

import javax.swing.JOptionPane;

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


	public void einloggenDozent() {

		String url = null;
		String user = null;
		String pw = null;

		url = view.getUrlTextField().getText();
		user = view.getUserTextField().getText();
		pw = view.getDbPasswortTextField().getText();

		if (url == null || url.length() == 0 || user == null || user.length() == 0 || pw == null || pw.length() == 0) {

			view.getFehlerLabel().setText("Datenbanklogin-Felder müssen ausgefüllt sein");

		} else {

			if (getPasswort() == null || getPasswort().length() == 0) {
				view.getFehlerLabel().setText("Das Passwort darf nicht leer sein");
			} else {

				try {
					if (einloggenDatenbank(url, user, pw, view.getNeueTabellenChkBox().isSelected())) {

						this.admin = db.readAdmin();
						if (getPasswort().equals(this.admin.getPasswort()) == false) {
							
							view.getFehlerLabel().setText("Das angegebene Passwort ist nicht korrekt");
						} else {
							
								this.db = DatabaseService.getInstance();
								view.getFrame().dispose();
								PruefungsverwaltungView view = new PruefungsverwaltungView();
							
						}
					} else {
						view.getFehlerLabel().setText("Datenbankanmeldung fehlgeschlagen");
					}
				} catch (Exception o) {
					view.getFehlerLabel().setText("Datenbankanmeldung fehlgeschlagen");
				}
			}
		}
	}


	public void einloggenStudent() {

		String url = null;
		String user = null;
		String pw = null;
		
		try {

		url = viewS.getUrlTextField().getText();
		user = viewS.getBenutzernameTextField().getText();
		pw = viewS.getPasswortTextField().getText();
		
		}catch(NullPointerException ne) {
			viewS.getFehlerLabel().setText("Datenbanklogin-Felder müssen ausgefüllt sein");
		}

		if (url == null || url.length() == 0 || user == null || user.length() == 0 || pw == null || pw.length() == 0) {

			viewS.getFehlerLabel().setText("Datenbanklogin-Felder müssen ausgefüllt sein");

		} else {

			try {
				if (einloggenDatenbank(url, user, pw, false)) {

					if (getMatrikelNr() == 0) {
						viewS.getFehlerLabel().setText("Darf nicht leer sein oder Zeichen enthalten");
					} else {

						try {
							List<Student> studenten = db.readLogin(getMatrikelNr());
							Student student = null;

							if (studenten.size() >= 0) {

								for (Student s : studenten) {
									if (s.getPruefung().isFreigegeben() == true && s.isHatAbgegeben() == false) {
										student = s;
									} else {
										viewS.getFehlerLabel().setText("Prüfung noch nicht freigegeben");
									}
								}

								PruefungView pruefungViewS = new PruefungView(student);
								student.setEingeloggt(true);
								db.persistNutzer(student);
								viewS.getLoginStudentFrame().dispose();

							} else {
								viewS.getFehlerLabel().setText("Matrikelnummer nicht gefunden");
							}

						} catch (NullPointerException ex) {
							viewS.getFehlerLabel().setText("Anmeldung fehlgeschlagen");
						}

						catch (Exception e) {
							viewS.getFehlerLabel().setText("Anmeldung fehlgeschlagen");
						}
					}

				} else {
					viewS.getFehlerLabel().setText("Datenbankanmeldung fehlgeschlagen");
				}
			} catch (Exception o) {
				viewS.getFehlerLabel().setText("Datenbankanmeldung fehlgeschlagen");
			}
		}
	}

	public boolean einloggenDatenbank(String url, String user, String pw, boolean neu) {

		String driver = "oracle.jdbc.OracleDriver";

		try {

			this.db = DatabaseService.getInstance(driver, url, user, pw, neu);

		} catch (Exception e) {
			return false;

		}

		if (neu) {

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
