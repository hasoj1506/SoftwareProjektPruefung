package Models;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "NutzerArt", discriminatorType = DiscriminatorType.STRING)
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
