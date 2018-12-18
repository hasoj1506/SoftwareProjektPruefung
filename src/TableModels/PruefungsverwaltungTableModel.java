package TableModels;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Pruefung;
import Models.Termin;

//Josah Weber
public class PruefungsverwaltungTableModel extends AbstractTableModel {

	private List<Pruefung> pruefungen;

	public PruefungsverwaltungTableModel(List<Pruefung> pruefungen) {
		this.pruefungen = pruefungen;
	}

	String[] columnNames = { "Titel", "Dauer (Min)", "Punkte", "Aufgaben", "Zuletzt erstellter Termin", "Teilnehmer" };

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return pruefungen.size();
	}

	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return pruefungen.get(row).getBezeichnung();
		case 1:
			return pruefungen.get(row).getDauer();
		case 2:
			return pruefungen.get(row).getPunkte();
		case 3:
			return pruefungen.get(row).getAufgaben().size();
		case 4:
			return pruefungen.get(row).getLetzterTermin();
		case 5:
			return pruefungen.get(row).getNutzer().size();
		default:
			return null;
		}
	}
}
