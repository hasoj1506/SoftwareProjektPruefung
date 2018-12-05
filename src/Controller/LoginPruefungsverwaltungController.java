package Controller;

import java.awt.Component;
import java.util.List;

import javax.swing.JOptionPane;

import org.eclipse.persistence.internal.oxm.mappings.Login;

import Models.DatabaseService;
import Models.Nutzer;
import Views.LoginPruefungsverwaltung;

public class LoginPruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der LoginPruefungsverwaltung-View aufgerufen werden können
	
	LoginPruefungsverwaltung view;
	
	//Zugriff auf die Datenbank
	DatabaseService db = DatabaseService.getInstance();
	
	//Konstruktor
	public LoginPruefungsverwaltungController(LoginPruefungsverwaltung view) {
		this.view = view;
	}
	
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
		
		List<String> benutzernamen;
		
		for(Nutzer nutzer1 : nutzer) {
			benutzernamen.add(nutzer1.getBenutzername());
		}
		
		
		List<String> passwort1;
		
		for(Nutzer nutzer1 : nutzer) {
			passwort1.add(nutzer1.getPasswort());
		}
//		
//		if(benutzernamen.contains(benutzername){
//			
//		}
		
		
		
		
		
		
	}

		
	}

	


