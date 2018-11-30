package Controller;

import Models.Aufgabe;
import Views.AufgabendetailsView;
import Views.FehlerPopUp;

public class AufgabenDetailsController {
	
	Aufgabe aufgabe;
	AufgabendetailsView view;
	
	public AufgabenDetailsController(Aufgabe aufgabe) {
		this.aufgabe = aufgabe;
		
	}
	
	public AufgabenDetailsController(AufgabendetailsView view) {
		this.view = view;
		
	}
	
	public AufgabenDetailsController() {
		
	}
	
	public void aufgabeSpeichern() {
		
		
		String titel = view.getAfgdTitelTextField().getText();
		
		if(titel.equals("")) {
			FehlerPopUp fehlermeldungTitel = new FehlerPopUp("Fehler - Titel", "Angegebner Titel nicht zul�ssig!");
		}
		
		try {
		
		int punkte = Integer.parseInt(view.getAfgdPunkteTextField().getText());
		
		}catch(NumberFormatException e) {
		
			FehlerPopUp fehlermeldungPunkte = new FehlerPopUp("Fehler - Punktzahl", "Angegebene Punktzahl nicht zul�ssig!");
		
		}
		
		String frage = view.getAfgdFrageTextField().getText();
		
		if(frage.equals("")) {
			FehlerPopUp fehlermeldungText = new FehlerPopUp("Fehler - Fragetext", "Angegebener Fragetext nicht zul�ssig!");
		}
		
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
