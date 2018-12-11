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
	// aufgerufen werden k�nnen

	private PruefungsverwaltungView view;
	private List<Pruefung> pruefungen;

	// um Zugriff auf die Datenbank zu bekommen
	DatabaseService db = DatabaseService.getInstance();

	public PruefungsverwaltungController(PruefungsverwaltungView view) {
		this.view = view;
	}

	// JTable in der Pruefungsverwaltung mit Datens�tzen f�llen
	public void fuelleTabellePruefungsverwaltung() {

		try {
			// Liste mit allen Pr�fungen der Datenbank erstellen
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
			JOptionPane.showMessageDialog(view.getFrame(), "Datens�tze konnten nicht geladen werden!");
		}

	}

	// Neu-Button wird geklickt
	public void neuPruefung() {

		Pruefung pruefung = new Pruefung();
		// Leere Maske der Pr�fungsdetails wird ge�ffnet
		PruefungsDetails detailView = new PruefungsDetails(view, pruefung);

		// Frame-Titel wird ge�ndert
		detailView.setTitle("Neue Pr�fung");

	}

	// bearbeiten Button wird geklickt / Doppelklick auf Pr�fung
	public void bearbeitePruefung() {
		try {
			// Wenn in der JTable eine Zeile ausgew�hlt ist
			if (view.getTablePruefungen().getSelectedRow() > -1) {
				// Identifizieren der zu bearbeitenden Pr�fung
				pruefungen = db.readPruefungen();
				int selection = view.getTablePruefungen().getSelectedRow();
				Pruefung zuBearbeitendePr�fung = pruefungen.get(selection);

				// Pr�fungsdetails-Maske �ffnen und zu bearbeitende Pr�fung
				// �bergeben
				PruefungsDetails detailView = new PruefungsDetails(zuBearbeitendePr�fung, view);
				
				// Frame-Titel wird ge�ndert
				detailView.setTitle("Bearbeiten: " + zuBearbeitendePr�fung.getBezeichnung());
			} else {
				JOptionPane.showMessageDialog(view.getFrame(), "Keine Pruefung ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung kann nicht bearbeitet werden!");
		}
	}

	// L�schen-Button wird geklickt
	public void loeschePruefung() {

		try {
			// Wenn in der JTable eine Zeile ausgew�hlt ist
			if (view.getTablePruefungen().getSelectedRow() > -1) {

				// Abfrage, ob wirklich gel�scht werden soll
				int reply = JOptionPane.showConfirmDialog(view.getFrame(), "Soll die Pr�fung wirklich gel�scht werden?",
						"Abfrage", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					// Identifizieren der zu l�schenden Pr�fung
					pruefungen = db.readPruefungen();
					int selection = view.getTablePruefungen().getSelectedRow();
					Pruefung zuLoeschendePruefung = pruefungen.get(selection);

					// L�schen der Pr�fung aus der Datenbank und neuladen der
					// Tabelle
					db.loeschePruefungAusPruefungsverwaltung(zuLoeschendePruefung);
					fuelleTabellePruefungsverwaltung();
				} else {
					// nichts tun
				}
			} else {
				JOptionPane.showMessageDialog(view.getFrame(), "Keine Pruefung ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung konnte nicht gel�scht werden!");
		}

	}

}
