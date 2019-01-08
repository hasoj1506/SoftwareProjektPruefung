package Views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;

import Controller.LoginPruefungsverwaltungController;
import Controller.PruefungsDetailsController;
import Models.Nutzer;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JCheckBox;

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
		//Kommentar 2
		frame = new JFrame();
		frame.setBounds(100, 100, 484, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		Image icon1 = new ImageIcon(this.getClass().getResource("/ELogo.png")).getImage();
		frame.setIconImage(icon1);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setBackground(Color.WHITE);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[] {30, 70, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(new ImageIcon(this.getClass().getResource("/ELogok.png")).getImage()));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Gill Sans MT", Font.BOLD, 72));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblExamo = new JLabel("examo");
		lblExamo.setFont(new Font("Verdana", Font.BOLD, 45));
		lblExamo.setForeground(new Color(0,155,187));
		GridBagConstraints gbc_lblExamo = new GridBagConstraints();
		gbc_lblExamo.insets = new Insets(0, 0, 5, 0);
		gbc_lblExamo.gridx = 0;
		gbc_lblExamo.gridy = 2;
		panel.add(lblExamo, gbc_lblExamo);
		
		JLabel lblInstructorTools = new JLabel("Instructor Tools");
		lblInstructorTools.setForeground(new Color(0,155,187));
		lblInstructorTools.setFont(new Font("Gill Sans MT", Font.BOLD, 24));
		GridBagConstraints gbc_lblInstructorTools = new GridBagConstraints();
		gbc_lblInstructorTools.gridx = 0;
		gbc_lblInstructorTools.gridy = 3;
		panel.add(lblInstructorTools, gbc_lblInstructorTools);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{20, 0, 20, 0};
		gbl_panel_1.rowHeights = new int[] {63, 0, 35, 0, 27, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{1.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Passwort");
		lblNewLabel_2.setForeground(new Color(0,155,187));
		lblNewLabel_2.setFont(new Font("Verdana", Font.BOLD, 16));
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 1;
		panel_1.add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		textFieldPasswort = new JPasswordField();
		GridBagConstraints gbc_textFieldPasswort = new GridBagConstraints();
		gbc_textFieldPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldPasswort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPasswort.gridx = 1;
		gbc_textFieldPasswort.gridy = 2;
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
		gbc_panel_3.gridy = 3;
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
		//t
		JLabel lblVersion = new JLabel("Version: 1.0");
		lblVersion.setForeground(new Color(102, 102, 102));
		panel_2.add(lblVersion);
		lblVersion.setFont(new Font("Verdana", Font.BOLD, 16));
		

		frame.setLocationRelativeTo(null);
		frame.setMinimumSize(new Dimension(500, 800));
		frame.setResizable(false);
		frame.setVisible(true);		
	}
	
	public JPasswordField getTFPasswort() {
		return this.textFieldPasswort;
		
	}
	
	public JFrame getLoginPruefungsverwaltungFrame() {
		return this.frame;
	}
	
	public void addActionListeners(){
		
		btnLogin.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				controller.einloggenDozent();
			}
		});
		
		textFieldPasswort.addActionListener(btnLogin.getActionListeners()[0]);
		
		
	}
	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPruefungsverwaltung window = new LoginPruefungsverwaltung();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrame getFrame() {
		return frame;
	}
	
	//
}
