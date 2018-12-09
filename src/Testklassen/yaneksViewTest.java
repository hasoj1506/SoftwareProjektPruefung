package Testklassen;

import java.util.ArrayList;
import java.util.List;

import Models.Antwort;
import Models.Aufgabe;
import DatabaseService.DatabaseService;
import Models.Pruefung;
import Models.Termin;
import TableModels.AufgabendetailsTableModel;
import Views.AufgabendetailsView;

public class yaneksViewTest {

	public static void main(String[] args) {

		DatabaseService service = DatabaseService.getInstance();

		Pruefung pruefung = new Pruefung("Mathepruefung 1", 120);

		Aufgabe aufgabe3 = new Aufgabe("t", 5, "5", pruefung);

		Antwort antwort1 = new Antwort("text", true, 5, aufgabe3);
		Antwort antwort2 = new Antwort("te33t", true, 7, aufgabe3);
		Antwort antwort3 = new Antwort("te44", false, 4, aufgabe3);

		aufgabe3.addAntwort(antwort1);
		aufgabe3.addAntwort(antwort2);
		aufgabe3.addAntwort(antwort3);

		pruefung.addAufgabe(aufgabe3);
		
		AufgabendetailsView view = new AufgabendetailsView(aufgabe3);
		
		
//	t
	}

}
