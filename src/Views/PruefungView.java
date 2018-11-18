package Views;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;

public class PruefungView {
	
	private JFrame frame;
	private JTextField txtAufgabenstellung;
	
	public PruefungView(){
		erstellePruefungView();
	}
	
	public void erstellePruefungView(){
		
		this.frame = new JFrame("Prüfung");
		frame.setPreferredSize(new Dimension(800, 500));
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JPanel infoPanel = new JPanel();
		frame.getContentPane().add(infoPanel, BorderLayout.NORTH);
		GridBagLayout gbl_infoPanel = new GridBagLayout();
		gbl_infoPanel.columnWidths = new int[]{295, 73, 75, 35, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_infoPanel.rowHeights = new int[]{14, 0};
		gbl_infoPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_infoPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		infoPanel.setLayout(gbl_infoPanel);
		
		JLabel lblPruefungstitel = new JLabel("Pr\u00FCfungstitel");
		lblPruefungstitel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblPruefungstitel = new GridBagConstraints();
		gbc_lblPruefungstitel.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblPruefungstitel.insets = new Insets(0, 0, 0, 5);
		gbc_lblPruefungstitel.gridx = 0;
		gbc_lblPruefungstitel.gridy = 0;
		infoPanel.add(lblPruefungstitel, gbc_lblPruefungstitel);
		
		JLabel lblMatrikelnummer = new JLabel("Matrikelnummer");
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 0, 5);
		gbc_lblMatrikelnummer.gridx = 2;
		gbc_lblMatrikelnummer.gridy = 0;
		infoPanel.add(lblMatrikelnummer, gbc_lblMatrikelnummer);
		
		JLabel lblVersion = new JLabel("Version");
		GridBagConstraints gbc_lblVersion = new GridBagConstraints();
		gbc_lblVersion.anchor = GridBagConstraints.NORTHWEST;
		gbc_lblVersion.gridx = 13;
		gbc_lblVersion.gridy = 0;
		infoPanel.add(lblVersion, gbc_lblVersion);
		
		JScrollPane scrollPane = new JScrollPane();
		frame.getContentPane().add(scrollPane, BorderLayout.WEST);
		
		JList listAufgaben = new JList();
		scrollPane.setViewportView(listAufgaben);
		listAufgaben.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAufgaben.setModel(new AbstractListModel() {
			String[] values = new String[] {"Aufgabe 1", "Aufgabe 2", "Aufgabe 3", "Aufgabe 4", "Aufgabe 5", "Aufgabe 6", "Aufgabe 7", "Aufgabe 8", "Aufgabe 9", "Aufgabe 10", "Aufgabe 11", "Aufgabe 12", "Aufgabe 13", "Aufgabe 14"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listAufgaben.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Aufgaben:", TitledBorder.LEADING, TitledBorder.ABOVE_TOP, null, new Color(0, 0, 0)));
		
		JPanel aufgabenstellungPanel = new JPanel();
		frame.getContentPane().add(aufgabenstellungPanel, BorderLayout.CENTER);
		GridBagLayout gbl_aufgabenstellungPanel = new GridBagLayout();
		gbl_aufgabenstellungPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_aufgabenstellungPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_aufgabenstellungPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_aufgabenstellungPanel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		aufgabenstellungPanel.setLayout(gbl_aufgabenstellungPanel);
		
		JButton btnAbgabe = new JButton("Abgabe");
		btnAbgabe.setIcon(new ImageIcon(PruefungView.class.getResource("/javax/swing/plaf/metal/icons/ocean/close.gif")));
		GridBagConstraints gbc_btnAbgabe = new GridBagConstraints();
		gbc_btnAbgabe.insets = new Insets(0, 0, 5, 5);
		gbc_btnAbgabe.gridx = 0;
		gbc_btnAbgabe.gridy = 0;
		aufgabenstellungPanel.add(btnAbgabe, gbc_btnAbgabe);
		
		JLabel lblTimer = new JLabel("41:37");
		GridBagConstraints gbc_lblTimer = new GridBagConstraints();
		gbc_lblTimer.insets = new Insets(0, 0, 5, 5);
		gbc_lblTimer.gridx = 0;
		gbc_lblTimer.gridy = 1;
		aufgabenstellungPanel.add(lblTimer, gbc_lblTimer);
		
		JLabel lblAufgabentitel = new JLabel("Aufgabentitel");
		lblAufgabentitel.setFont(new Font("Tahoma", Font.BOLD, 11));
		GridBagConstraints gbc_lblAufgabentitel = new GridBagConstraints();
		gbc_lblAufgabentitel.gridwidth = 5;
		gbc_lblAufgabentitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgabentitel.gridx = 1;
		gbc_lblAufgabentitel.gridy = 1;
		aufgabenstellungPanel.add(lblAufgabentitel, gbc_lblAufgabentitel);
		
		JScrollPane aufgabenStellungScrollPane = new JScrollPane();
		GridBagConstraints gbc_aufgabenStellungScrollPane = new GridBagConstraints();
		gbc_aufgabenStellungScrollPane.gridheight = 3;
		gbc_aufgabenStellungScrollPane.gridwidth = 5;
		gbc_aufgabenStellungScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_aufgabenStellungScrollPane.fill = GridBagConstraints.BOTH;
		gbc_aufgabenStellungScrollPane.gridx = 1;
		gbc_aufgabenStellungScrollPane.gridy = 2;
		aufgabenstellungPanel.add(aufgabenStellungScrollPane, gbc_aufgabenStellungScrollPane);
		
		txtAufgabenstellung = new JTextField();
		txtAufgabenstellung.setPreferredSize(new Dimension(6, 5));
		txtAufgabenstellung.setText("Aufgabenstellung");
		aufgabenStellungScrollPane.setViewportView(txtAufgabenstellung);
		txtAufgabenstellung.setColumns(10);
		
		JScrollPane antwortenScrollPane = new JScrollPane();
		GridBagConstraints gbc_antwortenScrollPane = new GridBagConstraints();
		gbc_antwortenScrollPane.gridheight = 3;
		gbc_antwortenScrollPane.gridwidth = 5;
		gbc_antwortenScrollPane.insets = new Insets(0, 0, 5, 5);
		gbc_antwortenScrollPane.fill = GridBagConstraints.BOTH;
		gbc_antwortenScrollPane.gridx = 1;
		gbc_antwortenScrollPane.gridy = 6;
		aufgabenstellungPanel.add(antwortenScrollPane, gbc_antwortenScrollPane);
		
		JList antwortenList = new JList();
		antwortenList.setModel(new AbstractListModel() {
			String[] values = new String[] {"Antwort 1", "Antwort 2", "Antwort 3", "Antwort 4", "Antwort 5"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		antwortenScrollPane.setViewportView(antwortenList);
		
		JLabel lblPunktzahl = new JLabel("Punktzahl:");
		GridBagConstraints gbc_lblPunktzahl = new GridBagConstraints();
		gbc_lblPunktzahl.insets = new Insets(0, 0, 5, 5);
		gbc_lblPunktzahl.gridx = 6;
		gbc_lblPunktzahl.gridy = 9;
		aufgabenstellungPanel.add(lblPunktzahl, gbc_lblPunktzahl);
		
		JLabel lblPunktzahlZahl = new JLabel("4");
		GridBagConstraints gbc_lblPunktzahlZahl = new GridBagConstraints();
		gbc_lblPunktzahlZahl.insets = new Insets(0, 0, 5, 5);
		gbc_lblPunktzahlZahl.gridx = 7;
		gbc_lblPunktzahlZahl.gridy = 9;
		aufgabenstellungPanel.add(lblPunktzahlZahl, gbc_lblPunktzahlZahl);
		
		frame.pack();
		
	}

}
