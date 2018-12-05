package Models;

import javax.persistence.*;

@Entity
public class Termin {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@JoinColumn(name = "terminId")
	private int id;
	
	private String datum;
	private String uhrzeit;	//ggf. mit GregorianCalender anderer Parameter
	private String raum;
	
	@ManyToOne
	@JoinColumn(nullable=false)
	private Pruefung pruefung;	//Zu jedem Termin genau eine Pruefung
	
	public Termin() {
		
		super();
		
	}
	
	public Termin(String datum, String uhrzeit, String raum, Pruefung pruefung) {
		
		super();
		
		this.datum = datum;
		this.uhrzeit = uhrzeit;
		this.raum = raum;
		this.pruefung = pruefung;
	}

	public String getDatum() {
		return datum;
	}

	public void setDatum(String datum) {
		this.datum = datum;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public String getRaum() {
		return raum;
	}

	public void setRaum(String raum) {
		this.raum = raum;
	}

	public Pruefung getPruefung() {
		return pruefung;
	}

	public void setPruefung(Pruefung pruefung) {
		this.pruefung = pruefung;
	}
	
	public int getTerminId(){
		return id;  
	}

}
