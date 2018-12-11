package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DatabaseService.DatabaseService;
import Models.Aufgabe;
import Models.Nutzer;
import Models.Pruefung;
import Models.Termin;
import TableModels.PruefungsDetailsAufgabenTableModel;
import TableModels.PruefungsDetailsTeilnehmerTableModel;
import TableModels.PruefungsDetailsTermineTableModel;
import Views.AufgabendetailsView;
import Views.NutzerErstellenPopUp;
import Views.PruefungsDetails;
import Views.PruefungsverwaltungView;
import Views.TerminErstellenPopUp;

//Josah Weber
public class PruefungsDetailsController {
	// alle Methoden, die durch Bedienung der PruefungsDetails-View aufgerufen
	// werden k�nnen

	private PruefungsDetails view;
	private List<Aufgabe> aufgaben;
	private List<Nutzer> nutzer;
	private List<Termin> termine;
	private List<Nutzer> teilnehmer;
	private Pruefung pruefung;

	// um Zugriff auf die Datenbank zu bekommen
	DatabaseService db = DatabaseService.getInstance();

	public PruefungsDetailsController(PruefungsDetails view, List<Aufgabe> aufgaben, List<Nutzer> nutzer,
			List<Termin> termine, Pruefung pruefung) {
		super();
		this.view = view;
		this.aufgaben = aufgaben;
		this.nutzer = nutzer;
		this.termine = termine;
		this.pruefung = pruefung;
	}

	public PruefungsDetailsController(PruefungsDetails view, Pruefung pruefung) {
		this.view = view;
		this.pruefung = pruefung;
	}

	public void fuellePruefungsDetails(Pruefung pruefung) {
		this.pruefung = pruefung;

		// Felder mit Daten der Pr�fung bef�llen
		JTextField textFieldPrfungstitel = view.getTextFieldPrfungstitel();
		JTextField textFieldDauer = view.getTextFieldDauer();
		JTextField textFieldPunkte = view.getTextFieldPunkte();

		textFieldPrfungstitel.setText(pruefung.getBezeichnung());

		try {
			textFieldDauer.setText(String.valueOf(pruefung.getDauer()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, "Die Dauer wurde nicht im richtigen Format eingegeben!");
		}

		try {
			textFieldPunkte.setText(String.valueOf(pruefung.getPunkte()));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, "Die Punkte wurden nicht im richtigen Format eingegeben!");
		}

		fuelleAufgabenTable(pruefung);

		fuelleTermineTable(pruefung);

		fuelleTeilnehmerTable(pruefung);
	}

	public void fuelleTeilnehmerTable(Pruefung pruefung) {
		this.pruefung = pruefung;
		JTable tableTeilnehmer = view.getTableTeilnehmer();
		try {
			// Liste mit Teilnehmern der Pr�fung erstellen
			nutzer = new ArrayList<Nutzer>(pruefung.getNutzer());

			// Dem JTable das Model inklusive Liste zuweisen
			PruefungsDetailsTeilnehmerTableModel tableModelTeilnehmer = new PruefungsDetailsTeilnehmerTableModel(
					nutzer);
			tableTeilnehmer.setModel(tableModelTeilnehmer);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}
	}

	public void fuelleTermineTable(Pruefung pruefung) {
		this.pruefung = pruefung;
		JTable tableTermine = view.getTableTermine();
		try {
			// Liste mit Terminen der Pr�fung erstellen
			termine = new ArrayList<Termin>(pruefung.getTermine());

			// Dem JTable das Model inklusive Liste zuweisen
			PruefungsDetailsTermineTableModel tableModelTermine = new PruefungsDetailsTermineTableModel(termine);
			tableTermine.setModel(tableModelTermine);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}
	}

