package Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import DatabaseService.DatabaseService;
import Models.Aufgabe;
import Models.Nutzer;
import Models.Pruefung;
import Models.Termin;
import TableModels.PruefungsDetailsAufgabenTableModel;
import TableModels.PruefungsDetailsTermineTableModel;
import Views.PruefungsDetails;

public class PruefungsDetailsController {
	// alle Methoden, die durch Bedienung der PruefungsDetails-View aufgerufen werden können
	
	private PruefungsDetails view;
	private List<Aufgabe> aufgaben;
	private List<Nutzer> teilnehmer;
	private List<Termin> termine;
	private Pruefung pruefung;
	
	public PruefungsDetailsController(PruefungsDetails view, List<Aufgabe> aufgaben, List<Nutzer> teilnehmer,
			List<Termin> termine, Pruefung pruefung) {
		super();
		this.view = view;
		this.aufgaben = aufgaben;
		this.teilnehmer = teilnehmer;
		this.termine = termine;
		this.pruefung = pruefung;
	}
	
	public PruefungsDetailsController(PruefungsDetails view) {
		this.view = view;
	}
	
	EntityManager em = DatabaseService.getInstance().getEntityManager();
	
	public List<Aufgabe> getAufgabenListe(){
		try {
			TypedQuery q = em.createQuery("SELECT a FROM Aufgabe a", Aufgabe.class);
			aufgaben = q.getResultList();
		}catch(Exception e) {
			//kommt noch
		}
		return aufgaben;
	}
	
	public void fuelleTabelleAufgaben() {
		try {
			aufgaben = getAufgabenListe();
			PruefungsDetailsAufgabenTableModel model = new PruefungsDetailsAufgabenTableModel(aufgaben);
			view.getTableAufgaben().setModel(model);
		}catch(Exception e) {
			//kommt noch
		}
	}
	
	//Josah Weber
	public void fuellePruefungsDetails(Pruefung pruefung){
		this.pruefung = pruefung;
		JTextField textFieldPrfungstitel = view.getTextFieldPrfungstitel();
		JTextField textFieldDauer = view.getTextFieldDauer();
		JTextField textFieldPunkte = view.getTextFieldPunkte();
		JTable tableAufgaben = view.getTableAufgaben();
		JTable tableTermine = view.getTableTermine();
		
		textFieldPrfungstitel.setText(pruefung.getBezeichnung());
		textFieldDauer.setText(String.valueOf(pruefung.getDauer()));
		textFieldPunkte.setText(String.valueOf(pruefung.getPunkte()));
		
		try {
			// Liste mit Aufgaben der Prüfung erstellen
			aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());

			// Dem JTable das Model inklusive Liste zuweisen
			PruefungsDetailsAufgabenTableModel tableModelAufgaben = new PruefungsDetailsAufgabenTableModel(aufgaben);
			tableAufgaben.setModel(tableModelAufgaben);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}
		
		try{
			//Liste mit Terminen der Prüfung erstellen
			termine = new ArrayList<Termin>(pruefung.getTermine());
			
			//Dem JTable das Model inklusive Liste zuweisen
			PruefungsDetailsTermineTableModel tableModelTermine = new PruefungsDetailsTermineTableModel(termine);
			tableTermine.setModel(tableModelTermine);
			
		} catch (Exception e) {
			//Was beim Fehler passiert
			JOptionPane.showMessageDialog(view, "Ein Fehler ist aufgetreten!" + e);
		}
	}
}
