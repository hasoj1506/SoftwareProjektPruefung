package TableModels;

import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Aufgabe;

//Marco Penner
public class PruefungViewAufgabenTableModel extends AbstractTableModel{
	
	private List<Aufgabe> aufgaben;  

	public PruefungViewAufgabenTableModel(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}
	
	String[] columnNames = { "Aufgaben"};

	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public int getRowCount() {
		return aufgaben.size();
	}

	public int getColumnCount() {
		return columnNames.length;
	}
	
	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return aufgaben.get(row).getAufgabentitel();
		default:
			return null;
		}
	}
	
	public void verwuerfeln() {
		
		Collections.shuffle(this.aufgaben);
		
	}
	
	

}
