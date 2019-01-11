package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Pruefung;

//Josah Weber
public class AufgabenImportierenPopUpTableModel extends AbstractTableModel {

	private List<Pruefung> pruefungen;

	public AufgabenImportierenPopUpTableModel(List<Pruefung> pruefungen) {
		this.pruefungen = pruefungen;
	}

	String[] columnNames = { "Titel", "Aufgaben" };

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
			return pruefungen.get(row).getAufgaben().size();
		default:
			return null;
		}
	}
}
