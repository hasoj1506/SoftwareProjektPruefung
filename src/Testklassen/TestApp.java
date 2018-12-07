package Testklassen;

import java.util.ArrayList;
import java.util.List;

import DatabaseService.DatabaseService;
import Models.Pruefung;
import Views.AufgabendetailsView;
import Views.PruefungView;
import Views.PruefungsDetails;
import Views.PruefungsverwaltungView;

public class TestApp {

	public static void main(String[] args) {
		
		DatabaseService service = DatabaseService.getInstance();
		
		
		
		List<Pruefung> pruefungen = service.readPruefungen();
		
		System.out.println(pruefungen.isEmpty());
		
		}
}
