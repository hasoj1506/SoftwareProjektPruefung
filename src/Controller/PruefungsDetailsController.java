package Controller;

import java.awt.Color;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableModel;

import DatabaseService.DatabaseService;
import Models.Aufgabe;
import Models.Nutzer;
import Models.Pruefung;
import Models.Student;
import Models.Termin;
import TableComparatoren.AufgabenComparator;
import TableComparatoren.TeilnehmerComparator;
import TableComparatoren.TerminComparator;
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
	// werden können

	private PruefungsDetails view;
	private List<Aufgabe> aufgaben;
	private List<Termin> termine;
	private List<Student> teilnehmer;
	private Pruefung pruefung;
	private PruefungsDetailsAufgabenTableModel tableModelAufgaben;

	// um Zugriff auf die Datenbank zu bekommen
	DatabaseService db = DatabaseService.getInstance();

	public PruefungsDetailsController(PruefungsDetails view, Pruefung pruefung) {
		this.view = view;
		this.pruefung = pruefung;
	}

	// Felder und Tabellen mit den Daten der Pruefung füllen
	public void fuellePruefungsDetails(Pruefung pruefung) {

		// Zu füllende Felder der View
		JTextField textFieldPrfungstitel = view.getTextFieldPrfungstitel();
		JTextField textFieldDauer = view.getTextFieldDauer();
		JTextField textFieldPunkte = view.getTextFieldPunkte();

		// Felder mit Daten der Prüfung füllen
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

		// Tabellen füllen
		fuelleAufgabenTable(pruefung);
		fuelleTermineTable(pruefung);
		fuelleTeilnehmerTable(pruefung);
		
		if(pruefung.isFreigegeben() == true) {
			view.getBtnFreigeben().setText("Sperren");
		} else {
			view.getBtnFreigeben().setText("Freigeben");
		}
	}

	public void fuelleTeilnehmerTable(Pruefung pruefung) {

		// Zu füllende Tabelle der View
		JTable tableTeilnehmer = view.getTableTeilnehmer();

		try {
			// Liste mit Teilnehmern der Prüfung erstellen
			teilnehmer = new ArrayList<Student>(pruefung.getStudenten());
			Collections.sort(teilnehmer, new TeilnehmerComparator());

			// Dem JTable das Model inklusive Liste zuweisen
			PruefungsDetailsTeilnehmerTableModel tableModelTeilnehmer = new PruefungsDetailsTeilnehmerTableModel(
					teilnehmer);
			tableTeilnehmer.setModel(tableModelTeilnehmer);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Teilnehmer-Tabelle konnte nicht gefüllt werden!");
		}
	}

	public void fuelleTermineTable(Pruefung pruefung) {

		// Zu füllende Tabelle der View
		JTable tableTermine = view.getTableTermine();

		try {
			// Liste mit Terminen der Prüfung erstellen
			termine = new ArrayList<Termin>(pruefung.getTermine());
			Collections.sort(termine, new TerminComparator());

			// Dem JTable das Model inklusive Liste zuweisen
			PruefungsDetailsTermineTableModel tableModelTermine = new PruefungsDetailsTermineTableModel(termine);
			tableTermine.setModel(tableModelTermine);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Termine-Tabelle konnte nicht gefüllt werden!");
		}
	}

	public void fuelleAufgabenTable(Pruefung pruefung) {

		// Zu füllende Tabelle der View
		JTable tableAufgaben = view.getTableAufgaben();

		try {
			// Liste mit Aufgaben der Prüfung erstellen
			aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());
			Collections.sort(aufgaben, new AufgabenComparator());

			// Dem JTable das Model inklusive Liste zuweisen

			tableModelAufgaben = new PruefungsDetailsAufgabenTableModel(aufgaben);
			tableAufgaben.setModel(tableModelAufgaben);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Aufgaben-Tabelle konnte nicht gefüllt werden!");
		}
	}

	// Neu-Aufgabe-Button wird geklickt
	public void neuAufgabe(Pruefung pruefung) {
		Aufgabe aufgabe = new Aufgabe();
		aufgabe.setPruefung(pruefung);

		// Leere Aufgaben-Details-Maske wird geöffnet
		AufgabendetailsView aufgabenDetails = new AufgabendetailsView(aufgabe, view);
	}

	// Aufgabe-bearbeiten Button wird geklickt / Doppelklick auf Aufgabe
	public void bearbeiteAufgabe() {
		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTableAufgaben().getSelectedRow() > -1) {

				// Identifizieren der zu bearbeitenden Aufgabe
				aufgaben = new ArrayList(pruefung.getAufgaben());
				Collections.sort(aufgaben, new AufgabenComparator());
				int selection = view.getTableAufgaben().getSelectedRow();
				Aufgabe zuBearbeitendeAufgabe = aufgaben.get(selection);

				// Aufgabendetails-Maske öffnen und zu bearbeitende Aufgabe
				// übergeben
				AufgabendetailsView detailView = new AufgabendetailsView(zuBearbeitendeAufgabe, view);
			} else {
				JOptionPane.showMessageDialog(view, "Keine Aufgabe ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Aufgabe kann nicht bearbeitet werden!");
		}
	}

	// Aufgabe-Löschen-Button wird geklickt
	public void loescheAufgabe() {

		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTableAufgaben().getSelectedRow() > -1) {

				// Abfrage, ob wirklich gelöscht werden soll
				int reply = JOptionPane.showConfirmDialog(view, "Soll die Aufgabe wirklich gelöscht werden?", "Abfrage",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					// Identifizieren der zu löschenden Aufgabe
					aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());
					Collections.sort(aufgaben, new AufgabenComparator());
					int selection = view.getTableAufgaben().getSelectedRow();
					Aufgabe zuLoeschendeAufgabe = aufgaben.get(selection);

					// Löschen der Aufgabe aus der Datenbank und neuladen der
					// Tabelle
					pruefung.getAufgaben().remove(zuLoeschendeAufgabe);
					db.loescheAufgabe(zuLoeschendeAufgabe);
					fuelleAufgabenTable(pruefung);
				} else {
					// nichts tun
				}
			} else {
				JOptionPane.showMessageDialog(view, "Keine Aufgabe ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Aufgabe konnte nicht gelöscht werden!");
		}

	}

	// Neu-Termin-Button wird geklickt
	public void neuTermin(Pruefung pruefung) {

		// Leere Termin-Details-Maske wird geöffnet
		TerminErstellenPopUp terminDetails = new TerminErstellenPopUp(view, pruefung);
		terminDetails.getFrmTermin().setTitle("Neuer Termin");
	}

	// Termin-bearbeiten Button wird geklickt / Doppelklick auf Termin
	public void bearbeiteTermin() {

		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTableTermine().getSelectedRow() > -1) {

				// Identifizieren des zu bearbeitenden Termins
				termine = new ArrayList(pruefung.getTermine());
				Collections.sort(termine, new TerminComparator());
				int selection = view.getTableTermine().getSelectedRow();
				Termin zuBearbeitenderTermin = termine.get(selection);

				// Termindetails-Maske öffnen und zu bearbeitende Aufgabe
				// übergeben
				TerminErstellenPopUp detailView = new TerminErstellenPopUp(view, pruefung, zuBearbeitenderTermin);
				detailView.getFrmTermin()
						.setTitle("Bearbeiten - Termin für: " + zuBearbeitenderTermin.getPruefung().getBezeichnung());
			} else {
				JOptionPane.showMessageDialog(view, "Kein Termin ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Termin konnte nicht bearbeitet werden!" + e);
		}
	}

	// Termin-Löschen-Button wird geklickt
	public void loescheTermin() {

		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTableTermine().getSelectedRow() > -1) {

				// Abfrage, ob wirklich gelöscht werden soll
				int reply = JOptionPane.showConfirmDialog(view, "Soll der Termin wirklich gelöscht werden?", "Abfrage",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					// Identifizieren des zu löschenden Termins
					termine = new ArrayList<Termin>(pruefung.getTermine());
					Collections.sort(termine, new TerminComparator());
					int selection = view.getTableTermine().getSelectedRow();
					Termin zuLoeschenderTermin = termine.get(selection);

					// Löschen des Termins aus der Liste und neuladen der
					// Tabelle
					pruefung.getTermine().remove(zuLoeschenderTermin);
					db.loescheTermin(zuLoeschenderTermin);
					fuelleTermineTable(pruefung);
				} else {
					// nichts tun
				}
			} else {
				JOptionPane.showMessageDialog(view, "Kein Termin ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Termin konnte nicht gelöscht werden!");
		}

	}

	// Neu-Teilnehmer-Button wird geklickt
	public void neuTeilnehmer(Pruefung pruefung) {

		// Leere Teilnehmer-Details-Maske wird geöffnet
		NutzerErstellenPopUp nutzerDetails = new NutzerErstellenPopUp(view, pruefung);
		nutzerDetails.getFrmNutzer().setTitle("Neuer Teilnehmer");
	}

	// Teilnehmer-bearbeiten Button wird geklickt / Doppelklick auf Teilnehmer
	public void bearbeiteTeilnehmer() {
		try {

			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTableTeilnehmer().getSelectedRow() > -1) {

				// Identifizieren des zu bearbeitenden Teilnehmers
				teilnehmer = new ArrayList(pruefung.getStudenten());
				Collections.sort(teilnehmer, new TeilnehmerComparator());
				int selection = view.getTableTeilnehmer().getSelectedRow();
				Student zuBearbeitenderTeilnehmer = teilnehmer.get(selection);

				// Termindetails-Maske öffnen und zu bearbeitende Aufgabe
				// übergeben
				NutzerErstellenPopUp detailView = new NutzerErstellenPopUp(view, pruefung, zuBearbeitenderTeilnehmer);
				detailView.getFrmNutzer().setTitle(
						"Bearbeiten - Teilnehmer für: " + zuBearbeitenderTeilnehmer.getPruefung().getBezeichnung());
			} else {
				JOptionPane.showMessageDialog(view, "Kein Teilnehmer ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Teilnehmer konnte nicht bearbeitet werden!");
		}
	}

	// Teilnehmer-Löschen-Button wird geklickt
	public void loescheTeilnehmer() {

		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (view.getTableTeilnehmer().getSelectedRow() > -1) {

				// Abfrage, ob wirklich gelöscht werden soll
				int reply = JOptionPane.showConfirmDialog(view, "Soll der Teilnehmer wirklich gelöscht werden?",
						"Abfrage", JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {

					// Identifizieren des zu löschenden Teilnehmers
					teilnehmer = new ArrayList<Student>(pruefung.getStudenten());
					Collections.sort(teilnehmer, new TeilnehmerComparator());
					int selection = view.getTableTeilnehmer().getSelectedRow();
					Nutzer zuLoeschenderTeilnehmer = teilnehmer.get(selection);

					// Löschen des Teilnehmers aus der Liste und neuladen der
					// Tabelle
					pruefung.getStudenten().remove(zuLoeschenderTeilnehmer);
					db.loescheNutzer(zuLoeschenderTeilnehmer);
					fuelleTeilnehmerTable(pruefung);
				} else {
					// nichts tun
				}
			} else {
				JOptionPane.showMessageDialog(view, "Kein Teilnehmer ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Teilnehmer konnte nicht gelöscht werden!");
		}

	}

	// Teilnehmer-importieren Button wird geklickt
	public void importiereTeilnehmer() {
		try {
			JFileChooser fc = new JFileChooser();
			fc.setDialogTitle("Welche Datei soll importiert werden?");
			int auswahl = fc.showOpenDialog(null);

			if (auswahl == JFileChooser.APPROVE_OPTION) {

				int importierteTeilnehmer = 0;

				String dateiPfad = fc.getSelectedFile().getAbsolutePath();

				BufferedReader CSVFile = new BufferedReader(new FileReader(dateiPfad));
				String dataRow = CSVFile.readLine();

				// Um die Kopfzeile zu überspringen, direkt in die zweite Zeile
				// der csv
				dataRow = CSVFile.readLine();

				while (dataRow != null && !dataRow.isEmpty()) {
					String[] dataArray = dataRow.split(";");

					String nachname = dataArray[0];
					String vorname = dataArray[1];
					String matrikelnummer = dataArray[2];
					int matrikelNr = 0;
					try {
						matrikelNr = Integer.parseInt(matrikelnummer);
					} catch (Exception e) {
						// noch füllen
					}

					Student teilnehmer = new Student(vorname, nachname, matrikelNr);
					teilnehmer.setPruefung(pruefung);
					pruefung.addStudent(teilnehmer);

					dataRow = CSVFile.readLine();
					importierteTeilnehmer++;
				}
				CSVFile.close();
				JOptionPane.showMessageDialog(view, "Es wurden " + importierteTeilnehmer + " Teilnehmer importiert!");
				fuelleTeilnehmerTable(pruefung);
			} else {
				// nichts tun
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Teilnehmer konnten nicht importiert werden!");
		}
	}

	// Teilnehmer-exportieren Button wird geklickt
	public void exportiereTeilnehmer() {
		try {

			// Pfad auswählen, wo Datei gespeichert werden soll
			JFileChooser fc = new JFileChooser();
			fc.setApproveButtonText("Hier speichern");
			fc.setDialogTitle("Wo soll die Datei gespeichert werden?");
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int auswahl = fc.showOpenDialog(null);

			// Wenn "hier speichern" geklickt wurde
			if (auswahl == JFileChooser.APPROVE_OPTION) {

				// Dateipfad holen
				String dateipfad = fc.getSelectedFile().getAbsolutePath();

				// Dateiname soll Auswertung plus Pruefungstitel und Zeit (um
				// überschreiben zu vermeiden)
				// beinhalten
				Date heute = new Date();
				int stunde = heute.getHours();
				int minute = heute.getMinutes();
				int sekunden = heute.getSeconds();
				String dateiname = "Auswertung-" + pruefung.getBezeichnung() + "-" + stunde + "-" + minute + "-"
						+ sekunden;

				// Excel-File am gewählten Pfad erstellen
				File excelFile = new File(dateipfad + "\\" + dateiname + ".xls");
				OutputStream excelStream = new FileOutputStream(excelFile);

				// Excel-Datei mit Daten der JTable füllen
				TableModel model = view.getTableTeilnehmer().getModel();
				FileWriter excelWriter = new FileWriter(excelFile);

				for (int i = 0; i < model.getColumnCount(); i++) {
					excelWriter.write(model.getColumnName(i) + "\t");
				}

				excelWriter.write("\n");

				for (int i = 0; i < model.getRowCount(); i++) {
					for (int j = 0; j < model.getColumnCount(); j++) {
						excelWriter.write(model.getValueAt(i, j).toString() + "\t");
					}
					excelWriter.write("\n");
				}
				excelWriter.close();

				// Erfolgsmeldung
				JOptionPane.showMessageDialog(view, "Teilnehmerliste wurde an folgenden Pfad exportiert: \n\n"
						+ dateipfad + "\\" + dateiname + ".xls");
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(view, "Teilnehmerliste konnte nicht exportiert werden!" + e);
		}
	}

	// Prüfung-speichern-Button wird geklickt
	public void speichernPruefung(PruefungsverwaltungView pruefungsverwaltung) {

		// Werte aus den Feldern holen
		String bezeichnung = view.getTextFieldPrfungstitel().getText();

		int dauer;
		try {
			dauer = Integer.parseInt(view.getTextFieldDauer().getText());
		} catch (Exception e) {
			dauer = 0;
		}

		double punkte;
		try {
			punkte = Double.parseDouble(view.getTextFieldPunkte().getText());
		} catch (Exception e) {
			punkte = 0.0;
		}

		// Standard-Füllfarbe der Felder
		view.getTextFieldPrfungstitel().setBackground(Color.WHITE);
		view.getTextFieldDauer().setBackground(Color.WHITE);

		// Wenn die Felder gefüllt sind, Pruefung mit Daten versehen,
		// andernfalls zum Füllen auffordern
		if (bezeichnung.length() <= 0) {
			view.getTextFieldPrfungstitel().setBackground(Color.RED);
			JOptionPane.showMessageDialog(view, "Bitte Bezeichnung korrekt füllen!");
		} else if (dauer == 0) {
			view.getTextFieldDauer().setBackground(Color.RED);
			JOptionPane.showMessageDialog(view, "Bitte Dauer korrekt füllen!");
		} else {
			pruefung.setBezeichnung(bezeichnung);
			pruefung.setDauer(dauer);
			pruefung.setPunkte(punkte);
			pruefung.setVerwuerfelt(view.getChckbxAufgabenVerwrfeln().isSelected());
			db.persistPruefung(pruefung);
			view.setVisible(false);
		}
	}

	// Prüfung-löschen-Button wird geklickt
	public void loeschenPruefung(PruefungsverwaltungView pruefungsverwaltung) {
		try {

			// Abfrage, ob wirklich gelöscht werden soll
			int reply = JOptionPane.showConfirmDialog(view, "Soll die Prüfung wirklich gelöscht werden?", "Abfrage",
					JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {

				// Identifizieren der zu löschenden Prüfung
				List<Pruefung> pruefungen = db.readPruefungen();
				Pruefung zuLoeschendePruefung = pruefung;

				// Löschen der Prüfung aus der Datenbank und neuladen der
				// Tabelle
				db.loeschePruefungAusPruefungsverwaltung(zuLoeschendePruefung);
				view.setVisible(false);
			} else {
				// nichts tun
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Prüfung konnte nicht gelöscht werden!");
		}
	}
	
	public void pruefungFreigeben() {
		if(pruefung.isFreigegeben() == false) {
			pruefung.setFreigegeben(true);
			view.getBtnFreigeben().setText("Sperren");
		}else {
			pruefung.setFreigegeben(false);
			view.getBtnFreigeben().setText("Freigeben");
		}
		
	}

	public PruefungsDetailsAufgabenTableModel getTableModelAufgaben() {
		return tableModelAufgaben;
	}

}
