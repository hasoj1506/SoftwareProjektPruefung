package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import Models.*;

//Firat Aslan
public class AuswertungTableModel extends AbstractTableModel{

		private List<Aufgabe> aufgaben;
		String[] columnNames = { "Aufgabe", "Erreichte Punktzahl"};

		public AuswertungTableModel(List<Aufgabe> aufgaben) {
			this.aufgaben = aufgaben;
		}

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

			Aufgabe aufgabe = aufgaben.get(row);

			switch (col) {

			case 0:
				return aufgabe.getAufgabentitel();
			case 1:
				return aufgabe.getErreichtePunktzahl();

			default:
				return null;

			}
		}
	}

	
	

