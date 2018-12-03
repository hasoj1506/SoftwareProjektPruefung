package Models;

import javax.persistence.*;

public class DatabaseService {
	
	private EntityManager em;
	private EntityManagerFactory emf;
	private static DatabaseService instance;
	
	private DatabaseService() {
		emf = Persistence.createEntityManagerFactory("SoftwareProjektPruefung");
		em = emf.createEntityManager();		
	}
	
	public static DatabaseService getInstance() {
		if(instance == null) {
			instance = new DatabaseService();
		} 
		
		return instance;
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
	
	public void persistNutzer(Nutzer nutzer) {
		
		em.getTransaction().begin();
		em.persist(nutzer);
		em.getTransaction().commit();
		
	}
	
	public void persistPruefung(Pruefung pruefung) {
		em.getTransaction().begin();
		em.persist(pruefung);
		em.getTransaction().commit();
	}
	
	public void persistAufgabe(Aufgabe aufgabe) {
		em.getTransaction().begin();
		em.persist(aufgabe);
		em.getTransaction().commit();
	}

	public void persistAntwort (Antwort antwort){
		em.getTransaction().begin();
		em.persist(antwort);
		em.getTransaction().commit();
	}
}
