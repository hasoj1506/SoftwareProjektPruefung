package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import Models.DatabaseService;
import Models.Pruefung;
import Views.PruefungsverwaltungView;

//Josah Weber
public class PruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der Pruefungsverwaltung-View
	// aufgerufen werden k�nnen

	private PruefungsverwaltungView view;
	private List<Pruefung> pruefungen;
	EntityManager em = DatabaseService.getInstance().getEntityManager();

	public PruefungsverwaltungController(PruefungsverwaltungView view) {
		this.view = view;
	}

	public void fuelleTabellePruefungsverwaltung() {

		// Liste von Pruefungsdatens�tzen erstellen
		try {

			Query q = em.createQuery("select * from pruefung");

			pruefungen = (List<Pruefung>)q.getResultList();

			// Zeile f�r Zeile die Tabelle f�llen
			for (int i = 0; i < pruefungen.size(); i++) {

				String titel = pruefungen.get(i).getBezeichnung();
				String termin = "Platzhalter"; // Muss noch ausprogrammiert
												// werden
				int dauer = pruefungen.get(i).getDauer();
				String punkte = "Platzhalter"; // muss noch ausprogrammiert
												// werden und Datentyp �ndern
				String teilnehmerzahl = "Platzhalter"; // muss noch
														// ausprogrammiert
														// werden und Datentyp
														// �ndern

				view.getTableModel().insertRow(view.getTableModel().getRowCount(),
						new Object[] { titel, termin, dauer, punkte, teilnehmerzahl });

			}

		} catch (Exception e) {
			// f�llen, was beim Fehler passiert
		}

	}

	public void erstellePruefung() {

	}

	public void editierePruefung() {

	}

	public void loeschePruefung() {

	}

}
