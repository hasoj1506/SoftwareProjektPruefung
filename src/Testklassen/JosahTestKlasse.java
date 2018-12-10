package Testklassen;

import java.util.ArrayList;
import java.util.List;

import DatabaseService.DatabaseService;
import Models.Antwort;
import Models.Aufgabe;
import Models.Pruefung;
import Models.Termin;
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
			
			Termin termin1 = new Termin((i+1) + ".07.2019", "08:30", "B44" + i, pruefung);
			Termin termin2 = new Termin((i+1) + ".07.2019", "08:30", "B44" + i, pruefung);
			Termin termin3 = new Termin((i+1) + ".07.2019", "08:30", "B44" + i, pruefung);
			Termin termin4 = new Termin((i+1) + ".07.2019", "08:30", "B44" + i, pruefung);

			aufgabe3.addAntwort(antwort1);
			aufgabe3.addAntwort(antwort2);
			aufgabe3.addAntwort(antwort3);

			pruefung.addAufgabe(aufgabe3);
			pruefung.addTermin(termin1);
			pruefung.addTermin(termin2);
			pruefung.addTermin(termin3);
			pruefung.addTermin(termin4);
			
			Aufgabe aufgabe4 = new Aufgabe("Testaufgabe " + i, (50+i), "Fragestellung " + i, pruefung);

			Antwort antwort6 = new Antwort("Antwort " + i, true, (i+5), aufgabe4);
			Antwort antwort5 = new Antwort("Antwort " + i, true, (i+6), aufgabe4);
			Antwort antwort7 = new Antwort("Antwort " + i, false, (i+7), aufgabe4);

			aufgabe4.addAntwort(antwort6);
			aufgabe4.addAntwort(antwort5);
			aufgabe4.addAntwort(antwort7);

			pruefung.addAufgabe(aufgabe4);
			
			service.persistPruefung(pruefung);

		}
	}

}
