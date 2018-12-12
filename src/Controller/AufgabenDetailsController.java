package Controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JOptionPane;

import DatabaseService.DatabaseService;
import Models.Antwort;
import Models.Aufgabe;
import Models.Pruefung;
import TableModels.AufgabendetailsTableModel;
import TableModels.PruefungsverwaltungTableModel;
import Views.AntwortErstellenPopUp;
import Views.AufgabendetailsView;

public class AufgabenDetailsController {

	Aufgabe aufgabe;
	AufgabendetailsView view;
	Pruefung pruefung;
	DatabaseService service = DatabaseService.getInstance();

	AufgabendetailsTableModel model;

	public AufgabenDetailsController(AufgabendetailsView view, Aufgabe aufgabe) { // Konstruktor falls bestehende
																					// Aufgabe bearbeitet wird
		this.aufgabe = aufgabe;
		this.pruefung = aufgabe.getPruefung();
		this.view = view;
		model = new AufgabendetailsTableModel(new ArrayList<Antwort>(aufgabe.getAntworten()));
		view.getAfgdTable().setModel(model);

	}

	public AufgabenDetailsController(AufgabendetailsView view, Pruefung pruefung) { // Konstruktor falls neue Aufgabe
																					// erzeugt wird
		this.view = view;
		this.pruefung = pruefung;
		view.getAfgdTable().setModel(new AufgabendetailsTableModel());
		this.model = new AufgabendetailsTableModel();
		view.getAfgdTable().setModel(model);

	}

	public void aufgabeSpeichern() {

		if (this.aufgabe == null) { // Prüft ob neue Aufgabe oder bestehene Aufgabe bearbeitet wird und erzeugt ggf.
									// eine neue Aufgabe

			aufgabe = new Aufgabe();
			aufgabe.setPruefung(this.pruefung);
		}

		int punkte = 0;
		String titel = view.getAfgdTitelTextField().getText();
		String frage = view.getAfgdFrageTextField().getText();

		if (titel == ("") || titel.length() == 0) {

			view.fehlerMeldung("Fehler: Der Titel darf nicht leer sein!");

		} else {

			aufgabe.setAufgabentitel(titel);

			if (frage == ("") || frage.length() == 0) {

				view.fehlerMeldung("Fehler: Der Fragetext darf nicht leer sein!");

			} else {

				aufgabe.setFrageStellung(frage);

				try {

					punkte = Integer.parseInt(view.getAfgdPunkteTextField().getText());

				} catch (NumberFormatException e) { // Prüft ob Punktzahl im richtigen Format ist {

					view.fehlerMeldung("Fehler: Die Punktzahl ist nicht im richtigen Format!");

				}

				aufgabe.setPunktzahl(punkte);

				if (model.getRowCount() < 2) {
					view.fehlerMeldung("Eine Aufgabe muss mindestens 2 Antworten haben");
				} else {

					if (model.getMindestensEineRichtig() == true) {
						aufgabe.setAntworten(new HashSet<Antwort>(model.getAntworten()));
						view.setAufgabe(aufgabe);
						pruefung.addAufgabe(aufgabe);
						view.getPruefungsDetailsView().getPruefungsDetailController().fuelleAufgabenTable(pruefung);
						view.schliessen();
					} else {
						view.fehlerMeldung("Es muss mindestens eine Aufgabe geben die richtig ist.");

					}
				}

			}
		}

	}

	public void aufgabeLoeschen() {

		if (this.aufgabe != null) {

			int reply = JOptionPane.showConfirmDialog(view.getAfgdFrame(), "Soll die Aufgabe wirklich gelöscht werden?",
					"Abfrage", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {

				try {
					service.loescheAufgabe(this.aufgabe);
					pruefung.getAufgaben().remove(aufgabe);
				} catch (NullPointerException e) {
					view.fehlerMeldung("Es ist ein Fehler aufgetreten!");
				}
				view.schliessen();
				view.getPruefungsDetailsView().getPruefungsDetailController().fuelleAufgabenTable(pruefung);
			}
		} else {
			view.schliessen();
		}

	}

	public void antwortErstellen() {

		AntwortErstellenPopUp pop = new AntwortErstellenPopUp(this.view);

	}

	public void antwortLoeschen() {

		if (view.getAfgdTable().getModel().getRowCount() > 0) {

			model.removeRow(model.get(view.getAfgdTable().getSelectedRow()));
			view.getAfgdTable().clearSelection();
			view.getAfgdTable().updateUI();
		} else {
			view.fehlerMeldung("Es sind keine Antworten vorhanden!");
		}
	}

	public void antwortBearbeiten() {

		if (view.getAfgdTable().getModel().getRowCount() > 0) {
			if (view.getAfgdTable().getSelectedRow() == -1) {
				view.fehlerMeldung("Es wurde keine Antwort ausgewählt!");
			} else {
				AntwortErstellenPopUp pop = new AntwortErstellenPopUp(this.view,
						model.get(view.getAfgdTable().getSelectedRow()));
			}
		} else {
			view.fehlerMeldung("Es sind keine Antworten vorhanden!");
		}

	}

	public Aufgabe getAufgabe() {
		return this.aufgabe;
	}

	public AufgabendetailsTableModel getModel() {
		return this.model;
	}

}
