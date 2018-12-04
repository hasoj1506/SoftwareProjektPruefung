package Controller;

import java.util.HashSet;
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
		antworten = new HashSet<Antwort>();

	}

	public AufgabenDetailsController(AufgabendetailsView view, Pruefung pruefung) { // Konstruktor falls neue Aufgabe
																					// erzeugt wird
		this.view = view;
		this.pruefung = pruefung;
		antworten = new HashSet<Antwort>();

	}

	public Aufgabe aufgabeSpeichern() {

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

		}

		if (frage == ("") || frage.length() == 0) {

			view.fehlerMeldung("Fehler: Der Fragetext darf nicht leer sein!");

		} else {

			aufgabe.setFrageStellung(frage);

		}

		try {

			punkte = Integer.parseInt(view.getAfgdPunkteTextField().getText());

		} catch (NumberFormatException e) { // Prüft ob Punktzahl im richtigen Format ist {

			view.fehlerMeldung("Fehler: Die Punktzahl ist nicht im richtigen Format!");

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
