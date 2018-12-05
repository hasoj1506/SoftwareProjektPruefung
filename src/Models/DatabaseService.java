package Models;

import java.util.List;

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
		if (instance == null) {
			instance = new DatabaseService();
		}

		return instance;
	}

	public EntityManager getEntityManager() {
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

	public void persistAntwort(Antwort antwort) {
		em.getTransaction().begin();
		em.persist(antwort);
		em.getTransaction().commit();
	}

	public List<Antwort> readAntworten(Aufgabe aufgabe) {

		List<Antwort> antworten;
		Query q = em.createQuery("select s from Aufgabe where id = " + aufgabe.getAufgabentitel());
		antworten = q.getResultList();

		return antworten;

	}

	public List<Termin> readTermin(Pruefung pruefung) {

		List<Termin> termin;
		Query q = em.createQuery("select s from Aufgabe where id = " + aufgabe.getAufgabentitel());
		termin = q.getResultList();

		return termin;

	}

	public List<Antwort> readAufgabe(Pruefung pruefung) {

		List<Antwort> antworten;
		Query q = em.createQuery("select s from Aufgabe where id = " + aufgabe.getAufgabentitel());
		antworten = q.getResultList();

		return antworten;

	}

	public List<Pruefung> readPruefungen() {

		List<Pruefung> pruefungen;

		try {
			TypedQuery q = em.createQuery("select p from Pruefung p", Pruefung.class);

			pruefungen = q.getResultList();

			return pruefungen;

		} catch (Exception e) {
			// füllen, was beim Fehler passiert
			return null;
		}

	}

	public List<Nutzer> readLogin(String username, String passwort, boolean isDozent) {

		int wahr;

		if (isDozent == true) {
			wahr = 1;
		} else {
			wahr = 0;
		}

		try {
			List<Nutzer> nutzer;
			TypedQuery q = em.createQuery("select s from Nutzer where username = " + username + " and passwort = "
					+ passwort + " and isDozent = " + wahr, Nutzer.class);
			nutzer = q.getResultList();
			return nutzer;

		} catch (Exception e) {

		}

		finally {
			return null;
		}
	}
	
	public void loeschePruefungAusPruefungsverwaltung(Pruefung pruefung){
		em.getTransaction().begin();
		em.remove(pruefung);
		em.getTransaction().commit();
		
	}
}