package br.com.sisvenda.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

public class ConsultarVendaForm extends JFrame {

	private JPanel contentPane;
	private JTextField jtfDataInicio;
	private JTable table;
	private JTextField jtfDataFim;
	private JLabel lblDataInicio;
	private JLabel lblDataFim;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarVendaForm frame = new ConsultarVendaForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ConsultarVendaForm() {
		setTitle("Consultar Vendas");
		setBounds(100, 100, 520, 470);
		contentPane = new JPanel();
		setLocationRelativeTo(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 485, 409);
		contentPane.add(panel);
		panel.setLayout(null);
		
		jtfDataInicio = new JTextField();
		jtfDataInicio.setBounds(10, 29, 115, 20);
		panel.add(jtfDataInicio);
		jtfDataInicio.setColumns(10);
		
		JButton btnPersquisar = new JButton("Persquisar");
		btnPersquisar.setBounds(278, 27, 107, 23);
		panel.add(btnPersquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 60, 466, 338);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setColumnHeaderView(table);
		
		jtfDataFim = new JTextField();
		jtfDataFim.setColumns(10);
		jtfDataFim.setBounds(141, 29, 115, 20);
		panel.add(jtfDataFim);
		
		lblDataInicio = new JLabel("Data Inicio:");
		lblDataInicio.setBounds(10, 11, 80, 14);
		panel.add(lblDataInicio);
		
		lblDataFim = new JLabel("Data Fim:");
		lblDataFim.setBounds(141, 11, 80, 14);
		panel.add(lblDataFim);
	}
}
