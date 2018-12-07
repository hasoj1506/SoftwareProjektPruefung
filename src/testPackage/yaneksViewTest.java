package testPackage;

import java.util.ArrayList;
import java.util.List;

import Models.Antwort;
import Models.Aufgabe;
import Models.DatabaseService;
import Models.Pruefung;
import Views.AufgabendetailsView;

public class yaneksViewTest {

	public static void main(String[] args) {
		
		DatabaseService service = DatabaseService.getInstance();

		Pruefung pruefung = new Pruefung("Mathepruefung 1", 120);
		
		Antwort antwort1 = new Antwort("test", true, 34);
		Antwort antwort2 = new Antwort("test2", true , 334);
		Antwort antwort3 = new Antwort("test4", true, 434);
		
		Aufgabe aufgabe = new Aufgabe("Mathe", 5 , "1 + 1", pruefung);
		
		aufgabe.addAntwort(antwort1);
		aufgabe.addAntwort(antwort2);
		aufgabe.addAntwort(antwort3);
		
		service.persistPruefung(pruefung);
		
		service.persistAufgabe(aufgabe);
		
		service.persistAntwort(antwort1);
		service.persistAntwort(antwort2);
		service.persistAntwort(antwort3);
		
	}

}
