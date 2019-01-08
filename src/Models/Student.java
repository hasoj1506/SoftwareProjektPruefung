package Models;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Student")
public class Student extends Nutzer {

	private int matrikelNr;
	private double erreichtePunktzahl;
	private int bonusPunkte;
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

	public double getErreichtePunktzahl() {
		return erreichtePunktzahl;

	}

	public void setErreichtePunktzahl(double erreichtePunktzahl) {
		this.erreichtePunktzahl = erreichtePunktzahl;
	}

	public int getBonusPunkte() {
		return bonusPunkte;
	}

	public void setBonusPunkte(int bonusPunkte) {
		this.bonusPunkte = bonusPunkte;
	}

}
