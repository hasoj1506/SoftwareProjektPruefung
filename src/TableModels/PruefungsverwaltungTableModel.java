package TableModels;

import java.awt.Image;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

import com.sun.codemodel.JLabel;

import Models.Pruefung;

//Josah Weber
public class PruefungsverwaltungTableModel extends AbstractTableModel {

	private List<Pruefung> pruefungen;

	public PruefungsverwaltungTableModel(List<Pruefung> pruefungen) {
		this.pruefungen = pruefungen;
	}

	String[] columnNames = { "Titel", "Dauer (Min)", "Punkte", "Aufgaben", "Zuletzt erstellter Termin", "Teilnehmer",
			"Freigegeben" };

	public String getColumnName(int col) {
		return columnNames[col];
	}

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return pruefungen.size();
	}

	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}

	public Object getValueAt(int row, int col) {
		Image greenImage = new ImageIcon(this.getClass().getResource("/greenIcon.png")).getImage();
		ImageIcon greenIcon = new ImageIcon(greenImage);
		Image redImage = new ImageIcon(this.getClass().getResource("/redIcon.png")).getImage();
		ImageIcon redIcon = new ImageIcon(redImage);

		switch (col) {
		case 0:
			return pruefungen.get(row).getBezeichnung();
		case 1:
			return pruefungen.get(row).getDauer();
		case 2:
			return pruefungen.get(row).getPunkte();
		case 3:
			return pruefungen.get(row).getAufgaben().size();
		case 4:
			return pruefungen.get(row).getLetzterTermin();
		case 5:
			return pruefungen.get(row).getStudenten().size();
		case 6:
			if (pruefungen.get(row).isFreigegeben() == true) {
				return greenIcon;
			} else {
				return redIcon;
			}
		default:
			return null;
		}
	}
}
