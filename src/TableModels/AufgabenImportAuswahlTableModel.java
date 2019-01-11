package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Aufgabe;

//Josah Weber
public class AufgabenImportAuswahlTableModel extends AbstractTableModel {

	private List<Aufgabe> aufgaben;

	public AufgabenImportAuswahlTableModel(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	String[] columnNames = { "Aufgabentitel", "Antwortanzahl", "Punktzahl", "Importieren?" };

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return aufgaben.size();
	}

	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return aufgaben.get(row).getAufgabentitel();
		case 1:
			return aufgaben.get(row).getAntworten().size();
		case 2:
			return aufgaben.get(row).getPunktzahl();
		case 3:
			return aufgaben.get(row).isSollImportieren();
		default:
			return null;
		}
	}

	public void setValueAt(Object value, int row, int col) {
		switch (col) {
		case 3:
			aufgaben.get(row).setSollImportieren((Boolean) value);
			break;
		}
	}

	@Override
	public boolean isCellEditable(int row, int col) {
		return col == 3;
	}

}
