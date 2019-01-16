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
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import Controller.LoginPruefungsverwaltungController;

//Victoria Meier
public class LoginPruefungsverwaltung {

	private JFrame frame;
	private JPasswordField textFieldPasswort;
	private JButton btnLogin;
	private JLabel fehlerLabel;

	public JLabel getFehlerLabel() {
		return fehlerLabel;
	}

	LoginPruefungsverwaltungController controller;

	private JTextField urlTextField;
	private JTextField userTextField;
	private JTextField dbPasswortTextField;

	private JCheckBox neueTabellenChkBox;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the application.
	 */
	public LoginPruefungsverwaltung() {
		this.controller = new LoginPruefungsverwaltungController(this);
		initialize();
		addActionListeners();

	}

//

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Kommentar 2
		frame = new JFrame();
		frame.setBounds(100, 100, 484, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		Image icon1 = new ImageIcon(this.getClass().getResource("/Elogok.png")).getImage();
		frame.setIconImage(icon1);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.WHITE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 577, 0 };
		gbl_panel.rowHeights = new int[] { 417 };
		gbl_panel.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0 };
		panel.setLayout(gbl_panel);

		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(this.getClass().getResource("/Elogok.png")));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 20, 0, 20, 0 };
		gbl_panel_1.rowHeights = new int[] { 52, 0, 0, 232, 0, 0, 35, 0, 30, 0 };
		gbl_panel_1.columnWeights = new double[] { 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 1.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblExamo = new JLabel("examo");
		GridBagConstraints gbc_lblExamo = new GridBagConstraints();
		gbc_lblExamo.fill = GridBagConstraints.VERTICAL;
		gbc_lblExamo.insets = new Insets(0, 0, 5, 5);
		gbc_lblExamo.gridx = 1;
		gbc_lblExamo.gridy = 0;
		panel_1.add(lblExamo, gbc_lblExamo);
		lblExamo.setFont(new Font("Verdana", Font.BOLD, 45));
		lblExamo.setForeground(new Color(0, 155, 187));

		JLabel lblInstructorTools = new JLabel("Instructor Tools");
		GridBagConstraints gbc_lblInstructorTools = new GridBagConstraints();
		gbc_lblInstructorTools.insets = new Insets(0, 0, 5, 5);
		gbc_lblInstructorTools.gridx = 1;
		gbc_lblInstructorTools.gridy = 1;
		panel_1.add(lblInstructorTools, gbc_lblInstructorTools);
		lblInstructorTools.setForeground(new Color(0, 155, 187));
		lblInstructorTools.setFont(new Font("Gill Sans MT", Font.BOLD, 24));

		JSeparator separator_1 = new JSeparator();
		GridBagConstraints gbc_separator_1 = new GridBagConstraints();
		gbc_separator_1.insets = new Insets(0, 0, 5, 5);
		gbc_separator_1.gridx = 1;
		gbc_separator_1.gridy = 2;
		panel_1.add(separator_1, gbc_separator_1);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 1;
		gbc_panel_4.gridy = 3;
		panel_1.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblDatenbankLogin = new JLabel("Datenbank Login");
		lblDatenbankLogin.setForeground(new Color(0, 155, 187));
		lblDatenbankLogin.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblDatenbankLogin = new GridBagConstraints();
		gbc_lblDatenbankLogin.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatenbankLogin.gridx = 0;
		gbc_lblDatenbankLogin.gridy = 0;
		panel_4.add(lblDatenbankLogin, gbc_lblDatenbankLogin);

		JLabel lblNewLabel_1 = new JLabel("URL");
		lblNewLabel_1.setForeground(new Color(0, 155, 187));
		lblNewLabel_1.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 1;
		panel_4.add(lblNewLabel_1, gbc_lblNewLabel_1);

		urlTextField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 0);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 0;
		gbc_textField.gridy = 2;
		panel_4.add(urlTextField, gbc_textField);
		urlTextField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Benutzername");
		lblNewLabel_3.setForeground(new Color(0, 155, 187));
		lblNewLabel_3.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 3;
		panel_4.add(lblNewLabel_3, gbc_lblNewLabel_3);

		userTextField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 0);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 0;
		gbc_textField_1.gridy = 4;
		panel_4.add(userTextField, gbc_textField_1);
		userTextField.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Passwort");
		lblNewLabel_4.setForeground(new Color(0, 155, 187));
		lblNewLabel_4.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_4.gridx = 0;
		gbc_lblNewLabel_4.gridy = 5;
		panel_4.add(lblNewLabel_4, gbc_lblNewLabel_4);

		dbPasswortTextField = new JTextField();
		GridBagConstraints gbc_textField_2 = new GridBagConstraints();
		gbc_textField_2.insets = new Insets(0, 0, 5, 0);
		gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_2.gridx = 0;
		gbc_textField_2.gridy = 6;
		panel_4.add(dbPasswortTextField, gbc_textField_2);
		dbPasswortTextField.setColumns(10);

		neueTabellenChkBox = new JCheckBox("Erstanmeldung");
		neueTabellenChkBox.setForeground(new Color(0, 155, 187));
		neueTabellenChkBox.setFont(new Font("Verdana", Font.PLAIN, 16));
		neueTabellenChkBox.setBackground(Color.WHITE);
		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 0);
		gbc_chckbxNewCheckBox.anchor = GridBagConstraints.EAST;
		gbc_chckbxNewCheckBox.gridx = 0;
		gbc_chckbxNewCheckBox.gridy = 7;
		panel_4.add(neueTabellenChkBox, gbc_chckbxNewCheckBox);

		JSeparator separator = new JSeparator();
		GridBagConstraints gbc_separator = new GridBagConstraints();
		gbc_separator.gridx = 0;
		gbc_separator.gridy = 8;
		panel_4.add(separator, gbc_separator);

		JLabel lblAnwendungLogin = new JLabel("Anwendung Login");
		lblAnwendungLogin.setForeground(new Color(0, 155, 187));
		lblAnwendungLogin.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblAnwendungLogin = new GridBagConstraints();
		gbc_lblAnwendungLogin.insets = new Insets(0, 0, 5, 5);
		gbc_lblAnwendungLogin.gridx = 1;
		gbc_lblAnwendungLogin.gridy = 4;
		panel_1.add(lblAnwendungLogin, gbc_lblAnwendungLogin);

		JLabel lblNewLabel_2 = new JLabel("Passwort");
		lblNewLabel_2.setForeground(new Color(0, 155, 187));
		lblNewLabel_2.setFont(new Font("Verdana", Font.PLAIN, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);

		textFieldPasswort = new JPasswordField();
		GridBagConstraints gbc_textFieldPasswort = new GridBagConstraints();
		gbc_textFieldPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPasswort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPasswort.gridx = 1;
		gbc_textFieldPasswort.gridy = 6;
		panel_1.add(textFieldPasswort, gbc_textFieldPasswort);
		textFieldPasswort.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_3.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 7;
		panel_1.add(panel_3, gbc_panel_3);

		fehlerLabel = new JLabel("");
		fehlerLabel.setFont(new Font("Verdana", Font.PLAIN, 12));
		fehlerLabel.setForeground(Color.RED);
		panel_3.add(fehlerLabel);

		btnLogin = new JButton("Login");
		panel_3.add(btnLogin);
		btnLogin.setForeground(new Color(51, 51, 51));
		btnLogin.setFont(new Font("Verdana", Font.PLAIN, 16));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 204));
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		// t
		JLabel lblVersion = new JLabel("Version: 1.0");
		lblVersion.setForeground(Color.BLACK);
		panel_2.add(lblVersion);
		lblVersion.setFont(new Font("Verdana", Font.PLAIN, 16));

		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(350, 1010));
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public JPasswordField getTFPasswort() {
		return this.textFieldPasswort;

	}

	public JFrame getLoginPruefungsverwaltungFrame() {
		return this.frame;
	}

	public void addActionListeners() {

		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.einloggenDozent();
			}
		});

		textFieldPasswort.addActionListener(btnLogin.getActionListeners()[0]);

		neueTabellenChkBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (neueTabellenChkBox.isSelected()) {
					int reply = JOptionPane.showConfirmDialog(frame,
							"Bei einer Neu-Erzeugung werden alle Daten auf der Datenbank gelöscht. Wollen sie fortfahren?",
							"Abfrage", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.NO_OPTION) {
						neueTabellenChkBox.setSelected(false);
					}
					if (reply == JOptionPane.YES_OPTION) {
						neueTabellenChkBox.setSelected(true);
					}

				}
			}
		});

	}

	public JFrame getFrame() {
		return frame;
	}

	public JTextField getUrlTextField() {
		return urlTextField;
	}

	public JTextField getUserTextField() {
		return userTextField;
	}

	public JTextField getDbPasswortTextField() {
		return dbPasswortTextField;
	}

	public JCheckBox getNeueTabellenChkBox() {
		return neueTabellenChkBox;
	}

	//
}
