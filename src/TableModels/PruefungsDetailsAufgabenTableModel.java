package TableModels;

import java.util.Collections;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Aufgabe;

//Josah Weber
public class PruefungsDetailsAufgabenTableModel extends AbstractTableModel {

	private List<Aufgabe> aufgaben;

	public PruefungsDetailsAufgabenTableModel(List<Aufgabe> aufgaben) {
		this.aufgaben = aufgaben;
	}

	String[] columnNames = { "Aufgabentitel", "Antwortanzahl", "Punktzahl" };

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
		default:
			return null;
		}
	}

	public double berechnePunktzahl() {

		double punkte = 0;

		try {
			for (int zaehler = 0; zaehler < aufgaben.size(); zaehler++) {

				punkte = punkte + aufgaben.get(zaehler).getPunktzahl();
			}
		} catch (NullPointerException e) {
			return 0;
		}
		return punkte;

	}

	public void verwuerfeln() {

		Collections.shuffle(aufgaben);

	}

}
