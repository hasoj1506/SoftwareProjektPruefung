package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Aufgabe;
import Models.Termin;

//Josah Weber
public class PruefungsDetailsTeilnehmerTableModel extends AbstractTableModel {

	private List<String> teilnehmer;

	public PruefungsDetailsTeilnehmerTableModel(List<String> teilnehmer) {
		this.teilnehmer = teilnehmer;
	}

	String[] columnNames = { "Name" };

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return teilnehmer.size();
	}

	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return teilnehmer.get(row);
		default:
			return null;
		}
	}

}
