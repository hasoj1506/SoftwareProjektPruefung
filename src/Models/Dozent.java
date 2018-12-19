package Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Dozent")
public class Dozent extends Nutzer {
	
	private int dozentenNr;
	
	public Dozent() {
		
	}
	
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
