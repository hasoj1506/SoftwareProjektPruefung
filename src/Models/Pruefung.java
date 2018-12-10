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
	private int pruefungId;

	private String bezeichnung;
	private int dauer; // wenn pro Punkt, 1 Minute Zeit, dann dauer = gesamtpunktzahl
	private int punkte;
	
	Set<String> teilnehmer;
	
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy="pruefung")
	Set<Aufgabe> aufgaben;

	@OneToMany(cascade = CascadeType.PERSIST, mappedBy="pruefung")
	Set<Termin> termine;

	public Pruefung() {
		super();
		termine = new HashSet<Termin>();
		aufgaben = new HashSet<Aufgabe>();
	}

	public Pruefung(String bezeichnung, int dauer, int punkte) {
		super();
		this.dauer = dauer;
		this.bezeichnung = bezeichnung;
		this.punkte = punkte;
		termine = new HashSet<Termin>();
		aufgaben = new HashSet<Aufgabe>();
		teilnehmer = new HashSet<String>();
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
	
	public Set<String> getTeilnehmer(){
		return teilnehmer;
	}
	
	public void addTeilnehmer(String teilnehmer){
		this.teilnehmer.add(teilnehmer);
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
	
	public int getPunkte(){
		return punkte;
	}
	
	public void setPunkte(int punkte){
		this.punkte = punkte;
	}

}
