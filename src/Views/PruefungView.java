package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JComboBox;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.SystemColor;
import java.awt.ComponentOrientation;

public class PruefungView {

	private JFrame frame;
	private int timerZeit;
	private JTextField txtAufgabentext;
	private JTable antwortenTable;

	public PruefungView() {
		erstellePruefungView();
	}

	public void erstellePruefungView() {

		this.frame = new JFrame("Prüfung");
		frame.getContentPane().setBackground(SystemColor.control);
		BorderLayout borderLayout = (BorderLayout) frame.getContentPane().getLayout();
		borderLayout.setVgap(50);
		borderLayout.setHgap(20);
		frame.setPreferredSize(new Dimension(800, 500));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel infoPanel = new JPanel();
		infoPanel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(infoPanel, BorderLayout.NORTH);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.rowHeights = new int[] { 20 };
		gbl_infoPanel.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0 };
		gbl_infoPanel.rowWeights = new double[] { 0.0 };
		infoPanel.setLayout(gbl_infoPanel);

		JLabel lblPrfungstitel = new JLabel("Pr\u00FCfungstitel");
		GridBagConstraints gbc_lblPrfungstitel = new GridBagConstraints();
		gbc_lblPrfungstitel.anchor = GridBagConstraints.WEST;
		gbc_lblPrfungstitel.insets = new Insets(0, 0, 0, 50);
		gbc_lblPrfungstitel.gridx = 0;
		gbc_lblPrfungstitel.gridy = 0;
		infoPanel.add(lblPrfungstitel, gbc_lblPrfungstitel);

