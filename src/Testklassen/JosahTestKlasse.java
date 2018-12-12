package Testklassen;

import java.util.List;

import DatabaseService.DatabaseService;
import Models.Nutzer;

public class JosahTestKlasse {

	public static void main(String[] args) {
		
		DatabaseService service = DatabaseService.getInstance();
//		PruefungsverwaltungView view = new PruefungsverwaltungView();
		
		List<Nutzer> nutzer = service.readLogin("HansWurst", "HansWurst", false);
		System.out.println(nutzer.size());
		
	}

}
