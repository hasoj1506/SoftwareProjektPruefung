package TableModels;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import Models.Student;

//Josah Weber
public class PruefungsDetailsTeilnehmerTableModel extends AbstractTableModel {

	private List<Student> studenten;

	public PruefungsDetailsTeilnehmerTableModel(List<Student> studenten) {
		this.studenten = studenten;
	}

	String[] columnNames = { "", "Name", "Vorname", "Matrikelnummer", "Erreichte Punktzahl", "Note",
			"Angemeldet" };

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
		// Icons für gewisse Spalten erstellen
		Image greenImage = new ImageIcon(this.getClass().getResource("/greenIcon.png")).getImage();
		ImageIcon greenIcon = new ImageIcon(greenImage);
		Image redImage = new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		ImageIcon redIcon = new ImageIcon(redImage);
		Image importImage = new ImageIcon(this.getClass().getResource("/import.png")).getImage();
		ImageIcon importIcon = new ImageIcon(importImage);
		Image manuellImage = new ImageIcon(this.getClass().getResource("/manuell.png")).getImage();
		ImageIcon manuellIcon = new ImageIcon(manuellImage);

		switch (col) {
		case 0:
			if (studenten.get(row).isIstImportiert() == true) {
				return importIcon;
			} else if (studenten.get(row).isIstImportiert() == false) {
				return manuellIcon;
			}
		case 1:
			return studenten.get(row).getNachname();
		case 2:
			return studenten.get(row).getVorname();
		case 3:
			return studenten.get(row).getMatrikelNr();
		case 4:
			return studenten.get(row).getErreichtePunktzahl();
		case 5:
			return studenten.get(row).getBonusPunkte();
		case 6:
			if (studenten.get(row).isEingeloggt() == false) {
				return redIcon;
			} else if (studenten.get(row).isEingeloggt() == true) {
				return greenIcon;
			}
		default:
			return null;
		}
	}

	public void setList(List<Student> studenten) {

		this.studenten = studenten;
	}

}
