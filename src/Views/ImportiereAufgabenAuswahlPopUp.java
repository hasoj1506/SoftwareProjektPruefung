package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

import Controller.PruefungsverwaltungController;
import DatabaseService.DatabaseService;
import Models.Antwort;
import Models.Aufgabe;
import Models.Pruefung;
import TableComparatoren.AufgabenComparator;
import TableModels.AufgabenImportAuswahlTableModel;
import TableModels.PruefungsDetailsAufgabenTableModel;
import TableModels.PruefungsverwaltungTableModel;

//Josah Weber
public class ImportiereAufgabenAuswahlPopUp {

	private JFrame frame;
	private JTable tableAufgaben;
	private JButton btnAbbrechen;
	private JButton btnImportieren;

	private List<Aufgabe> aufgaben;
	private AufgabenImportAuswahlTableModel model;
	private Pruefung importierendePruefung;
	private PruefungsDetails pruefungsdetails;
	private Pruefung pruefung;
	
	// um Zugriff auf die Datenbank zu bekommen
	DatabaseService db = DatabaseService.getInstance();

	public ImportiereAufgabenAuswahlPopUp(Pruefung pruefung, Pruefung importierendePruefung,
			PruefungsDetails pruefungsdetails) {
		this.pruefung = pruefung;
		this.importierendePruefung = importierendePruefung;
		this.pruefungsdetails = pruefungsdetails;
		onCreate();
		addActionListeners();
		tabelleFuellen();

	}

	public void onCreate() {

		this.frame = new JFrame();
		frame.setTitle("Welche Aufgaben sollen importiert werden?");
		frame.setForeground(Color.WHITE);
		frame.setMinimumSize(new Dimension(500, 250));

		JPanel aufgabenPanel = new JPanel();
		aufgabenPanel.setBackground(new Color(255, 255, 255));
		aufgabenPanel.setMinimumSize(new Dimension(400, 300));
		frame.getContentPane().add(aufgabenPanel, BorderLayout.CENTER);
		GridBagLayout gbl_aufgabenPanel = new GridBagLayout();
		gbl_aufgabenPanel.rowHeights = new int[] { 30, 0, 0, 30 };
		gbl_aufgabenPanel.columnWidths = new int[] { 20, 150, 125, 65, 0 };
		gbl_aufgabenPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_aufgabenPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
		aufgabenPanel.setLayout(gbl_aufgabenPanel);

		JLabel aufgabenLabel = new JLabel("Aufgaben:");
		aufgabenLabel.setForeground(new Color(51, 51, 51));
		aufgabenLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_aufgabenLabel = new GridBagConstraints();
		gbc_aufgabenLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_aufgabenLabel.insets = new Insets(0, 0, 5, 5);
		gbc_aufgabenLabel.gridx = 1;
		gbc_aufgabenLabel.gridy = 2;
		aufgabenPanel.add(aufgabenLabel, gbc_aufgabenLabel);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_tableScrollPane = new GridBagConstraints();
		gbc_tableScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_tableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_tableScrollPane.gridx = 2;
		gbc_tableScrollPane.gridy = 2;
		aufgabenPanel.add(tableScrollPane, gbc_tableScrollPane);

		tableAufgaben = new JTable();
		tableAufgaben.setFont(new Font("Verdana", Font.PLAIN, 16));
		tableAufgaben.setRowHeight(25);
		tableAufgaben.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableAufgaben.setMinimumSize(new Dimension(500, 300));
		tableScrollPane.setViewportView(tableAufgaben);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 204, 204));
		buttonPanel.setMinimumSize(new Dimension(400, 300));
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 10));

		JPanel unterPanel = new JPanel();
		unterPanel.setBackground(new Color(204, 204, 204));
		buttonPanel.add(unterPanel);
		GridBagLayout gbl_unterPanel = new GridBagLayout();
		gbl_unterPanel.columnWidths = new int[] { 100, 77, 63, 0, 57, 0 };
		gbl_unterPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_unterPanel.rowWeights = new double[] { 0.0 };
		unterPanel.setLayout(gbl_unterPanel);

		btnImportieren = new JButton("Importieren");
		btnImportieren.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnImportieren = new GridBagConstraints();
		gbc_btnImportieren.insets = new Insets(0, 0, 0, 5);
		gbc_btnImportieren.gridx = 3;
		gbc_btnImportieren.gridy = 0;
		unterPanel.add(btnImportieren, gbc_btnImportieren);

		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnAbbrechen.setForeground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbbrechen.gridx = 4;
		gbc_btnAbbrechen.gridy = 0;
		unterPanel.add(btnAbbrechen, gbc_btnAbbrechen);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.pack();
		frame.setLocationRelativeTo(null);

	}

	// Hinzufügen der ActionListener
	public void addActionListeners() {

		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});

		btnImportieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				importiereAufgaben();
			}
		});
	}

	public void tabelleFuellen() {
		try {
			// Liste mit allen Prüfungen der Datenbank erstellen
			aufgaben = new ArrayList<Aufgabe>(pruefung.getAufgaben());
			Collections.sort(aufgaben, new AufgabenComparator());

			model = new AufgabenImportAuswahlTableModel(aufgaben);
			tableAufgaben.setModel(model);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(frame, "Aufgaben konnten nicht geladen werden!");
		}
	}
	
	//Klicken des Importieren-Buttons
	public void importiereAufgaben() {
		try {
			//alle Aufgaben der gewählten Prüfung durchgehen
			for (Aufgabe a : pruefung.getAufgaben()) {
				
				//Wenn Aufgabe zum Importieren markiert wurde, duplizieren
				if (a.isSollImportieren() == true) {
					Aufgabe aufgabe = new Aufgabe();

					for (Antwort ant : a.getAntworten()) {
						Antwort antwort = new Antwort();
						antwort.setAntworttext(ant.getAntworttext());
						antwort.setAufgabe(aufgabe);
						antwort.setIstRichtig(ant.isIstRichtig());
						aufgabe.addAntwort(antwort);
					}
					aufgabe.setAufgabentitel(a.getAufgabentitel());
					aufgabe.setFrageStellung(a.getFrageStellung());
					aufgabe.setPruefung(importierendePruefung);
					aufgabe.setPunktzahl(a.getPunktzahl());

					importierendePruefung.addAufgabe(aufgabe);
					
					//Markierung zurücksetzen
					a.setSollImportieren(false);
				}
			}
			frame.dispose();
			//Aufgabenliste aktualisieren
			pruefungsdetails.getPruefungsDetailController().fuelleAufgabenTable(importierendePruefung);
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(frame, "Aufgaben können nicht importiert werden!");
		}
	}
}
