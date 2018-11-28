package Views;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import Models.Pruefung;


public class Pruefungsverwaltung {

	private JFrame frame = new JFrame();
	private JPanel panel = new JPanel();
	private JList liste;
	private final JScrollPane scrollPane = new JScrollPane();
	private JTable table;
	private DefaultTableModel tableModel;

	public Pruefungsverwaltung() {
		createComponents();
	}

	public void createComponents() {

		frame.setTitle("Prüfungsverwaltung");
		frame.setSize(400, 200);

		panel.setLayout(new BorderLayout(0, 0));

		frame.getContentPane().add(panel);
		scrollPane.setBackground(SystemColor.inactiveCaption);

		panel.add(scrollPane, BorderLayout.CENTER);


		// tableModel.setColumnIdentifiers(new Object[]{"Nummer",
		// "Prüfungstitel", "Dauer"});
		// for( int r = 0; r < pl_model.getPruefungsliste().size(); r++ ){
		// Object[] row = new Object[ tableModel.getColumnCount() ];
		//
		// for( int c = 0; c < row.length; c++ ){
		// row[c] = pl_model.getPruefungsliste().get(r).getPruefungsnummer();
		// }
		//
		// tableModel.addRow( row );
		// }

		table = new JTable(tableModel);
		table.setFont(new Font("Tahoma", Font.BOLD, 11));
		table.setBackground(SystemColor.inactiveCaption);
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		table.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent evt) {
//				JTable table = (JTable) evt.getSource();
//				if (evt.getClickCount() == 2) {
//					int selectedRow = table.getSelectedRow();
//					PruefungsDetails a_view = new PruefungsDetails(
//							pruefung.getPruefungsliste().get(selectedRow));
//				}
//			}
//		});

		scrollPane.setViewportView(table);
		frame.setVisible(true);
		frame.pack();

	}


}
