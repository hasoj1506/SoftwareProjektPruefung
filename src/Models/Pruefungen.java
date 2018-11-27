package Models;

import javax.persistence.*;

@Entity
public class Pruefungen {
	
	@Id
	@JoinColumn(name = "Prüfungsnummer")
	private int pnr;
	
	private int pruefungsnummer;
	private int gesamtPunktzahl;
	
	private boolean freigeben;
	private String bezeichnung; 
	private String raum;
	
	private double uhrzeit;			//korrekter Datentyp?
	private String datum;			//korrekter Datentyp?
	private short pruefdauer; 
	
	public Pruefungen() {
		
		super();
	}

	
	public Pruefungen(int pruefungsnummer, int gesamtPunktzahl, boolean freigeben, String bezeichnung, String raum, double uhrzeit, String datum, short pruefdauer){
		
		super();
		
		this.pruefungsnummer = pruefungsnummer;
		this.gesamtPunktzahl = gesamtPunktzahl;
		this.freigeben = freigeben;
		this.bezeichnung = bezeichnung;
		this.raum = raum;
		this.uhrzeit = uhrzeit;
		this.datum = datum;
		this.pruefdauer = pruefdauer;
	}
	
	public void setPruefungsnummer(int pruefungsnummer) {
		this.pruefungsnummer = pruefungsnummer;
	}
	
	public int getPruefungsnummer(){
		return pruefungsnummer; 
	}
	
	public void setGesamtPunktzahl(int gesamtpunktzahl) {
		this.gesamtPunktzahl = gesamtPunktzahl;
	}

	public int getGesamtPunktzahl(){
		return gesamtPunktzahl; 
	}
	
	public void setFreigeben(boolean freigeben) {
		this.freigeben = freigeben;	
	}
	
	public boolean getFreigeben(){
		return freigeben; 
	}
	
	public void setBezeichnung(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
		
	public String getBezeichnung(){
		return bezeichnung; 
	}
	
	public void setRaum(String raum) {
		this.raum = raum;
	}
	
	public String getRaum(){
		return raum; 
	}
	
	public void setUhrzeit(double uhrzeit) {
		this.uhrzeit = uhrzeit;
	}
	
	public double getUhrzeit(){
		return uhrzeit; 
	}
	 
	public void setDatum(String datum) {
		this.datum = datum;
	}
	
	public String getDatum(){
		return datum; 
	}
	
	public void setPruefdauer(short pruefdauer) {
		this.pruefdauer = pruefdauer;
	}
	
	public short getPruefdauer(){
		return pruefdauer; 
	}
}
