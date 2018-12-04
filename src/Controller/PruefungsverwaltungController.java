package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Models.DatabaseService;
import Models.Pruefung;
import Views.PruefungsverwaltungView;

//Josah Weber
public class PruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der Pruefungsverwaltung-View
	// aufgerufen werden können

	private PruefungsverwaltungView view;
	private List<Pruefung> pruefungen;
	EntityManager em = DatabaseService.getInstance().getEntityManager();

	public PruefungsverwaltungController(PruefungsverwaltungView view) {
		this.view = view;
	}
	
	//Liste mit allen Prüfungen aus der Datenbank generieren
	public List<Pruefung> getPruefungsliste(){
		try {
			List<Pruefung> pruefungen;
			
			TypedQuery q = em.createQuery("SELECT p FROM Pruefung p", Pruefung.class);

			pruefungen = q.getResultList();

		} catch (Exception e) {
			// füllen, was beim Fehler passiert
		}
		return pruefungen;
	}

	public void fuelleTabellePruefungsverwaltung() {

		// Liste von Pruefungsdatensätzen erstellen
		try {

			TypedQuery q = em.createQuery("SELECT p FROM Pruefung p", Pruefung.class);

			pruefungen = q.getResultList();

			// Zeile für Zeile die Tabelle füllen
			for (int i = 0; i < pruefungen.size(); i++) {

				String titel = pruefungen.get(i).getBezeichnung();
				String termin = "Platzhalter"; // Muss noch ausprogrammiert
												// werden
				int dauer = pruefungen.get(i).getDauer();
				String punkte = "Platzhalter"; // muss noch ausprogrammiert
												// werden und Datentyp ändern
				String teilnehmerzahl = "Platzhalter"; // muss noch
														// ausprogrammiert
														// werden und Datentyp
														// ändern

				view.getTableModel().insertRow(view.getTableModel().getRowCount(),
						new Object[] { titel, termin, dauer, punkte, teilnehmerzahl });

			}

		} catch (Exception e) {
			// füllen, was beim Fehler passiert
		}

	}

	public void erstellePruefung() {

	}

	public void editierePruefung() {

	}

	public void loeschePruefung() {

	}

}
