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

import DatabaseService.DatabaseService;
import Models.Pruefung;
import TableComparatoren.PruefungComparator;
import TableModels.AufgabenImportierenPopUpTableModel;

//Josah Weber
public class ImportiereAufgabenPopUp {

	private JFrame frame;
	private JTable tablePruefungen;
	private JButton btnAbbrechen;
	private JButton btnAufgabenAnzeigen;
	private JButton btnFertig;

	private List<Pruefung> pruefungen;
	private AufgabenImportierenPopUpTableModel model;
	private Pruefung importierendePruefung;
	private PruefungsDetails pruefungsdetails;
	private Pruefung pruefung;

	// um Zugriff auf die Datenbank zu bekommen
	DatabaseService db = DatabaseService.getInstance();

	public ImportiereAufgabenPopUp(Pruefung importierendePruefung, PruefungsDetails pruefungsdetails) {

		this.importierendePruefung = importierendePruefung;
		this.pruefungsdetails = pruefungsdetails;
		onCreate();
		addActionListeners();
		tabelleFuellen();

	}

	public void onCreate() {

		this.frame = new JFrame();
		frame.setTitle("Von welcher Pr\u00FCfung sollen Aufgaben importiert werden?");
		frame.setForeground(Color.WHITE);
		frame.setMinimumSize(new Dimension(500, 250));

		JPanel PruefungenPanel = new JPanel();
		PruefungenPanel.setBackground(new Color(255, 255, 255));
		PruefungenPanel.setMinimumSize(new Dimension(300, 200));
		frame.getContentPane().add(PruefungenPanel, BorderLayout.CENTER);
		GridBagLayout gbl_PruefungenPanel = new GridBagLayout();
		gbl_PruefungenPanel.rowHeights = new int[] { 30, 0, 0, 30 };
		gbl_PruefungenPanel.columnWidths = new int[] { 20, 150, 125, 65, 0 };
		gbl_PruefungenPanel.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_PruefungenPanel.rowWeights = new double[] { 0.0, 0.0, 1.0, 0.0 };
		PruefungenPanel.setLayout(gbl_PruefungenPanel);

		JLabel pruefungenLabel = new JLabel("Pr\u00FCfungen:");
		pruefungenLabel.setForeground(new Color(51, 51, 51));
		pruefungenLabel.setFont(new Font("Verdana", Font.BOLD, 16));
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
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT, 25, 10));

		JPanel unterPanel = new JPanel();
		unterPanel.setBackground(new Color(204, 204, 204));
		buttonPanel.add(unterPanel);
		GridBagLayout gbl_unterPanel = new GridBagLayout();
		gbl_unterPanel.columnWidths = new int[] { 100, 77, 63, 0, 0, 57, 0 };
		gbl_unterPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_unterPanel.rowWeights = new double[] { 0.0 };
		unterPanel.setLayout(gbl_unterPanel);

		btnAufgabenAnzeigen = new JButton("Aufgaben anzeigen");
		btnAufgabenAnzeigen.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnAufgabenAnzeigen = new GridBagConstraints();
		gbc_btnAufgabenAnzeigen.insets = new Insets(0, 0, 0, 5);
		gbc_btnAufgabenAnzeigen.gridx = 3;
		gbc_btnAufgabenAnzeigen.gridy = 0;
		unterPanel.add(btnAufgabenAnzeigen, gbc_btnAufgabenAnzeigen);

		btnFertig = new JButton("Fertig");
		btnFertig.setForeground(new Color(51, 51, 51));
		btnFertig.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_btnFertig = new GridBagConstraints();
		gbc_btnFertig.insets = new Insets(0, 0, 0, 5);
		gbc_btnFertig.gridx = 4;
		gbc_btnFertig.gridy = 0;
		unterPanel.add(btnFertig, gbc_btnFertig);

		btnAbbrechen = new JButton("Abbrechen");
		btnAbbrechen.setFont(new Font("Verdana", Font.PLAIN, 16));
		btnAbbrechen.setForeground(new Color(51, 51, 51));
		GridBagConstraints gbc_btnAbbrechen = new GridBagConstraints();
		gbc_btnAbbrechen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAbbrechen.gridx = 5;
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

		btnFertig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});

		tablePruefungen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				JTable table = (JTable) evt.getSource();
				if (evt.getClickCount() == 2) {
					oeffneAufgabenAuswahl();
				}
			}
		});

		btnAufgabenAnzeigen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				oeffneAufgabenAuswahl();
			}
		});
	}

	public void tabelleFuellen() {
		try {
			// Liste mit allen Prüfungen der Datenbank erstellen
			pruefungen = db.readPruefungen();
			Collections.sort(pruefungen, new PruefungComparator());

			model = new AufgabenImportierenPopUpTableModel(pruefungen);
			tablePruefungen.setModel(model);

		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(frame, "Prüfungen konnten nicht geladen werden!");
		}
	}

	public void oeffneAufgabenAuswahl() {
		try {
			// Wenn in der JTable eine Zeile ausgewählt ist
			if (tablePruefungen.getSelectedRow() > -1) {
				// Identifizieren der Prüfung
				int selection = tablePruefungen.getSelectedRow();
				Pruefung identifiziertePrüfung = pruefungen.get(selection);

				// Aufgabenauswahl öffnen und Prüfung übergeben
				ImportiereAufgabenAuswahlPopUp aufgabenAuswahl = new ImportiereAufgabenAuswahlPopUp(
						identifiziertePrüfung, importierendePruefung, pruefungsdetails);
			} else {
				JOptionPane.showMessageDialog(frame, "Keine Pruefung ausgewählt!");
			}
		} catch (Exception e) {
			// Was beim Fehler passiert
			JOptionPane.showMessageDialog(frame, "Aufgaben-Auswahl kann nicht geöffnet werden!");
		}
	}
}
