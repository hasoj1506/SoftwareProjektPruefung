package Testklassen;

import java.util.ArrayList;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import Models.Antwort;
import Models.Aufgabe;
import Models.Nutzer;
import DatabaseService.DatabaseService;
import Models.Pruefung;
import Models.Termin;
import TableModels.AufgabendetailsTableModel;
import Views.AufgabendetailsView;
import Views.PruefungsverwaltungView;

public class yaneksViewTest {

	public static void main(String[] args) {

		DatabaseService service = DatabaseService.getInstance();

		Pruefung pruefung = new Pruefung("Mathepruefung 1", 120, 6);

		Aufgabe aufgabe3 = new Aufgabe("t", 5, "5", pruefung);

		Antwort antwort1 = new Antwort("text", true, 5, aufgabe3);
		Antwort antwort2 = new Antwort("te33t", true, 7, aufgabe3);
		Antwort antwort3 = new Antwort("te44", false, 4, aufgabe3);

		aufgabe3.addAntwort(antwort1);
		aufgabe3.addAntwort(antwort2);
		aufgabe3.addAntwort(antwort3);

		pruefung.addAufgabe(aufgabe3);
		
		
	/*try {
	  
	        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       
	    }
	    catch (ClassNotFoundException e) {
	       
	    }
	    catch (InstantiationException e) {
	       
	    }
	    catch (IllegalAccessException e) {
	       
	    }
		;
		
		PruefungsverwaltungView view = new PruefungsverwaltungView();
		
//	t*/
		//Nutzer nutzer = new Nutzer("Peter", "Wolf", "pwolf", "1235", false);
		//service.persistNutzer(nutzer);
		
		int tester;
		
		try {
		List<Nutzer> n = service.readLogin("pwolf", "1235", false);
		tester = n.size();
		System.out.println(n.size());
		
		if(tester == 1) {
			System.out.println("Login erfolgreich!");
			}
			
		}
		
		catch(NullPointerException e) {
			System.out.println("Login fehlgeschlagen!");
		}

		
	}

}
