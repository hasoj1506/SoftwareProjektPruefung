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
import TableModels.PruefungsDetailsTermineTableModel;
import Views.AufgabendetailsView;
import Views.PruefungsDetails;

public class PruefungsDetailsController {
	// alle Methoden, die durch Bedienung der PruefungsDetails-View aufgerufen
	// werden k�nnen

	private PruefungsDetails view;
	private List<Aufgabe> aufgaben;
	private List<Nutzer> teilnehmer;
	private List<Termin> termine;
	private Pruefung pruefung;

	// um Zugriff auf die Datenbank zu bekommen
	DatabaseService db = DatabaseService.getInstance();

	public PruefungsDetailsController(PruefungsDetails view, List<Aufgabe> aufgaben, List<Nutzer> teilnehmer,
			List<Termin> termine, Pruefung pruefung) {
		super();
		this.view = view;
		this.aufgaben = aufgaben;
		this.teilnehmer = teilnehmer;
		this.termine = termine;
		this.pruefung = pruefung;
	}

	public PruefungsDetailsController(PruefungsDetails view) {
		this.view = view;
	}

	EntityManager em = DatabaseService.getInstance().getEntityManager();

	public List<Aufgabe> getAufgabenListe() {
		try {
			TypedQuery q = em.createQuery("SELECT a FROM Aufgabe a", Aufgabe.class);
			aufgaben = q.getResultList();
		} catch (Exception e) {
			// kommt noch
		}
		return aufgaben;
	}

	public void fuelleTabelleAufgaben() {
		try {
			aufgaben = getAufgabenListe();
			PruefungsDetailsAufgabenTableModel model = new PruefungsDetailsAufgabenTableModel(aufgaben);
			view.getTableAufgaben().setModel(model);
		} catch (Exception e) {
			// kommt noch
		}
	}

	// ab hier: Josah Weber
	public void fuellePruefungsDetails(Pruefung pruefung) {
		this.pruefung = pruefung;
		
		//Felder mit Daten der Pr�fung bef�llen
		JTextField textFieldPrfungstitel = view.getTextFieldPrfungstitel();
		JTextField textFieldDauer = view.getTextFieldDauer();
		JTextField textFieldPunkte = view.getTextFieldPunkte();
		JTable tableAufgaben = view.getTableAufgaben();
		JTable tableTermine = view.getTableTermine();

		textFieldPrfungstitel.setText(pruefung.getBezeichnung());
		textFieldDauer.setText(String.valueOf(pruefung.getDauer()));
		textFieldPunkte.setText(String.valueOf(pruefung.getPunkte()));

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

	// Neu-Aufgabe-Button wird geklickt
	public void neuAufgabe() {

		// Leere Aufgaben-Details-Maske wird ge�ffnet
		AufgabendetailsView aufgabenDetails = new AufgabendetailsView(pruefung);
	}

	// bearbeiten Button wird geklickt / Doppelklick auf Aufgabe
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
				AufgabendetailsView detailView = new AufgabendetailsView(zuBearbeitendeAufgabe);
				detailView.getAfgdFrame().setTitle("Bearbeiten: " + zuBearbeitendeAufgabe.getAufgabentitel());
			} else {
				JOptionPane.showMessageDialog(view, "Keine Aufgabe ausgew�hlt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}
	}

	// L�schen-Button wird geklickt
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
					
					db.loescheAufgabe(zuLoeschendeAufgabe);
					fuellePruefungsDetails(pruefung);
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
}
