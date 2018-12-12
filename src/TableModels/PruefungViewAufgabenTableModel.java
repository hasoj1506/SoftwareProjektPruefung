package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Aufgabe;

public class PruefungViewAufgabenTableModel extends AbstractTableModel{
	
	private List<Aufgabe> aufgaben;

	public PruefungViewAufgabenTableModel(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}
	
	public int getRowCount() {
		return aufgaben.size();
	}

	public int getColumnCount() {
		return 1;
	}
	
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return aufgaben.get(row).getAufgabentitel();
		default:
			return null;
		}
	}
	

}
