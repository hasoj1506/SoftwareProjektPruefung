package Models;

public class Pruefung {
	
	private String bezeichnung;
	private int dauer;	//wenn pro Punkt, 1 Minute Zeit, dann dauer = gesamtpunktzahl

	public Pruefung() {
		
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
}
