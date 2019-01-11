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
	// aufgerufen werden k�nnen

	private PruefungsverwaltungView view;
	private List<Pruefung> pruefungen;

	private PruefungsverwaltungTableModel model;
	private DefaultTableCellRenderer centerRenderer;

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
			Collections.sort(pruefungen, new PruefungComparator());

			model = new PruefungsverwaltungTableModel(pruefungen);
			view.getTablePruefungen().setModel(model);

			spaltenbreiteAnpassen();

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
		view.getTablePruefungen().getColumnModel().getColumn(6).setPreferredWidth(10);
	}

	// Neu-Button wird geklickt
	public void neuPruefung() {

		Pruefung pruefung = new Pruefung();
		// Leere Maske der Pr�fungsdetails wird ge�ffnet
		PruefungsDetails detailView = new PruefungsDetails(view, pruefung);

		// Frame-Titel wird ge�ndert
		detailView.getFrame().setTitle("Neue Pr�fung");

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
				detailView.getFrame().setTitle("Bearbeiten: " + zuBearbeitendePr�fung.getBezeichnung());

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
			// Wenn Pr�fung ausgew�hlt ist
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
							"Pr�fungen ohne Aufgaben/Teilnehmer/Termine k�nnen nicht freigegeben werden!");
				}
			} else {
				JOptionPane.showMessageDialog(view.getFrame(),
						"Es wurde keine Pr�fung zum freigeben oder sperren ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view.getFrame(), "Pruefung konnte nicht freigegeben werden!");
		}

	}

	// Ver�nderung des Freigeben-Buttons
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
