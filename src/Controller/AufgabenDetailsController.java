package Controller;

import Models.Aufgabe;
import Views.AufgabendetailsView;

public class AufgabenDetailsController {
	
	Aufgabe aufgabe;
	AufgabendetailsView view;
	
	
	public AufgabenDetailsController() {
		
		
	}
	
	public void aufgabeSpeichern() {
		
		String titel = view.getAfgdTitelTextField().getText();
		int punkte = Integer.parseInt(view.getAfgdPunkteTextField().getText());
		String frage = view.getAfgdFrageTextField().getText();
		
		
		
		
		
		
		
		
	}
}
