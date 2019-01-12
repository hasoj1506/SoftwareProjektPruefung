package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Termin;

//Josah Weber
public class PruefungsDetailsTermineTableModel extends AbstractTableModel {

	private List<Termin> termine;

	public PruefungsDetailsTermineTableModel(List<Termin> termine) {
		this.termine = termine;
	}

	String[] columnNames = { "Datum", "Uhrzeit", "Raum" };

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return termine.size();
	}

	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return termine.get(row).getDatum();
		case 1:
			return termine.get(row).getUhrzeit();
		case 2:
			return termine.get(row).getRaum();
		default:
			return null;
		}
	}

}
