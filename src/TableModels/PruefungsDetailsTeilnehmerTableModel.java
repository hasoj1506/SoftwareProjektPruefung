package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import Models.Aufgabe;
import Models.Nutzer;
import Models.Student;
import Models.Termin;

//Josah Weber
public class PruefungsDetailsTeilnehmerTableModel extends AbstractTableModel {

	private List<Student> studenten;

	public PruefungsDetailsTeilnehmerTableModel(List<Student> studenten) {
		this.studenten = studenten;
	}

	String[] columnNames = { "Name", "Vorname", "Matrikelnummer", "Erreichte Punktzahl"};

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return studenten.size();
	}

	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	public Object getValueAt(int row, int col) {
		switch (col) {
		case 0:
			return studenten.get(row).getNachname();
		case 1:
			return studenten.get(row).getVorname();
		case 2:
			return studenten.get(row).getMatrikelNr();
		case 3:
			return studenten.get(row).getErreichtePunktzahl();
		default:
			return null;
		}
	}

}
