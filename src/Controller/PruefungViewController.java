package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DatabaseService.DatabaseService;
import Models.Antwort;
import Models.Aufgabe;
import Models.Nutzer;
import Models.Pruefung;
import TableModels.PruefungViewAufgabenTableModel;
import TableModels.PruefungViewTableModel;
import Views.PruefungView;

public class PruefungViewController {
	// alle Methoden, die durch Bedienung der PruefungView aufgerufen werden können
	
	Pruefung pruefung;
	Nutzer nutzer;
	List<Aufgabe> aufgaben;
	DatabaseService service = DatabaseService.getInstance();
	
	PruefungView view;
	PruefungViewAufgabenTableModel model;
	PruefungViewTableModel antwortenModel;
	
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
	
	public void fuelleAufgabe(Pruefung pruefung) {
		/* Table ausfüllen
	 Textfelder ausfüllen */
		try {
			if(view.getAufgabenTable().getSelectedRow() > -1) {
				aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());
				int selection = view.getAufgabenTable().getSelectedRow();
				Aufgabe ausgewaehlteAufgabe = aufgaben.get(selection);
				
				view.getTxtAufgabentitel().setText(ausgewaehlteAufgabe.getAufgabentitel());
				view.getTxtAufgabentext().setText(ausgewaehlteAufgabe.getFrageStellung());
				antwortenModel = new PruefungViewTableModel(new ArrayList<Antwort>(ausgewaehlteAufgabe.getAntworten()));
				view.getAntwortenTable().setModel(antwortenModel);
			}else {
				//nichts wird ausgefüllt
			}
				
		}catch(Exception e) {
			JOptionPane.showMessageDialog(view.getFrame(), "Fehler!");
		}
	}
	

}
