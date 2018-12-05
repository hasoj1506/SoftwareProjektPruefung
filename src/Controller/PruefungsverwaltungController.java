package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import Models.DatabaseService;
import Models.Pruefung;
import TableModels.PruefungsverwaltungTableModel;
import Views.PruefungsDetails;
import Views.PruefungsverwaltungView;

//Josah Weber
public class PruefungsverwaltungController {
	// alle Methoden, die durch Bedienung der Pruefungsverwaltung-View
	// aufgerufen werden können

	private PruefungsverwaltungView view;
	private List<Pruefung> pruefungen;
	
	//um Zugriff auf die Datenbank zu bekommen
	EntityManager em = DatabaseService.getInstance().getEntityManager();

	public PruefungsverwaltungController(PruefungsverwaltungView view) {
		this.view = view;
	}
	
	//Liste mit allen Prüfungen aus der Datenbank generieren
	public List<Pruefung> getPruefungsliste(){
		try {
			TypedQuery q = em.createQuery("SELECT p FROM Pruefung p", Pruefung.class);

			pruefungen = q.getResultList();

		} catch (Exception e) {
			// füllen, was beim Fehler passiert
		}
		return pruefungen;
	}

	public void fuelleTabellePruefungsverwaltung() {

		// Liste von Pruefungsdatensätzen erstellen
		try {
			pruefungen = getPruefungsliste();
			PruefungsverwaltungTableModel model = new PruefungsverwaltungTableModel(pruefungen);
			view.getTablePruefungen().setModel(model);
		} catch (Exception e) {
			// füllen, was beim Fehler passiert
		}

	}
	
	//Neu-Button wird geklickt
	public void neuPruefung() {
		PruefungsDetails detailView = new PruefungsDetails();
		detailView.setTitle("Neue Prüfung");

	}
	
	//bearbeiten Button wird geklickt / Doppelklick auf Prüfung
	public void bearbeitePruefung() {
		try{
		pruefungen = getPruefungsliste();
		int selection = view.getTablePruefungen().getSelectedRow();
		PruefungsDetails detailView = new PruefungsDetails(pruefungen.get(selection));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(view.getFrame(), e);
		}
	}

	public void loeschePruefung() {
		
	}

}
