package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.JList;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.GridLayout;

public class PruefungsDetails extends JFrame {
	private JTextField textFieldPrfungstitel;
	private JTextField textFieldDauer;
	private JTextField textFieldPunkte;
	private JTable tableAufgaben;
	private JTable table;
	public PruefungsDetails() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panelButtons.add(btnSpeichern);
		
		JButton btnLschen = new JButton("L\u00F6schen");
		panelButtons.add(btnLschen);
		
		JButton btnFreigeben = new JButton("Freigeben");
		panelButtons.add(btnFreigeben);
		
		JPanel panelMain = new JPanel();
		getContentPane().add(panelMain, BorderLayout.CENTER);
		GridBagLayout gbl_panelMain = new GridBagLayout();
		gbl_panelMain.columnWidths = new int[]{0, 0, 300, 50, 0, 0, 0};
		gbl_panelMain.rowHeights = new int[]{0, 0, 59, 0, 0, 0, 0};
		gbl_panelMain.columnWeights = new double[]{0.0, 0.0, 1.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelMain.rowWeights = new double[]{0.0, 0.0, 0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE};
		panelMain.setLayout(gbl_panelMain);
		
		JLabel lblPrfungstitel = new JLabel("Pr\u00FCfungstitel:");
		GridBagConstraints gbc_lblPrfungstitel = new GridBagConstraints();
		gbc_lblPrfungstitel.anchor = GridBagConstraints.EAST;
		gbc_lblPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_lblPrfungstitel.gridx = 1;
		gbc_lblPrfungstitel.gridy = 1;
		panelMain.add(lblPrfungstitel, gbc_lblPrfungstitel);
		
		textFieldPrfungstitel = new JTextField();
		GridBagConstraints gbc_textFieldPrfungstitel = new GridBagConstraints();
		gbc_textFieldPrfungstitel.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPrfungstitel.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPrfungstitel.gridx = 2;
		gbc_textFieldPrfungstitel.gridy = 1;
		panelMain.add(textFieldPrfungstitel, gbc_textFieldPrfungstitel);
		textFieldPrfungstitel.setColumns(10);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTH;
		gbc_panel.gridwidth = 2;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		panelMain.add(panel, gbc_panel);
		
		JLabel lblDauermin = new JLabel("Dauer(Min):");
		lblDauermin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblDauermin);
		
		textFieldDauer = new JTextField();
		panel.add(textFieldDauer);
		textFieldDauer.setColumns(4);
		
		JLabel lblPunte = new JLabel("Punkte:");
		lblPunte.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel.add(lblPunte);
		
		textFieldPunkte = new JTextField();
		panel.add(textFieldPunkte);
		textFieldPunkte.setColumns(4);
		
		JList listTermine = new JList();
		panel.add(listTermine);
		
		JLabel lblAufgaben = new JLabel("Aufgaben:");
		GridBagConstraints gbc_lblAufgaben = new GridBagConstraints();
		gbc_lblAufgaben.anchor = GridBagConstraints.NORTH;
		gbc_lblAufgaben.insets = new Insets(0, 0, 5, 5);
		gbc_lblAufgaben.gridx = 1;
		gbc_lblAufgaben.gridy = 3;
		panelMain.add(lblAufgaben, gbc_lblAufgaben);
		
		tableAufgaben = new JTable();
		GridBagConstraints gbc_tableAufgaben = new GridBagConstraints();
		gbc_tableAufgaben.insets = new Insets(0, 0, 5, 5);
		gbc_tableAufgaben.fill = GridBagConstraints.BOTH;
		gbc_tableAufgaben.gridx = 2;
		gbc_tableAufgaben.gridy = 3;
		panelMain.add(tableAufgaben, gbc_tableAufgaben);
		
		JLabel lblNewLabel = new JLabel("Teilnehmer:");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 4;
		panelMain.add(lblNewLabel, gbc_lblNewLabel);
		
		table = new JTable();
		GridBagConstraints gbc_table = new GridBagConstraints();
		gbc_table.insets = new Insets(0, 0, 5, 5);
		gbc_table.fill = GridBagConstraints.BOTH;
		gbc_table.gridx = 2;
		gbc_table.gridy = 4;
		panelMain.add(table, gbc_table);
	}

}
