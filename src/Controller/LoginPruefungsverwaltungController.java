package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DatabaseService.DatabaseService;
import Models.Nutzer;
import Views.LoginPruefungsverwaltung;

public class LoginPruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der LoginPruefungsverwaltung-View aufgerufen werden können
	
	private LoginPruefungsverwaltung view;
	
	//Zugriff auf die Datenbank
	DatabaseService db = DatabaseService.getInstance();
	
	//Konstruktor
	public LoginPruefungsverwaltungController(LoginPruefungsverwaltung view) {
		this.view = view;
	}
	
	//Get Benutzer und passwort von textfeld in view
	public String getBenutzername() {
		return view.getTFBenutzername().getText();
	}
	
	public String getPasswort() {
		char[] passwort = view.getTFPasswort().getPassword();
		return String.valueOf(passwort);
	}
	
	public void Einloggen() {
		List<Nutzer> nutzer = db.readLogin(getBenutzername(), getPasswort(), true);
		String benutzername = getBenutzername();
		String passwort = getPasswort();
		
		//Liste mit Benutzer und Passwort aus DB?
		List<String> benutzernameListe = new ArrayList<String>();
		
		for(Nutzer i : nutzer) {
			benutzernameListe.add(i.getBenutzername());
		}
		

		
		List<String> passwoerterListe = new ArrayList<String>();
		
		for(Nutzer i : nutzer) {
			passwoerterListe.add(i.getPasswort());
		}
		
		if(benutzernameListe.contains(benutzername) && passwoerterListe.contains(passwort)){
			JOptionPane.showMessageDialog(null, "Erfolg");			
		}
		else {
			JOptionPane.showMessageDialog(null, "Fehler");
		}
		
		
		
		
		
		
	}

		
	}

	


