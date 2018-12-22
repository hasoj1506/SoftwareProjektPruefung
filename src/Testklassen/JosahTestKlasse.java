package Testklassen;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import DatabaseService.DatabaseService;
import Models.Nutzer;
import Models.Pruefung;
import Models.Student;
import Views.LoginAbfrage;
import Views.PruefungView;
import Views.PruefungsverwaltungView;

public class JosahTestKlasse {

	public static void main(String[] args) {

		try {

			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			
		} catch (UnsupportedLookAndFeelException e) {

		} catch (ClassNotFoundException e) {

		} catch (InstantiationException e) {

		} catch (IllegalAccessException e) {

		};

//		List<Pruefung> pruefungen = DatabaseService.getInstance().readPruefungen();
//		Pruefung pruefung = pruefungen.get(0);
//		System.out.println(pruefung.getBezeichnung());
//		Pruefung p1 = DatabaseService.getInstance().getEntityManager().find(Pruefung.class, pruefung.getPruefungId());
//		System.out.println(p1.getBezeichnung());
		PruefungsverwaltungView view = new PruefungsverwaltungView();
		

	
	}
}
