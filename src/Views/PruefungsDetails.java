package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Controller.PruefungsDetailsController;
import Models.Aufgabe;
import Models.Nutzer;
import Models.Pruefung;
import Models.Termin;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;

//Josah Weber 
public class PruefungsDetails extends JFrame {

	private PruefungsverwaltungView pruefungsverwaltung;

	private Pruefung pruefung;

	private JTextField textFieldPrfungstitel;
	private JTable tableAufgaben;
	private JTable tableTeilnehmer;
	private JTable tableTermine;
	private JTextField textFieldDauer;
	private JTextField textFieldPunkte;
	private JButton btnNeuAufgabe;
	private JButton btnBearbeitenAufgabe;
	private JButton btnLschenAufgabe;
	private JButton btnNeuTermin;
	private JButton btnSpeichernPruefung;
	private JButton btnBearbeitenTermin;
	private JButton btnLschenTermin;
	private JButton btnNeuTeilnehmer;
	private JButton btnBearbeitenTeilnehmer;
	private JButton btnLschenTeilnehmer;
	private JButton btnLschenPruefung;
	

	PruefungsDetailsController controller;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel lblPrfungsdetails;
	private JLabel lblLegeDieEigenschaften;
	private JLabel label_2;
	private JCheckBox chckbxAufgabenVerwrfeln;
	private JButton btnAbbrechen;
	private JPanel panel_4;
	private JButton btnExportieren;

	private JButton btnImportieren;

	/**
	 * @wbp.parser.constructor
	 */
	// Konstruktor für leere Maske
	public PruefungsDetails(PruefungsverwaltungView pruefungsverwaltung, Pruefung pruefung) {

		this.pruefung = pruefung;
		this.controller = new PruefungsDetailsController(this, pruefung);
		this.pruefungsverwaltung = pruefungsverwaltung;
		onCreate();
		addActionListeners();
		punkteCheck();
	}

	// Konstruktor zum Bearbeiten der Pruefung
	public PruefungsDetails(Pruefung pruefung, PruefungsverwaltungView pruefungsverwaltung) {

		this.pruefung = pruefung;
		this.controller = new PruefungsDetailsController(this, pruefung);
		this.pruefungsverwaltung = pruefungsverwaltung;
		onCreate();
		fuellePruefungsDetailsZumBearbeiten();
		addActionListeners();
		punkteCheck();
	}

