package Models;

import java.util.Date;

public class Termin {
	
	private Date datum;
	private int uhrzeit;	//ggf. mit GregorianCalender anderer Parameter
	private String raum;
	
	private Pruefung pruefung;	//Zu jedem Termin genau eine Pruefung
	
	public Termin() {
		
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public int getUhrzeit() {
		return uhrzeit;
	}

	public void setUhrzeit(int uhrzeit) {
		this.uhrzeit = uhrzeit;
	}

	public String getRaum() {
		return raum;
	}

	public void setRaum(String raum) {
		this.raum = raum;
	}

}
