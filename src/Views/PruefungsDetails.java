package Views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

public class PruefungsDetails extends JFrame {
	private PruefungsverwaltungView pruefungsverwaltung;
	
	private Pruefung pruefung;
	
	private JTextField textFieldPrfungstitel;
	private JTable tableAufgaben;
	private JTable tableTeilnehmer;
	private JTable tableTermine;
	private JTextField textFieldDauer;
	private JTextField textFieldPunkte;
	private JButton btnNeu;
	private JButton btnBearbeiten;
	private JButton btnLschen_1;
	private JButton btnNeuTermin;
	private JButton btnSpeichern;
	private JButton btnBearbeitenTermin;
	private JButton btnLschenTermin;
	
	PruefungsDetailsController controller;
	Aufgabe aufgabe;
	Termin termin;
	Nutzer nutzer;
	
	/**
	 * @wbp.parser.constructor
	 */
	//Konstruktor für leere Maske
	public PruefungsDetails(PruefungsverwaltungView pruefungsverwaltung, Pruefung pruefung) {
		this.pruefung = pruefung;
		this.controller = new PruefungsDetailsController(this);
		this.pruefungsverwaltung = pruefungsverwaltung;
		onCreate();
		addActionListeners();
	}
	
	//Josah Weber (Konstruktor zum Bearbeiten der Pruefung)
	public PruefungsDetails(Pruefung pruefung, PruefungsverwaltungView pruefungsverwaltung){
		
		this.pruefung = pruefung;
		this.controller = new PruefungsDetailsController(this);
		this.pruefungsverwaltung = pruefungsverwaltung;
		onCreate();
		fuellePruefungsDetailsZumBearbeiten();
		addActionListeners();
	}
	
	public void onCreate() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setMinimumSize(new Dimension(850, 650));
		setPreferredSize(new Dimension(850, 650));
		
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		btnSpeichern = new JButton("Speichern");
		panelButtons.add(btnSpeichern);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		panelButtons.add(btnLschen);
		
		JButton btnFreigeben = new JButton("Freigeben");
		panelButtons.add(btnFreigeben);
		
		JPanel panelMain = new JPanel();
		getContentPane().add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[]{153, 300, 0};
		gbl_panelMain.rowHeights = new int[]{0, 0, 0, 0, 50, 0, 50, 0, 50, 0};
		gbl_panelMain.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JLabel lblPrfungstitel = new JLabel("Pr\u00FCfungstitel:");
		GridBagConstraints gbc_lblPrfungstitel = new GridBagConstraints();
		gbc_lblPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungstitel.gridx = 0;
		gbc_lblPrfungstitel.gridy = 0;
		panelMain.add(lblPrfungstitel, gbc_lblPrfungstitel);
		
		textFieldPrfungstitel = new JTextField();
		GridBagConstraints gbc_textFieldPrfungstitel = new GridBagConstraints();
		gbc_textFieldPrfungstitel.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPrfungstitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrfungstitel.gridx = 1;
		gbc_textFieldPrfungstitel.gridy = 0;
		panelMain.add(textFieldPrfungstitel, gbc_textFieldPrfungstitel);
		textFieldPrfungstitel.setColumns(10);
		
		JLabel lblDauermin = new JLabel("Dauer(Min):");
		lblDauermin.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblDauermin = new GridBagConstraints();
		gbc_lblDauermin.insets = new Insets(0, 0, 5, 5);
		gbc_lblDauermin.gridx = 0;
		gbc_lblDauermin.gridy = 1;
		panelMain.add(lblDauermin, gbc_lblDauermin);
		
		textFieldDauer = new JTextField();
		GridBagConstraints gbc_textFieldDauer = new GridBagConstraints();
		gbc_textFieldDauer.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldDauer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldDauer.gridx = 1;
		gbc_textFieldDauer.gridy = 1;
		panelMain.add(textFieldDauer, gbc_textFieldDauer);
		textFieldDauer.setColumns(5);
		
