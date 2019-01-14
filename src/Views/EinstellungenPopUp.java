package Views;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JSeparator;
import java.awt.Font;
import javax.swing.JCheckBox;
import java.awt.Color;

public class EinstellungenPopUp {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnSchlieﬂen;
	
	public EinstellungenPopUp(){
		onCreate();
		
	}
//
	public void onCreate(){
		JFrame frmEinstellungen = new JFrame("Einstellungen");
		frmEinstellungen.getContentPane().setBackground(Color.WHITE);
		frmEinstellungen.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		frmEinstellungen.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		frmEinstellungen.getContentPane().add(tabbedPane);
		
		JPanel datenbankPanel = new JPanel();
		datenbankPanel.setBackground(Color.WHITE);
		tabbedPane.addTab("Datenbank", null, datenbankPanel, null);
		GridBagLayout gbl_datenbankPanel = new GridBagLayout();
		gbl_datenbankPanel.columnWidths = new int[]{30, 0, 0, 30, 0};
		gbl_datenbankPanel.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 0, 30, 0};
		gbl_datenbankPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_datenbankPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		datenbankPanel.setLayout(gbl_datenbankPanel);
		
		JLabel lblNewLabel = new JLabel("Geben Sie den neuen Datenbankzugang an");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.gridwidth = 2;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		datenbankPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblDatenbankUrl = new JLabel("Datenbank URL:");
		lblDatenbankUrl.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblDatenbankUrl = new GridBagConstraints();
		gbc_lblDatenbankUrl.insets = new Insets(0, 0, 5, 5);
		gbc_lblDatenbankUrl.anchor = GridBagConstraints.EAST;
		gbc_lblDatenbankUrl.gridx = 1;
		gbc_lblDatenbankUrl.gridy = 2;
		datenbankPanel.add(lblDatenbankUrl, gbc_lblDatenbankUrl);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 2;
		gbc_textField.gridy = 2;
		datenbankPanel.add(textField, gbc_textField);
		textField.setColumns(10);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridwidth = 2;
		gbc_separator.insets = new Insets(0, 0, 5, 5);
		gbc_separator.gridx = 1;
		gbc_separator.gridy = 3;
		datenbankPanel.add(separator, gbc_separator);
		
		JLabel lblBenutzname = new JLabel("Benutzname: ");
		lblBenutzname.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblBenutzname = new GridBagConstraints();
		gbc_lblBenutzname.anchor = GridBagConstraints.EAST;
		gbc_lblBenutzname.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzname.gridx = 1;
		gbc_lblBenutzname.gridy = 4;
		datenbankPanel.add(lblBenutzname, gbc_lblBenutzname);
		
		textField_1 = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 2;
		gbc_textField_1.gridy = 4;
		datenbankPanel.add(textField_1, gbc_textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort:");
		lblPasswort.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 1;
		gbc_lblPasswort.gridy = 5;
		datenbankPanel.add(lblPasswort, gbc_lblPasswort);
		
		textField_2 = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 5);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 2;
		gbc_textField_2.gridy = 5;
		datenbankPanel.add(textField_2, gbc_textField_2);
		textField_2.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		FlowLayout flowLayout_1 = (FlowLayout) panel.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 6;
		datenbankPanel.add(panel, gbc_panel);
		
		JCheckBox chckbxTabellenErzeugen = new JCheckBox("Tabellen erzeugen");
		chckbxTabellenErzeugen.setFont(new Font("Verdana", Font.PLAIN, 11));
		chckbxTabellenErzeugen.setBackground(new Color(255, 255, 255));
		panel.add(chckbxTabellenErzeugen);
		
		JButton btnNewButton_2 = new JButton("Speichern");
		btnNewButton_2.setFont(new Font("Verdana", Font.PLAIN, 11));
		panel.add(btnNewButton_2);
		
		
		JPanel sicherheitsPanel = new JPanel();
		sicherheitsPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Sicherheit", null, sicherheitsPanel, null);
		GridBagLayout gbl_sicherheitsPanel = new GridBagLayout();
		gbl_sicherheitsPanel.columnWidths = new int[]{30, 0, 0, 0, 30, 0};
		gbl_sicherheitsPanel.rowHeights = new int[]{30, 0, 0, 0, 0, 30, 0};
		gbl_sicherheitsPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_sicherheitsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		sicherheitsPanel.setLayout(gbl_sicherheitsPanel);
		
		JLabel lblWhlenSieEin = new JLabel("W\u00E4hlen Sie ein neues Passwort\r\n");
		lblWhlenSieEin.setFont(new Font("Verdana", Font.BOLD, 12));
		GridBagConstraints gbc_lblWhlenSieEin = new GridBagConstraints();
		gbc_lblWhlenSieEin.anchor = GridBagConstraints.WEST;
		gbc_lblWhlenSieEin.gridwidth = 3;
		gbc_lblWhlenSieEin.insets = new Insets(0, 0, 5, 5);
		gbc_lblWhlenSieEin.gridx = 1;
		gbc_lblWhlenSieEin.gridy = 1;
		sicherheitsPanel.add(lblWhlenSieEin, gbc_lblWhlenSieEin);
		
