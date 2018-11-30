package Controller;

import Models.Aufgabe;
import Models.Pruefung;
import Views.AufgabendetailsView;
import Views.FehlerPopUp;

public class AufgabenDetailsController {

	Aufgabe aufgabe;
	AufgabendetailsView view;
	Pruefung pruefung;

	public AufgabenDetailsController(AufgabendetailsView view, Aufgabe aufgabe, Pruefung pruefung) {
		this.aufgabe = aufgabe;
		this.pruefung = pruefung;
		this.view = view;

	}

	public AufgabenDetailsController(AufgabendetailsView view, Pruefung pruefung) {
		this.view = view;
		this.pruefung = pruefung;

	}

	public AufgabenDetailsController() {

	}

	public Aufgabe aufgabeSpeichern() {

		if (this.aufgabe == null) {

			aufgabe = new Aufgabe();
			aufgabe.setPruefung(this.pruefung);
		}

		String titel = view.getAfgdTitelTextField().getText();
		int punkte = 0;
		String frage = view.getAfgdFrageTextField().getText();

		if (titel.equals("")) {
			FehlerPopUp fehlermeldungTitel = new FehlerPopUp("Fehler - Titel", "Angegebner Titel nicht zulässig!");
		}

		if (frage.equals("")) {
			FehlerPopUp fehlermeldungText = new FehlerPopUp("Fehler - Fragetext",
					"Angegebener Fragetext nicht zulässig!");
		}

		try {

			punkte = Integer.parseInt(view.getAfgdPunkteTextField().getText());

		} catch (NumberFormatException e) {

			FehlerPopUp fehlermeldungPunkte = new FehlerPopUp("Fehler - Punktzahl",
					"Angegebene Punktzahl nicht zulässig!");

		}

		aufgabe.setAufgabentitel(titel);
		aufgabe.setFrageStellung(frage);
		aufgabe.setPunktzahl(punkte);
		// aufgabe.setAntworten();

		return this.aufgabe;

	}

	public void aufgabeLoeschen() {

	}

	public void antwortErstellen() {

	}

	public void antwortLoeschen() {

	}

	public void antwortBearbeiten() {

	}

	public Aufgabe getAufgabe() {
		return this.aufgabe;
	}
}
