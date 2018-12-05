package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Aufgabe;

public class PruefungsDetailsAufgabenTableModel extends AbstractTableModel{
	
	private List<Aufgabe> aufgaben;

	public PruefungsDetailsAufgabenTableModel(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}
	
	String[] columnNames = {"Aufgabentitel", "Punktzahl"};
	
	public String getColumnNames(int col) {
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
		switch(col) {
		case 0: return aufgaben.get(row).getAufgabentitel();
		case 1: return aufgaben.get(row).getPunktzahl();
		default:
			return null;
		}
	}

}