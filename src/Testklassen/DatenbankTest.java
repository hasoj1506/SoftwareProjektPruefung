package Testklassen;

import java.util.ArrayList;
import DatabaseService.DatabaseService;
import Models.Pruefung;
import Models.Termin;

public class DatenbankTest {

	public static void main(String[] args) {

		DatabaseService service = DatabaseService.getInstance();

		for (int i = 0; i < 20; i++) {
			// erzeugt ein Pr�fungsobjekt mit Daten (siehe Konstruktor)
			Pruefung pruefung = new Pruefung("Mathepruefung 1", 120);

			// erzeugt ein Termin Objekt mit Daten (siehe Konstruktor)
			Termin termin = new Termin("test", "test", "test", pruefung);
			Termin termin1 = new Termin("test5", "test4", "test3", pruefung);
			Termin termin2 = new Termin("test35", "test42", "test2", pruefung);

			// f�gt ein Termin in den HashSet hinzu
			pruefung.addTermin(termin);
			pruefung.addTermin(termin1);
			pruefung.addTermin(termin2);

			//
			// persistiert(in die Datenbank schreiben) die Pr�fung in der
			// Datenbank
			service.persistPruefung(pruefung);
		}

	}

}
