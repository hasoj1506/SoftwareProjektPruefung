package Controller;

import Models.Aufgabe;
import Models.Pruefung;
import Views.AufgabendetailsView;
import Views.FehlerPopUp;

public class AufgabenDetailsController {

	Aufgabe aufgabe;
	AufgabendetailsView view;
	Pruefung pruefung;

	public AufgabenDetailsController(AufgabendetailsView view, Pruefung pruefung, Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
		this.pruefung = pruefung;
		this.view = view;

	}

	public AufgabenDetailsController(AufgabendetailsView view, Pruefung pruefung) {
		this.view = view;
		this.pruefung = pruefung;

	}

	public Aufgabe aufgabeSpeichern() {

		if (this.aufgabe == null) {

			aufgabe = new Aufgabe();
			aufgabe.setPruefung(this.pruefung);
		}

		String titel = view.getAfgdTitelTextField().getText();
		int punkte = 0;
		String frage = view.getAfgdFrageTextField().getText();

		try {

			punkte = Integer.parseInt(view.getAfgdPunkteTextField().getText());
			aufgabe.setAufgabentitel(titel);
			aufgabe.setFrageStellung(frage);
			
		} catch (NullPointerException a) {

			if(titel == ("")) {
				FehlerPopUp fehlermeldungTitel = new FehlerPopUp("Fehler - Titel", "Angegebner Titel nicht zulässig!");
				
			} else if(frage == ("")) {
				FehlerPopUp fehlermeldungTitel = new FehlerPopUp("Fehler - Titel", "Angegebner Titel nicht zulässig!");
					
			}
		} catch (NumberFormatException e) {

			FehlerPopUp fehlermeldungPunkte = new FehlerPopUp("Fehler - Punktzahl",
					"Angegebene Punktzahl nicht zulässig!");

		}
	
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
}
