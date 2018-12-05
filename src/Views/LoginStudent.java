package Views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import java.util.GregorianCalendar;
import javax.swing.JButton;

public class LoginStudent {

	private JFrame frame;
	
	private GregorianCalendar calender = new GregorianCalendar();
	
	int day = calender.get(GregorianCalendar.DAY_OF_MONTH);
	String dayS = String.valueOf(day);
	
	int month = calender.get(GregorianCalendar.MONTH) + 1;
	String monthS = String.valueOf(month);
	
	int year = calender.get(GregorianCalendar.YEAR);
	String yearS = String.valueOf(year);
	
	private JTextField textFieldBenutzer;
	private JTextField textFieldPassword;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginStudent window = new LoginStudent();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public LoginStudent() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[] {40, 20, 25, 20, 20};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblTestat = new JLabel("Testat");
		lblTestat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblTestat = new GridBagConstraints();
		gbc_lblTestat.anchor = GridBagConstraints.SOUTH;
		gbc_lblTestat.insets = new Insets(0, 0, 5, 0);
		gbc_lblTestat.gridx = 0;
		gbc_lblTestat.gridy = 0;
		panel.add(lblTestat, gbc_lblTestat);
		
		JLabel lblDatum = new JLabel(dayS + "." + monthS + "." + yearS);
		lblDatum.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_lblDatum = new GridBagConstraints();
		gbc_lblDatum.insets = new Insets(0, 0, 5, 0);
		gbc_lblDatum.gridx = 0;
		gbc_lblDatum.gridy = 1;
		panel.add(lblDatum, gbc_lblDatum);
		
		JLabel lblMatrikelnummer = new JLabel("Matrikelnummer:");
		GridBagConstraints gbc_lblMatrikelnummer = new GridBagConstraints();
		gbc_lblMatrikelnummer.anchor = GridBagConstraints.SOUTH;
		gbc_lblMatrikelnummer.insets = new Insets(0, 0, 5, 0);
		gbc_lblMatrikelnummer.gridx = 0;
		gbc_lblMatrikelnummer.gridy = 2;
		panel.add(lblMatrikelnummer, gbc_lblMatrikelnummer);
		
		JLabel lblVersion = new JLabel("Version");
		GridBagConstraints gbc_lblVersion = new GridBagConstraints();
		gbc_lblVersion.gridx = 0;
		gbc_lblVersion.gridy = 3;
		panel.add(lblVersion, gbc_lblVersion);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblBenutzername = new JLabel("Benutzername");
		GridBagConstraints gbc_lblBenutzername = new GridBagConstraints();
		gbc_lblBenutzername.anchor = GridBagConstraints.EAST;
		gbc_lblBenutzername.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzername.gridx = 0;
		gbc_lblBenutzername.gridy = 0;
		panel_1.add(lblBenutzername, gbc_lblBenutzername);
		
		textFieldBenutzer = new JTextField();
		GridBagConstraints gbc_textFieldBenutzer = new GridBagConstraints();
		gbc_textFieldBenutzer.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBenutzer.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBenutzer.gridx = 1;
		gbc_textFieldBenutzer.gridy = 0;
		panel_1.add(textFieldBenutzer, gbc_textFieldBenutzer);
		textFieldBenutzer.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 0;
		gbc_lblPasswort.gridy = 1;
		panel_1.add(lblPasswort, gbc_lblPasswort);
		
		textFieldPassword = new JTextField();
		GridBagConstraints gbc_textFieldPassword = new GridBagConstraints();
		gbc_textFieldPassword.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPassword.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPassword.gridx = 1;
		gbc_textFieldPassword.gridy = 1;
		panel_1.add(textFieldPassword, gbc_textFieldPassword);
		textFieldPassword.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.EAST;
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 2;
		panel_1.add(btnLogin, gbc_btnLogin);
	}

}
