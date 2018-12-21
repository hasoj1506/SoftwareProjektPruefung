package TableModels;

import java.util.List;

import javax.swing.table.AbstractTableModel;
import Models.*;

public class AuswertungTableModel extends AbstractTableModel{

		private List<Aufgabe> aufgaben;
		String[] columnNames = { "Aufgabe", "Richtig gesetzt", "Falsch gesetzt", "Erreichte Punktzahl"};

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
		//		return antwort.isIstRichtig();

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

	
	
	
}
