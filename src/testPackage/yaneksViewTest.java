package testPackage;

import Models.Aufgabe;
import Models.Pruefung;
import Views.AufgabendetailsView;

public class yaneksViewTest {

	public static void main(String[] args) {

		Pruefung pruefung = new Pruefung("Mathepruefung 1", 120);
		AufgabendetailsView view = new AufgabendetailsView(pruefung);

	}

}
