package Controller;

import Models.Aufgabe;
import Views.AufgabendetailsView;

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
		int punkte = Integer.parseInt(view.getAfgdPunkteTextField().getText());
		String frage = view.getAfgdFrageTextField().getText();
		
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
