package Models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Aufgabe {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int aufgabeId;

	private String aufgabentitel;
	private String frageStellung;
	private int punktzahl;

	@ManyToOne
	@JoinColumn(nullable=false)
	private Pruefung pruefung; // Zu jeder Aufgabe genau eine Prüfung
	
	@OneToMany(cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, mappedBy="aufgabe")
	Set<Antwort> antworten;
	

	public Aufgabe() {

		super();
		antworten = new HashSet<Antwort>();

	}

	public Aufgabe(String aufgabentitel, int punktzahl, String frageStellung, Pruefung pruefung) {

		super();

		this.aufgabentitel = aufgabentitel;
		this.frageStellung = frageStellung;
		this.punktzahl = punktzahl;
		this.pruefung = pruefung;
		antworten = new HashSet<Antwort>();
	}

	public String getAufgabentitel() {
		return aufgabentitel;
	}

	public void setAufgabentitel(String aufgabentitel) {
		this.aufgabentitel = aufgabentitel;
	}

	public String getFrageStellung() {
		return frageStellung;
	}

	public void setFrageStellung(String frageStellung) {
		this.frageStellung = frageStellung;
	}

	public int getPunktzahl() {
		return punktzahl;
	}

	public void setPunktzahl(int punktzahl) {
		this.punktzahl = punktzahl;
	}

	public Pruefung getPruefung() {
		return pruefung;
	}

	public void setPruefung(Pruefung pruefung) {
		this.pruefung = pruefung;
	}

	public Set<Antwort> getAntworten() {
		return antworten;
	}

	public void setAntworten(Set<Antwort> antworten) {
		this.antworten = antworten;
	}
	
	public void addAntwort(Antwort antwort) {
		this.antworten.add(antwort);
	}
	
	public int getAufgabeId(){
		return aufgabeId; 
	}
}
