package Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Student")
public class Student extends Nutzer{
	
	private int matrikelNr;
	private int erreichtePunktzahl;
	
	public Student() {
		
	}
	
	public Student(String vorname, String nachname, int matrikelNr, int erreichtePunktzahl) {
		super(vorname, nachname);
		this.matrikelNr = matrikelNr;
		this.erreichtePunktzahl = erreichtePunktzahl;
	}

	public int getMatrikelNr() {
		return matrikelNr;
	}

	public void setMatrikelNr(int matrikelNr) {
		this.matrikelNr = matrikelNr;
	}

	public int getErreichtePunktzahl() {
		return erreichtePunktzahl;
	}

	public void setErreichtePunktzahl(int erreichtePunktzahl) {
		this.erreichtePunktzahl = erreichtePunktzahl;
	}

}
