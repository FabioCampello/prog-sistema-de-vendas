package br.com.sisvenda.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import br.com.sisvenda.controller.ConexaoMySQL;
import br.com.sisvenda.controller.FornecedorController;

public class FornecedoresForm extends JFrame {

	// ************************************************************************************************************
	// DECLARAÇÃO DE VARIÁVEIS
	// ************************************************************************************************************
	private JPanel contentPane;
	private JTextField jtfPesquisar;
	private JTextField jtfNome;
	private JTextField jtfEndereco;
	private JTextField jtfBairro;
	private JTextField jtfCidade;
	private JTextField jtfTelefone;
	private JTextField jtfCEP;
	private JLabel lblUf;
	private JButton btnNovo;
	private JButton btnAlterar;
	private JButton btnExcluir;
	private JButton btnFechar;
	private JTable table;
	DefaultTableModel modelo = new DefaultTableModel();
	private static JComboBox jcbNomeForncedor;
	private static JComboBox jcbUf;
	private static JTextField jtfNumero;
	private static String cmdcb;
	private static ResultSet rs;

	// ************************************************************************************************************
	// MÉTODO PRINCIPAL
	// ************************************************************************************************************
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FornecedoresForm frame = new FornecedoresForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// ************************************************************************************************************
	// CONSTRUTOR DA CLASSE
	// ************************************************************************************************************
	public FornecedoresForm() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setTitle("Fornecedores");
		setBounds(100, 100, 950, 500);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// **************************************************************
		// PAINEL PRINCIPAL DA TELA
		// **************************************************************
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBounds(10, 11, 914, 439);
		contentPane.add(panel);
		panel.setLayout(null);

		// **************************************************************
		// CAMPO PESQUISAR
		// **************************************************************
		jtfPesquisar = new JTextField();
		jtfPesquisar.setBounds(10, 11, 349, 20);
		panel.add(jtfPesquisar);
		jtfPesquisar.setColumns(10);

		// **************************************************************
		// BOTÃO PESQUISAR
		// **************************************************************
		JButton btnPersquisar = new JButton("Pesquisar");
		btnPersquisar.setBounds(369, 10, 107, 23);
		panel.add(btnPersquisar);

		// **************************************************************
		// COMBOBOX NOME DO FORNECEDOR
		// **************************************************************
		jcbNomeForncedor = new JComboBox();
		jcbNomeForncedor.setModel(new DefaultComboBoxModel(new String[] { "Selecione um fornecedor" }));
		jcbNomeForncedor.setBounds(486, 11, 418, 20);
		panel.add(jcbNomeForncedor);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setBounds(10, 42, 894, 155);
		panel.add(scrollPane);

		// **************************************************************
		// TABELA DE EXIBIÇÃO DE FORNECEDOR
		// **************************************************************
		table = new JTable(new DefaultTableModel(new Object[][] { { null, null, null }, },
				new String[] { "nome", "endereco", "numero", "bairro", "cidade", "uf", "cep", "telefone" }));
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "C\u00F3digo", "Nome", "Endereco",
				"N\u00FAmero", "Bairro", "Cidade", "UF", "CEP", "Telefone" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, true, true, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(4).setPreferredWidth(130);
		table.getColumnModel().getColumn(8).setPreferredWidth(80);
		scrollPane.setViewportView(table);

		// **************************************************************
		// CAMPO DE TEXTO NOME
		// **************************************************************
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(122, 208, 60, 15);
		panel.add(lblNome);

		jtfNome = new JTextField();
		jtfNome.setBounds(122, 228, 644, 20);
		panel.add(jtfNome);
		jtfNome.setColumns(10);

		// **************************************************************
		// CAMPO DE TEXTO ENDEREÇO
		// **************************************************************
		JLabel lblEndereo = new JLabel("Endere\u00E7o:");
		lblEndereo.setBounds(122, 259, 60, 15);
		panel.add(lblEndereo);

		jtfEndereco = new JTextField();
		jtfEndereco.setBounds(122, 279, 378, 20);
		panel.add(jtfEndereco);
		jtfEndereco.setColumns(10);

		// **************************************************************
		// CAMPO DE TEXTO NÚMERO
		// **************************************************************
		JLabel lblNmero = new JLabel("N\u00FAmero:");
		lblNmero.setBounds(510, 259, 70, 14);
		panel.add(lblNmero);

