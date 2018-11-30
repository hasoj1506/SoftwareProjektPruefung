package testPackage;

import Models.Aufgabe;
import Models.Pruefung;
import Views.AufgabendetailsView;

public class yaneksViewTest {

	public static void main(String[] args) {
	
		
		Pruefung pruefung = new Pruefung("Mathepruefung 1", 120);
		Aufgabe aufgabe = new Aufgabe("Geometrie", 5, "Wie viele Ecken hat ein 19Eck?", pruefung);
		AufgabendetailsView view = new AufgabendetailsView(aufgabe);

	}

}