		JLabel lblMatrikelnummer = new JLabel("Matrikelnummer: 1587953");
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.anchor = GridBagConstraints.WEST;
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 0, 50);
		gbc_lblMatrikelnummer.gridx = 1;
		gbc_lblMatrikelnummer.gridy = 0;
		infoPanel.add(lblMatrikelnummer, gbc_lblMatrikelnummer);

		JLabel lblVersion = new JLabel("Version 1.01");
		GridBagConstraints gbc_lblVersion = new GridBagConstraints();
		gbc_lblVersion.anchor = GridBagConstraints.WEST;
		gbc_lblVersion.insets = new Insets(0, 0, 0, 50);
		gbc_lblVersion.gridx = 2;
		gbc_lblVersion.gridy = 0;
		infoPanel.add(lblVersion, gbc_lblVersion);

		JLabel lblRestzeit = new JLabel("Restzeit: 24:32");
		GridBagConstraints gbc_lblRestzeit = new GridBagConstraints();
		gbc_lblRestzeit.insets = new Insets(0, 0, 0, 5);
		gbc_lblRestzeit.anchor = GridBagConstraints.EAST;
		gbc_lblRestzeit.gridx = 3;
		gbc_lblRestzeit.gridy = 0;
		infoPanel.add(lblRestzeit, gbc_lblRestzeit);

		JScrollPane aufgabenlisteScrollPane = new JScrollPane();
		aufgabenlisteScrollPane.setPreferredSize(new Dimension(100, 2));
		aufgabenlisteScrollPane.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(aufgabenlisteScrollPane, BorderLayout.WEST);

		String[] aufgaben = new String[10];
		for (int i = 0; i < aufgaben.length; i++) {
			aufgaben[i] = "Aufgabe" + (i + 1);
		}
		JList listAufgaben = new JList(aufgaben);
		listAufgaben.setBackground(SystemColor.activeCaption);
		aufgabenlisteScrollPane.setViewportView(listAufgaben);
		listAufgaben.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAufgaben.setBorder(null);

		JPanel aufgabenstellungPanel = new JPanel();
		aufgabenstellungPanel.setBackground(SystemColor.activeCaption);
		frame.getContentPane().add(aufgabenstellungPanel, BorderLayout.CENTER);
		GridBagLayout gbl_aufgabenstellungPanel = new GridBagLayout();
		gbl_aufgabenstellungPanel.columnWidths = new int[] { 0, 768 };
		gbl_aufgabenstellungPanel.rowHeights = new int[] { 30, 150, 150, 30 };
		gbl_aufgabenstellungPanel.columnWeights = new double[] { 0.0, 1.0 };
		gbl_aufgabenstellungPanel.rowWeights = new double[] { 0.0, 1.0, 1.0 };
		aufgabenstellungPanel.setLayout(gbl_aufgabenstellungPanel);

		JLabel lblAufgabentitel = new JLabel("Aufgabentitel:");
		lblAufgabentitel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAufgabentitel = new GridBagConstraints();
		gbc_lblAufgabentitel.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAufgabentitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgabentitel.gridx = 0;
		gbc_lblAufgabentitel.gridy = 0;
		aufgabenstellungPanel.add(lblAufgabentitel, gbc_lblAufgabentitel);

		JTextField txtAufgabentitel = new JTextField("Aufgabentitel");
		txtAufgabentitel.setBackground(SystemColor.inactiveCaption);
		txtAufgabentitel.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAufgabentitel.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_txtAufgabentitel = new GridBagConstraints();
		gbc_txtAufgabentitel.anchor = GridBagConstraints.NORTHEAST;
		gbc_txtAufgabentitel.fill = GridBagConstraints.BOTH;
		gbc_txtAufgabentitel.insets = new Insets(0, 0, 5, 0);
		gbc_txtAufgabentitel.gridx = 1;
		gbc_txtAufgabentitel.gridy = 0;
		aufgabenstellungPanel.add(txtAufgabentitel, gbc_txtAufgabentitel);

		JLabel lblAufgabenstellung = new JLabel("Aufgabenstellung:");
		lblAufgabenstellung.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAufgabenstellung = new GridBagConstraints();
		gbc_lblAufgabenstellung.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAufgabenstellung.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgabenstellung.gridx = 0;
		gbc_lblAufgabenstellung.gridy = 1;
		aufgabenstellungPanel.add(lblAufgabenstellung, gbc_lblAufgabenstellung);

		JScrollPane aufgabentextScrollPane = new JScrollPane();
		aufgabentextScrollPane.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_aufgabentextScrollPane = new GridBagConstraints();
		gbc_aufgabentextScrollPane.anchor = GridBagConstraints.NORTHEAST;
		gbc_aufgabentextScrollPane.fill = GridBagConstraints.BOTH;
		gbc_aufgabentextScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_aufgabentextScrollPane.gridx = 1;
		gbc_aufgabentextScrollPane.gridy = 1;
		aufgabenstellungPanel.add(aufgabentextScrollPane, gbc_aufgabentextScrollPane);

		txtAufgabentext = new JTextField();
		txtAufgabentext.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtAufgabentext.setBackground(SystemColor.inactiveCaption);
		txtAufgabentext.setText("Welche der folgenden Aussagen sind korrekt?");
		aufgabentextScrollPane.setViewportView(txtAufgabentext);
		txtAufgabentext.setColumns(10);

		JLabel lblAntworten = new JLabel("Antworten:");
		lblAntworten.setFont(new Font("Tahoma", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAntworten = new GridBagConstraints();
		gbc_lblAntworten.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblAntworten.insets = new Insets(0, 0, 5, 5);
		gbc_lblAntworten.gridx = 0;
		gbc_lblAntworten.gridy = 2;
		aufgabenstellungPanel.add(lblAntworten, gbc_lblAntworten);

		JScrollPane antwortenScrollPane = new JScrollPane();
		antwortenScrollPane.setMaximumSize(new Dimension(0, 0));
		antwortenScrollPane.setBackground(SystemColor.inactiveCaption);
		GridBagConstraints gbc_antwortenScrollPane = new GridBagConstraints();
		gbc_antwortenScrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_antwortenScrollPane.fill = GridBagConstraints.BOTH;
		gbc_antwortenScrollPane.gridx = 1;
		gbc_antwortenScrollPane.gridy = 2;
		aufgabenstellungPanel.add(antwortenScrollPane, gbc_antwortenScrollPane);

		antwortenTable = new JTable();
		antwortenTable.setShowGrid(false);
		antwortenTable.setSelectionBackground(SystemColor.inactiveCaptionBorder);
		antwortenTable.setRowHeight(20);
		antwortenTable.setFont(new Font("Tahoma", Font.BOLD, 11));
		antwortenTable.setBackground(SystemColor.inactiveCaption);
		antwortenTable.setModel(
				new DefaultTableModel(
						new Object[][] { { Boolean.FALSE, "Java ist eine objektorientierte Programmiersprache" },
								{ null, "Integer sind unbegrenzt" }, { null, "Interfaces haben nur Nachteile" },
								{ null, "Vererbung schafft \u00FCberfl\u00FCssigen Code" },
								{ null, "Methoden k\u00F6nnen einen R\u00FCckgabewert haben" }, },
						new String[] { "", "" }) {
					Class[] columnTypes = new Class[] { Boolean.class, Object.class };

					public Class getColumnClass(int columnIndex) {
						return columnTypes[columnIndex];
					}
				});
		antwortenTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		antwortenTable.getColumnModel().getColumn(0).setMaxWidth(50);
		antwortenTable.setTableHeader(null);
		antwortenScrollPane.setViewportView(antwortenTable);

		JLabel lblPunktzahl = new JLabel("Punktzahl: 5");
		lblPunktzahl.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPunktzahl = new GridBagConstraints();
		gbc_lblPunktzahl.insets = new Insets(0, 0, 0, 5);
		gbc_lblPunktzahl.anchor = GridBagConstraints.EAST;
		gbc_lblPunktzahl.gridx = 1;
		gbc_lblPunktzahl.gridy = 3;
		aufgabenstellungPanel.add(lblPunktzahl, gbc_lblPunktzahl);

		JPanel buttonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);

		JButton btnAbgabe = new JButton("Abgabe");
		Image abgabeIcon = new ImageIcon(this.getClass().getResource("/abgabe.png")).getImage();
		btnAbgabe.setIcon(new ImageIcon(abgabeIcon));
		btnAbgabe.setBackground(SystemColor.activeCaption);
		buttonPanel.add(btnAbgabe);
		timerZeit = 60;

		String[] antworten = new String[7];
		for (int i = 0; i < antworten.length; i++) {
			antworten[i] = "Antwort " + (i + 1);
		}

		frame.pack();

	}

	public static void main(String[] args) {
		PruefungView pruefungView = new PruefungView();
	}

}
