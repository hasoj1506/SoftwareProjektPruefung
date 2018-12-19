package Models;

public class Student extends Nutzer{
	
	private int matrikelNr;
	
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

}
