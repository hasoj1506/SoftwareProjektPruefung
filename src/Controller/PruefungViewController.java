package Controller;

import DatabaseService.DatabaseService;
import Models.Nutzer;
import Models.Pruefung;
import TableModels.PruefungViewTableModel;
import Views.PruefungView;

public class PruefungViewController {
	// alle Methoden, die durch Bedienung der PruefungView aufgerufen werden können
	
	Pruefung pruefung;
	Nutzer nutzer;
	DatabaseService service = DatabaseService.getInstance();
	
	PruefungView view;
	PruefungViewTableModel model;
	
	public PruefungViewController(PruefungView view, Pruefung pruefung, Nutzer nutzer) {
		this.view = view;
		this.pruefung = pruefung;
		this.nutzer = nutzer;
		
	}
	
	
	

}
