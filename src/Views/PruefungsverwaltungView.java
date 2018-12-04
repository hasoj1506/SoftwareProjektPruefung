package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;

import Controller.PruefungsverwaltungController;
import Models.Pruefung;

//Josah Weber
public class PruefungsverwaltungView {

	private JFrame frmPrfungsverwaltung;

	private JTable tablePruefungen;

	private JButton btnNeuPruefung;
	private JButton btnBearbeitenPruefung;
	private JButton btnLoeschenPruefung;

	PruefungsverwaltungController controller;

	Pruefung pruefung;


	/**
	 * @wbp.parser.entryPoint
	 */
	public PruefungsverwaltungView() { 

		this.controller = new PruefungsverwaltungController(this);
		onCreate();
		tabelleFuellen();

	}

	//noch Refactoring?
	public void onCreate() {

		this.frmPrfungsverwaltung = new JFrame();
		frmPrfungsverwaltung.setTitle("Pr\u00FCfungsverwaltung");
		frmPrfungsverwaltung.setForeground(Color.WHITE);
		frmPrfungsverwaltung.setMinimumSize(new Dimension(850, 650));

		JPanel PruefungenPanel = new JPanel();
		PruefungenPanel.setMinimumSize(new Dimension(400, 300));
		frmPrfungsverwaltung.getContentPane().add(PruefungenPanel, BorderLayout.CENTER);
		GridBagLayout gbl_PruefungenPanel = new GridBagLayout();
		gbl_PruefungenPanel.columnWidths = new int[] { 65, 0, 125, 65, 0 };
		gbl_PruefungenPanel.rowHeights = new int[] { 0, 0, 0 };
		gbl_PruefungenPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_PruefungenPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		PruefungenPanel.setLayout(gbl_PruefungenPanel);

		JLabel pruefungenLabel = new JLabel("Pruefungen:");
		GridBagConstraints gbc_pruefungenLabel = new GridBagConstraints();
		gbc_pruefungenLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_pruefungenLabel.insets = new Insets(0, 0, 0, 5);
		gbc_pruefungenLabel.gridx = 1;
		gbc_pruefungenLabel.gridy = 1;
		PruefungenPanel.add(pruefungenLabel, gbc_pruefungenLabel);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_tableScrollPane = new GridBagConstraints();
		gbc_tableScrollPane.insets = new Insets(0, 0, 0, 5);
		gbc_tableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_tableScrollPane.gridx = 2;
		gbc_tableScrollPane.gridy = 1;
		PruefungenPanel.add(tableScrollPane, gbc_tableScrollPane);

		tablePruefungen = new JTable();
		tablePruefungen.setMinimumSize(new Dimension(500, 300));
		tableScrollPane.setViewportView(tablePruefungen);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setMinimumSize(new Dimension(400, 300));
		frmPrfungsverwaltung.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 70, 10));

		JPanel unterPanel = new JPanel();
		buttonPanel.add(unterPanel);
		GridBagLayout gbl_unterPanel = new GridBagLayout();
		gbl_unterPanel.columnWidths = new int[] { 46, 33, 54, 0, 39, 57, 0 };
		gbl_unterPanel.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_unterPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_unterPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		unterPanel.setLayout(gbl_unterPanel);

		JSeparator buttonSeparator = new JSeparator();
		GridBagConstraints gbc_buttonSeparator = new GridBagConstraints();
		gbc_buttonSeparator.gridwidth = 6;
		gbc_buttonSeparator.insets = new Insets(0, 0, 5, 5);
		gbc_buttonSeparator.gridx = 0;
		gbc_buttonSeparator.gridy = 1;
		unterPanel.add(buttonSeparator, gbc_buttonSeparator);

		btnNeuPruefung = new JButton("Neu");
		GridBagConstraints gbc_btnNeuPruefung = new GridBagConstraints();
		gbc_btnNeuPruefung.gridwidth = 2;
		gbc_btnNeuPruefung.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNeuPruefung.insets = new Insets(0, 0, 5, 5);
		gbc_btnNeuPruefung.gridx = 0;
		gbc_btnNeuPruefung.gridy = 0;
		unterPanel.add(btnNeuPruefung, gbc_btnNeuPruefung);

		btnBearbeitenPruefung = new JButton("Bearbeiten");
		GridBagConstraints gbc_btnBearbeitenPruefung = new GridBagConstraints();
		gbc_btnBearbeitenPruefung.gridwidth = 2;
		gbc_btnBearbeitenPruefung.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBearbeitenPruefung.insets = new Insets(0, 0, 5, 5);
		gbc_btnBearbeitenPruefung.gridx = 2;
		gbc_btnBearbeitenPruefung.gridy = 0;
		unterPanel.add(btnBearbeitenPruefung, gbc_btnBearbeitenPruefung);

		btnLoeschenPruefung = new JButton("L\u00F6schen");
		GridBagConstraints gbc_btnLoeschenPruefung = new GridBagConstraints();
		gbc_btnLoeschenPruefung.gridwidth = 2;
		gbc_btnLoeschenPruefung.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLoeschenPruefung.insets = new Insets(0, 0, 5, 0);
		gbc_btnLoeschenPruefung.gridx = 4;
		gbc_btnLoeschenPruefung.gridy = 0;
		unterPanel.add(btnLoeschenPruefung, gbc_btnLoeschenPruefung);

		frmPrfungsverwaltung.setVisible(true);
		frmPrfungsverwaltung.setDefaultCloseOperation(frmPrfungsverwaltung.DISPOSE_ON_CLOSE);
		frmPrfungsverwaltung.pack();
		frmPrfungsverwaltung.setLocationRelativeTo(null); // Frame wird in der Mitte des Bildschirms erzeugt

	}

	public void btnAction() {

		btnNeuPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Pruefungsdetails leer öffnen
			}
		});

		btnBearbeitenPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Pruefungsdetails mit passendem Datensatz öffnen
			}
		});

		btnLoeschenPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//Datensatz löschen und Tabelle aktualisieren
			}
		});

	}
	

	public JTable getTablePruefungen() {
		return tablePruefungen;
	}

	public void setTablePruefungen(JTable tablePruefungen) {
		this.tablePruefungen = tablePruefungen;
	}

	
	public void tabelleFuellen() {
		controller.fuelleTabellePruefungsverwaltung();
	}

	public static void main(String[] ar) {
		PruefungsverwaltungView view = new PruefungsverwaltungView();
	}

}
