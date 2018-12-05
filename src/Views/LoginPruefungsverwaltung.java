package Views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

public class LoginPruefungsverwaltung {

	private JFrame frame;
	private JTextField textFieldBenutzername;
	private JPasswordField textFieldPasswort;

	
	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the application.
	 */
	public LoginPruefungsverwaltung() {
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
		gbl_panel.rowHeights = new int[] {40, 40};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblPruefungsverwaltung = new JLabel("Pruefungsverwaltung");
		lblPruefungsverwaltung.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GridBagConstraints gbc_lblPruefungsverwaltung = new GridBagConstraints();
		gbc_lblPruefungsverwaltung.insets = new Insets(0, 0, 5, 0);
		gbc_lblPruefungsverwaltung.gridx = 0;
		gbc_lblPruefungsverwaltung.gridy = 0;
		panel.add(lblPruefungsverwaltung, gbc_lblPruefungsverwaltung);
		
		JLabel lblVersion = new JLabel("Version");
		GridBagConstraints gbc_lblVersion = new GridBagConstraints();
		gbc_lblVersion.anchor = GridBagConstraints.NORTH;
		gbc_lblVersion.gridx = 0;
		gbc_lblVersion.gridy = 1;
		panel.add(lblVersion, gbc_lblVersion);
		
		JPanel panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{0, 0, 0};
		gbl_panel_1.rowHeights = new int[] {0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		JLabel lblBenutzername = new JLabel("Benutzername");
		GridBagConstraints gbc_lblBenutzername = new GridBagConstraints();
		gbc_lblBenutzername.insets = new Insets(0, 0, 5, 5);
		gbc_lblBenutzername.anchor = GridBagConstraints.EAST;
		gbc_lblBenutzername.gridx = 0;
		gbc_lblBenutzername.gridy = 0;
		panel_1.add(lblBenutzername, gbc_lblBenutzername);
		
		textFieldBenutzername = new JTextField();
		GridBagConstraints gbc_textFieldBenutzername = new GridBagConstraints();
		gbc_textFieldBenutzername.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldBenutzername.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldBenutzername.gridx = 1;
		gbc_textFieldBenutzername.gridy = 0;
		panel_1.add(textFieldBenutzername, gbc_textFieldBenutzername);
		textFieldBenutzername.setColumns(10);
		
		JLabel lblPasswort = new JLabel("Passwort");
		GridBagConstraints gbc_lblPasswort = new GridBagConstraints();
		gbc_lblPasswort.anchor = GridBagConstraints.EAST;
		gbc_lblPasswort.insets = new Insets(0, 0, 5, 5);
		gbc_lblPasswort.gridx = 0;
		gbc_lblPasswort.gridy = 1;
		panel_1.add(lblPasswort, gbc_lblPasswort);
		
		textFieldPasswort = new JPasswordField();
		GridBagConstraints gbc_textFieldPasswort = new GridBagConstraints();
		gbc_textFieldPasswort.insets = new Insets(0, 0, 5, 0);
		gbc_textFieldPasswort.fill = GridBagConstraints.HORIZONTAL;
		gbc_textFieldPasswort.gridx = 1;
		gbc_textFieldPasswort.gridy = 1;
		panel_1.add(textFieldPasswort, gbc_textFieldPasswort);
		textFieldPasswort.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.EAST;
		gbc_btnLogin.gridx = 1;
		gbc_btnLogin.gridy = 2;
		panel_1.add(btnLogin, gbc_btnLogin);
		
//		setLocationRelativeTo(null);
//		setMinimumSize(new Dimension(500, 300));
//		setResizable(false);
	}
}
