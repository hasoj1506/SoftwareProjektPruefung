package DatabaseService;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import Models.*;

import javax.persistence.*;

public class DatabaseService {

	private EntityManager em;
	private EntityManagerFactory emf;
	private static DatabaseService instance;

	private DatabaseService() {

		emf = Persistence.createEntityManagerFactory("SoftwareProjektPruefung");
		em = emf.createEntityManager();

	}

	private DatabaseService(Map map) {
		emf = Persistence.createEntityManagerFactory("SoftwareProjektPruefung", map);
		em = emf.createEntityManager();
	}

	public static DatabaseService getInstance() {

		if (instance == null) {

			instance = new DatabaseService();
		}

		return instance;
	}

	public static DatabaseService getInstance(String benutzername, String passwort) {

		if (instance == null) {

			Map map = new HashMap();

			map.put("javax.persistence.jbdc.password", passwort);
			map.put("javax.persistence.jbdc.username", benutzername);

			instance = new DatabaseService(map);
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

	public void persistTermin(Termin termin) {
		em.getTransaction().begin();
		em.persist(termin);
		em.getTransaction().commit();
	}

	public List<Antwort> readAntworten(Aufgabe aufgabe) {

		List<Antwort> antworten;

		try {

			TypedQuery q = em.createQuery("SELECT p FROM Antwort p WHERE p.aufgabeId = " + aufgabe.getAufgabeId(),
					Antwort.class);

			antworten = q.getResultList();

			return antworten;

		} catch (Exception e) {

			return null;
		}

	}

	public List<Termin> readTermin(Pruefung pruefung) {

		try {

			List<Termin> termine;

			TypedQuery q = em.createQuery("SELECT p FROM Termin p WHERE p.pruefungId =" + pruefung.getPruefungId(),
					Termin.class);

			termine = q.getResultList();

			return termine;

		} catch (Exception e) {

			return null;
		}

	}

	public List<Aufgabe> readAufgabe(Pruefung pruefung) {

		try {

			List<Aufgabe> aufgaben;

			TypedQuery q = em.createQuery("SELECT p FROM Aufgabe p WHERE p.aufgabenId =" + pruefung.getPruefungId(),
					Aufgabe.class);

			aufgaben = q.getResultList();

			return aufgaben;

		} catch (Exception e) {

			return null;
		}

	}

	public List<Pruefung> readPruefungen() {

		List<Pruefung> pruefungen;

		try {

			Query q = em.createQuery("SELECT p FROM Pruefung p", Pruefung.class);

			pruefungen = (List<Pruefung>) q.getResultList();

			return pruefungen;

		} catch (Exception e) {
			// f�llen, was beim Fehler passiert
			return null;
		}

	}

	public List<Pruefung> readPruefungenSuche(String suchText) {

		List<Pruefung> pruefungen;

		try {

			TypedQuery q = em.createQuery(
					"SELECT p FROM Pruefung p WHERE lower(p.bezeichnung) LIKE lower('%" + suchText + "%')",
					Pruefung.class);

			pruefungen = q.getResultList();

			return pruefungen;

		} catch (Exception e) {
			// f�llen, was beim Fehler passiert
			return null;
		}

	}

	public List<Nutzer> readNutzer() {

		List<Nutzer> nutzer;

		try {

			Query q = em.createQuery("SELECT p FROM Nutzer p", Nutzer.class);

			nutzer = (List<Nutzer>) q.getResultList();

			return nutzer;

		} catch (Exception e) {
			// f�llen, was beim Fehler passiert
			return null;
		}

	}

	public List<Nutzer> readLogin(int matrikelNr) {

		try {
			List<Nutzer> nutzer;
			TypedQuery q = em.createQuery("SELECT p FROM Student p WHERE p.matrikelNr = " + matrikelNr, Nutzer.class);
			nutzer = q.getResultList();
			return nutzer;

		} catch (Exception e) {
			return null;
		}

	}

	public void loescheAntwort(Antwort antwort) {
		em.getTransaction().begin();
		em.remove(antwort);
		em.getTransaction().commit();

	}

	public void loescheNutzer(Nutzer nutzer) {
		em.getTransaction().begin();
		em.remove(nutzer);
		em.getTransaction().commit();

	}

	public void loescheAufgabe(Aufgabe aufgabe) {
		em.getTransaction().begin();
		em.remove(aufgabe);
		em.getTransaction().commit();

	}

	public void loescheTermin(Termin termin) {
		em.getTransaction().begin();
		em.remove(termin);
		em.getTransaction().commit();

	}

	public void loeschePruefungAusPruefungsverwaltung(Pruefung pruefung) {
		em.getTransaction().begin();
		em.remove(pruefung);
		em.getTransaction().commit();

	}
}