package DatabaseService;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import Models.*;

import javax.persistence.*;
import javax.persistence.spi.PersistenceUnitTransactionType;

import static org.eclipse.persistence.config.PersistenceUnitProperties.*;

//Beteiligt Yanek Wilken, Josah Weber, Victoria Meier
public class DatabaseService {

	// ab hier: Yanek Wilken
	private EntityManager em;
	private EntityManagerFactory emf;
	private static DatabaseService instance;

	//Standart Konstruktor
	private DatabaseService() {

		emf = Persistence.createEntityManagerFactory("SoftwareProjektPruefung");
		em = emf.createEntityManager();

	}
	//Konstruktor mit Properties
	private DatabaseService(Map map) {
		emf = Persistence.createEntityManagerFactory("SoftwareProjektPruefung", map);
		em = emf.createEntityManager();
	}
	//Standard getInstance
	public static DatabaseService getInstance() {

		if (instance == null) {

			instance = new DatabaseService();
		}

		return instance;
	}
	//getInstance mit Datenbank Login
	public static DatabaseService getInstance(String driver, String url, String benutzername, String passwort,
			boolean neuAnlegen) {

		if (instance == null) {

			Map properties = new HashMap();
			
			if (neuAnlegen) {

				properties.put(TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());
				properties.put(JDBC_DRIVER, driver);
				properties.put(JDBC_URL, url);
				properties.put(JDBC_USER, benutzername);
				properties.put(JDBC_PASSWORD, passwort);
				properties.put("eclipselink.ddl-generation.output-mode", "database");
				properties.put("eclipselink.ddl-generation", "drop-and-create-tables");
				
			}else{
				
				properties.put(TRANSACTION_TYPE, PersistenceUnitTransactionType.RESOURCE_LOCAL.name());
				properties.put(JDBC_DRIVER, driver);
				properties.put(JDBC_URL, url);
				properties.put(JDBC_USER, benutzername);
				properties.put(JDBC_PASSWORD, passwort);
				properties.put("eclipselink.ddl-generation.output-mode", "database");

			}
			

			instance = new DatabaseService(properties);
		}

		return instance;

	}
	//Persitieren/Mergen von neuen/vorhandenen Objekten
	public void persistNutzer(Nutzer nutzer) {
		em.getTransaction().begin();
		em.merge(nutzer);
		em.getTransaction().commit();
	}
	
	public void persistAdmin(Admin admin) {
		em.getTransaction().begin();
		em.merge(admin);
		em.getTransaction().commit();
	}

	public void persistPruefung(Pruefung pruefung) {
		em.getTransaction().begin();
		em.merge(pruefung);
		em.getTransaction().commit();
	}

	public void persistAufgabe(Aufgabe aufgabe) {
		em.getTransaction().begin();
		em.merge(aufgabe);
		em.getTransaction().commit();
	}

	public void persistAntwort(Antwort antwort) {
		em.getTransaction().begin();
		em.merge(antwort);
		em.getTransaction().commit();
	}

	public void persistTermin(Termin termin) {
		em.getTransaction().begin();
		em.merge(termin);
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

	// ab hier: Josah Weber
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

	// ab hier: Yanek Wilken
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
	public Admin readAdmin() {

		try {

			List<Admin> admins;

			TypedQuery q = em.createQuery("SELECT p FROM Admin p",
					Admin.class);

			admins = q.getResultList();

			return admins.get(0);

		} catch (Exception e) {

			return null;
		}

	}

	// ab hier: Josah Weber
	public List<Pruefung> readPruefungen() {

		List<Pruefung> pruefungen;

		try {

			TypedQuery q = em.createQuery("SELECT p FROM Pruefung p", Pruefung.class);

			pruefungen = q.getResultList();

			return pruefungen;

		} catch (Exception e) {

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

			return null;
		}

	}

	// ab hier: Victoria Meier
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

	// ab hier: Josah Weber
	public List<Student> readTeilnehmer(int pruefungId) {

		List<Student> studenten;

		try {

			Query q = em.createQuery("SELECT s FROM Student s WHERE s.pruefung.pruefungId = " + pruefungId,
					Student.class);

			studenten = (List<Student>) q.getResultList();

			return studenten;

		} catch (Exception e) {
			// f�llen, was beim Fehler passiert
			return null;
		}

	}

	// ab hier: Victoria Meier
	public List<Student> readLogin(int matrikelNr) {

		try {
			List<Student> student;
			TypedQuery q = em.createQuery("SELECT p FROM Student p WHERE p.matrikelNr = " + matrikelNr, Student.class);
			student = q.getResultList();
			return student;

		} catch (Exception e) {
			return null;
		}

	}

	// ab hier: Yanek Wilken
	public void refreshList(List<Student> teilnehmer) {

		for (Student student : teilnehmer) {
			em.refresh(student);
		}

	}

	public void loescheAntwort(Antwort antwort) {
		em.getTransaction().begin();
		em.remove(antwort);
		em.getTransaction().commit();

	}
	
	public void loescheAdmin(Admin admin) {
		em.getTransaction().begin();
		em.remove(admin);
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
	
	public EntityManager getEntityManager() {
		return em;
	}
	

	public EntityManager getEm() {
		return em;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

}