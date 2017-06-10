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
import javax.swing.SwingConstants;

public class ProdutosForm extends JFrame {

	private JPanel contentPane;
	private JTextField jtfPesquisar;
	private JTable table;
	private JTextField jtfNome;
	private JTextField jtfFornecedor;
	private JTextField jtfEstoque;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnFechar;
	private JLabel lblValor;
	private JTextField jtfValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProdutosForm frame = new ProdutosForm();
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
	public ProdutosForm() {
		setTitle("Produtos");
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
		
		jtfPesquisar = new JTextField();
		jtfPesquisar.setBounds(10, 11, 349, 20);
		panel.add(jtfPesquisar);
		jtfPesquisar.setColumns(10);
		
		JButton btnPersquisar = new JButton("Persquisar");
		btnPersquisar.setBounds(369, 10, 107, 23);
		panel.add(btnPersquisar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 42, 466, 156);
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
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 209, 60, 15);
		panel.add(lblNome);
		
		jtfNome = new JTextField();
		jtfNome.setBounds(10, 229, 340, 20);
		panel.add(jtfNome);
		jtfNome.setColumns(10);
		
		JLabel lblFornecedor = new JLabel("Fornecedor:");
		lblFornecedor.setBounds(10, 260, 60, 15);
		panel.add(lblFornecedor);
		
		jtfFornecedor = new JTextField();
		jtfFornecedor.setBounds(10, 280, 340, 20);
		panel.add(jtfFornecedor);
		jtfFornecedor.setColumns(10);
		
		jtfEstoque = new JTextField();
		jtfEstoque.setBounds(361, 280, 115, 20);
		panel.add(jtfEstoque);
		jtfEstoque.setColumns(10);
		
		JLabel lblEstoque = new JLabel("Estoque:");
		lblEstoque.setBounds(361, 260, 60, 15);
		panel.add(lblEstoque);
		
		btnNovo = new JButton("Novo");
		btnNovo.setBounds(32, 355, 89, 43);
		panel.add(btnNovo);
		
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(141, 355, 89, 43);
		panel.add(btnAlterar);
		
		btnExcluir = new JButton("Excluir");
		btnExcluir.setBounds(255, 355, 89, 43);
		panel.add(btnExcluir);
		
		btnFechar = new JButton("Fechar");
		btnFechar.setBounds(369, 355, 89, 43);
		panel.add(btnFechar);
		
		lblValor = new JLabel("Valor:");
		lblValor.setBounds(361, 209, 60, 15);
		panel.add(lblValor);
		
		jtfValor = new JTextField();
		jtfValor.setColumns(10);
		jtfValor.setBounds(361, 229, 115, 20);
		panel.add(jtfValor);
	}
}
