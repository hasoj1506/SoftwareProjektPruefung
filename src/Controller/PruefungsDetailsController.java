package Controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import Models.Aufgabe;
import DatabaseService.DatabaseService;
import Models.Nutzer;
import Models.Pruefung;
import Models.Termin;
import TableModels.PruefungsDetailsAufgabenTableModel;
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
	
	
	
}
