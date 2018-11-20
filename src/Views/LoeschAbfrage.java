package Views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class LoeschAbfrage extends JFrame{
	public LoeschAbfrage() {
		
		JLabel lblAbfrage = new JLabel("       Soll wirklich gel\u00F6scht werden?       ");
		lblAbfrage.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblAbfrage, BorderLayout.CENTER);
		
		JPanel panelButtons = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panelButtons.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(panelButtons, BorderLayout.SOUTH);
		
		JButton btnBesttigen = new JButton("Best\u00E4tigen");
		panelButtons.add(btnBesttigen);
		
		JButton btnAbbrechen = new JButton("Abbrechen");
		panelButtons.add(btnAbbrechen);
		
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
	}

}
