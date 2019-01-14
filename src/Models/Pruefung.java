package Models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//Firat Aslan

@Entity													//ist eine persistente Klasse
public class Pruefung {

	@Id													//Primärschlüssel der Klasse
	@GeneratedValue(strategy = GenerationType.AUTO)		//generiert automatisch fortlaufende Primärschlüssel
	private int pruefungId;
	private String bezeichnung;
	private int dauer;
	private double punkte;
	private boolean freigegeben = false;
	private boolean verwuerfelt;

	
	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "pruefung")
	Set<Student> studenten;

	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "pruefung")
	Set<Aufgabe> aufgaben;

	@OneToMany(cascade = { CascadeType.REMOVE, CascadeType.PERSIST }, mappedBy = "pruefung")
	Set<Termin> termine;

	public Pruefung() {
		super();
		termine = new HashSet<Termin>();
		aufgaben = new HashSet<Aufgabe>();
		studenten = new HashSet<Student>();
	}

	public Pruefung(String bezeichnung, int dauer) {
		super();
		this.dauer = dauer;
		this.bezeichnung = bezeichnung;
		this.punkte = punkte;
		termine = new HashSet<Termin>();
		aufgaben = new HashSet<Aufgabe>();
		studenten = new HashSet<Student>();
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

	public int getPruefungId() {
		return pruefungId;
	}

	public Set<Student> getStudenten() {
		return studenten;
	}

	public void addStudent(Student student) {
		this.studenten.add(student);
	}

	public Set<Termin> getTermine() {
		return termine;
	}

	public void addTermin(Termin termin) {
		this.termine.add(termin);
	}

	public Set<Aufgabe> getAufgaben() {
		return aufgaben;
	}

	public void addAufgabe(Aufgabe aufgabe) {
		this.aufgaben.add(aufgabe);
	}

	public double getPunkte() {
		return punkte;
	}

	public void setPunkte(double punkte) {
		this.punkte = punkte;
	}

	public String getLetzterTermin() {

		ArrayList<Termin> termine = new ArrayList<Termin>(this.termine);
		try {
			Termin letzterTermin = termine.get(termine.size() - 1);

			return letzterTermin.getDatum();
		} catch (Exception e) {
			return "Keine Termine";
		}
	}

	public void setAufgaben(Set<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	public boolean isFreigegeben() {
		return freigegeben;
	}

	public void setFreigegeben(boolean freigegeben) {
		this.freigegeben = freigegeben;
	}

	public boolean isVerwuerfelt() {
		return verwuerfelt;
	}

	public void setVerwuerfelt(boolean verwuerfelt) {
		this.verwuerfelt = verwuerfelt;
	}

}
