package TableModels;

import java.util.*;
import javax.swing.table.AbstractTableModel;
import java.util.Collections;
import Models.Antwort;

public class AufgabendetailsTableModel extends AbstractTableModel {

	private List<Antwort> antworten;
	String[] columnNames = { "Antworttext", "Richtig"};

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

	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	public Object getValueAt(int row, int col) {

		Antwort antwort = antworten.get(row);

		switch (col) {

		case 0:
			return antwort.getAntworttext();
		case 1:
			return antwort.isIstRichtig();

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
			antwort.setIstRichtig((Boolean) value);
			break;
		}
	}

	public void addRow(Antwort antwort) {

		antworten.add(antwort);

	}

	public void removeRow(Antwort antwort) {

		antworten.remove(antwort);

	}

	public void removeRow(int index) {
		antworten.remove(index);

	}

	public Antwort get(int index) {
		return antworten.get(index);
	}

	public void setAntworten(List<Antwort> antworten) {
		this.antworten = antworten;
	}

	public List<Antwort> getAntworten() {
		return this.antworten;
	}

	public boolean getMindestensEineRichtig() {

		for (int zaehler = 0; zaehler < antworten.size(); zaehler++) {

			if (antworten.get(zaehler).isIstRichtig()) {

				return true;
			}
		}

		return false;

	}


}
