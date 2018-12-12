package Controller;

import java.util.ArrayList;

import DatabaseService.DatabaseService;
import Models.Aufgabe;
import Models.Nutzer;
import Models.Pruefung;
import TableModels.PruefungViewAufgabenTableModel;
import Views.PruefungView;

public class PruefungViewController {
	// alle Methoden, die durch Bedienung der PruefungView aufgerufen werden können
	
	Pruefung pruefung;
	Nutzer nutzer;
	DatabaseService service = DatabaseService.getInstance();
	
	PruefungView view;
	PruefungViewAufgabenTableModel model;
	
	public PruefungViewController(PruefungView view, Pruefung pruefung, Nutzer nutzer) {
		this.view = view;
		this.pruefung = pruefung;
		this.nutzer = nutzer;
		model = new PruefungViewAufgabenTableModel(new ArrayList<Aufgabe>(pruefung.getAufgaben()));
		view.getAufgabenTable().setModel(model);
	}
	
	public void abgeben() {
		//kommt 
		
	}
	
	public void fuelleAufgabe(Aufgabe aufgabe) {
		/* Table ausfüllen
	 Textfelder ausfüllen */
	}
	

}
