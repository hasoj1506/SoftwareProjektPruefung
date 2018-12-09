package Controller;

import java.util.List;
import java.util.Set;
import DatabaseService.DatabaseService;
import Models.Antwort;
import Models.Aufgabe;
import Models.Pruefung;
import TableModels.AufgabendetailsTableModel;
import Views.AntwortErstellenPopUp;
import Views.AufgabendetailsView;
import Views.FehlerPopUp;

public class AufgabenDetailsController {

	Aufgabe aufgabe;
	AufgabendetailsView view;
	Pruefung pruefung;
	DatabaseService service = DatabaseService.getInstance();
	
	AufgabendetailsTableModel model;

	public AufgabenDetailsController(AufgabendetailsView view, Aufgabe aufgabe, List<Antwort> antworten) { // Konstruktor falls bestehende
																					// Aufgabe bearbeitet wird
		this.aufgabe = aufgabe;
		this.pruefung = aufgabe.getPruefung();
		this.view = view;
		//this.model = new AufgabendetailsTableModel(service.readAntworten(aufgabe));
		this.model = new AufgabendetailsTableModel(antworten);
		view.getAfgdTable().setModel(model); // hier kommt der Nullpointer obwohl das Model da ist
		

	}

	public AufgabenDetailsController(AufgabendetailsView view, Pruefung pruefung) { // Konstruktor falls neue Aufgabe
																					// erzeugt wird
		this.view = view;
		this.pruefung = pruefung;
		view.getAfgdTable().setModel(new AufgabendetailsTableModel());
		this.model = new AufgabendetailsTableModel();
		view.getAfgdTable().setModel(model);
		
		

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
		//aufgabe.setAntworten(this.antworten);

		return this.aufgabe;

	}

	public void aufgabeLoeschen() {

	}

	public void antwortErstellen() {

		AntwortErstellenPopUp pop = new AntwortErstellenPopUp(this.view);

		Antwort antwort = new Antwort(pop.getText(), pop.isRichtig(), pop.getPunktzahl(), this.aufgabe);
		
		model.setValueAt(pop.getText(), model.getRowCount() + 1, 0);
		model.setValueAt(pop.isRichtig(), model.getRowCount(), 1);
		model.setValueAt(pop.getText(), model.getRowCount(), 2);
		
		view.getAfgdTable().setModel(model);

	}

	public void antwortLoeschen() {

	}

	public void antwortBearbeiten() {
		
		AntwortErstellenPopUp pop = new AntwortErstellenPopUp(this.view);
		
		/*pop.setPunktzahl(model.getview.getAfgdTable().getSelectedRow());
		pop.setRichtig(antwort.isIstRichtig());
		pop.setText(antwort.getAntworttext());*/
		
		
		

	}
	

}
