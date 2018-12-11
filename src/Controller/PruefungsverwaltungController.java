package Controller;

import java.util.List;

import javax.swing.JOptionPane;

import DatabaseService.DatabaseService;
import Models.Pruefung;
import TableModels.PruefungsverwaltungTableModel;
import Views.PruefungsDetails;
import Views.PruefungsverwaltungView;

//Josah Weber
public class PruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der Pruefungsverwaltung-View
	// aufgerufen werden können

	private PruefungsverwaltungView view;
	private List<Pruefung> pruefungen;

	// um Zugriff auf die Datenbank zu bekommen
	DatabaseService db = DatabaseService.getInstance();

	public PruefungsverwaltungController(PruefungsverwaltungView view) {
		this.view = view;
	}

	// JTable in der Pruefungsverwaltung mit Datensätzen füllen
	public void fuelleTabellePruefungsverwaltung() {

		try {
			// Liste mit allen Prüfungen der Datenbank erstellen
			pruefungen = db.readPruefungen();

			// Dem JTable das Model inklusive Liste zuweisen
			PruefungsverwaltungTableModel model = new PruefungsverwaltungTableModel(pruefungen);
			view.getTablePruefungen().setModel(model);
			
			//Spaltenbreiten anpassen
			view.getTablePruefungen().getColumnModel().getColumn(0).setPreferredWidth(100);
			view.getTablePruefungen().getColumnModel().getColumn(1).setPreferredWidth(20);
			view.getTablePruefungen().getColumnModel().getColumn(2).setPreferredWidth(10);
			view.getTablePruefungen().getColumnModel().getColumn(3).setPreferredWidth(20);
			view.getTablePruefungen().getColumnModel().getColumn(4).setPreferredWidth(100);
			view.getTablePruefungen().getColumnModel().getColumn(5).setPreferredWidth(20);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Datensätze konnten nicht geladen werden!");
		}

	}

	// Neu-Button wird geklickt
	public void neuPruefung() {

		Pruefung pruefung = new Pruefung();
		// Leere Maske der Prüfungsdetails wird geöffnet
		PruefungsDetails detailView = new PruefungsDetails(view, pruefung);

		// Frame-Titel wird geändert
		detailView.setTitle("Neue Prüfung");

	}

	// bearbeiten Button wird geklickt / Doppelklick auf Prüfung
	public void bearbeitePruefung() {
		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTablePruefungen().getSelectedRow() > -1) {
				// Identifizieren der zu bearbeitenden Prüfung
				pruefungen = db.readPruefungen();
				int selection = view.getTablePruefungen().getSelectedRow();
				Pruefung zuBearbeitendePrüfung = pruefungen.get(selection);

				// Prüfungsdetails-Maske öffnen und zu bearbeitende Prüfung
				// übergeben
				PruefungsDetails detailView = new PruefungsDetails(zuBearbeitendePrüfung, view);
				
				// Frame-Titel wird geändert
				detailView.setTitle("Bearbeiten: " + zuBearbeitendePrüfung.getBezeichnung());
			} else {
				JOptionPane.showMessageDialog(view.getFrame(), "Keine Pruefung ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung kann nicht bearbeitet werden!");
		}
	}

	// Löschen-Button wird geklickt
	public void loeschePruefung() {

		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTablePruefungen().getSelectedRow() > -1) {

				// Abfrage, ob wirklich gelöscht werden soll
				int reply = JOptionPane.showConfirmDialog(view.getFrame(), "Soll die Prüfung wirklich gelöscht werden?",
						"Abfrage", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					// Identifizieren der zu löschenden Prüfung
					pruefungen = db.readPruefungen();
					int selection = view.getTablePruefungen().getSelectedRow();
					Pruefung zuLoeschendePruefung = pruefungen.get(selection);

					// Löschen der Prüfung aus der Datenbank und neuladen der
					// Tabelle
					db.loeschePruefungAusPruefungsverwaltung(zuLoeschendePruefung);
					fuelleTabellePruefungsverwaltung();
				} else {
					// nichts tun
				}
			} else {
				JOptionPane.showMessageDialog(view.getFrame(), "Keine Pruefung ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung konnte nicht gelöscht werden!");
		}

	}

}
