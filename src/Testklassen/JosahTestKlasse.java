package Testklassen;

import java.util.List;

import javax.persistence.TypedQuery;

import DatabaseService.DatabaseService;
import Models.Pruefung;

public class JosahTestKlasse {

	public static void main(String[] args) {
		String suchText = "Te3rf3";
		DatabaseService db = DatabaseService.getInstance();
		TypedQuery q = db.getEntityManager().createQuery("SELECT p FROM Pruefung p WHERE p.bezeichnung LIKE '%"  + suchText + "%'",
				Pruefung.class);
		
		List<Pruefung> pruefungen = q.getResultList();
		
		System.out.println(pruefungen.size());
		
		
		
		

		
	}

}
