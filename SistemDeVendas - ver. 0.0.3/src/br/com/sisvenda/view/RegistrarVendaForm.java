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
import javax.swing.JComboBox;

public class RegistrarVendaForm extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField jtfDesconto;
	private JButton btnFinalizar;
	private JButton btnCancelar;
	private JTextField jtfQuant;
	private JTextField jtfTotal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrarVendaForm frame = new RegistrarVendaForm();
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
	public RegistrarVendaForm() {
		setTitle("Registrar Vendas");
		setBounds(100, 100, 520, 470);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 485, 409);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 131, 466, 156);
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
		
		JLabel lblDesconto = new JLabel("Desconto:");
		lblDesconto.setBounds(300, 298, 60, 15);
		panel.add(lblDesconto);
		
		jtfDesconto = new JTextField();
		jtfDesconto.setColumns(10);
		jtfDesconto.setBounds(359, 295, 115, 20);
		panel.add(jtfDesconto);
		
		btnFinalizar = new JButton("Finalizar");
		btnFinalizar.setBounds(141, 355, 89, 43);
		panel.add(btnFinalizar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(255, 355, 89, 43);
		panel.add(btnCancelar);
		
		JComboBox jcbCliente = new JComboBox();
		jcbCliente.setBounds(10, 32, 466, 20);
		panel.add(jcbCliente);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(10, 11, 80, 14);
		panel.add(lblCliente);
		
		JLabel lblProduto = new JLabel("Produto:");
		lblProduto.setBounds(10, 63, 80, 14);
		panel.add(lblProduto);
		
		JComboBox jcbProduto = new JComboBox();
		jcbProduto.setBounds(10, 84, 300, 20);
		panel.add(jcbProduto);
		
		JLabel lblQuant = new JLabel("Quant.:");
		lblQuant.setBounds(320, 69, 46, 14);
		panel.add(lblQuant);
		
		jtfQuant = new JTextField();
		jtfQuant.setBounds(366, 63, 110, 20);
		panel.add(jtfQuant);
		jtfQuant.setColumns(10);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setBounds(320, 327, 60, 15);
		panel.add(lblTotal);
		
		jtfTotal = new JTextField();
		jtfTotal.setColumns(10);
		jtfTotal.setBounds(360, 324, 115, 20);
		panel.add(jtfTotal);
		
		JButton btnIncluir = new JButton("Incluir");
		btnIncluir.setBounds(387, 97, 89, 23);
		panel.add(btnIncluir);
	}
}
