package Testklassen;

import DatabaseService.DatabaseService;
import Models.Nutzer;
import Views.PruefungsverwaltungView;

public class JosahTestKlasse {

	public static void main(String[] args) {
		
		DatabaseService db = DatabaseService.getInstance();
		Nutzer admin = new Nutzer("Admin", "", "Admin", "Admin", true);
		db.persistNutzer(admin);
		

		
	}

}
