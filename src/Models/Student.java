package Models;

public class Student extends Nutzer{
	
	private int matrikelNr;
	private int erreichtePunktzahl;
	
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

}