		JLabel lblPunkte = new JLabel("Punkte:");
		GridBagConstraints gbc_lblPunkte = new GridBagConstraints();
		gbc_lblPunkte.insets = new Insets(0, 0, 5, 5);
		gbc_lblPunkte.gridx = 0;
		gbc_lblPunkte.gridy = 2;
		panelMain.add(lblPunkte, gbc_lblPunkte);
		
		textFieldPunkte = new JTextField();
		GridBagConstraints gbc_textFieldPunkte = new GridBagConstraints();
		gbc_textFieldPunkte.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPunkte.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPunkte.gridx = 1;
		gbc_textFieldPunkte.gridy = 2;
		panelMain.add(textFieldPunkte, gbc_textFieldPunkte);
		textFieldPunkte.setColumns(5);
		
		JLabel lblAufgaben = new JLabel("Aufgaben:");
		GridBagConstraints gbc_lblAufgaben = new GridBagConstraints();
		gbc_lblAufgaben.anchor = GridBagConstraints.NORTH;
		gbc_lblAufgaben.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgaben.gridx = 0;
		gbc_lblAufgaben.gridy = 3;
		panelMain.add(lblAufgaben, gbc_lblAufgaben);
		
		JScrollPane scrollPaneAufgabenTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneAufgabenTable = new GridBagConstraints();
		gbc_scrollPaneAufgabenTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneAufgabenTable.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneAufgabenTable.gridx = 1;
		gbc_scrollPaneAufgabenTable.gridy = 3;
		panelMain.add(scrollPaneAufgabenTable, gbc_scrollPaneAufgabenTable);
		
		tableAufgaben = new JTable();
		tableAufgaben.setPreferredScrollableViewportSize(new Dimension(450, 300));
		tableAufgaben.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneAufgabenTable.setViewportView(tableAufgaben);
		
		JPanel panelAufgabenButtons = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panelAufgabenButtons.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelAufgabenButtons = new GridBagConstraints();
		gbc_panelAufgabenButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelAufgabenButtons.gridwidth = 2;
		gbc_panelAufgabenButtons.insets = new Insets(0, 0, 5, 0);
		gbc_panelAufgabenButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelAufgabenButtons.gridx = 0;
		gbc_panelAufgabenButtons.gridy = 4;
		panelMain.add(panelAufgabenButtons, gbc_panelAufgabenButtons);
		
		btnLschen_1 = new JButton("L\u00F6schen");
		panelAufgabenButtons.add(btnLschen_1);
		
		btnBearbeiten = new JButton("Bearbeiten");
		panelAufgabenButtons.add(btnBearbeiten);
		
		btnNeu = new JButton("Neu");
		panelAufgabenButtons.add(btnNeu);
		
