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
import Models.Student;
import Models.Termin;
import TableModels.AufgabendetailsTableModel;
import Views.AufgabendetailsView;
import Views.PruefungView;
import Views.PruefungsverwaltungView;

public class yaneksViewTest {

	public static void main(String[] args) {

		DatabaseService service = DatabaseService.getInstance();

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (UnsupportedLookAndFeelException e) {

		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {

		} catch (IllegalAccessException e) {

		}
		;
		
		
		Pruefung pruefung = new Pruefung("test", 5);
	    pruefung.setPunkte(5);
		
		
		Aufgabe aufgabe = new Aufgabe("Mathe", 5, "Wieviel ist 1 + 1?",pruefung);
		pruefung.addAufgabe(aufgabe);
		Antwort antwort = new Antwort("1", false, aufgabe);
		Antwort antwort1 = new Antwort("2", true, aufgabe);
		Antwort antwort2 = new Antwort("3", false, aufgabe);
		aufgabe.addAntwort(antwort);
		aufgabe.addAntwort(antwort1);
		aufgabe.addAntwort(antwort2);
		
		Student student = new Student("t","t", 12);
		student.setPruefung(pruefung);

		PruefungView view = new PruefungView(student);

	}

}
