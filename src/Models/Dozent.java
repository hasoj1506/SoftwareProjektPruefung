package Models;

public class Dozent extends Nutzer {
	
	private int dozentenNr;
	
	public Dozent(String vorname, String nachname, int dozentenNr) {
		super(vorname, nachname);
		this.dozentenNr = dozentenNr;
		
	}

	public int getDozentenNr() {
		return dozentenNr;
	}

	public void setDozentenNr(int dozentenNr) {
		this.dozentenNr = dozentenNr;
		
		
	}
	
	

}
