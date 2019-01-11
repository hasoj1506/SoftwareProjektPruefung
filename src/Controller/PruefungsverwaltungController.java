package Controller;

import java.util.Collections;
import java.util.List;

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
	// aufgerufen werden können

	private PruefungsverwaltungView view;
	private List<Pruefung> pruefungen;

	private PruefungsverwaltungTableModel model;
	private DefaultTableCellRenderer centerRenderer;

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
			Collections.sort(pruefungen, new PruefungComparator());

			model = new PruefungsverwaltungTableModel(pruefungen);
			view.getTablePruefungen().setModel(model);

			spaltenbreiteAnpassen();

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Datensätze konnten nicht geladen werden!");
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
		view.getTablePruefungen().getColumnModel().getColumn(6).setPreferredWidth(10);
	}

	// Neu-Button wird geklickt
	public void neuPruefung() {

		Pruefung pruefung = new Pruefung();
		// Leere Maske der Prüfungsdetails wird geöffnet
		PruefungsDetails detailView = new PruefungsDetails(view, pruefung);

		// Frame-Titel wird geändert
		detailView.getFrame().setTitle("Neue Prüfung");

	}

	// bearbeiten Button wird geklickt / Doppelklick auf Prüfung
	public void bearbeitePruefung() {
		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTablePruefungen().getSelectedRow() > -1) {
				// Identifizieren der zu bearbeitenden Prüfung
				int selection = view.getTablePruefungen().getSelectedRow();
				Pruefung zuBearbeitendePrüfung = pruefungen.get(selection);

				// Prüfungsdetails-Maske öffnen und zu bearbeitende Prüfung
				// übergeben
				PruefungsDetails detailView = new PruefungsDetails(zuBearbeitendePrüfung, view);

				// Frame-Titel wird geändert
				detailView.getFrame().setTitle("Bearbeiten: " + zuBearbeitendePrüfung.getBezeichnung());

			} else {
				JOptionPane.showMessageDialog(view.getFrame(), "Keine Pruefung ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung kann nicht bearbeitet werden!");
		}
	}

	// duplizieren Button wird geklickt
	public void duplizierePruefung() {
		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTablePruefungen().getSelectedRow() > -1) {
				// Identifizieren der zu duplizierenden Prüfung
				int selection = view.getTablePruefungen().getSelectedRow();
				Pruefung zuDuplizierendePrüfung = pruefungen.get(selection);

				// dem Duplikat die Werte übergeben
				Pruefung duplikat = new Pruefung();
				duplikat.setBezeichnung(zuDuplizierendePrüfung.getBezeichnung() + " Kopie");
				duplikat.setDauer(zuDuplizierendePrüfung.getDauer());
				duplikat.setPunkte(zuDuplizierendePrüfung.getPunkte());

				// Folgendes ist notwendig, um neue Aufgaben/Antworten-Entities
				// in die DB zu speichern
				for (Aufgabe a : zuDuplizierendePrüfung.getAufgaben()) {
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
				JOptionPane.showMessageDialog(view.getFrame(), "Keine Pruefung ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung kann nicht dupliziert werden!");
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
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung konnte nicht gesucht werden!");
		}

	}

	// Reset-Button wird geklickt
	public void resetSuche() {
		view.getTextFieldSuche().setText("");
		fuelleTabellePruefungsverwaltung();
		view.getBtnReset().setVisible(false);
	}

	// Freigeben-Button wird geklickt
	public void pruefungFreigeben() {

		try {
			// Wenn Prüfung ausgewählt ist
			if (view.getTablePruefungen().getSelectedRow() > -1) {

				// Identifizieren der Pruefung
				int selection = view.getTablePruefungen().getSelectedRow();
				Pruefung pruefungZumFreigeben = pruefungen.get(selection);

				if (pruefungZumFreigeben.getAufgaben().isEmpty() == false
						&& pruefungZumFreigeben.getStudenten().isEmpty() == false
						&& pruefungZumFreigeben.getTermine().isEmpty() == false) {
					// Freigeben
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
							"Prüfungen ohne Aufgaben/Teilnehmer/Termine können nicht freigegeben werden!");
				}
			} else {
				JOptionPane.showMessageDialog(view.getFrame(),
						"Es wurde keine Prüfung zum freigeben oder sperren ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung konnte nicht freigegeben werden!");
		}

	}

	// Veränderung des Freigeben-Buttons
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
