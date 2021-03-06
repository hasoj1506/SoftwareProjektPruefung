package Controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DatabaseService.DatabaseService;
import Models.Antwort;
import Models.Aufgabe;
import Models.Pruefung;
import Models.Student;
import TableModels.PruefungViewAufgabenTableModel;
import TableModels.PruefungViewTableModel;
import Views.AuswertungView;
import Views.PruefungView;

//Beteiligt: Yanek Wilken, Marco Penner
public class PruefungViewController {

	// alle Methoden, die durch Bedienung der PruefungView aufgerufen werden
	// k�nnen

	//ab hier: Marco Penner
	Pruefung pruefung;
	Student student;
	List<Aufgabe> aufgaben;
	DatabaseService service = DatabaseService.getInstance();

	PruefungView view;
	PruefungViewAufgabenTableModel model;
	PruefungViewTableModel antwortenModel;

	boolean abgegeben = false;

	private int selection;

	public PruefungViewController(PruefungView view, Pruefung pruefung, Student student) {
		this.view = view;
		this.pruefung = pruefung;
		this.student = student;
		this.aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());

	}

	
	public void fuelleAufgabenTabelle() {
		model = new PruefungViewAufgabenTableModel(new ArrayList<Aufgabe>(pruefung.getAufgaben()));

		if (pruefung.isVerwuerfelt()) {
			model.verwuerfeln();
		}

		view.getAufgabenTable().setModel(model);
		view.getAufgabenTable().setRowSelectionInterval(0, 0);
		fuelleAufgabe();
	}

	public void abgeben() {

		int reply = 0;

		// Wenn Zeit noch nicht abgelaufen, Best�tigung fordern
		if (view.isZeitUm() == false) {

			reply = JOptionPane.showConfirmDialog(view.getFrame(), "M�chtest du wirklich abgeben?", "Abfrage",
					JOptionPane.YES_NO_OPTION);
		} else if (view.isZeitUm() == true) {

			// Wenn Zeit abgelaufen, keine Best�tigung mehr erw�nscht
			reply = JOptionPane.YES_OPTION;
		}

		// Jede Antwort mit der L�sung abgleichen und Punkte berechnen
		if (reply == JOptionPane.YES_OPTION) {
			abgegeben();
		} else {
			// nichts tun wenn nein geklickt wurde
		}

	}

	public void abgegeben() {
		abgegeben = true;
		double ergebnis = berechneErgebnis();

		// Antworten zur�cksetzen

		for (Aufgabe aufgabe : aufgaben) {

			for (Antwort antwort : aufgabe.getAntworten()) {
				antwort.setAlsRichtigBeantwortet(false);

			}
		}

		// Dem Nutzer die erreichten Punkte in die Datenbank schreiben
		view.getFrame().dispose();
		AuswertungView auswertungsView = new AuswertungView(student, ergebnis);
	}

	
	public void fuelleAufgabe() {
		/*
		 * Table ausf�llen Textfelder ausf�llen
		 */
		try {
			if (view.getAufgabenTable().getSelectedRow() > -1) {

				aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());
				selection = view.getAufgabenTable().getSelectedRow();
				Aufgabe ausgewaehlteAufgabe = aufgaben.get(selection);

				view.getTxtAufgabentitel().setText(ausgewaehlteAufgabe.getAufgabentitel());
				view.getTxtAufgabentext().setForeground(Color.BLACK);
				view.getTxtAufgabentext().setText(ausgewaehlteAufgabe.getFrageStellung());
				antwortenModel = new PruefungViewTableModel(new ArrayList<Antwort>(ausgewaehlteAufgabe.getAntworten()));

				if (ausgewaehlteAufgabe.isVerwuerfelt()) {
					antwortenModel.verwuerfeln();
				}
				view.getAntwortenTable().setModel(antwortenModel);

			} else {
				// nichts wird ausgef�llt
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(view.getFrame(), "Fehler!");
		}
	}

	public void setMatrNummer(Student student) {

		view.getTxtMatrikelnummer().setText(student.getMatrikelNr() + "");

	}

	public void setPruefungstitel(Pruefung pruefung) {

		view.getLblPrfungstitel().setText(pruefung.getBezeichnung());
	}

	public void naechste() {
		selection = view.getAufgabenTable().getSelectedRow();
		if (selection == view.getAufgabenTable().getRowCount() - 1) {
			view.getAufgabenTable().setRowSelectionInterval(0, 0);
			fuelleAufgabe();
		} else {
			view.getAufgabenTable().setRowSelectionInterval(selection++, selection++);
			fuelleAufgabe();
		}

	}

	public void vorherige() {
		selection = view.getAufgabenTable().getSelectedRow();
		if (selection == 0) {
			view.getAufgabenTable().setRowSelectionInterval(view.getAufgabenTable().getRowCount() - 1,
					view.getAufgabenTable().getRowCount() - 1);
			fuelleAufgabe();
		} else {
			view.getAufgabenTable().setRowSelectionInterval(selection--, selection--);
			fuelleAufgabe();
		}

	}

	
	public void timerAbgelaufen() {

		abgegeben();
	}

	//ab hier: Yanek Wilken
	//Berechnung der Gesamtpunktzahl; Bei zwei Antwort, reicht 1 Fehler f�r 0 Punkte
	public double berechneErgebnis() {

		double gesamtePunktzahl = 0;

		for (Aufgabe aufgabe : this.aufgaben) {

			double punkteProAufgabe = aufgabe.getPunktzahl();
			int anzFalsch = 0;

			for (Antwort antwort : aufgabe.getAntworten()) {

				if ((antwort.isIstRichtig() != antwort.isAlsRichtigBeantwortet())) {

					anzFalsch++;

				}
			}

			if (aufgabe.getAntworten().size() < 3) {

				if (anzFalsch > 0) {
					punkteProAufgabe = 0;
				}

			} else {

				if (anzFalsch == 1) {
					punkteProAufgabe = punkteProAufgabe - (0.5 * aufgabe.getPunktzahl());
				} else if (anzFalsch > 1) {
					punkteProAufgabe = 0;
				}
			}

			aufgabe.setErreichtePunktzahl(punkteProAufgabe);
			gesamtePunktzahl = gesamtePunktzahl + punkteProAufgabe;

		}

		return gesamtePunktzahl;
	}

	public boolean isAbgegeben() {
		return abgegeben;
	}

}
