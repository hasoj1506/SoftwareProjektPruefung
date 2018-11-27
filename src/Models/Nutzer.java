package Models;

import javax.persistence.*;

@Entity
public class Nutzer {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JoinColumn(name = "nummer")
	
	private int idNummer;	// Dozentennummer oder Matrikelnummer
	
	private String vorname;
	private String nachname;
	
	private String benutzername;
	private String passwort;
	
	private boolean istDozent;
	
	public Nutzer() {
		
		super();
		
	}
	
	public Nutzer(String vorname, String nachname, String benutzername, String passwort, boolean istDozent) {
		
		super();
		
		this.vorname = vorname;
		this.nachname = nachname;
		this.benutzername = benutzername;
		this.passwort = passwort;
		this.istDozent = istDozent;
		
		
	}

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public String getBenutzername() {
		return benutzername;
	}

	public void setBenutzername(String benutzername) {
		this.benutzername = benutzername;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public boolean isIstDozent() {
		return istDozent;
	}

	public void setIstDozent(boolean istDozent) {
		this.istDozent = istDozent;
	}

	public int getIdNummer() {
		return idNummer;
	}

	public void setIdNummer(int idNummer) {
		this.idNummer = idNummer;
	}
	
	
	
	
}
