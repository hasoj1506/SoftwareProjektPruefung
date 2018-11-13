package Views;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JScrollBar;

@SuppressWarnings("serial")
public class Pruefungsverwaltung extends JFrame{
	private JTable tablePruefungen;
	public Pruefungsverwaltung() {
		
		JLabel lblPruefungsverwaltung = new JLabel(" Pr\u00FCfungsverwaltung");
		getContentPane().add(lblPruefungsverwaltung, BorderLayout.NORTH);
		
		tablePruefungen = new JTable();
		tablePruefungen.setColumnSelectionAllowed(true);
		getContentPane().add(tablePruefungen, BorderLayout.CENTER);
		
		JPanel buttonPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) buttonPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(buttonPanel, BorderLayout.SOUTH);
		
		JButton btnNeu = new JButton("Neu");
		btnNeu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		buttonPanel.add(btnNeu);
		
		JButton btnAendern = new JButton("\u00C4ndern");
		buttonPanel.add(btnAendern);
		
		JButton btnLoeschen = new JButton("L\u00F6schen");
		buttonPanel.add(btnLoeschen);
		
		JScrollBar scrollBar = new JScrollBar();
		getContentPane().add(scrollBar, BorderLayout.EAST);
		
		setTitle("Prüfungs-System");
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		pack();
		
	}

}