	public void fuelleAufgabenTable(Pruefung pruefung) {
		this.pruefung = pruefung;
		JTable tableAufgaben = view.getTableAufgaben();

		try {
			// Liste mit Aufgaben der Pr�fung erstellen
			aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());

			// Dem JTable das Model inklusive Liste zuweisen
			PruefungsDetailsAufgabenTableModel tableModelAufgaben = new PruefungsDetailsAufgabenTableModel(aufgaben);
			tableAufgaben.setModel(tableModelAufgaben);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}
	}

	// Neu-Aufgabe-Button wird geklickt
	public void neuAufgabe(Pruefung pruefung) {
		Aufgabe aufgabe = new Aufgabe();
		aufgabe.setPruefung(pruefung);
		// Leere Aufgaben-Details-Maske wird ge�ffnet
		AufgabendetailsView aufgabenDetails = new AufgabendetailsView(aufgabe, view);
	}

	// Aufgabe-bearbeiten Button wird geklickt / Doppelklick auf Aufgabe
	public void bearbeiteAufgabe() {
		try {
			// Wenn in der JTable eine Zeile ausgew�hlt ist
			if (view.getTableAufgaben().getSelectedRow() > -1) {
				// Identifizieren der zu bearbeitenden Aufgabe
				aufgaben = new ArrayList(pruefung.getAufgaben());
				int selection = view.getTableAufgaben().getSelectedRow();
				Aufgabe zuBearbeitendeAufgabe = aufgaben.get(selection);

				// Aufgabendetails-Maske �ffnen und zu bearbeitende Aufgabe
				// �bergeben
				AufgabendetailsView detailView = new AufgabendetailsView(zuBearbeitendeAufgabe, view);
				detailView.getAfgdFrame().setTitle("Bearbeiten: " + zuBearbeitendeAufgabe.getAufgabentitel());
			} else {
				JOptionPane.showMessageDialog(view, "Keine Aufgabe ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}
	}

	// Aufgabe-L�schen-Button wird geklickt
	public void loescheAufgabe() {

		try {
			// Wenn in der JTable eine Zeile ausgew�hlt ist
			if (view.getTableAufgaben().getSelectedRow() > -1) {

				// Abfrage, ob wirklich gel�scht werden soll
				int reply = JOptionPane.showConfirmDialog(view, "Soll die Aufgabe wirklich gel�scht werden?", "Abfrage",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					// Identifizieren der zu l�schenden Aufgabe
					aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());
					int selection = view.getTableAufgaben().getSelectedRow();
					Aufgabe zuLoeschendeAufgabe = aufgaben.get(selection);

					// L�schen der Aufgabe aus der Datenbank und neuladen der
					// Tabelle

					pruefung.getAufgaben().remove(zuLoeschendeAufgabe);
					db.loescheAufgabe(zuLoeschendeAufgabe);
					fuelleAufgabenTable(pruefung);
				} else {
					// nichts tun
				}
			} else {
				JOptionPane.showMessageDialog(view, "Keine Aufgabe ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}

	}

	// Neu-Termin-Button wird geklickt
	public void neuTermin(Pruefung pruefung) {

		// Leere Termin-Details-Maske wird ge�ffnet
		TerminErstellenPopUp terminDetails = new TerminErstellenPopUp(view, pruefung);
	}

	// Termin-bearbeiten Button wird geklickt / Doppelklick auf Termin
	public void bearbeiteTermin() {
		try {
			// Wenn in der JTable eine Zeile ausgew�hlt ist
			if (view.getTableTermine().getSelectedRow() > -1) {
				// Identifizieren des zu bearbeitenden Termins
				termine = new ArrayList(pruefung.getTermine());
				int selection = view.getTableTermine().getSelectedRow();
				Termin zuBearbeitenderTermin = termine.get(selection);

				// Termindetails-Maske �ffnen und zu bearbeitende Aufgabe
				// �bergeben
				TerminErstellenPopUp detailView = new TerminErstellenPopUp(view, pruefung, zuBearbeitenderTermin);
				detailView.getFrmTermin()
						.setTitle("Bearbeiten - Termin f�r: " + zuBearbeitenderTermin.getPruefung().getBezeichnung());
			} else {
				JOptionPane.showMessageDialog(view, "Kein Termin ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}
	}

	// Termin-L�schen-Button wird geklickt
	public void loescheTermin() {

		try {
			// Wenn in der JTable eine Zeile ausgew�hlt ist
			if (view.getTableTermine().getSelectedRow() > -1) {

				// Abfrage, ob wirklich gel�scht werden soll
				int reply = JOptionPane.showConfirmDialog(view, "Soll der Termin wirklich gel�scht werden?", "Abfrage",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					// Identifizieren des zu l�schenden Termins
					termine = new ArrayList<Termin>(pruefung.getTermine());
					int selection = view.getTableTermine().getSelectedRow();
					Termin zuLoeschenderTermin = termine.get(selection);

					// L�schen des Termins aus der Liste und neuladen der
					// Tabelle
					pruefung.getTermine().remove(zuLoeschenderTermin);
					fuelleTermineTable(pruefung);
				} else {
					// nichts tun
				}
			} else {
				JOptionPane.showMessageDialog(view, "Kein Termin ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}

	}
	
	// Neu-Teilnehmer-Button wird geklickt
		public void neuTeilnehmer(Pruefung pruefung) {

			// Leere Teilnehmer-Details-Maske wird ge�ffnet
			NutzerErstellenPopUp nutzerDetails = new NutzerErstellenPopUp(view, pruefung);
		}
		
		// Teilnehmer-bearbeiten Button wird geklickt / Doppelklick auf Teilnehmer
		public void bearbeiteTeilnehmer() {
			try {
				// Wenn in der JTable eine Zeile ausgew�hlt ist
				if (view.getTableTeilnehmer().getSelectedRow() > -1) {
					// Identifizieren des zu bearbeitenden Teilnehmers
					teilnehmer = new ArrayList(pruefung.getNutzer());
					int selection = view.getTableTeilnehmer().getSelectedRow();
					Nutzer zuBearbeitenderTeilnehmer = teilnehmer.get(selection);

					// Termindetails-Maske �ffnen und zu bearbeitende Aufgabe
					// �bergeben
					NutzerErstellenPopUp detailView = new NutzerErstellenPopUp(view, pruefung, zuBearbeitenderTeilnehmer);
					detailView.getFrmTermin()
							.setTitle("Bearbeiten - Teilnehmer f�r: " + zuBearbeitenderTeilnehmer.getPruefung().getBezeichnung());
				} else {
					JOptionPane.showMessageDialog(view, "Kein Teilnehmer ausgew�hlt!");
				}
			} catch (Exception e) {
				// Was beim Fehler passiert
				JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
			}
		}
		
		// Teilnehmer-L�schen-Button wird geklickt
		public void loescheTeilnehmer() {

			try {
				// Wenn in der JTable eine Zeile ausgew�hlt ist
				if (view.getTableTeilnehmer().getSelectedRow() > -1) {

					// Abfrage, ob wirklich gel�scht werden soll
					int reply = JOptionPane.showConfirmDialog(view, "Soll der Teilnehmer wirklich gel�scht werden?", "Abfrage",
							JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {

						// Identifizieren des zu l�schenden Teilnehmers
						teilnehmer = new ArrayList<Nutzer>(pruefung.getNutzer());
						int selection = view.getTableTeilnehmer().getSelectedRow();
						Nutzer zuLoeschenderTeilnehmer = teilnehmer.get(selection);

						// L�schen des Teilnehmers aus der Liste und neuladen der
						// Tabelle
						pruefung.getNutzer().remove(zuLoeschenderTeilnehmer);
						fuelleTeilnehmerTable(pruefung);
					} else {
						// nichts tun
					}
				} else {
					JOptionPane.showMessageDialog(view, "Kein Teilnehmer ausgew�hlt!");
				}
			} catch (Exception e) {
				// Was beim Fehler passiert
				JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
			}

		}

	public void speichernPruefung(PruefungsverwaltungView pruefungsverwaltung) {
		String bezeichnung = view.getTextFieldPrfungstitel().getText();

		int dauer;
		try {
			dauer = Integer.parseInt(view.getTextFieldDauer().getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, e);
			dauer = 0;
		}

		int punkte;
		try {
			punkte = Integer.parseInt(view.getTextFieldPunkte().getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, e);
			punkte = 0;
		}

		pruefung.setBezeichnung(bezeichnung);
		pruefung.setDauer(dauer);
		pruefung.setPunkte(punkte);
		db.persistPruefung(pruefung);
		view.dispose();
		pruefungsverwaltung.tabelleFuellen();
	}
	
	public void loeschenPruefung(PruefungsverwaltungView pruefungsverwaltung){
		try {

				// Abfrage, ob wirklich gel�scht werden soll
				int reply = JOptionPane.showConfirmDialog(view, "Soll die Pr�fung wirklich gel�scht werden?",
						"Abfrage", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					// Identifizieren der zu l�schenden Pr�fung
					List<Pruefung> pruefungen = db.readPruefungen();
					Pruefung zuLoeschendePruefung = pruefung;

					// L�schen der Pr�fung aus der Datenbank und neuladen der
					// Tabelle
					db.loeschePruefungAusPruefungsverwaltung(zuLoeschendePruefung);
					view.dispose();
					pruefungsverwaltung.tabelleFuellen();
				} else {
					// nichts tun
				}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}
	}

}
