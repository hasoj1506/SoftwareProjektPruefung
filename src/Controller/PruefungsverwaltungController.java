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

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Ein Fehler ist aufgetreten!" + e);
		}

	}

	// Neu-Button wird geklickt
	public void neuPruefung() {

		// Leere Maske der Pr�fungsdetails wird ge�ffnet
		PruefungsDetails detailView = new PruefungsDetails(view);

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
				detailView.setTitle("Bearbeiten: " + zuBearbeitendePr�fung.getBezeichnung());
			} else {
				JOptionPane.showMessageDialog(view.getFrame(), "Keine Pruefung ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Ein Fehler ist aufgetreten!" + e);
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
			JOptionPane.showMessageDialog(view.getFrame(), "Ein Fehler ist aufgetreten!" + e);
		}

	}

}