		jtfNumero = new JTextField();
		jtfNumero.setBounds(510, 279, 86, 20);
		panel.add(jtfNumero);
		jtfNumero.setColumns(10);

		// **************************************************************
		// CAMPO DE TEXTO BAIRRO
		// **************************************************************
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(606, 259, 60, 15);
		panel.add(lblBairro);

		jtfBairro = new JTextField();
		jtfBairro.setBounds(606, 279, 160, 20);
		panel.add(jtfBairro);
		jtfBairro.setColumns(10);

		// **************************************************************
		// CAMPO DE TEXTO CIDADE
		// **************************************************************
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(122, 307, 60, 15);
		panel.add(lblCidade);

		jtfCidade = new JTextField();
		jtfCidade.setColumns(10);
		jtfCidade.setBounds(122, 327, 283, 20);
		panel.add(jtfCidade);

		// **************************************************************
		// CAMPO DE TEXTO TELEFONE
		// **************************************************************
		JLabel lblTelefone = new JLabel("Telefone:");
		lblTelefone.setBounds(606, 307, 60, 15);
		panel.add(lblTelefone);

		jtfTelefone = new JTextField();
		jtfTelefone.setColumns(10);
		jtfTelefone.setBounds(606, 327, 160, 20);
		panel.add(jtfTelefone);

		// **************************************************************
		// CAMPO DE TEXTO CEP
		// **************************************************************
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setBounds(488, 307, 60, 15);
		panel.add(lblCep);

		jtfCEP = new JTextField();
		jtfCEP.setColumns(10);
		jtfCEP.setBounds(488, 327, 100, 20);
		panel.add(jtfCEP);

		// **************************************************************
		// COMBOBOX UF
		// **************************************************************
		lblUf = new JLabel("UF:");
		lblUf.setBounds(426, 307, 45, 15);
		panel.add(lblUf);

		jcbUf = new JComboBox();
		jcbUf.setModel(new DefaultComboBoxModel(new String[] { "", "AC", "AL", "AP", "AM", "BA", "CE\t ", "DF\t ",
				"ES\t ", "GO\t ", "MA\t ", "MT\t ", "MS\t ", "MG\t ", "PA\t ", "PB\t ", "PR\t ", "PE\t ", "PI\t ",
				"RJ\t ", "RN\t ", "RS\t ", "RO\t ", "RR\t ", "SC\t ", "SP\t ", "SE\t ", "TO" }));
		jcbUf.setBounds(426, 327, 45, 20);
		panel.add(jcbUf);

		// ************************************************************************************************************
		// MÉTODO QUE INSERIRE UM NOVO FORNECEDOR
		// ************************************************************************************************************
		btnNovo = new JButton("Novo");
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				FornecedorController fc = new FornecedorController();

