package Views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

import DatabaseService.DatabaseService;
import Models.Admin;

public class EinstellungenPopUp {
	private JButton btnSchlieﬂen;
	private JPasswordField aktuellesPasswortField;
	private JPasswordField neuesPasswortField;
	
	private JButton btnSpeichern;
	private Admin admin;
	private JLabel messageLabel;
	
	private JFrame frmEinstellungen;
	
	private DatabaseService db = DatabaseService.getInstance();
	
	public EinstellungenPopUp(){
		onCreate();
		this.admin = db.readAdmin();
		btnSpeichern.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				messageLabel.setForeground(Color.RED);
				
				String pw = null;
				String neuesPw = null;
				
				try {
					char[] passwort = aktuellesPasswortField.getPassword();
					char[] neuesPasswort = neuesPasswortField.getPassword();
					pw =  String.valueOf(passwort);
					neuesPw = String.valueOf(neuesPasswort);
				} catch (Exception ex) {

					messageLabel.setText("Bitte Felder f¸llen!");
					
				}
				
				if(pw.equals(admin.getPasswort())) {
					
					admin.setPasswort(neuesPw);
					db.persistAdmin(admin);
					messageLabel.setForeground(Color.GREEN);
					messageLabel.setText("Passwort wurde ge‰ndert!");
				
				} else {
					messageLabel.setText("Aktuelles Passwort falsch!");
				}
				
				
				
			}
		});
		
		btnSchlieﬂen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmEinstellungen.dispose();
			
			}
		});
		
	}
//
	public void onCreate(){
		frmEinstellungen = new JFrame("Einstellungen");
		frmEinstellungen.setMinimumSize(new Dimension(500, 300));
		frmEinstellungen.getContentPane().setBackground(Color.WHITE);
		frmEinstellungen.getContentPane().setFont(new Font("Verdana", Font.PLAIN, 11));
		frmEinstellungen.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.WHITE);
		frmEinstellungen.getContentPane().add(tabbedPane);
		
		
		JPanel sicherheitsPanel = new JPanel();
		sicherheitsPanel.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Sicherheit", null, sicherheitsPanel, null);
		GridBagLayout gbl_sicherheitsPanel = new GridBagLayout();
		gbl_sicherheitsPanel.columnWidths = new int[]{30, 0, 0, 0, 30, 0};
		gbl_sicherheitsPanel.rowHeights = new int[]{30, 0, 0, 0, 0, 0, 30, 0};
		gbl_sicherheitsPanel.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_sicherheitsPanel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
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
		
		aktuellesPasswortField = new JPasswordField();
		GridBagConstraints gbc_aktuellesPasswortField = new GridBagConstraints();
		gbc_aktuellesPasswortField.insets = new Insets(0, 0, 5, 5);
		gbc_aktuellesPasswortField.fill = GridBagConstraints.HORIZONTAL;
		gbc_aktuellesPasswortField.gridx = 2;
		gbc_aktuellesPasswortField.gridy = 2;
		sicherheitsPanel.add(aktuellesPasswortField, gbc_aktuellesPasswortField);
		
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
		
		neuesPasswortField = new JPasswordField();
		GridBagConstraints gbc_neuesPasswortField = new GridBagConstraints();
		gbc_neuesPasswortField.insets = new Insets(0, 0, 5, 5);
		gbc_neuesPasswortField.fill = GridBagConstraints.HORIZONTAL;
		gbc_neuesPasswortField.gridx = 2;
		gbc_neuesPasswortField.gridy = 4;
		sicherheitsPanel.add(neuesPasswortField, gbc_neuesPasswortField);
		
		btnSpeichern = new JButton("Speichern");
		btnSpeichern.setFont(new Font("Verdana", Font.PLAIN, 11));
		GridBagConstraints gbc_btnSpeichern = new GridBagConstraints();
		gbc_btnSpeichern.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnSpeichern.insets = new Insets(0, 0, 5, 5);
		gbc_btnSpeichern.gridx = 3;
		gbc_btnSpeichern.gridy = 4;
		sicherheitsPanel.add(btnSpeichern, gbc_btnSpeichern);
		
		messageLabel = new JLabel("");
		messageLabel.setForeground(Color.RED);
		messageLabel.setFont(new Font("Verdana", Font.PLAIN, 10));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 2;
		gbc_lblNewLabel.gridy = 5;
		sicherheitsPanel.add(messageLabel, gbc_lblNewLabel);
		
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
		
		btnSchlieﬂen = new JButton("Schlie\u00DFen");
		btnSchlieﬂen.setFont(new Font("Verdana", Font.PLAIN, 11));
		buttonPanel.add(btnSchlieﬂen);
		
		frmEinstellungen.pack();
		frmEinstellungen.setVisible(true);
		frmEinstellungen.setLocationRelativeTo(null);
		frmEinstellungen.setDefaultCloseOperation(frmEinstellungen.DISPOSE_ON_CLOSE);
		
		
	}
	
}
