package Controller;

import java.util.List;
import Models.Aufgabe;
import Models.Nutzer;
import Models.Pruefung;
import Models.Termin;
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
	
	
	
}
