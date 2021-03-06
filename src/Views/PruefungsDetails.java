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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;

import Controller.PruefungsDetailsController;
import Models.Pruefung;

//Josah Weber, Yanek Wilken
public class PruefungsDetails {
	//ab hier: Josah Weber
	private PruefungsverwaltungView pruefungsverwaltung;
	private PruefungsDetailsController controller;

	private Pruefung pruefung;

	private JFrame frame;
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

	private JPanel headerPanel;
	private JPanel headerPanel2;
	private JLabel lblPrfungsdetails;
	private JLabel lblLegeDieEigenschaften;
	private JLabel labelHeader2;
	private JCheckBox chckbxAufgabenVerwrfeln;
	private JButton btnAbbrechen;
	private JPanel unterPanelTnBtn;
	private JButton btnExportieren;

	private JButton btnImportieren;
	private JPanel unterPanel;
	private JButton btnAktualisieren;
	private JButton btnImportiereAufgaben;
	
	/**
	 * @wbp.parser.constructor
	 */
	
	//Konstruktor zum Neu-erstellen einer Pruefung
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

	public void onCreate() {

		this.frame = new JFrame();
		frame.setMinimumSize(new Dimension(1200, 850));
		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		frame.setIconImage(icon1);

		JPanel panelButtons = new JPanel();
		panelButtons.setBorder(null);
		panelButtons.setBackground(new Color(204, 204, 204));
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setVgap(10);
		flowLayout.setHgap(25);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(panelButtons, BorderLayout.SOUTH);

		unterPanel = new JPanel();
		unterPanel.setBackground(new Color(204, 204, 204, 204));
		unterPanel.setBorder(null);
		panelButtons.add(unterPanel);
		unterPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnSpeichernPruefung = new JButton("Pr\u00FCfung Speichern");
		unterPanel.add(btnSpeichernPruefung);
		btnSpeichernPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));

		btnLschenPruefung = new JButton("Pr\u00FCfung L\u00F6schen");
		unterPanel.add(btnLschenPruefung);
		btnLschenPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));

		btnAbbrechen = new JButton("Abbrechen");
		unterPanel.add(btnAbbrechen);
		btnAbbrechen.setFont(new Font("Verdana", Font.PLAIN, 16));

		JPanel panelMain = new JPanel();
		panelMain.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[] { 20, 150, 300, 65, 0 };
		gbl_panelMain.rowHeights = new int[] { 22, 0, 50, 0, 50, 0, 50, 0 };
		gbl_panelMain.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelMain.rowWeights = new double[] { 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		panelMain.setLayout(gbl_panelMain);

		JLabel lblAufgaben = new JLabel("Aufgaben:");
		lblAufgaben.setFont(new Font("Verdana", Font.PLAIN, 16));
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
		gbc_panelAufgabenButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelAufgabenButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelAufgabenButtons.gridx = 2;
		gbc_panelAufgabenButtons.gridy = 2;
		panelMain.add(panelAufgabenButtons, gbc_panelAufgabenButtons);

		btnImportiereAufgaben = new JButton("Importieren");
		btnImportiereAufgaben.setFont(new Font("Verdana", Font.PLAIN, 16));
		panelAufgabenButtons.add(btnImportiereAufgaben);

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
		lblTeilnehmer.setFont(new Font("Verdana", Font.PLAIN, 16));
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
		gbc_panelTeilnehmerButtons.insets = new Insets(0, 0, 5, 5);
		gbc_panelTeilnehmerButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTeilnehmerButtons.gridx = 2;
		gbc_panelTeilnehmerButtons.gridy = 4;
		panelMain.add(panelTeilnehmerButtons, gbc_panelTeilnehmerButtons);
		GridBagLayout gbl_panelTeilnehmerButtons = new GridBagLayout();
		gbl_panelTeilnehmerButtons.columnWidths = new int[] { 259, 129, 65, 121, 99, 0 };
		gbl_panelTeilnehmerButtons.rowHeights = new int[] { 29, 0 };
		gbl_panelTeilnehmerButtons.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panelTeilnehmerButtons.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panelTeilnehmerButtons.setLayout(gbl_panelTeilnehmerButtons);

		unterPanelTnBtn = new JPanel();
		unterPanelTnBtn.setBackground(Color.WHITE);
		FlowLayout fl_unterPanelTnBtn = (FlowLayout) unterPanelTnBtn.getLayout();
		fl_unterPanelTnBtn.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_unterPanelTnBtn = new GridBagConstraints();
		gbc_unterPanelTnBtn.insets = new Insets(0, 0, 0, 5);
		gbc_unterPanelTnBtn.fill = GridBagConstraints.BOTH;
		gbc_unterPanelTnBtn.gridx = 0;
		gbc_unterPanelTnBtn.gridy = 0;
		panelTeilnehmerButtons.add(unterPanelTnBtn, gbc_unterPanelTnBtn);

		btnExportieren = new JButton("Exportieren");
		btnExportieren.setFont(new Font("Verdana", Font.PLAIN, 16));
		unterPanelTnBtn.add(btnExportieren);

		btnImportieren = new JButton("Importieren");
		unterPanelTnBtn.add(btnImportieren);
		btnImportieren.setFont(new Font("Verdana", Font.PLAIN, 16));

		btnAktualisieren = new JButton("Aktualisieren");
		btnAktualisieren.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAktualisieren = new GridBagConstraints();
		gbc_btnAktualisieren.insets = new Insets(0, 0, 0, 5);
		gbc_btnAktualisieren.gridx = 1;
		gbc_btnAktualisieren.gridy = 0;
		panelTeilnehmerButtons.add(btnAktualisieren, gbc_btnAktualisieren);

		btnNeuTeilnehmer = new JButton("Neu");
		btnNeuTeilnehmer.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNeuTeilnehmer = new GridBagConstraints();
		gbc_btnNeuTeilnehmer.anchor = GridBagConstraints.WEST;
		gbc_btnNeuTeilnehmer.insets = new Insets(0, 0, 0, 5);
		gbc_btnNeuTeilnehmer.gridx = 2;
		gbc_btnNeuTeilnehmer.gridy = 0;
		panelTeilnehmerButtons.add(btnNeuTeilnehmer, gbc_btnNeuTeilnehmer);

		btnBearbeitenTeilnehmer = new JButton("Bearbeiten");
		btnBearbeitenTeilnehmer.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnBearbeitenTeilnehmer = new GridBagConstraints();
		gbc_btnBearbeitenTeilnehmer.anchor = GridBagConstraints.WEST;
		gbc_btnBearbeitenTeilnehmer.insets = new Insets(0, 0, 0, 5);
		gbc_btnBearbeitenTeilnehmer.gridx = 3;
		gbc_btnBearbeitenTeilnehmer.gridy = 0;
		panelTeilnehmerButtons.add(btnBearbeitenTeilnehmer, gbc_btnBearbeitenTeilnehmer);

		btnLschenTeilnehmer = new JButton("L\u00F6schen");
		btnLschenTeilnehmer.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnLschenTeilnehmer = new GridBagConstraints();
		gbc_btnLschenTeilnehmer.anchor = GridBagConstraints.WEST;
		gbc_btnLschenTeilnehmer.gridx = 4;
		gbc_btnLschenTeilnehmer.gridy = 0;
		panelTeilnehmerButtons.add(btnLschenTeilnehmer, gbc_btnLschenTeilnehmer);

		JLabel lblTermine = new JLabel("Termine:");
		lblTermine.setForeground(new Color(51, 51, 51));
		lblTermine.setFont(new Font("Verdana", Font.PLAIN, 16));
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
		gbc_panelTermineButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTermineButtons.gridx = 2;
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

		headerPanel = new JPanel();
		headerPanel.setBackground(new Color(204, 204, 204));
		frame.getContentPane().add(headerPanel, BorderLayout.NORTH);
		GridBagLayout gbl_headerPanel = new GridBagLayout();
		gbl_headerPanel.columnWidths = new int[] { 475, 0 };
		gbl_headerPanel.rowHeights = new int[] { 210, 14, 0, 0 };
		gbl_headerPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_headerPanel.rowWeights = new double[] { 0.0, 1.0, 1.0, Double.MIN_VALUE };
		headerPanel.setLayout(gbl_headerPanel);

		headerPanel2 = new JPanel();
		headerPanel2.setBackground(new Color(0, 155, 187));
		GridBagConstraints gbc_headerPanel2 = new GridBagConstraints();
		gbc_headerPanel2.insets = new Insets(0, 0, 5, 0);
		gbc_headerPanel2.fill = GridBagConstraints.BOTH;
		gbc_headerPanel2.gridx = 0;
		gbc_headerPanel2.gridy = 0;
		headerPanel.add(headerPanel2, gbc_headerPanel2);
		GridBagLayout gbl_headerPanel2 = new GridBagLayout();
		gbl_headerPanel2.columnWidths = new int[] { 35, 30, 0, 0, 30, 0 };
		gbl_headerPanel2.rowHeights = new int[] { 50, 0, 40, 0 };
		gbl_headerPanel2.columnWeights = new double[] { 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_headerPanel2.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		headerPanel2.setLayout(gbl_headerPanel2);

		lblPrfungsdetails = new JLabel("Pr\u00FCfungsdetails");
		lblPrfungsdetails.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblPrfungsdetails = new GridBagConstraints();
		gbc_lblPrfungsdetails.anchor = GridBagConstraints.WEST;
		gbc_lblPrfungsdetails.gridwidth = 2;
		gbc_lblPrfungsdetails.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungsdetails.gridx = 1;
		gbc_lblPrfungsdetails.gridy = 1;
		headerPanel2.add(lblPrfungsdetails, gbc_lblPrfungsdetails);
		Image icon2 = new ImageIcon(this.getClass().getResource("/Logo_FH_Bielefeld-652.png")).getImage();

		lblLegeDieEigenschaften = new JLabel("Lege die Eigenschaften der Pr\u00FCfung fest");
		lblLegeDieEigenschaften.setFont(new Font("Verdana", Font.BOLD, 17));
		GridBagConstraints gbc_lblLegeDieEigenschaften = new GridBagConstraints();
		gbc_lblLegeDieEigenschaften.anchor = GridBagConstraints.WEST;
		gbc_lblLegeDieEigenschaften.insets = new Insets(0, 0, 0, 5);
		gbc_lblLegeDieEigenschaften.gridx = 2;
		gbc_lblLegeDieEigenschaften.gridy = 2;
		headerPanel2.add(lblLegeDieEigenschaften, gbc_lblLegeDieEigenschaften);

		labelHeader2 = new JLabel("");
		labelHeader2.setIcon(new ImageIcon(icon2));
		GridBagConstraints gbc_labelHeader2 = new GridBagConstraints();
		gbc_labelHeader2.anchor = GridBagConstraints.EAST;
		gbc_labelHeader2.fill = GridBagConstraints.VERTICAL;
		gbc_labelHeader2.insets = new Insets(0, 0, 0, 5);
		gbc_labelHeader2.gridx = 3;
		gbc_labelHeader2.gridy = 2;
		headerPanel2.add(labelHeader2, gbc_labelHeader2);

		JPanel panelDetails = new JPanel();
		panelDetails.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_panelDetails = new GridBagConstraints();
		gbc_panelDetails.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelDetails.anchor = GridBagConstraints.NORTH;
		gbc_panelDetails.gridx = 0;
		gbc_panelDetails.gridy = 2;
		headerPanel.add(panelDetails, gbc_panelDetails);
		GridBagLayout gbl_panelDetails = new GridBagLayout();
		gbl_panelDetails.columnWidths = new int[] { 20, 150, 104, 30, 0, 80, 30, 0, 0, 65, 0 };
		gbl_panelDetails.rowHeights = new int[] { 44, 0, 35, 0 };
		gbl_panelDetails.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelDetails.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panelDetails.setLayout(gbl_panelDetails);

		JLabel lblPrfungstitel = new JLabel("Pr\u00FCfungstitel:");
		lblPrfungstitel.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPrfungstitel = new GridBagConstraints();
		gbc_lblPrfungstitel.anchor = GridBagConstraints.EAST;
		gbc_lblPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungstitel.gridx = 1;
		gbc_lblPrfungstitel.gridy = 1;
		panelDetails.add(lblPrfungstitel, gbc_lblPrfungstitel);

		textFieldPrfungstitel = new JTextField();
		GridBagConstraints gbc_textFieldPrfungstitel = new GridBagConstraints();
		gbc_textFieldPrfungstitel.gridwidth = 7;
		gbc_textFieldPrfungstitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrfungstitel.gridx = 2;
		gbc_textFieldPrfungstitel.gridy = 1;
		panelDetails.add(textFieldPrfungstitel, gbc_textFieldPrfungstitel);
		textFieldPrfungstitel.setColumns(10);

		JLabel lblDauermin = new JLabel("Dauer(Min):");
		lblDauermin.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDauermin = new GridBagConstraints();
		gbc_lblDauermin.anchor = GridBagConstraints.EAST;
		gbc_lblDauermin.insets = new Insets(0, 0, 0, 5);
		gbc_lblDauermin.gridx = 1;
		gbc_lblDauermin.gridy = 2;
		panelDetails.add(lblDauermin, gbc_lblDauermin);
		lblDauermin.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldDauer = new JTextField();
		GridBagConstraints gbc_textFieldDauer = new GridBagConstraints();
		gbc_textFieldDauer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDauer.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldDauer.gridx = 2;
		gbc_textFieldDauer.gridy = 2;
		panelDetails.add(textFieldDauer, gbc_textFieldDauer);
		textFieldDauer.setColumns(5);

		JLabel lblPunkte = new JLabel("Punkte:");
		lblPunkte.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPunkte = new GridBagConstraints();
		gbc_lblPunkte.anchor = GridBagConstraints.EAST;
		gbc_lblPunkte.insets = new Insets(0, 0, 0, 5);
		gbc_lblPunkte.gridx = 4;
		gbc_lblPunkte.gridy = 2;
		panelDetails.add(lblPunkte, gbc_lblPunkte);

		textFieldPunkte = new JTextField();
		textFieldPunkte.setEditable(false);
		GridBagConstraints gbc_textFieldPunkte = new GridBagConstraints();
		gbc_textFieldPunkte.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPunkte.insets = new Insets(0, 0, 0, 5);
		gbc_textFieldPunkte.gridx = 5;
		gbc_textFieldPunkte.gridy = 2;
		panelDetails.add(textFieldPunkte, gbc_textFieldPunkte);
		textFieldPunkte.setColumns(5);

		chckbxAufgabenVerwrfeln = new JCheckBox("Aufgaben verw\u00FCrfeln");
		chckbxAufgabenVerwrfeln.setBackground(new Color(255, 255, 255));
		chckbxAufgabenVerwrfeln.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_chckbxAufgabenVerwrfeln = new GridBagConstraints();
		gbc_chckbxAufgabenVerwrfeln.insets = new Insets(0, 0, 0, 5);
		gbc_chckbxAufgabenVerwrfeln.gridx = 7;
		gbc_chckbxAufgabenVerwrfeln.gridy = 2;
		panelDetails.add(chckbxAufgabenVerwrfeln, gbc_chckbxAufgabenVerwrfeln);

		frame.setVisible(true);
		frame.setDefaultCloseOperation(frame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);

	}

	//ab hier: Yanek Wilken
	public void punkteCheck() {

		try {

			textFieldPunkte.setText(String.valueOf(controller.getTableModelAufgaben().berechnePunktzahl()));
		} catch (NullPointerException e) {
			textFieldPunkte.setText("0");
		}

	}

	//ab hier: Josah Weber
	// Wenn vorhandene Pr�fung bearbeitet werden soll
	public void fuellePruefungsDetailsZumBearbeiten() {
		controller.fuellePruefungsDetails(pruefung);
	}

	// Zuweisung der ActionListener f�r Buttons etc.
	public void addActionListeners() {

		btnSpeichernPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.speichernPruefung(pruefungsverwaltung);
				pruefungsverwaltung.tabelleFuellen();
			}
		});

		btnLschenPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.loeschenPruefung(pruefungsverwaltung);
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

		btnImportiereAufgaben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.importiereAufgaben();
				;
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

		btnAbbrechen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.abbrechen();
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

		btnExportieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.exportiereTeilnehmer();
			}
		});

		btnAktualisieren.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.aktualisiereTeilnehmerTable();
			}
		});

		frame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				pruefungsverwaltung.getFrame().setVisible(true);
				pruefungsverwaltung.tabelleFuellen();
			}
		});
	}

	public JCheckBox getChckbxAufgabenVerwrfeln() {
		return chckbxAufgabenVerwrfeln;
	}

	public void setChckbxAufgabenVerwrfeln(JCheckBox chckbxAufgabenVerwrfeln) {
		this.chckbxAufgabenVerwrfeln = chckbxAufgabenVerwrfeln;
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

	public PruefungsverwaltungView getPruefungsverwaltung() {
		return pruefungsverwaltung;
	}

	public JFrame getFrame() {
		return frame;
	}

}