		JLabel lblAktuellesPasswort = new JLabel("Aktuelles Passwort:");
		lblAktuellesPasswort.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblAktuellesPasswort = new GridBagConstraints();
		gbc_lblAktuellesPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblAktuellesPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblAktuellesPasswort.gridx = 1;
		gbc_lblAktuellesPasswort.gridy = 2;
		sicherheitsPanel.add(lblAktuellesPasswort, gbc_lblAktuellesPasswort);
		
		textField_3 = new JTextField();
		GridBagConstraints gbc_textField_3 = new GridBagConstraints();
		gbc_textField_3.insets = new Insets(0, 0, 5, 5);
		gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_3.gridx = 2;
		gbc_textField_3.gridy = 2;
		sicherheitsPanel.add(textField_3, gbc_textField_3);
		textField_3.setColumns(10);
		
		JButton btnberprfen = new JButton("\u00DCberpr\u00FCfen");
		btnberprfen.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_btnberprfen = new GridBagConstraints();
		gbc_btnberprfen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnberprfen.insets = new Insets(0, 0, 5, 5);
		gbc_btnberprfen.gridx = 3;
		gbc_btnberprfen.gridy = 2;
		sicherheitsPanel.add(btnberprfen, gbc_btnberprfen);
		
		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.gridwidth = 3;
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 3;
		sicherheitsPanel.add(separator_1, gbc_separator_1);
		
		JLabel lblNeuesPasswort = new JLabel("Neues Passwort:");
		lblNeuesPasswort.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_lblNeuesPasswort = new GridBagConstraints();
		gbc_lblNeuesPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblNeuesPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblNeuesPasswort.gridx = 1;
		gbc_lblNeuesPasswort.gridy = 4;
		sicherheitsPanel.add(lblNeuesPasswort, gbc_lblNeuesPasswort);
		
		textField_4 = new JTextField();
		GridBagConstraints gbc_textField_4 = new GridBagConstraints();
		gbc_textField_4.insets = new Insets(0, 0, 5, 5);
		gbc_textField_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_4.gridx = 2;
		gbc_textField_4.gridy = 4;
		sicherheitsPanel.add(textField_4, gbc_textField_4);
		textField_4.setColumns(10);
		
		JButton btnSpeichern = new JButton("Speichern");
		btnSpeichern.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeichern.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpeichern.gridx = 3;
		gbc_btnSpeichern.gridy = 4;
		sicherheitsPanel.add(btnSpeichern, gbc_btnSpeichern);
		
		JPanel informationsPanel = new JPanel();
		informationsPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Informationen", null, informationsPanel, null);
		
		JLabel lblVersionsnummer = new JLabel("Versionsnummer: 1.0");
		lblVersionsnummer.setFont(new Font("Verdana", Font.PLAIN, 11));
		informationsPanel.add(lblVersionsnummer);
		
		JPanel ueberunsPanel = new JPanel();
		ueberunsPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("\u00DCber uns", null, ueberunsPanel, null);
		GridBagLayout gbl_ueberunsPanel = new GridBagLayout();
		gbl_ueberunsPanel.columnWidths = new int[]{30, 212, 30, 0};
		gbl_ueberunsPanel.rowHeights = new int[]{30, 22, 30, 0};
		gbl_ueberunsPanel.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_ueberunsPanel.rowWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		ueberunsPanel.setLayout(gbl_ueberunsPanel);
		
		JTextArea txtrSoftwareprojektImDritten = new JTextArea();
		txtrSoftwareprojektImDritten.setFont(new Font("Verdana", Font.PLAIN, 11));
		txtrSoftwareprojektImDritten.setText("Softwareprojekt im dritten Semester, der FH-Bielefeld\r\nProjektleiter: Prof. Dr. Alexander F\u00F6rster\r\nDas Team: Victoria Meier, Firat Aslan, Josah Weber, \nMarco Penner, Yanek Wilken\r\n18.1.2019");
		GridBagConstraints gbc_txtrSoftwareprojektImDritten = new GridBagConstraints();
		gbc_txtrSoftwareprojektImDritten.insets = new Insets(0, 0, 5, 5);
		gbc_txtrSoftwareprojektImDritten.anchor = GridBagConstraints.NORTHWEST;
		gbc_txtrSoftwareprojektImDritten.gridx = 1;
		gbc_txtrSoftwareprojektImDritten.gridy = 1;
		ueberunsPanel.add(txtrSoftwareprojektImDritten, gbc_txtrSoftwareprojektImDritten);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(new Color(204, 204, 204));
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		frmEinstellungen.getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnSchlieﬂen = new JButton("Schlie\u00DFen");
		btnSchlieﬂen.setFont(new Font("Verdana", Font.PLAIN, 11));
		buttonPanel.add(btnSchlieﬂen);
	}
	

	/*	btnSchlieﬂen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			frmEinstellungen.dispose();
			}
		});
	} */
}
