package Models;

import javax.persistence.*;

public class DatabaseService {
	
	private EntityManager em;
	private EntityManagerFactory emf;
	private DatabaseService instance;
	
	private DatabaseService() {
		emf = Persistence.createEntityManagerFactory("SoftwareProjektPruefung");
		em = emf.createEntityManager();		
	}
	
	private DatabaseService getInstance() {
		if(this.instance == null) {
			instance = new DatabaseService();
		} 
		
		return this.instance;
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

}
