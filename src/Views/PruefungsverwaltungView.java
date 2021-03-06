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
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Controller.PruefungsverwaltungController;
import Models.Pruefung;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;

//Josah Weber
public class PruefungsverwaltungView {

	private JFrame frmPrfungsverwaltung;
	private JTable tablePruefungen;
	private JButton btnNeuPruefung;
	private JButton btnBearbeitenPruefung;
	private JButton btnLoeschenPruefung;
	private JButton btnDuplizierenPruefung;
	private JButton btnReset;
	private JButton btnSuchen;
	private JButton btnFreigeben;
	private JTextField textFieldSuche;
	private JButton btnSettings;

	private PruefungsverwaltungController controller;

	private Pruefung pruefung;

	public PruefungsverwaltungView() {

		this.controller = new PruefungsverwaltungController(this);
		onCreate();
		addActionListeners();
		tabelleFuellen();

	}

	public void onCreate() {

		this.frmPrfungsverwaltung = new JFrame();
		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		frmPrfungsverwaltung.setIconImage(icon1);
		frmPrfungsverwaltung.setTitle("Pr\u00FCfungsverwaltung");
		frmPrfungsverwaltung.setForeground(Color.WHITE);
		frmPrfungsverwaltung.setMinimumSize(new Dimension(1200, 800));

		JPanel PruefungenPanel = new JPanel();
		PruefungenPanel.setBackground(new Color(255, 255, 255));
		PruefungenPanel.setMinimumSize(new Dimension(400, 300));
		frmPrfungsverwaltung.getContentPane().add(PruefungenPanel, BorderLayout.CENTER);
		GridBagLayout gbl_PruefungenPanel = new GridBagLayout();
		gbl_PruefungenPanel.rowHeights = new int[] { 30, 0, 0, 30 };
		gbl_PruefungenPanel.columnWidths = new int[] { 20, 150, 125, 65, 0 };
		gbl_PruefungenPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_PruefungenPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
		PruefungenPanel.setLayout(gbl_PruefungenPanel);
		
		Image searchIcon = new ImageIcon(this.getClass().getResource("/searchIcon.png")).getImage();
		Image resetIcon = new ImageIcon(this.getClass().getResource("/closeIcon.png")).getImage();
		Image settingsIcon = new ImageIcon(this.getClass().getResource("/settings-icon.png")).getImage();

		JPanel panelSuche = new JPanel();
		panelSuche.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panelSuche.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panelSuche = new GridBagConstraints();
		gbc_panelSuche.insets = new Insets(0, 0, 5, 5);
		gbc_panelSuche.fill = GridBagConstraints.HORIZONTAL;
		gbc_panelSuche.gridx = 2;
		gbc_panelSuche.gridy = 1;
		PruefungenPanel.add(panelSuche, gbc_panelSuche);

		textFieldSuche = new JTextField();
		panelSuche.add(textFieldSuche);
		textFieldSuche.setColumns(10);

		btnSuchen = new JButton("");
		btnSuchen.setMaximumSize(new Dimension(20, 20));
		btnSuchen.setPreferredSize(new Dimension(20, 20));
		btnSuchen.setIcon(new ImageIcon(searchIcon));
		panelSuche.add(btnSuchen);

		btnReset = new JButton("");
		btnReset.setPreferredSize(new Dimension(20, 20));
		btnReset.setMinimumSize(new Dimension(20, 20));
		btnReset.setMaximumSize(new Dimension(20, 20));
		btnReset.setIcon(new ImageIcon(resetIcon));
		btnReset.setVisible(false);
		panelSuche.add(btnReset);

		JLabel pruefungenLabel = new JLabel("Pr\u00FCfungen:");
		pruefungenLabel.setForeground(new Color(51, 51, 51));
		pruefungenLabel.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_pruefungenLabel = new GridBagConstraints();
		gbc_pruefungenLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_pruefungenLabel.insets = new Insets(0, 0, 5, 5);
		gbc_pruefungenLabel.gridx = 1;
		gbc_pruefungenLabel.gridy = 2;
		PruefungenPanel.add(pruefungenLabel, gbc_pruefungenLabel);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_tableScrollPane = new GridBagConstraints();
		gbc_tableScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_tableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_tableScrollPane.gridx = 2;
		gbc_tableScrollPane.gridy = 2;
		PruefungenPanel.add(tableScrollPane, gbc_tableScrollPane);

		tablePruefungen = new JTable();
		tablePruefungen.setFont(new Font("Verdana", Font.PLAIN, 16));
		tablePruefungen.setRowHeight(25);
		tablePruefungen.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablePruefungen.setMinimumSize(new Dimension(500, 300));
		tableScrollPane.setViewportView(tablePruefungen);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 204, 204));
		buttonPanel.setMinimumSize(new Dimension(400, 300));
		frmPrfungsverwaltung.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 10));

		JPanel unterPanel = new JPanel();
		unterPanel.setBackground(new Color(204, 204, 204));
		buttonPanel.add(unterPanel);
		GridBagLayout gbl_unterPanel = new GridBagLayout();
		gbl_unterPanel.columnWidths = new int[] { 100, 77, 63, 0, 57, 0 };
		gbl_unterPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_unterPanel.rowWeights = new double[] { 0.0 };
		unterPanel.setLayout(gbl_unterPanel);

		btnNeuPruefung = new JButton("Neu");
		btnNeuPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNeuPruefung = new GridBagConstraints();
		gbc_btnNeuPruefung.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNeuPruefung.insets = new Insets(0, 0, 0, 5);
		gbc_btnNeuPruefung.gridx = 0;
		gbc_btnNeuPruefung.gridy = 0;
		unterPanel.add(btnNeuPruefung, gbc_btnNeuPruefung);

		btnBearbeitenPruefung = new JButton("Bearbeiten");
		btnBearbeitenPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnBearbeitenPruefung = new GridBagConstraints();
		gbc_btnBearbeitenPruefung.insets = new Insets(0, 0, 0, 5);
		gbc_btnBearbeitenPruefung.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBearbeitenPruefung.gridx = 1;
		gbc_btnBearbeitenPruefung.gridy = 0;
		unterPanel.add(btnBearbeitenPruefung, gbc_btnBearbeitenPruefung);

		btnDuplizierenPruefung = new JButton("Duplizieren");
		btnDuplizierenPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnDuplizieren = new GridBagConstraints();
		gbc_btnDuplizieren.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnDuplizieren.insets = new Insets(0, 0, 0, 5);
		gbc_btnDuplizieren.gridx = 2;
		gbc_btnDuplizieren.gridy = 0;
		unterPanel.add(btnDuplizierenPruefung, gbc_btnDuplizieren);

		btnFreigeben = new JButton("Freigeben");
		btnFreigeben.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnFreigeben = new GridBagConstraints();
		gbc_btnFreigeben.insets = new Insets(0, 0, 0, 5);
		gbc_btnFreigeben.gridx = 3;
		gbc_btnFreigeben.gridy = 0;
		unterPanel.add(btnFreigeben, gbc_btnFreigeben);

		btnLoeschenPruefung = new JButton("L\u00F6schen");
		btnLoeschenPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnLoeschenPruefung = new GridBagConstraints();
		gbc_btnLoeschenPruefung.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLoeschenPruefung.gridx = 4;
		gbc_btnLoeschenPruefung.gridy = 0;
		unterPanel.add(btnLoeschenPruefung, gbc_btnLoeschenPruefung);

		JPanel headerPanel = new JPanel();
		headerPanel.setBackground(new Color(204, 204, 204));
		frmPrfungsverwaltung.getContentPane().add(headerPanel, BorderLayout.NORTH);
		GridBagLayout gbl_headerPanel = new GridBagLayout();
		gbl_headerPanel.columnWidths = new int[] { 472, 0 };
		gbl_headerPanel.rowHeights = new int[] { 210, 14, 0 };
		gbl_headerPanel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_headerPanel.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		headerPanel.setLayout(gbl_headerPanel);

		JPanel headerPanel2 = new JPanel();
		GridBagConstraints gbc_headerPanel2 = new GridBagConstraints();
		gbc_headerPanel2.fill = GridBagConstraints.HORIZONTAL;
		gbc_headerPanel2.insets = new Insets(0, 0, 5, 0);
		gbc_headerPanel2.anchor = GridBagConstraints.NORTH;
		gbc_headerPanel2.gridx = 0;
		gbc_headerPanel2.gridy = 0;
		headerPanel.add(headerPanel2, gbc_headerPanel2);
		headerPanel2.setBackground(new Color(0, 155, 187));
		GridBagLayout gbl_headerPanel2 = new GridBagLayout();
		gbl_headerPanel2.columnWidths = new int[] { 35, 30, 0, 0, 30, 0 };
		gbl_headerPanel2.rowHeights = new int[] { 50, 0, 40, 0 };
		gbl_headerPanel2.columnWeights = new double[] { 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_headerPanel2.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		headerPanel2.setLayout(gbl_headerPanel2);
		
		JPanel headerPanel3 = new JPanel();
		headerPanel3.setBackground(new Color(0, 155, 187));
		FlowLayout fl_headerPanel3 = (FlowLayout) headerPanel3.getLayout();
		fl_headerPanel3.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_headerPanel3 = new GridBagConstraints();
		gbc_headerPanel3.gridwidth = 2;
		gbc_headerPanel3.insets = new Insets(0, 0, 5, 0);
		gbc_headerPanel3.fill = GridBagConstraints.BOTH;
		gbc_headerPanel3.gridx = 3;
		gbc_headerPanel3.gridy = 0;
		headerPanel2.add(headerPanel3, gbc_headerPanel3);
		
		btnSettings = new JButton("");
		btnSettings.setFocusable(false);
		btnSettings.setBorder(null);
		btnSettings.setBackground(new Color(0, 155, 187));
		btnSettings.setIcon(new ImageIcon(settingsIcon));
		headerPanel3.add(btnSettings);

		JLabel lblPrfungsverwaltung = new JLabel("Pr\u00FCfungsverwaltung");
		lblPrfungsverwaltung.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblPrfungsverwaltung = new GridBagConstraints();
		gbc_lblPrfungsverwaltung.anchor = GridBagConstraints.WEST;
		gbc_lblPrfungsverwaltung.gridwidth = 2;
		gbc_lblPrfungsverwaltung.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungsverwaltung.gridx = 1;
		gbc_lblPrfungsverwaltung.gridy = 1;
		headerPanel2.add(lblPrfungsverwaltung, gbc_lblPrfungsverwaltung);

		JLabel lblVerwaltungAllerAnstehenden = new JLabel("Verwaltung aller anstehenden Pr\u00FCfungen");
		lblVerwaltungAllerAnstehenden.setFont(new Font("Verdana", Font.BOLD, 17));
		GridBagConstraints gbc_lblVerwaltungAllerAnstehenden = new GridBagConstraints();
		gbc_lblVerwaltungAllerAnstehenden.anchor = GridBagConstraints.WEST;
		gbc_lblVerwaltungAllerAnstehenden.insets = new Insets(0, 0, 0, 5);
		gbc_lblVerwaltungAllerAnstehenden.gridx = 2;
		gbc_lblVerwaltungAllerAnstehenden.gridy = 2;
		headerPanel2.add(lblVerwaltungAllerAnstehenden, gbc_lblVerwaltungAllerAnstehenden);

		JLabel label_2 = new JLabel("");
		Image icon = new ImageIcon(this.getClass().getResource("/Logo_FH_Bielefeld-652.png")).getImage();
		label_2.setIcon(new ImageIcon(icon));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.VERTICAL;
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 2;
		headerPanel2.add(label_2, gbc_label_2);

		frmPrfungsverwaltung.setVisible(true);
		frmPrfungsverwaltung.setDefaultCloseOperation(frmPrfungsverwaltung.DISPOSE_ON_CLOSE);
		frmPrfungsverwaltung.pack();
		frmPrfungsverwaltung.setLocationRelativeTo(null);

	}

	// Hinzufügen der ActionListener
	public void addActionListeners() {
		
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EinstellungenPopUp settings = new EinstellungenPopUp();
			}
		});

		btnNeuPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.neuPruefung();
			}
		});

		btnBearbeitenPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.bearbeitePruefung();
			}
		});

		btnDuplizierenPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.duplizierePruefung();
			}
		});

		btnLoeschenPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.loeschePruefung();
			}
		});

		tablePruefungen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 2) {
					controller.bearbeitePruefung();
				}
			}
		});

		btnSuchen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.suchePruefung();
			}
		});

		textFieldSuche.getDocument().addDocumentListener(new DocumentListener() {
			public void updateLog(DocumentEvent et) {
				controller.suchePruefung();
			}

			public void changedUpdate(DocumentEvent e) {
				updateLog(e);

			}

			public void insertUpdate(DocumentEvent e) {
				updateLog(e);

			}

			public void removeUpdate(DocumentEvent e) {
				updateLog(e);

			}

		});

		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.resetSuche();
			}
		});

		btnFreigeben.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.pruefungFreigeben();
			}
		});

		tablePruefungen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 1) {
					controller.aendereBtnFreigeben();
				}
			}
		});
	}

	public JTable getTablePruefungen() {
		return tablePruefungen;
	}

	public JFrame getFrame() {
		return frmPrfungsverwaltung;
	}

	public void setTablePruefungen(JTable tablePruefungen) {
		this.tablePruefungen = tablePruefungen;
	}

	public void tabelleFuellen() {
		controller.fuelleTabellePruefungsverwaltung();
	}

	public JTextField getTextFieldSuche() {
		return textFieldSuche;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public JButton getBtnFreigeben() {
		return btnFreigeben;
	}

}
