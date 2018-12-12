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

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {

		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {

		} catch (IllegalAccessException e) {

		}
		;

		PruefungsverwaltungView view = new PruefungsverwaltungView();

	}

}
