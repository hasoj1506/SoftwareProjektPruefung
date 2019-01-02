package Controller;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

import DatabaseService.DatabaseService;
import Models.Antwort;
import Models.Aufgabe;
import Models.Pruefung;
import TableComparatoren.PruefungComparator;
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
	private PruefungsverwaltungTableModel model;
	private DefaultTableCellRenderer centerRenderer;

	public PruefungsverwaltungController(PruefungsverwaltungView view) {
		this.view = view;
	}

	// JTable in der Pruefungsverwaltung mit Datens�tzen f�llen
	public void fuelleTabellePruefungsverwaltung() {

		try {
			// Liste mit allen Pr�fungen der Datenbank erstellen
			pruefungen = db.readPruefungen();
			Collections.sort(pruefungen, new PruefungComparator());

			model = new PruefungsverwaltungTableModel(pruefungen);
			view.getTablePruefungen().setModel(model);

			spaltenbreiteAnpassen();

			// centerRenderer = new DefaultTableCellRenderer();
			// centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
			// for (int i = 0; i < view.getTablePruefungen().getColumnCount();
			// i++) {
			// view.getTablePruefungen().getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
			// }

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Datens�tze konnten nicht geladen werden!");
		}

	}

	private void spaltenbreiteAnpassen() {
		// Spaltenbreiten anpassen
		view.getTablePruefungen().getColumnModel().getColumn(0).setPreferredWidth(120);
		view.getTablePruefungen().getColumnModel().getColumn(1).setPreferredWidth(30);
		view.getTablePruefungen().getColumnModel().getColumn(2).setPreferredWidth(10);
		view.getTablePruefungen().getColumnModel().getColumn(3).setPreferredWidth(20);
		view.getTablePruefungen().getColumnModel().getColumn(4).setPreferredWidth(100);
		view.getTablePruefungen().getColumnModel().getColumn(5).setPreferredWidth(30);
	}

	// Neu-Button wird geklickt
	public void neuPruefung() {

		Pruefung pruefung = new Pruefung();
		// Leere Maske der Pr�fungsdetails wird ge�ffnet
		PruefungsDetails detailView = new PruefungsDetails(view, pruefung);

		// Frame-Titel wird ge�ndert
		detailView.setTitle("Neue Pr�fung");

		view.getFrame().setVisible(false);

	}

	// bearbeiten Button wird geklickt / Doppelklick auf Pr�fung
	public void bearbeitePruefung() {
		try {
			// Wenn in der JTable eine Zeile ausgew�hlt ist
			if (view.getTablePruefungen().getSelectedRow() > -1) {
				// Identifizieren der zu bearbeitenden Pr�fung
				int selection = view.getTablePruefungen().getSelectedRow();
				Pruefung zuBearbeitendePr�fung = pruefungen.get(selection);

				// Pr�fungsdetails-Maske �ffnen und zu bearbeitende Pr�fung
				// �bergeben
				PruefungsDetails detailView = new PruefungsDetails(zuBearbeitendePr�fung, view);

				// Frame-Titel wird ge�ndert
				detailView.setTitle("Bearbeiten: " + zuBearbeitendePr�fung.getBezeichnung());

				view.getFrame().setVisible(false);
			} else {
				JOptionPane.showMessageDialog(view.getFrame(), "Keine Pruefung ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung kann nicht bearbeitet werden!");
		}
	}

	// duplizieren Button wird geklickt
	public void duplizierePruefung() {
		try {
			// Wenn in der JTable eine Zeile ausgew�hlt ist
			if (view.getTablePruefungen().getSelectedRow() > -1) {
				// Identifizieren der zu duplizierenden Pr�fung
				int selection = view.getTablePruefungen().getSelectedRow();
				Pruefung zuDuplizierendePr�fung = pruefungen.get(selection);

				// dem Duplikat die Werte �bergeben
				Pruefung duplikat = new Pruefung();
				duplikat.setBezeichnung(zuDuplizierendePr�fung.getBezeichnung() + " Kopie");
				duplikat.setDauer(zuDuplizierendePr�fung.getDauer());
				duplikat.setPunkte(zuDuplizierendePr�fung.getPunkte());

				// Folgendes ist notwendig, um neue Aufgaben/Antworten-Entities
				// in die DB zu speichern
				for (Aufgabe a : zuDuplizierendePr�fung.getAufgaben()) {
					Aufgabe aufgabe = new Aufgabe();

					for (Antwort ant : a.getAntworten()) {
						Antwort antwort = new Antwort();
						antwort.setAntworttext(ant.getAntworttext());
						antwort.setAufgabe(aufgabe);
						antwort.setIstRichtig(ant.isIstRichtig());
						aufgabe.addAntwort(antwort);
					}
					aufgabe.setAufgabentitel(a.getAufgabentitel());
					aufgabe.setFrageStellung(a.getFrageStellung());
					aufgabe.setPruefung(duplikat);
					aufgabe.setPunktzahl(a.getPunktzahl());

					duplikat.addAufgabe(aufgabe);
				}

				// Das Duplikat in die Datenbank schreiben und die Tabelle
				// aktualisieren
				db.persistPruefung(duplikat);
				fuelleTabellePruefungsverwaltung();
			} else {
				JOptionPane.showMessageDialog(view.getFrame(), "Keine Pruefung ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung kann nicht dupliziert werden!");
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

	// Suchen-Button wird geklickt
	public void suchePruefung() {

		String suchText = view.getTextFieldSuche().getText();

		try {

			pruefungen = db.readPruefungenSuche(suchText);
			Collections.sort(pruefungen, new PruefungComparator());

			model = new PruefungsverwaltungTableModel(pruefungen);
			view.getTablePruefungen().setModel(model);

			spaltenbreiteAnpassen();

			view.getBtnReset().setVisible(true);

		} catch (Exception e) {

		}

	}

	public void resetSuche() {
		view.getTextFieldSuche().setText("");
		fuelleTabellePruefungsverwaltung();
		view.getBtnReset().setVisible(false);
	}

	public void pruefungFreigeben() {
		if (view.getTablePruefungen().getSelectedRow() > -1) {

			int selection = view.getTablePruefungen().getSelectedRow();
			Pruefung pruefungZumFreigeben = pruefungen.get(selection);

			if (pruefungZumFreigeben.isFreigegeben() == false) {
				pruefungZumFreigeben.setFreigegeben(true);
				db.persistPruefung(pruefungZumFreigeben);
				view.getBtnFreigeben().setText("Sperren");
			} else {
				pruefungZumFreigeben.setFreigegeben(false);
				db.persistPruefung(pruefungZumFreigeben);
				view.getBtnFreigeben().setText("Freigeben");
			}

			fuelleTabellePruefungsverwaltung();

		} else {
			JOptionPane.showMessageDialog(view.getFrame(),
					"Es wurde keine Pr�fung zum freigeben oder sperren ausgew�hlt!");
		}

	}

	public void aendereBtnFreigeben() {

		int selection = view.getTablePruefungen().getSelectedRow();
		Pruefung pruefungZumFreigeben = pruefungen.get(selection);

		if (pruefungZumFreigeben.isFreigegeben() == true) {
			view.getBtnFreigeben().setText("Sperren");
		} else {
			view.getBtnFreigeben().setText("Freigeben");
		}
	}

}
