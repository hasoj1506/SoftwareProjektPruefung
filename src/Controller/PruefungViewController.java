package Controller;

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
		setPruefungstitel(pruefung);
		setMatrNummer(nutzer);
		model = new PruefungViewAufgabenTableModel(new ArrayList<Aufgabe>(pruefung.getAufgaben()));
		view.getAufgabenTable().setModel(model);

	}

	public void abgeben() {

		if (view.isZeitUm() == false) {

			int reply = JOptionPane.showConfirmDialog(view.getFrame(), "Möchtest du wirklich abgeben?", "Abfrage",
					JOptionPane.YES_NO_OPTION);

			if (reply == JOptionPane.YES_OPTION) {

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
		if (selection == model.getRowCount()) {
			selection = 0;

		} else {
			selection++;
		}

	}

	public void vorherige() {
		if (selection == 0) {
			selection = model.getRowCount();
		} else {
			selection--;
		}

	}

	public void timerAbgelaufen() {

		abgeben();
	}

}
