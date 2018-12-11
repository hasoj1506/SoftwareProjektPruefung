package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Aufgabe;
import Models.Nutzer;
import Models.Termin;

//Josah Weber
public class PruefungsDetailsTeilnehmerTableModel extends AbstractTableModel {

	private List<Nutzer> nutzer;

	public PruefungsDetailsTeilnehmerTableModel(List<Nutzer> nutzer) {
		this.nutzer = nutzer;
	}

	String[] columnNames = { "Name" };

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return nutzer.size();
	}

	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return nutzer.get(row);
		default:
			return null;
		}
	}

}
