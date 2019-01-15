package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.GregorianCalendar;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;

import Controller.LoginPruefungsverwaltungController;

import java.awt.Color;
import javax.swing.JCheckBox;
import javax.swing.JSeparator;

//Victoria Meier
public class LoginStudent {

	private JFrame frame;
	private JButton btnLogin;
	
	private GregorianCalendar calender = new GregorianCalendar();
	
	int day = calender.get(GregorianCalendar.DAY_OF_MONTH);
	String dayS = String.valueOf(day);
	
	int month = calender.get(GregorianCalendar.MONTH) + 1;
	String monthS = String.valueOf(month);
	
	int year = calender.get(GregorianCalendar.YEAR);
	String yearS = String.valueOf(year);
	
	LoginPruefungsverwaltungController controller;
	private JTextField textFieldMatrikelNr;
	private JLabel fehlerLabel;
	
	private JTextField urlTextField;
	private JTextField benutzernameTextField;
	private JTextField passwortTextField;

	/**
	 * Create the application.
	 */
	public LoginStudent() {
		this.controller = new LoginPruefungsverwaltungController(this);
		initialize();
		addActionListeners();
	}
	//
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() { 
		frame = new JFrame();
		frame.setVisible(true);
		frame.getContentPane().setBackground(new Color(0, 155, 187));
		frame.getContentPane().setMinimumSize(new Dimension(700, 400));
		frame.getContentPane().setMaximumSize(new Dimension(700, 400));
		frame.getContentPane().setSize(new Dimension(700, 400));
		frame.setResizable(false);
//		frame.setBounds(100, 100, 871, 902);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{559, 25, 400, 25, 0};
		gridBagLayout.rowHeights = new int[]{211, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		frame.setIconImage(icon1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 155, 187));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		frame.getContentPane().add(panel, gbc_panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[] {50, 20, 45, 20};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTestat = new JLabel("examo");
		lblTestat.setForeground(new Color(255, 255, 255));
		lblTestat.setFont(new Font("Gill Sans MT", Font.PLAIN, 78));
		GridBagConstraints gbc_lblTestat = new GridBagConstraints();
		gbc_lblTestat.insets = new Insets(0, 0, 5, 0);
		gbc_lblTestat.gridx = 0;
		gbc_lblTestat.gridy = 0;
		panel.add(lblTestat, gbc_lblTestat);
		
		JLabel lblDatum = new JLabel(dayS + "." + monthS + "." + yearS);
		lblDatum.setForeground(new Color(255, 255, 255));
		lblDatum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatum.gridx = 0;
		gbc_lblDatum.gridy = 1;
		panel.add(lblDatum, gbc_lblDatum);
		
		JLabel lblTestat_1 = new JLabel("Testat");
		lblTestat_1.setFont(new Font("Verdana", Font.BOLD, 30));
		lblTestat_1.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblTestat_1 = new GridBagConstraints();
		gbc_lblTestat_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblTestat_1.gridx = 0;
		gbc_lblTestat_1.gridy = 2;
		panel.add(lblTestat_1, gbc_lblTestat_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 155, 187));
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 1;
		frame.getContentPane().add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{309, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 33, 0, 0};
		gbl_panel_1.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 1.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0,155,187));
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_1.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{0, 0};
		gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		
		JLabel label = new JLabel("Datenbank Login");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 5, 0);
		gbc_label.gridx = 0;
		gbc_label.gridy = 0;
		panel_3.add(label, gbc_label);
		
		JLabel label_1 = new JLabel("URL");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.anchor = GridBagConstraints.WEST;
		gbc_label_1.insets = new Insets(0, 0, 5, 0);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel_3.add(label_1, gbc_label_1);
		
		urlTextField = new JTextField();
		urlTextField.setColumns(10);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panel_3.add(urlTextField, gbc_textField);
		
		JLabel label_2 = new JLabel("Benutzername");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.anchor = GridBagConstraints.WEST;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 0;
		gbc_label_2.gridy = 3;
		panel_3.add(label_2, gbc_label_2);
		
		benutzernameTextField = new JTextField();
		benutzernameTextField.setColumns(10);
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		panel_3.add(benutzernameTextField, gbc_textField_1);
		
		JLabel label_3 = new JLabel("Passwort");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.anchor = GridBagConstraints.WEST;
		gbc_label_3.insets = new Insets(0, 0, 5, 0);
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 5;
		panel_3.add(label_3, gbc_label_3);
		
		passwortTextField = new JTextField();
		passwortTextField.setColumns(10);
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 6;
		panel_3.add(passwortTextField, gbc_textField_2);
		
		JCheckBox checkBox = new JCheckBox("Erstanmeldung");
		checkBox.setForeground(Color.WHITE);
		checkBox.setFont(new Font("Verdana", Font.PLAIN, 16));
		checkBox.setBackground(new Color(0,155,187));
		GridBagConstraints gbc_checkBox = new GridBagConstraints();
		gbc_checkBox.anchor = GridBagConstraints.EAST;
		gbc_checkBox.insets = new Insets(0, 0, 5, 0);
		gbc_checkBox.gridx = 0;
		gbc_checkBox.gridy = 7;
		panel_3.add(checkBox, gbc_checkBox);
		
		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 8;
		panel_3.add(separator, gbc_separator);
		
		JLabel lblPrfungLogin = new JLabel("Pr\u00FCfung Login");
		lblPrfungLogin.setForeground(Color.WHITE);
		lblPrfungLogin.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblPrfungLogin = new GridBagConstraints();
		gbc_lblPrfungLogin.insets = new Insets(0, 0, 5, 0);
		gbc_lblPrfungLogin.gridx = 0;
		gbc_lblPrfungLogin.gridy = 1;
		panel_1.add(lblPrfungLogin, gbc_lblPrfungLogin);
		
		JLabel lblMatrikelnummer = new JLabel("Matrikelnummer");
		lblMatrikelnummer.setForeground(Color.WHITE);
		lblMatrikelnummer.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 0);
		gbc_lblMatrikelnummer.anchor = GridBagConstraints.SOUTHWEST;
		gbc_lblMatrikelnummer.gridx = 0;
		gbc_lblMatrikelnummer.gridy = 2;
		panel_1.add(lblMatrikelnummer, gbc_lblMatrikelnummer);
		
		textFieldMatrikelNr = new JTextField();
		GridBagConstraints gbc_textField5 = new GridBagConstraints();
		gbc_textField5.insets = new Insets(0, 0, 5, 0);
		gbc_textField5.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField5.gridx = 0;
		gbc_textField5.gridy = 3;
		panel_1.add(textFieldMatrikelNr, gbc_textField);
		textFieldMatrikelNr.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0,155,187));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.anchor = GridBagConstraints.EAST;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 4;
		panel_1.add(panel_2, gbc_panel_2);
		
		fehlerLabel = new JLabel("");
		fehlerLabel.setForeground(Color.RED);
		fehlerLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		panel_2.add(fehlerLabel);
		
		btnLogin = new JButton("Login");
		panel_2.add(btnLogin);
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 16));
		
		JLabel lblVersion = new JLabel("Version: 1.0");
		lblVersion.setForeground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblVersion = new GridBagConstraints();
		gbc_lblVersion.anchor = GridBagConstraints.WEST;
		gbc_lblVersion.gridx = 0;
		gbc_lblVersion.gridy = 5;
		panel_1.add(lblVersion, gbc_lblVersion);
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(500, 300));
		frame.setResizable(false);
	}
	
	public JTextField getTFMatrikelNr() {
		return this.textFieldMatrikelNr;
	}
	
	public JFrame getLoginStudentFrame() {
		return this.frame;
	}
	
	public void addActionListeners(){
		
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.einloggenStudent();
			}
		});
		
		textFieldMatrikelNr.addActionListener(btnLogin.getActionListeners()[0]);
	}
	
	public JLabel getFehlerLabel() {
		return fehlerLabel;
	}
	public JTextField getUrlTextField() {
		return urlTextField;
	}
	public JTextField getBenutzernameTextField() {
		return benutzernameTextField;
	}
	public JTextField getPasswortTextField() {
		return passwortTextField;
	}

}
