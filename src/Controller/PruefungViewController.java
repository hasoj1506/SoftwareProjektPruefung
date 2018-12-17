package Controller;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

import DatabaseService.DatabaseService;
import Models.Antwort;
import Models.Aufgabe;
import Models.Nutzer;
import Models.Pruefung;
import TableModels.PruefungViewAufgabenTableModel;
import TableModels.PruefungViewTableModel;
import Views.PruefungView;

public class PruefungViewController {

	// alle Methoden, die durch Bedienung der PruefungView aufgerufen werden
	// können

	Pruefung pruefung;
	Nutzer nutzer;
	List<Aufgabe> aufgaben;
	DatabaseService service = DatabaseService.getInstance();

	PruefungView view;
	PruefungViewAufgabenTableModel model;
	PruefungViewTableModel antwortenModel;

	private int selection;

	public PruefungViewController(PruefungView view, Pruefung pruefung, Nutzer nutzer) {
		this.view = view;
		this.pruefung = pruefung;
		this.nutzer = nutzer;
		this.aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());
		setPruefungstitel(pruefung);
		setMatrNummer(nutzer);
		aufgabeAuswaehlenAufforderung();
		model = new PruefungViewAufgabenTableModel(new ArrayList<Aufgabe>(pruefung.getAufgaben()));
		view.getAufgabenTable().setModel(model);
		view.getAufgabenTable().setRowSelectionInterval(0, 0);
		fuelleAufgabe();

	}
	
	//Josah Weber
	public void abgeben() {
		Aufgabe aufgabe;
		List<Antwort> antworten;
		Antwort antwort;
		int punkte;
		int neuePunktzahl = 0;
		
		if (view.isZeitUm() == false) {

			int reply = JOptionPane.showConfirmDialog(view.getFrame(), "Möchtest du wirklich abgeben?", "Abfrage",
					JOptionPane.YES_NO_OPTION);
			
			//Jede Antwort mit der Lösung abgleichen und Punkte berechnen
			if (reply == JOptionPane.YES_OPTION) {
				for (int i = 0; i < aufgaben.size(); i++) {
					aufgabe = aufgaben.get(i);
					antworten = new ArrayList<Antwort>(aufgabe.getAntworten());

					for (int j = 0; j < antworten.size(); j++) {
						antwort = antworten.get(j);

						if (antwort.isIstRichtig() == antwort.isAlsRichtigBeantwortet()) {
							punkte = antwort.getPunkte();
							neuePunktzahl = neuePunktzahl + punkte;
							nutzer.setErreichtePunktzahl(neuePunktzahl);
						}
					}

				}

				// Antworten zurücksetzen
				for (int i = 0; i < aufgaben.size(); i++) {
					aufgabe = aufgaben.get(i);
					antworten = new ArrayList<Antwort>(aufgabe.getAntworten());

					for (int j = 0; j < antworten.size(); j++) {
						antwort = antworten.get(j);

						antwort.setAlsRichtigBeantwortet(false);
					}

				}
				
				//Dem Nutzer die erreichten Punkte in die Datenbank schreiben
				service.persistNutzer(nutzer);
				JOptionPane.showMessageDialog(view.getFrame(),
						"Erreichte Punktzahl: " + neuePunktzahl + " von " + pruefung.getPunkte());
				view.getFrame().dispose();

			}
		}

	}

	public void fuelleAufgabe() {
		/*
		 * Table ausfüllen Textfelder ausfüllen
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
				view.getAntwortenTable().setModel(antwortenModel);

			} else {
				// nichts wird ausgefüllt
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(view.getFrame(), "Fehler!");
		}
	}

	public void setMatrNummer(Nutzer nutzer) {

		view.getTxtMatrikelnummer().setText(nutzer.getNutzerId() + "");

	}

	public void setPruefungstitel(Pruefung pruefung) {

		view.getLblPrfungstitel().setText(pruefung.getBezeichnung());
	}

	public void naechste() {
		selection = view.getAufgabenTable().getSelectedRow();
		if (selection == view.getAufgabenTable().getRowCount()-1) {
			view.getAufgabenTable().setRowSelectionInterval(0, 0);
			fuelleAufgabe();
		}else{
			view.getAufgabenTable().setRowSelectionInterval(selection++, selection++);
			fuelleAufgabe();
		}

	}

	public void vorherige() {
		selection = view.getAufgabenTable().getSelectedRow();
		if (selection == 0) {
			view.getAufgabenTable().setRowSelectionInterval(view.getAufgabenTable().getRowCount()-1, view.getAufgabenTable().getRowCount()-1);
			fuelleAufgabe();
		}else{
			view.getAufgabenTable().setRowSelectionInterval(selection--, selection--);
			fuelleAufgabe();
		}

	}

	public void timerAbgelaufen() {

		abgeben();
	}

	public void aufgabeAuswaehlenAufforderung() {
		view.getTxtAufgabentext().setText("Bitte wähle links eine Aufgabe aus!");
		view.getTxtAufgabentext().setForeground(Color.RED);
	}

}
