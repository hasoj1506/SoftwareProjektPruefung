package Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Student")
public class Student extends Nutzer{
	
	private int matrikelNr;
	private int erreichtePunktzahl = 0;
	private boolean eingeloggt = false;
	
	public Student() {
		
	}
	
	public Student(String vorname, String nachname, int matrikelNr) {
		super(vorname, nachname);
		this.matrikelNr = matrikelNr;
	}

	public int getMatrikelNr() {
		return matrikelNr;
	}

	public void setMatrikelNr(int matrikelNr) {
		this.matrikelNr = matrikelNr;
	}
	
	public boolean isEingeloggt() {
		return eingeloggt;
	}

	public void setEingeloggt(boolean eingeloggt) {
		this.eingeloggt = eingeloggt;
	}

	public int getErreichtePunktzahl() {
		return erreichtePunktzahl;
		
	}

	public void setErreichtePunktzahl(int erreichtePunktzahl) {
		this.erreichtePunktzahl = erreichtePunktzahl;
	}

}
