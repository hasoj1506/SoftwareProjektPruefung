package Testklassen;

import java.util.ArrayList;
import java.util.List;

import Models.Antwort;
import Models.Aufgabe;
import DatabaseService.DatabaseService;
import Models.Pruefung;
import Models.Termin;
import Views.AufgabendetailsView;

public class yaneksViewTest {

	public static void main(String[] args) {
		
		DatabaseService service = DatabaseService.getInstance();

		Pruefung pruefung = new Pruefung("Mathepruefung 1", 120);
		
		Termin termin = new Termin("test","test","test", pruefung);
		Termin termin1 = new Termin("test5","test4","test3", pruefung);
		Termin termin2 = new Termin("test35","test42","test2", pruefung);
		
		service.persistPruefung(pruefung);
		
		service.persistTermin(termin);
		service.persistTermin(termin1);
		service.persistTermin(termin2);
	}

}
