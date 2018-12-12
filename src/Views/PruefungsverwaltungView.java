package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
import javax.swing.ListSelectionModel;
import java.awt.Frame;
import java.awt.Font;
import javax.swing.ImageIcon;

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
		addActionListeners();
		tabelleFuellen();

	}

	public void onCreate() {

		this.frmPrfungsverwaltung = new JFrame();
		Image icon1 = new ImageIcon(this.getClass().getResource("/Logo.png")).getImage();
		frmPrfungsverwaltung.setIconImage(icon1);
		frmPrfungsverwaltung.setTitle("Pr\u00FCfungsverwaltung");
		frmPrfungsverwaltung.setForeground(Color.WHITE);
		frmPrfungsverwaltung.setMinimumSize(new Dimension(850, 650));

		JPanel PruefungenPanel = new JPanel();
		PruefungenPanel.setMinimumSize(new Dimension(400, 300));
		frmPrfungsverwaltung.getContentPane().add(PruefungenPanel, BorderLayout.CENTER);
		GridBagLayout gbl_PruefungenPanel = new GridBagLayout();
		gbl_PruefungenPanel.columnWidths = new int[] { 65, 0, 125, 65, 0 };
		gbl_PruefungenPanel.rowHeights = new int[] { 44, 0, 30, 0 };
		gbl_PruefungenPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_PruefungenPanel.rowWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		PruefungenPanel.setLayout(gbl_PruefungenPanel);

		JLabel pruefungenLabel = new JLabel("Pruefungen:");
		pruefungenLabel.setForeground(new Color(51, 51, 51));
		pruefungenLabel.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_pruefungenLabel = new GridBagConstraints();
		gbc_pruefungenLabel.anchor = GridBagConstraints.NORTHEAST;
		gbc_pruefungenLabel.insets = new Insets(0, 0, 5, 5);
		gbc_pruefungenLabel.gridx = 1;
		gbc_pruefungenLabel.gridy = 1;
		PruefungenPanel.add(pruefungenLabel, gbc_pruefungenLabel);

		JScrollPane tableScrollPane = new JScrollPane();
		tableScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		tableScrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GridBagConstraints gbc_tableScrollPane = new GridBagConstraints();
		gbc_tableScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_tableScrollPane.fill = GridBagConstraints.BOTH;
		gbc_tableScrollPane.gridx = 2;
		gbc_tableScrollPane.gridy = 1;
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
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 70, 10));

		JPanel unterPanel = new JPanel();
		unterPanel.setBackground(new Color(204, 204, 204));
		buttonPanel.add(unterPanel);
		GridBagLayout gbl_unterPanel = new GridBagLayout();
		gbl_unterPanel.columnWidths = new int[] { 46, 33, 54, 0, 39, 57, 0 };
		gbl_unterPanel.rowHeights = new int[] { 0, 0 };
		gbl_unterPanel.columnWeights = new double[] { 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_unterPanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		unterPanel.setLayout(gbl_unterPanel);

		btnNeuPruefung = new JButton("Neu");
		btnNeuPruefung.setForeground(new Color(51, 51, 51));
		btnNeuPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNeuPruefung = new GridBagConstraints();
		gbc_btnNeuPruefung.gridwidth = 2;
		gbc_btnNeuPruefung.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNeuPruefung.insets = new Insets(0, 0, 0, 5);
		gbc_btnNeuPruefung.gridx = 0;
		gbc_btnNeuPruefung.gridy = 0;
		unterPanel.add(btnNeuPruefung, gbc_btnNeuPruefung);

		btnBearbeitenPruefung = new JButton("Bearbeiten");
		btnBearbeitenPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnBearbeitenPruefung.setForeground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnBearbeitenPruefung = new GridBagConstraints();
		gbc_btnBearbeitenPruefung.gridwidth = 2;
		gbc_btnBearbeitenPruefung.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnBearbeitenPruefung.insets = new Insets(0, 0, 0, 5);
		gbc_btnBearbeitenPruefung.gridx = 2;
		gbc_btnBearbeitenPruefung.gridy = 0;
		unterPanel.add(btnBearbeitenPruefung, gbc_btnBearbeitenPruefung);

		btnLoeschenPruefung = new JButton("L\u00F6schen");
		btnLoeschenPruefung.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnLoeschenPruefung.setForeground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnLoeschenPruefung = new GridBagConstraints();
		gbc_btnLoeschenPruefung.gridwidth = 2;
		gbc_btnLoeschenPruefung.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnLoeschenPruefung.gridx = 4;
		gbc_btnLoeschenPruefung.gridy = 0;
		unterPanel.add(btnLoeschenPruefung, gbc_btnLoeschenPruefung);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 204));
		frmPrfungsverwaltung.getContentPane().add(panel_1, BorderLayout.NORTH);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{472, 0};
		gbl_panel_1.rowHeights = new int[]{159, 32, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		panel_1.add(panel, gbc_panel);
		panel.setBackground(new Color(0, 155, 187));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{35, 30, 0, 0, 30, 0};
		gbl_panel.rowHeights = new int[]{50, 0, 0, 48, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblPrfungsverwaltung = new JLabel("Pr\u00FCfungsverwaltung");
		lblPrfungsverwaltung.setFont(new Font("Verdana", Font.BOLD, 20));
		GridBagConstraints gbc_lblPrfungsverwaltung = new GridBagConstraints();
		gbc_lblPrfungsverwaltung.anchor = GridBagConstraints.WEST;
		gbc_lblPrfungsverwaltung.gridwidth = 2;
		gbc_lblPrfungsverwaltung.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungsverwaltung.gridx = 1;
		gbc_lblPrfungsverwaltung.gridy = 1;
		panel.add(lblPrfungsverwaltung, gbc_lblPrfungsverwaltung);
		
		JLabel lblVerwaltungAllerAnstehenden = new JLabel("Verwaltung aller anstehenden Pr\u00FCfung");
		lblVerwaltungAllerAnstehenden.setFont(new Font("Verdana", Font.BOLD, 17));
		GridBagConstraints gbc_lblVerwaltungAllerAnstehenden = new GridBagConstraints();
		gbc_lblVerwaltungAllerAnstehenden.anchor = GridBagConstraints.WEST;
		gbc_lblVerwaltungAllerAnstehenden.insets = new Insets(0, 0, 0, 5);
		gbc_lblVerwaltungAllerAnstehenden.gridx = 2;
		gbc_lblVerwaltungAllerAnstehenden.gridy = 3;
		panel.add(lblVerwaltungAllerAnstehenden, gbc_lblVerwaltungAllerAnstehenden);
		
		JLabel label_2 = new JLabel("");
		Image icon = new ImageIcon(this.getClass().getResource("/Logo_FH_Bielefeld-652.png")).getImage();
		label_2.setIcon(new ImageIcon(icon));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.fill = GridBagConstraints.VERTICAL;
		gbc_label_2.anchor = GridBagConstraints.EAST;
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 3;
		panel.add(label_2, gbc_label_2);

		frmPrfungsverwaltung.setVisible(true);
		frmPrfungsverwaltung.setDefaultCloseOperation(frmPrfungsverwaltung.DISPOSE_ON_CLOSE);
		frmPrfungsverwaltung.pack();
		frmPrfungsverwaltung.setLocationRelativeTo(null); // Frame wird in der
															// Mitte des
															// Bildschirms
															// erzeugt
		
		//Fenster maximiert starten
		frmPrfungsverwaltung.setExtendedState(Frame.MAXIMIZED_BOTH);

	}

	// Hinzufügen der ActionListener
	public void addActionListeners() {

		btnNeuPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.neuPruefung();
				// um das Mainframe zu sperren während das Secondframe offen ist
				// frmPrfungsverwaltung.setEnabled(false);

			}
		});

		btnBearbeitenPruefung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				controller.bearbeitePruefung();
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

	public static void main(String[] ar) {
		PruefungsverwaltungView view = new PruefungsverwaltungView();
	}

}
