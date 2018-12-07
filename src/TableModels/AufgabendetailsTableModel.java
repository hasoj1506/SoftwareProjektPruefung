package TableModels;

import java.util.*;

import javax.swing.table.AbstractTableModel;

import Models.Antwort;

public class AufgabendetailsTableModel extends AbstractTableModel {
	
	private List<Antwort> antworten;
	String[] columnNames = {"Antworttext" , "Richtig" , "Punkte"};
	
	
	public AufgabendetailsTableModel(List<Antwort> antworten) {
		this.antworten = antworten;
	}
	
	public AufgabendetailsTableModel() {
		antworten = new ArrayList<Antwort>();
	}
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	public int getColumnCount() {
		return columnNames.length;
	}
	
	public int getRowCount() {
		return antworten.size();
	}
	
	public Class getColumnClass(int col){
		return getValueAt(0, col).getClass();
	}
	
	public Object getValueAt(int row, int col) {
		
		switch(col) {
		
		case 0: return antworten.get(row).getAntworttext();
		case 1: return antworten.get(row).isIstRichtig();
		case 2: return antworten.get(row).getPunktzahl();
		
		default: return null;
		
		}
	}
	
	public void setValueAt(Object value, int row, int col) {
		
		Antwort antwort = antworten.get(row);
		
		switch(col) {
		case 0: 
			antwort.setAntworttext((String) value);
			break;
		case 1:
			antwort.setIstRichtig((Boolean) value);
			break;
		case 2:
			antwort.setPunktzahl((Integer) value);
			break;
		}
		
	}

}
