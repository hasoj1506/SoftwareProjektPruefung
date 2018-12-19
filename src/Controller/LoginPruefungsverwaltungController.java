package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DatabaseService.DatabaseService;
import Models.Nutzer;
import Models.Pruefung;
import Views.LoginPruefungsverwaltung;
import Views.LoginStudent;
import Views.PruefungView;
import Views.PruefungsverwaltungView;

public class LoginPruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der LoginPruefungsverwaltung-View
	// aufgerufen werden k�nnen

	private LoginPruefungsverwaltung view;
	private LoginStudent viewS;

	Pruefung pruefung;
	Nutzer nutzers;

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
	public String getBenutzername() {
		return view.getTFBenutzername().getText();
	}

	public String getPasswort() {
		char[] passwort = view.getTFPasswort().getPassword();
		return String.valueOf(passwort);
	}

	public void einloggenDozent() {
		try {

			this.db = DatabaseService.getInstance(getBenutzername(), getPasswort());
			
			PruefungsverwaltungView view = new PruefungsverwaltungView();

		} catch (NullPointerException e) {
//			System.out.println("Nullpointerexception");

		}
	}

	// Get Benutzer und passwort von textfeld in view von Student
	public String getBenutzernameS() {
		return viewS.getTFBenutzername().getText();
	}

	public String getPasswortS() {
		char[] passwort = viewS.getTFPasswort().getPassword();
		return String.valueOf(passwort);
	}
	
	public int getMatrikelNr() {
		return Integer.parseInt(viewS.getTFMatrikelNr().getText());
	}

	public void einloggenStudent() {
		try {
			List<Nutzer> nutzer = db.readLogin(getMatrikelNr());

			if (nutzer.size() >= 0) {

				PruefungView pruefungViewS = new PruefungView(nutzer.get(0));
				viewS.getLoginStudentFrame().dispose();

			} else {
				JOptionPane.showMessageDialog(view.getLoginPruefungsverwaltungFrame(),
						"Benutzername oder Passwort nicht gefunden!");

			}
		} catch (NullPointerException e) {
			System.out.println("Nullpointerexception");

		}
	}

}
