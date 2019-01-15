package Testklassen;

import java.util.ArrayList;
import DatabaseService.DatabaseService;
import Models.Nutzer;
import Models.Pruefung;
import Models.Termin;

public class DatenbankTest {

	public static void main(String[] args) {

		String driver = "oracle.jdbc.OracleDriver";
		String url = "jdbc:oracle:thin:@aix1.fh-bielefeld.de:1521:d2";
		String benutzer = "dvi724";
		String passwort = "fh6317";

//		DatabaseService service = DatabaseService.getInstance(driver,url, benutzer, passwort);

		// erzeugt ein Prüfungsobjekt mit Daten (siehe Konstruktor)
		Pruefung pruefung = new Pruefung("Mathepruefung 1", 120);

		// erzeugt ein Termin Objekt mit Daten (siehe Konstruktor)
		Termin termin = new Termin("test", "test", "test", pruefung);
		Termin termin1 = new Termin("test5", "test4", "test3", pruefung);
		Termin termin2 = new Termin("test35", "test42", "test2", pruefung);

		// fügt ein Termin in den HashSet hinzu
		pruefung.addTermin(termin);
		pruefung.addTermin(termin1);
		pruefung.addTermin(termin2);

		//
		// persistiert(in die Datenbank schreiben) die Prüfung in der
		// Datenbank
//		service.persistPruefung(pruefung);
	}

}
