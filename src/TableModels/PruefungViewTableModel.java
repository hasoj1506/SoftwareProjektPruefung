package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Antwort;

public class PruefungViewTableModel extends AbstractTableModel{
	
	private List<Antwort> antworten;
	
	String[] columnNames = { "Antwort", "Richtig"};

	public PruefungViewTableModel(List<Antwort> antworten) {
		this.antworten = antworten;
	}
	
	public int getRowCount() {
		return antworten.size();
	}

	public int getColumnCount() {
		return 2;
	}
	
	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}
	
	public boolean isCellEditable(int row, int col) {
	     switch (col) {
	         case 0:
	        	 return false;
	         case 1:
	             return true;
	         default:
	             return false;
	      }
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return antworten.get(row).getAntworttext();
		case 1:
			return antworten.get(row).isAlsRichtigBeantwortet();
					
		default:
			return null;
		}
	}
	
	public void setValueAt(Object value, int row, int col) {

		Antwort antwort = antworten.get(row);

		switch (col) {
		case 0:
			antwort.setAntworttext((String) value);
			break;
		case 1:
			antwort.setAlsRichtigBeantwortet((Boolean) value);
			break;
		}
	}
	
	public boolean isCellEditable(int row, int col) {
		switch (col) {
			case 0:
				return false;
			case 1:
				return true;
			default:
				return false;
		}
	}

	

}
