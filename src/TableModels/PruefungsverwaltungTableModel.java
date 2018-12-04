package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Pruefung;

//Josah Weber
public class PruefungsverwaltungTableModel extends AbstractTableModel {
	
	private List<Pruefung> pruefungen;
	
	public PruefungsverwaltungTableModel(List<Pruefung> pruefungen){
		this.pruefungen = pruefungen;
	}
	
	String[] columnNames = {"Titel", "Dauer", "Punkte"};
	
	public String getColumnName(int col){
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return pruefungen.size();
	}
	
	public Class getColumnClass(int col){
		return getValueAt(0, col).getClass();
	}

	public Object getValueAt(int row, int col) {
		switch(col) {
		case 0: return pruefungen.get(row).getBezeichnung();
		case 1: return pruefungen.get(row).getDauer();
		case 2: return pruefungen.get(row).getPunkte();
		default:
			return null;
		}
	}
	
//	public void setValueAt(Object value, int row, int col) {
//		Pruefung pruefung = pruefungen.get(row);
//		switch(col){
//		case 0:
//			pruefung.setBezeichnung((String)value);
//			break;
//		case 1:
//			//pruefung.setTermin((String)value);
//		case 2:
//			pruefung.setDauer((Integer)value);
//			break;
//		}
//	}
	

}
