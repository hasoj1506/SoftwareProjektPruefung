package Models;

import javax.persistence.*;

@Entity
public class Antwort {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@JoinColumn(name = "antwortId")
	private int antwortid;
	

	private boolean alsRichtigBeantwortet;
	private boolean istRichtig;
	private String antworttext;

	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Aufgabe aufgabe;// Zu jeder Aufgabe gibt es 1 oder mehrere Antworten

	
	public Antwort() {

		super();
	}

	public Antwort(boolean istRichtig, String antworttext) {
		super();

		this.istRichtig = istRichtig;
		this.antworttext = antworttext;
	}

	public boolean isIstRichtig() {
		return istRichtig;
	}

	public void setIstRichtig(boolean istRichtig) {
		this.istRichtig = istRichtig;
	}

	public String getAntworttext() {
		return antworttext;
	}

	public void setAntworttext(String antworttext) {
		this.antworttext = antworttext;
	}

	public boolean isAlsRichtigBeantwortet() {
		return alsRichtigBeantwortet;
	}

	public void setAlsRichtigBeantwortet(boolean alsRichtigBeantwortet) {
		this.alsRichtigBeantwortet = alsRichtigBeantwortet;
	}

	public Aufgabe getAufgabe() {
		return aufgabe;
	}

	public void setAufgabe(Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
	}
	
	public int getAntwortId(){
		return antwortid; 
	}

}
