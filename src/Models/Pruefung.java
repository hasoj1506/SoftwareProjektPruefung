package Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Pruefung {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "pruefungsnummer")
	private int pnr;

	private String bezeichnung;
	private int dauer; // wenn pro Punkt, 1 Minute Zeit, dann dauer =
						// gesamtpunktzahl
	
	@OneToMany(cascade = CascadeType.PERSIST)
	ArrayList<Aufgabe> aufgaben;

	@OneToMany(cascade = CascadeType.PERSIST)
	Set<Termin> termine;

	public Pruefung() {
		super();
		termine = new HashSet<Termin>();
		aufgaben = new ArrayList<Aufgabe>();
	}

	public Pruefung(String bezeichnung, int dauer) {
		super();
		this.dauer = dauer;
		this.bezeichnung = bezeichnung;
		termine = new HashSet<Termin>();
		aufgaben = new ArrayList<Aufgabe>();
	}

	public String getBezeichnung() {
		return bezeichnung;
	}

	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}

	public int getDauer() {
		return dauer;
	}

	public void setDauer(int dauer) {
		this.dauer = dauer;
	}

	public int getPnr() {
		return pnr;
	}

	public void setPnr(int pnr) {
		this.pnr = pnr;
	}

	public Set<Termin> getTermine() {
		return termine;
	}

	public void addTermin(Termin termin) {
		this.termine.add(termin);
	}

	/*
	 * public void setTermine(Set<Termin> termine) { this.termine = termine; }
	 */

}