		JLabel lblNewLabel = new JLabel("Teilnehmer:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 5;
		panelMain.add(lblNewLabel, gbc_lblNewLabel);
		
		JScrollPane scrollPaneTeilnehmerTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTeilnehmerTable = new GridBagConstraints();
		gbc_scrollPaneTeilnehmerTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTeilnehmerTable.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneTeilnehmerTable.gridx = 1;
		gbc_scrollPaneTeilnehmerTable.gridy = 5;
		panelMain.add(scrollPaneTeilnehmerTable, gbc_scrollPaneTeilnehmerTable);
		
		tableTeilnehmer = new JTable();
		tableTeilnehmer.setPreferredScrollableViewportSize(new Dimension(450, 300));
		tableTeilnehmer.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTeilnehmerTable.setViewportView(tableTeilnehmer);
		
		JPanel panelTeilnehmerButtons = new JPanel();
		FlowLayout fl_panelTeilnehmerButtons = (FlowLayout) panelTeilnehmerButtons.getLayout();
		fl_panelTeilnehmerButtons.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelTeilnehmerButtons = new GridBagConstraints();
		gbc_panelTeilnehmerButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelTeilnehmerButtons.gridwidth = 2;
		gbc_panelTeilnehmerButtons.insets = new Insets(0, 0, 5, 0);
		gbc_panelTeilnehmerButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTeilnehmerButtons.gridx = 0;
		gbc_panelTeilnehmerButtons.gridy = 6;
		panelMain.add(panelTeilnehmerButtons, gbc_panelTeilnehmerButtons);
		
		JButton btnLschen_2 = new JButton("L\u00F6schen");
		panelTeilnehmerButtons.add(btnLschen_2);
		
		JButton btnBearbeiten_1 = new JButton("Bearbeiten");
		panelTeilnehmerButtons.add(btnBearbeiten_1);
		
		JButton btnNeu_1 = new JButton("Neu");
		panelTeilnehmerButtons.add(btnNeu_1);
		
		JLabel lblTermine = new JLabel("Termine:");
		GridBagConstraints gbc_lblTermine = new GridBagConstraints();
		gbc_lblTermine.anchor = GridBagConstraints.NORTH;
		gbc_lblTermine.insets = new Insets(0, 0, 5, 5);
		gbc_lblTermine.gridx = 0;
		gbc_lblTermine.gridy = 7;
		panelMain.add(lblTermine, gbc_lblTermine);
		
		JScrollPane scrollPaneTermineTable = new JScrollPane();
		GridBagConstraints gbc_scrollPaneTermineTable = new GridBagConstraints();
		gbc_scrollPaneTermineTable.fill = GridBagConstraints.BOTH;
		gbc_scrollPaneTermineTable.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPaneTermineTable.gridx = 1;
		gbc_scrollPaneTermineTable.gridy = 7;
		panelMain.add(scrollPaneTermineTable, gbc_scrollPaneTermineTable);
		
		tableTermine = new JTable();
		tableTermine.setPreferredScrollableViewportSize(new Dimension(450, 200));
		tableTermine.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPaneTermineTable.setViewportView(tableTermine);
		
		JPanel panelTermineButtons = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panelTermineButtons.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panelTermineButtons = new GridBagConstraints();
		gbc_panelTermineButtons.anchor = GridBagConstraints.NORTH;
		gbc_panelTermineButtons.gridwidth = 2;
		gbc_panelTermineButtons.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelTermineButtons.gridx = 0;
		gbc_panelTermineButtons.gridy = 8;
		panelMain.add(panelTermineButtons, gbc_panelTermineButtons);
		
		btnLschenTermin = new JButton("L\u00F6schen");
		panelTermineButtons.add(btnLschenTermin);
		
		btnBearbeitenTermin = new JButton("Bearbeiten");
		panelTermineButtons.add(btnBearbeitenTermin);
		
		btnNeuTermin = new JButton("Neu");
		panelTermineButtons.add(btnNeuTermin);
		
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		pack();
	}
	
	public JTable getTableAufgaben() {
		return tableAufgaben;
	}
	
	public void fuelleAufgaben() {
		controller.fuelleTabelleAufgaben();
	}
	
	
	// ab hier: Josah Weber
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
	
	//Wenn vorhandene Prüfung bearbeitet werden soll
	public void fuellePruefungsDetailsZumBearbeiten(){
		controller.fuellePruefungsDetails(pruefung);	
	}
	
	public JTable getTableTermine() {
		return tableTermine;
	}
	
	//Zuweisung der ActionListener für Buttons etc
	public void addActionListeners(){
		
		btnSpeichern.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.speichernPruefung(pruefungsverwaltung);
			}
		});
		
		btnNeu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.neuAufgabe();
			}
		});
		
		btnBearbeiten.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.bearbeiteAufgabe();
			}
		});
		
		btnLschen_1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
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
		
		btnNeuTermin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.neuTermin(pruefung);
			}
		});
		
		btnBearbeitenTermin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
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
		
		btnLschenTermin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.loescheTermin();
			}
		});
	}
	
	
	

}
