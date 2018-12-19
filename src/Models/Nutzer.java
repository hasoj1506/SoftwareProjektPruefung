package Models;

import javax.persistence.*;

@Entity
public class Nutzer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int nutzerId; // Dozentennummer oder Matrikelnummer

	
	private String vorname;
	private String nachname;


	@ManyToOne
	@JoinColumn(nullable = true)
	private Pruefung pruefung; // Zu jedem Nutzer genau eine Pruefung

	public Nutzer() {

		super();

	}

	public Nutzer(String vorname, String nachname) {

		super();

		this.vorname = vorname;
		this.nachname = nachname;
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

	public int getNutzerId() {
		return nutzerId;
	}

	public Pruefung getPruefung() {
		return pruefung;
	}

	public void setPruefung(Pruefung pruefung) {
		this.pruefung = pruefung;
	}



}
