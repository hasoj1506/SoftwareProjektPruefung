package Controller;

import java.util.ArrayList;
import java.util.List;

import DatabaseService.DatabaseService;
import Models.Nutzer;
import Views.LoginPruefungsverwaltung;

public class LoginPruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der LoginPruefungsverwaltung-View
	// aufgerufen werden können

	private LoginPruefungsverwaltung view;
	
	private List<String> benutzernameListe;
	private List<String> passwoerterListe;

	// Zugriff auf die Datenbank
	DatabaseService db = DatabaseService.getInstance();

	// Konstruktor
	public LoginPruefungsverwaltungController(LoginPruefungsverwaltung view) {
		this.view = view;
	}
	
//	public LoginPruefungsverwaltungController(LoginPruefungsverwaltung view, List<String> benutzernameListe, List<String> passwoerterListe) {
//		this.view = view;
//		this.benutzernameListe = benutzernameListe;
//		this.passwoerterListe = passwoerterListe;
//	}

	// Get Benutzer und passwort von textfeld in view
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

		// Liste mit Benutzer und Passwort aus DB?
		benutzernameListe = new ArrayList<String>();
		try {
			for (Nutzer i : nutzer) {
				benutzernameListe.add(i.getBenutzername());
			}

			passwoerterListe = new ArrayList<String>();

			for (Nutzer i : nutzer) {
				passwoerterListe.add(i.getPasswort());
			}

			if (benutzernameListe.contains(benutzername) && passwoerterListe.contains(passwort)) {
//				JOptionPane.showMessageDialog(null, "Erfolg");	
				System.out.println("erf");
			} else {
//				JOptionPane.showMessageDialog(null, "Fehler");
				System.out.println("miss");

			}
		} catch (Exception e) {
			// Fehler

		}

	}

}
