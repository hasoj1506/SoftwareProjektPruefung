package Controller;

import java.util.Set;

import Models.Antwort;
import Models.Aufgabe;
import Models.Pruefung;
import Views.AntwortErstellenPopUp;
import Views.AufgabendetailsView;
import Views.FehlerPopUp;

public class AufgabenDetailsController {

	Aufgabe aufgabe;
	AufgabendetailsView view;
	Pruefung pruefung;
	Set<Antwort> antworten;

	public AufgabenDetailsController(AufgabendetailsView view, Aufgabe aufgabe) { // Konstruktor falls bestehende
																					// Aufgabe bearbeitet wird
		this.aufgabe = aufgabe;
		this.pruefung = aufgabe.getPruefung();
		this.view = view;

	}

	public AufgabenDetailsController(AufgabendetailsView view, Pruefung pruefung) { // Konstruktor falls neue Aufgabe
																					// erzeugt wird
		this.view = view;
		this.pruefung = pruefung;

	}

	public Aufgabe aufgabeSpeichern() {

		if (this.aufgabe == null) { // Prüft ob neue Aufgabe oder bestehene Aufgabe bearbeitet wird und erzeugt ggf.
									// eine neue Aufgabe

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

		} catch (NullPointerException a) { // Prüft ob Titel oder Frage leer zugewiesen werden

			if (titel == ("")) {
				FehlerPopUp fehlermeldungTitel = new FehlerPopUp("Fehler - Titel", "Angegebner Titel nicht zulässig!"); // Neues
																														// "PopUpFehler-Fenster"

			} else if (frage == ("")) {
				FehlerPopUp fehlermeldungTitel = new FehlerPopUp("Fehler - Titel", "Angegebner Titel nicht zulässig!");

			}
		} catch (NumberFormatException e) { // Prüft ob Punktzahl im Zahen Format ist

			FehlerPopUp fehlermeldungPunkte = new FehlerPopUp("Fehler - Punktzahl",
					"Angegebene Punktzahl nicht zulässig!");

		}

		aufgabe.setPunktzahl(punkte);
		aufgabe.setAntworten(this.antworten);

		return this.aufgabe;

	}

	public void aufgabeLoeschen() {

	}

	public void antwortErstellen() {

		AntwortErstellenPopUp pop = new AntwortErstellenPopUp(this.view);

		Antwort antwort = new Antwort(pop.isRichtig(), pop.getText());

		this.antworten.add(antwort);

	}

	public void antwortLoeschen() {

		view.getTableModel().removeRow(view.getAfgdTable().getSelectedRow());

	}

	public void antwortBearbeiten(Antwort antwort) {

		AntwortErstellenPopUp pop = new AntwortErstellenPopUp(this.view, antwort);

		antwort.setAntworttext(pop.getText());
		antwort.setIstRichtig(pop.isRichtig());

	}

	public void setAntworten(Set<Antwort> antworten) {
		this.antworten = antworten;
	}

	public Set<Antwort> getAntworten() {
		return this.antworten;
	}
}
