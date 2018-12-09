package Testklassen;

import java.util.ArrayList;
import java.util.List;

import DatabaseService.DatabaseService;
import Models.Antwort;
import Models.Aufgabe;
import Models.Pruefung;
import Views.AufgabendetailsView;

public class JosahTestKlasse {

	public static void main(String[] args) {
		DatabaseService service = DatabaseService.getInstance();
		
		for(int i = 0; i<20; i++){
			

			Pruefung pruefung = new Pruefung("Mathepruefung " + (i+1), (100+i));

			Aufgabe aufgabe3 = new Aufgabe("Testaufgabe " + i, (50+i), "Fragestellung " + i, pruefung);

			Antwort antwort1 = new Antwort("Antwort " + i, true, (i+5), aufgabe3);
			Antwort antwort2 = new Antwort("Antwort " + i, true, (i+6), aufgabe3);
			Antwort antwort3 = new Antwort("Antwort " + i, false, (i+7), aufgabe3);

			aufgabe3.addAntwort(antwort1);
			aufgabe3.addAntwort(antwort2);
			aufgabe3.addAntwort(antwort3);

			pruefung.addAufgabe(aufgabe3);
			
			service.persistPruefung(pruefung);

		}
	}

}
