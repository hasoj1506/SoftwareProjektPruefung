package Views;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;

public class EinstellungenPopUp {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	public EinstellungenPopUp(){
		onCreate();
		
	}

	public void onCreate(){
		JFrame frame = new JFrame("Einstellungen");
		frame.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane);
		
		JPanel datenbankPanel = new JPanel();
		tabbedPane.addTab("Datenbank", null, datenbankPanel, null);
		GridBagLayout gbl_datenbankPanel = new GridBagLayout();
		gbl_datenbankPanel.columnWidths = new int[]{30, 0, 0, 0, 0};
		gbl_datenbankPanel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_datenbankPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_datenbankPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		datenbankPanel.setLayout(gbl_datenbankPanel);
		
		JLabel lblDatenbankUrl = new JLabel("Datenbank URL:");
		lblDatenbankUrl.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDatenbankUrl = new GridBagConstraints();
		gbc_lblDatenbankUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatenbankUrl.anchor = GridBagConstraints.EAST;
		gbc_lblDatenbankUrl.gridx = 1;
		gbc_lblDatenbankUrl.gridy = 1;
		datenbankPanel.add(lblDatenbankUrl, gbc_lblDatenbankUrl);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 1;
		datenbankPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 2;
		datenbankPanel.add(separator, gbc_separator);
		
		JLabel lblBenutzname = new JLabel("Benutzname: ");
		lblBenutzname.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblBenutzname = new GridBagConstraints();
		gbc_lblBenutzname.anchor = GridBagConstraints.EAST;
		gbc_lblBenutzname.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzname.gridx = 1;
		gbc_lblBenutzname.gridy = 3;
		datenbankPanel.add(lblBenutzname, gbc_lblBenutzname);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 3;
		datenbankPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 1;
		gbc_lblPasswort.gridy = 4;
		datenbankPanel.add(lblPasswort, gbc_lblPasswort);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 4;
		datenbankPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JPanel sicherheitsPanel = new JPanel();
		tabbedPane.addTab("Sicherheit", null, sicherheitsPanel, null);
		GridBagLayout gbl_sicherheitsPanel = new GridBagLayout();
		gbl_sicherheitsPanel.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0};
		gbl_sicherheitsPanel.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_sicherheitsPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_sicherheitsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		sicherheitsPanel.setLayout(gbl_sicherheitsPanel);
		
		JLabel lblAktuellesPasswort = new JLabel("Aktuelles Passwort:");
		GridBagConstraints gbc_lblAktuellesPasswort = new GridBagConstraints();
		gbc_lblAktuellesPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblAktuellesPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblAktuellesPasswort.gridx = 2;
		gbc_lblAktuellesPasswort.gridy = 1;
		sicherheitsPanel.add(lblAktuellesPasswort, gbc_lblAktuellesPasswort);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 3;
		gbc_textField_3.gridy = 1;
		sicherheitsPanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnberprfen = new JButton("\u00DCberpr\u00FCfen");
		GridBagConstraints gbc_btnberprfen = new GridBagConstraints();
		gbc_btnberprfen.insets = new Insets(0, 0, 5, 5);
		gbc_btnberprfen.gridx = 4;
		gbc_btnberprfen.gridy = 1;
		sicherheitsPanel.add(btnberprfen, gbc_btnberprfen);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 2;
		gbc_separator_1.gridy = 2;
		sicherheitsPanel.add(separator_1, gbc_separator_1);
		
		JLabel lblNeuesPasswort = new JLabel("Neues Passwort:");
		GridBagConstraints gbc_lblNeuesPasswort = new GridBagConstraints();
		gbc_lblNeuesPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblNeuesPasswort.insets = new Insets(0, 0, 0, 5);
		gbc_lblNeuesPasswort.gridx = 2;
		gbc_lblNeuesPasswort.gridy = 3;
		sicherheitsPanel.add(lblNeuesPasswort, gbc_lblNeuesPasswort);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 0, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 3;
		gbc_textField_4.gridy = 3;
		sicherheitsPanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JPanel informationsPanel = new JPanel();
		tabbedPane.addTab("Informationen", null, informationsPanel, null);
		
		JLabel lblVersionsnummer = new JLabel("Versionsnummer: 1.0");
		informationsPanel.add(lblVersionsnummer);
		
		JPanel ueberunsPanel = new JPanel();
		tabbedPane.addTab("\u00DCber uns", null, ueberunsPanel, null);
		GridBagLayout gbl_ueberunsPanel = new GridBagLayout();
		gbl_ueberunsPanel.columnWidths = new int[]{30, 212, 30, 0};
		gbl_ueberunsPanel.rowHeights = new int[]{22, 0};
		gbl_ueberunsPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_ueberunsPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		ueberunsPanel.setLayout(gbl_ueberunsPanel);
		
		JTextArea textArea = new JTextArea();
		GridBagConstraints gbc_textArea = new GridBagConstraints();
		gbc_textArea.insets = new Insets(0, 0, 0, 5);
		gbc_textArea.anchor = GridBagConstraints.NORTHWEST;
		gbc_textArea.gridx = 1;
		gbc_textArea.gridy = 0;
		ueberunsPanel.add(textArea, gbc_textArea);
		
		JPanel buttonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Speichern");
		buttonPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Abbrechen");
		buttonPanel.add(btnNewButton_1);
	}
	
}
