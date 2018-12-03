package Models;

import java.util.ArrayList;

public class DatenbankTest {

	public static void main(String[] args) {

		DatabaseService service = DatabaseService.getInstance();

		// Nutzer nutzerA = new Nutzer("Hans", "Dieter", "hDieter","1234",true);
		// Nutzer nutzerB = new Nutzer("Franz", "Rudolf",
		// "hRudolf","3563",true);
		// Nutzer nutzerC = new Nutzer("Werner", "Ulf", "hUlf","3234",true);
		// Nutzer nutzerD = new Nutzer("Fritz", "Mueller",
		// "hMeier","1564",true);
		// Nutzer nutzerE = new Nutzer("Hainer", "Karsten",
		// "hKarsten","1222",true);
		// Nutzer nutzerF = new Nutzer("Test", "Test", "hTest","9988",true);
		
		//Testdatensätze für Prüfungen anlegen, um Query testen zu können
		ArrayList<Pruefung> pruefungen = new ArrayList<Pruefung>();
		
		for (int i = 0; i < 20; i++) {
			pruefungen.add(new Pruefung("Test " + (i+1), 60));
		}
		
		for (int i = 0; i < pruefungen.size(); i++) {
			service.persistPruefung(pruefungen.get(i));
		}

		// Aufgabe a1 = new Aufgabe("Test", 30, "Funktionierts?", p1);
		//
		// Antwort a2 = new Antwort(true,true, "Antwort lautet: 3" );

		// service.persistNutzer(nutzerA);
		// service.persistNutzer(nutzerB);
		// service.persistNutzer(nutzerC);
		// service.persistNutzer(nutzerD);
		// service.persistNutzer(nutzerE);

//		service.persistPruefung(p1);
//
//		service.persistAufgabe(a1);
//		service.persistAntwort(a2);

	}

}