	// Refactoring?
	public void onCreate() {

		setMinimumSize(new Dimension(850, 650));
		setPreferredSize(new Dimension(850, 650));
		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		setIconImage(icon1);

		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(new Color(204, 204, 204));
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(25);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 204));
		panelButtons.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 0, 163, 151, 0 };
		gbl_panel.rowHeights = new int[] { 29, 0 };
		gbl_panel.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		btnAbbrechen = new JButton("Abbrechen");
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.insets = new Insets(0, 0, 0, 5);
		gbc_btnAbbrechen.gridx = 0;
		gbc_btnAbbrechen.gridy = 0;
		panel.add(btnAbbrechen, gbc_btnAbbrechen);

		btnSpeichernPruefung = new JButton("Pr\u00FCfung Speichern");
		btnSpeichernPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnSpeichernPruefung = new GridBagConstraints();
		gbc_btnSpeichernPruefung.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSpeichernPruefung.insets = new Insets(0, 0, 0, 5);
		gbc_btnSpeichernPruefung.gridx = 1;
		gbc_btnSpeichernPruefung.gridy = 0;
		panel.add(btnSpeichernPruefung, gbc_btnSpeichernPruefung);

		btnLschenPruefung = new JButton("Pr\u00FCfung L\u00F6schen");
		btnLschenPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnLschenPruefung = new GridBagConstraints();
		gbc_btnLschenPruefung.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnLschenPruefung.gridx = 2;
		gbc_btnLschenPruefung.gridy = 0;
		panel.add(btnLschenPruefung, gbc_btnLschenPruefung);

		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		getContentPane().add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[] { 65, 100, 300, 65, 0 };
		gbl_panelMain.rowHeights = new int[] { 22, 0, 50, 0, 50, 0, 50, 0 };
		gbl_panelMain.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelMain.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panelMain.setLayout(gbl_panelMain);

		JLabel lblAufgaben = new JLabel("Aufgaben:");
		lblAufgaben.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblAufgaben = new GridBagConstraints();
		gbc_lblAufgaben.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAufgaben.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgaben.gridx = 1;
		gbc_lblAufgaben.gridy = 1;
		panelMain.add(lblAufgaben, gbc_lblAufgaben);

		JScrollPane scrollPaneAufgabenTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneAufgabenTable = new GridBagConstraints();
		gbc_scrollPaneAufgabenTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAufgabenTable.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneAufgabenTable.gridx = 2;
		gbc_scrollPaneAufgabenTable.gridy = 1;
		panelMain.add(scrollPaneAufgabenTable, gbc_scrollPaneAufgabenTable);

		tableAufgaben = new JTable();
		tableAufgaben.setRowHeight(25);
		tableAufgaben.setPreferredScrollableViewportSize(new Dimension(450, 300));
		tableAufgaben.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneAufgabenTable.setViewportView(tableAufgaben);

		JPanel panelAufgabenButtons = new JPanel();
		panelAufgabenButtons.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_2 = (FlowLayout) panelAufgabenButtons.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelAufgabenButtons = new GridBagConstraints();
		gbc_panelAufgabenButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelAufgabenButtons.gridwidth = 2;
		gbc_panelAufgabenButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelAufgabenButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelAufgabenButtons.gridx = 1;
		gbc_panelAufgabenButtons.gridy = 2;
		panelMain.add(panelAufgabenButtons, gbc_panelAufgabenButtons);

		btnNeuAufgabe = new JButton("Neu");
		btnNeuAufgabe.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelAufgabenButtons.add(btnNeuAufgabe);

		btnBearbeitenAufgabe = new JButton("Bearbeiten");
		btnBearbeitenAufgabe.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelAufgabenButtons.add(btnBearbeitenAufgabe);

		btnLschenAufgabe = new JButton("L\u00F6schen");
		btnLschenAufgabe.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelAufgabenButtons.add(btnLschenAufgabe);

		JLabel lblTeilnehmer = new JLabel("Teilnehmer:");
		lblTeilnehmer.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblTeilnehmer = new GridBagConstraints();
		gbc_lblTeilnehmer.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTeilnehmer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTeilnehmer.gridx = 1;
		gbc_lblTeilnehmer.gridy = 3;
		panelMain.add(lblTeilnehmer, gbc_lblTeilnehmer);

		JScrollPane scrollPaneTeilnehmerTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTeilnehmerTable = new GridBagConstraints();
		gbc_scrollPaneTeilnehmerTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTeilnehmerTable.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneTeilnehmerTable.gridx = 2;
		gbc_scrollPaneTeilnehmerTable.gridy = 3;
		panelMain.add(scrollPaneTeilnehmerTable, gbc_scrollPaneTeilnehmerTable);

		tableTeilnehmer = new JTable();
		tableTeilnehmer.setRowHeight(25);
		tableTeilnehmer.setPreferredScrollableViewportSize(new Dimension(450, 300));
		tableTeilnehmer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTeilnehmerTable.setViewportView(tableTeilnehmer);

		JPanel panelTeilnehmerButtons = new JPanel();
		panelTeilnehmerButtons.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelTeilnehmerButtons = new GridBagConstraints();
		gbc_panelTeilnehmerButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelTeilnehmerButtons.gridwidth = 2;
		gbc_panelTeilnehmerButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelTeilnehmerButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTeilnehmerButtons.gridx = 1;
		gbc_panelTeilnehmerButtons.gridy = 4;
		panelMain.add(panelTeilnehmerButtons, gbc_panelTeilnehmerButtons);
		GridBagLayout gbl_panelTeilnehmerButtons = new GridBagLayout();
		gbl_panelTeilnehmerButtons.columnWidths = new int[] { 259, 129, 65, 121, 99, 0 };
		gbl_panelTeilnehmerButtons.rowHeights = new int[] { 29, 0 };
		gbl_panelTeilnehmerButtons.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelTeilnehmerButtons.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelTeilnehmerButtons.setLayout(gbl_panelTeilnehmerButtons);
		
		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 0, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panelTeilnehmerButtons.add(panel_4, gbc_panel_4);
		
		btnExportieren = new JButton("Exportieren");
		panel_4.add(btnExportieren);

		btnImportieren = new JButton("Importieren");
		panel_4.add(btnImportieren);
		btnImportieren.setFont(new Font("Verdana", Font.PLAIN, 16));

		btnNeuTeilnehmer = new JButton("Neu");
		btnNeuTeilnehmer.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNeuTeilnehmer = new GridBagConstraints();
		gbc_btnNeuTeilnehmer.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnNeuTeilnehmer.insets = new Insets(0, 0, 0, 5);
		gbc_btnNeuTeilnehmer.gridx = 2;
		gbc_btnNeuTeilnehmer.gridy = 0;
		panelTeilnehmerButtons.add(btnNeuTeilnehmer, gbc_btnNeuTeilnehmer);

		btnBearbeitenTeilnehmer = new JButton("Bearbeiten");
		btnBearbeitenTeilnehmer.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnBearbeitenTeilnehmer = new GridBagConstraints();
		gbc_btnBearbeitenTeilnehmer.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnBearbeitenTeilnehmer.insets = new Insets(0, 0, 0, 5);
		gbc_btnBearbeitenTeilnehmer.gridx = 3;
		gbc_btnBearbeitenTeilnehmer.gridy = 0;
		panelTeilnehmerButtons.add(btnBearbeitenTeilnehmer, gbc_btnBearbeitenTeilnehmer);

		btnLschenTeilnehmer = new JButton("L\u00F6schen");
		btnLschenTeilnehmer.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnLschenTeilnehmer = new GridBagConstraints();
		gbc_btnLschenTeilnehmer.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnLschenTeilnehmer.gridx = 4;
		gbc_btnLschenTeilnehmer.gridy = 0;
		panelTeilnehmerButtons.add(btnLschenTeilnehmer, gbc_btnLschenTeilnehmer);

		JLabel lblTermine = new JLabel("Termine:");
		lblTermine.setForeground(new Color(51, 51, 51));
		lblTermine.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblTermine = new GridBagConstraints();
		gbc_lblTermine.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblTermine.insets = new Insets(0, 0, 5, 5);
		gbc_lblTermine.gridx = 1;
		gbc_lblTermine.gridy = 5;
		panelMain.add(lblTermine, gbc_lblTermine);

		JScrollPane scrollPaneTermineTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTermineTable = new GridBagConstraints();
		gbc_scrollPaneTermineTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTermineTable.insets = new Insets(0, 0, 5, 5);
		gbc_scrollPaneTermineTable.gridx = 2;
		gbc_scrollPaneTermineTable.gridy = 5;
		panelMain.add(scrollPaneTermineTable, gbc_scrollPaneTermineTable);

		tableTermine = new JTable();
		tableTermine.setRowHeight(25);
		tableTermine.setPreferredScrollableViewportSize(new Dimension(450, 200));
		tableTermine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTermineTable.setViewportView(tableTermine);

		JPanel panelTermineButtons = new JPanel();
		panelTermineButtons.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_3 = (FlowLayout) panelTermineButtons.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelTermineButtons = new GridBagConstraints();
		gbc_panelTermineButtons.insets = new Insets(0, 0, 0, 5);
		gbc_panelTermineButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelTermineButtons.gridwidth = 2;
		gbc_panelTermineButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTermineButtons.gridx = 1;
		gbc_panelTermineButtons.gridy = 6;
		panelMain.add(panelTermineButtons, gbc_panelTermineButtons);

		btnNeuTermin = new JButton("Neu");
		btnNeuTermin.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelTermineButtons.add(btnNeuTermin);

		btnBearbeitenTermin = new JButton("Bearbeiten");
		btnBearbeitenTermin.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelTermineButtons.add(btnBearbeitenTermin);

		btnLschenTermin = new JButton("L\u00F6schen");
		btnLschenTermin.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelTermineButtons.add(btnLschenTermin);

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		getContentPane().add(panel_2, BorderLayout.NORTH);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 475, 0 };
		gbl_panel_2.rowHeights = new int[] { 110, 32, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 1.0, 1.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 155, 187));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] { 35, 30, 0, 0, 30, 0 };
		gbl_panel_3.rowHeights = new int[] { 50, 0, 0, 48, 0 };
		gbl_panel_3.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_3.rowWeights = new double[] { 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_3.setLayout(gbl_panel_3);

		lblPrfungsdetails = new JLabel("Pr\u00FCfungsdetails");
		lblPrfungsdetails.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblPrfungsdetails = new GridBagConstraints();
		gbc_lblPrfungsdetails.anchor = GridBagConstraints.WEST;
		gbc_lblPrfungsdetails.gridwidth = 2;
		gbc_lblPrfungsdetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungsdetails.gridx = 1;
		gbc_lblPrfungsdetails.gridy = 1;
		panel_3.add(lblPrfungsdetails, gbc_lblPrfungsdetails);
		Image icon2 = new ImageIcon(this.getClass().getResource("/Logo_FH_Bielefeld-652.png")).getImage();

		lblLegeDieEigenschaften = new JLabel("Lege die Eigenschaften der Pr\u00FCfung fest");
		lblLegeDieEigenschaften.setFont(new Font("Verdana", Font.BOLD, 17));
		GridBagConstraints gbc_lblLegeDieEigenschaften = new GridBagConstraints();
		gbc_lblLegeDieEigenschaften.anchor = GridBagConstraints.WEST;
		gbc_lblLegeDieEigenschaften.insets = new Insets(0, 0, 0, 5);
		gbc_lblLegeDieEigenschaften.gridx = 2;
		gbc_lblLegeDieEigenschaften.gridy = 3;
		panel_3.add(lblLegeDieEigenschaften, gbc_lblLegeDieEigenschaften);

		label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(icon2));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.fill = GridBagConstraints.VERTICAL;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 3;
		panel_3.add(label_2, gbc_label_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_1.anchor = GridBagConstraints.NORTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 2;
		panel_2.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 65, 85, 104, 30, 0, 80, 30, 0, 0, 65, 0 };
		gbl_panel_1.rowHeights = new int[] { 44, 0, 35, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblPrfungstitel = new JLabel("Pr\u00FCfungstitel:");
		lblPrfungstitel.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblPrfungstitel = new GridBagConstraints();
		gbc_lblPrfungstitel.anchor = GridBagConstraints.EAST;
		gbc_lblPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungstitel.gridx = 1;
		gbc_lblPrfungstitel.gridy = 1;
		panel_1.add(lblPrfungstitel, gbc_lblPrfungstitel);

		textFieldPrfungstitel = new JTextField();
		GridBagConstraints gbc_textFieldPrfungstitel = new GridBagConstraints();
		gbc_textFieldPrfungstitel.gridwidth = 7;
		gbc_textFieldPrfungstitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrfungstitel.gridx = 2;
		gbc_textFieldPrfungstitel.gridy = 1;
		panel_1.add(textFieldPrfungstitel, gbc_textFieldPrfungstitel);
		textFieldPrfungstitel.setColumns(10);

		JLabel lblDauermin = new JLabel("Dauer(Min):");
		lblDauermin.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblDauermin = new GridBagConstraints();
		gbc_lblDauermin.anchor = GridBagConstraints.EAST;
		gbc_lblDauermin.insets = new Insets(0, 0, 0, 5);
		gbc_lblDauermin.gridx = 1;
		gbc_lblDauermin.gridy = 2;
		panel_1.add(lblDauermin, gbc_lblDauermin);
		lblDauermin.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldDauer = new JTextField();
		GridBagConstraints gbc_textFieldDauer = new GridBagConstraints();
		gbc_textFieldDauer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDauer.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldDauer.gridx = 2;
		gbc_textFieldDauer.gridy = 2;
		panel_1.add(textFieldDauer, gbc_textFieldDauer);
		textFieldDauer.setColumns(5);

		JLabel lblPunkte = new JLabel("Punkte:");
		lblPunkte.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblPunkte = new GridBagConstraints();
		gbc_lblPunkte.anchor = GridBagConstraints.EAST;
		gbc_lblPunkte.insets = new Insets(0, 0, 0, 5);
		gbc_lblPunkte.gridx = 4;
		gbc_lblPunkte.gridy = 2;
		panel_1.add(lblPunkte, gbc_lblPunkte);

		textFieldPunkte = new JTextField();
		textFieldPunkte.setEditable(false);
		GridBagConstraints gbc_textFieldPunkte = new GridBagConstraints();
		gbc_textFieldPunkte.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPunkte.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldPunkte.gridx = 5;
		gbc_textFieldPunkte.gridy = 2;
		panel_1.add(textFieldPunkte, gbc_textFieldPunkte);
		textFieldPunkte.setColumns(5);

		chckbxAufgabenVerwrfeln = new JCheckBox("Aufgaben verw\u00FCrfeln");
		chckbxAufgabenVerwrfeln.setBackground(new Color(255, 255, 255));
		chckbxAufgabenVerwrfeln.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_chckbxAufgabenVerwrfeln = new GridBagConstraints();
		gbc_chckbxAufgabenVerwrfeln.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxAufgabenVerwrfeln.gridx = 7;
		gbc_chckbxAufgabenVerwrfeln.gridy = 2;
		panel_1.add(chckbxAufgabenVerwrfeln, gbc_chckbxAufgabenVerwrfeln);

		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//pack();
		setLocationRelativeTo(null);

		// Fenster maximiert starten
		setExtendedState(Frame.MAXIMIZED_BOTH);
	}

	public void punkteCheck() {

		try {

			textFieldPunkte.setText(String.valueOf(controller.getTableModelAufgaben().berechnePunktzahl()));
		} catch (NullPointerException e) {
			textFieldPunkte.setText("0");
		}

	}

	public JTable getTableAufgaben() {
		return tableAufgaben;
	}

	public JTextField getTextFieldPrfungstitel() {
		return textFieldPrfungstitel;
	}

	public JTextField getTextFieldDauer() {
		return textFieldDauer;
	}

	public JTextField getTextFieldPunkte() {
		return textFieldPunkte;
	}

	public JTable getTableTeilnehmer() {
		return tableTeilnehmer;
	}

	public PruefungsDetailsController getPruefungsDetailController() {
		return this.controller;
	}

	public JTable getTableTermine() {
		return tableTermine;
	}

	// Wenn vorhandene Prüfung bearbeitet werden soll
	public void fuellePruefungsDetailsZumBearbeiten() {
		controller.fuellePruefungsDetails(pruefung);
	}

	// Zuweisung der ActionListener für Buttons etc.
	public void addActionListeners() {

		btnSpeichernPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.speichernPruefung(pruefungsverwaltung);
				pruefungsverwaltung.getFrame().setVisible(true);
				pruefungsverwaltung.tabelleFuellen();
			}
		});

		btnLschenPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loeschenPruefung(pruefungsverwaltung);
				pruefungsverwaltung.getFrame().setVisible(true);
				pruefungsverwaltung.tabelleFuellen();
			}
		});

		btnNeuAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.neuAufgabe(pruefung);
			}
		});

		btnBearbeitenAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bearbeiteAufgabe();
			}
		});

		btnLschenAufgabe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loescheAufgabe();
			}
		});

		tableAufgaben.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 2) {
					controller.bearbeiteAufgabe();
				}
			}
		});

		btnNeuTermin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.neuTermin(pruefung);
			}
		});

		btnBearbeitenTermin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bearbeiteTermin();
			}
		});

		tableTermine.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 2) {
					controller.bearbeiteTermin();
				}
			}
		});

		btnLschenTermin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loescheTermin();
			}
		});

		btnNeuTeilnehmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.neuTeilnehmer(pruefung);
			}
		});

		btnBearbeitenTeilnehmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.bearbeiteTeilnehmer();
			}
		});

		tableTeilnehmer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 2) {
					controller.bearbeiteTeilnehmer();
				}
			}
		});
		
		//ActionListener zum schließen des Frames
		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				pruefungsverwaltung.getFrame().setVisible(true);
			}
		});
		

		btnLschenTeilnehmer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loescheTeilnehmer();
			}
		});
		
		btnImportieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.importiereTeilnehmer();
			}
		});

		chckbxAufgabenVerwrfeln.addActionListener((new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				controller.getTableModelAufgaben().verwuerfeln();
				tableAufgaben.updateUI();

			}
		}));

		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				pruefungsverwaltung.getFrame().setVisible(true);
				pruefungsverwaltung.tabelleFuellen();
			}
		});
	}

}
