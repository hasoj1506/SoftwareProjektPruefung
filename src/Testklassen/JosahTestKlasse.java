package Testklassen;

import java.util.List;

import DatabaseService.DatabaseService;
import Models.Nutzer;

public class JosahTestKlasse {

	public static void main(String[] args) {
		
		DatabaseService service = DatabaseService.getInstance();
//		PruefungsverwaltungView view = new PruefungsverwaltungView();
		Nutzer n1 = new Nutzer("Alex", "Förster", "AlexFörster", "AlexFörster", true);
		service.persistNutzer(n1);
		
		List<Nutzer> nutzer = service.readLogin("drgdrg", "srgwg", false);
		System.out.println(nutzer.size());
		
	}

}
