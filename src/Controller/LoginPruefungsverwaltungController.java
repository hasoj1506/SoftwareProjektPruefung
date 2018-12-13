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
	
	//Konstruktor Student
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

	public void einloggen() {
		try {
			List<Nutzer> nutzer = db.readLogin(getBenutzername(), getPasswort(), false);

			if (nutzer.size() > 0) {

				PruefungsverwaltungView pruefungView = new PruefungsverwaltungView();
				
			} else {
				JOptionPane.showMessageDialog(view.getLoginPruefungsverwaltungFrame(), "Fehler!");

			}
		} catch (NullPointerException e) {
			System.out.println("Nullpointerexception");

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

	public void EinloggenStudent() {
		try {
			List<Nutzer> nutzer = db.readLogin(getBenutzernameS(), getPasswortS(), true);

			if (nutzer.size() >= 0) {

				PruefungView pruefungViewS = new PruefungView(pruefung, nutzers);
				
			} else {
				JOptionPane.showMessageDialog(view.getLoginPruefungsverwaltungFrame(), "Fehler!");

			}
		} catch (NullPointerException e) {
			System.out.println("Nullpointerexception");

		}
	}
	
	
	


}
