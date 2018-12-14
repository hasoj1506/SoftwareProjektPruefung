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

	

}