				try {
					if (jtfNome.getText().isEmpty() || jtfEndereco.getText().isEmpty() || jtfNumero.getText().isEmpty()
							|| jtfBairro.getText().isEmpty() || jtfCidade.getText().isEmpty()
							|| jtfCidade.getText().isEmpty() || jcbUf.getSelectedItem() == ""
							|| jtfCEP.getText().isEmpty() || jtfTelefone.getText().isEmpty()) {

						JOptionPane.showMessageDialog(rootPane, "Informe todos os dados do fornecedor!",
								"ERRO DE UTILIZAÇÂO", JOptionPane.ERROR_MESSAGE);

					} else {

						String nome = jtfNome.getText();
						String endereco = jtfEndereco.getText();
						String numero = jtfNumero.getText();
						String bairro = jtfBairro.getText();
						String cidade = jtfCidade.getText();
						String uf = (String) jcbUf.getSelectedItem();
						String cep = jtfCEP.getText();
						String telefone = jtfTelefone.getText();

						fc.inserirFornecedor(nome, endereco, numero, bairro, cidade, uf, cep, telefone);

						JOptionPane.showMessageDialog(rootPane, "Fornecedor salvo com sucesso!", "DADOS GRAVADOS",
								JOptionPane.INFORMATION_MESSAGE);

						jtfNome.setText("");
						jtfEndereco.setText("");
						jtfNumero.setText("");
						jtfBairro.setText("");
						jtfCidade.setText("");
						jcbUf.setToolTipText(null);
						jtfCEP.setText("");
						jtfTelefone.setText("");

						new FornecedoresForm().setVisible(true);
						dispose();
					}
				} catch (Exception e1) {
					System.out.println(e1);
				}

			}
		});
		btnNovo.setBounds(240, 385, 89, 43);
		panel.add(btnNovo);

		// ******************************************************************************************************************************
		// EVENTO DO BOTÃO ALTERAR
		// ******************************************************************************************************************************
		btnAlterar = new JButton("Alterar");
		btnAlterar.setBounds(349, 385, 89, 43);
		panel.add(btnAlterar);

		// ******************************************************************************************************************************
		// EVENTO DO BOTÃO EXCLUIR
		// ******************************************************************************************************************************
		btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				FornecedorController fc = new FornecedorController();

				try {

					if (jcbNomeForncedor.getSelectedItem() == "") {

						JOptionPane.showMessageDialog(rootPane, "Selecione um nome de fornecedor!", "ERRO DE UTILIZAÇÂO",
								JOptionPane.ERROR_MESSAGE);

					} else {

						fc.excluirFornecedor((String) jcbNomeForncedor.getSelectedItem());

						new FornecedoresForm().setVisible(true);
						dispose();

						JOptionPane.showMessageDialog(rootPane, "Fornecedor excluido com sucesso!", "DADOS EXCLUIDOS",
								JOptionPane.INFORMATION_MESSAGE);

					}

				} catch (Exception e) {
					JOptionPane.showMessageDialog(rootPane, e, "ERRO DE UTILIZAÇÂO", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btnExcluir.setBounds(463, 385, 89, 43);
		panel.add(btnExcluir);

		// ******************************************************************************************************************************
		// EVENTO DO BOTÃO FECHAR
		// ******************************************************************************************************************************
		btnFechar = new JButton("Fechar");
		btnFechar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnFechar.setBounds(577, 385, 89, 43);
		panel.add(btnFechar);

		loadTable();
		loadCombo();

	}

	// ******************************************************************************************************************************
	// MÉTODO DE COSNSTRUÇÃO DA TABELA COM OS RESULTADOS DO BANCO
	// ******************************************************************************************************************************
	private void loadTable() {

		try {
			Connection con1 = ConexaoMySQL.getInstance().getConnection();
			String cmd = "select * from fornecedores";
			ResultSet rs = con1.createStatement().executeQuery(cmd);

			while (rs.next()) {
				int idFornecedoresDB = rs.getInt("idFornecedores");
				String nomeFornecedoresDB = rs.getString("nome");
				String enderecoDB = rs.getString("endereco");
				int numeroDB = rs.getInt("numero");
				String bairroDB = rs.getString("bairro");
				String cidadeDB = rs.getString("cidade");
				String ufDB = rs.getString("uf");
				String cepDB = rs.getString("cep");
				String telefoneDB = rs.getString("telefone");

				Vector v = new Vector();
				v.addElement(idFornecedoresDB);
				v.addElement(nomeFornecedoresDB);
				v.addElement(enderecoDB);
				v.addElement(numeroDB);
				v.addElement(bairroDB);
				v.addElement(cidadeDB);
				v.addElement(ufDB);
				v.addElement(cepDB);
				v.addElement(telefoneDB);

				((DefaultTableModel) table.getModel()).addRow(v);
			}

		} catch (SQLException e) {

			String msg = "Erro! Tipo " + e.getMessage();
			System.out.println(msg);
		}

	}

	// ******************************************************************************************************************************
	// MÉTODO QUE INSERE OS NOMES DOS CURSOS NO JCOMBOBOX NOME CURSO
	// ******************************************************************************************************************************
	static private void loadCombo() {

		try {

			Connection con = ConexaoMySQL.getInstance().getConnection();
			cmdcb = "select nome from fornecedores";

			rs = con.createStatement().executeQuery(cmdcb);

			// AQUI É PARA EXEIBIR ALGUMA MENSAGEM DE ERRO PARA O DESENVOLVEDOR,
			// SE HOUVER
			System.out.println(cmdcb);
			System.out.println(rs);

			while (rs.next()) {

				String nomeDB = rs.getString("nome");

				// ESTÁ OPÇÃO - MOSTRA NO COMBOBOX CURSO SOMENTE O NOME DO CURSO
				((DefaultComboBoxModel) jcbNomeForncedor.getModel()).addElement(nomeDB);

			}

		} catch (SQLException e) {
			String msg = "Erro! Tpipo " + e.getMessage();
			JOptionPane.showMessageDialog(null, msg, "ERRO DE UTILIZAÇÂO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
