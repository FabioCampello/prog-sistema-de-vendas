package br.com.sisvenda.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.JProgressBar;
import java.awt.Canvas;

public class PrincipalForm extends JFrame {

	private JPanel contentPane;
	ClientesForm clientes;
	ProdutosForm produtos;
	FornecedoresForm fornecedores;
	RegistrarVendaForm regVendas;
	ConsultarVendaForm conVendas;

	// ************************************************************************************************************
	// MÉTODO PRINCIPAL
	// ************************************************************************************************************
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalForm frame = new PrincipalForm();
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
	public PrincipalForm() {
		setTitle("Sistem de Vendas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		// ************************************************************************************************************
		// BARRA DE MENU
		// ************************************************************************************************************
		JMenuBar menuBarra = new JMenuBar();
		setJMenuBar(menuBarra);

		// **************************************************************
		// ITEM OPÇÕES DO MENU
		// **************************************************************
		JMenu menuOpcoes = new JMenu("Op\u00E7\u00F5es");
		menuBarra.add(menuOpcoes);

		// **************************************************************
		// EVENTO DO MENU SOBRE
		// **************************************************************
		JMenuItem menuSobre = new JMenuItem("Sobre o Sistema");
		menuSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String sobre = "Sistema de Vendas - ver. 0.0.3 \n Desenvolvido por: Fábio Campêllo \n Email: fabiocampello@outlook.com.br";
				JOptionPane.showMessageDialog(rootPane, sobre, "AJYA Informática LTDA",
						JOptionPane.INFORMATION_MESSAGE);
			}
		});
		menuOpcoes.add(menuSobre);

		//SEPARADORES DOS ITENS DO MENU
		JSeparator separator = new JSeparator();
		menuOpcoes.add(separator);

		// **************************************************************
		// EVENTO DO MENU SAIR
		// **************************************************************
		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				dispose();

			}
		});
		menuOpcoes.add(menuSair);

		JMenu menuCadastros = new JMenu("Cadastros");
		menuBarra.add(menuCadastros);

		// **************************************************************
		// EVENTO DO MENU CLIENTE
		// **************************************************************
		JMenuItem menuClientes = new JMenuItem("Clientes");
		menuClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarClientes();
			}
		});
		menuCadastros.add(menuClientes);

		JSeparator separator_1 = new JSeparator();
		menuCadastros.add(separator_1);

		// **************************************************************
		// EVENTO DO MENU PRODUTOS
		// **************************************************************
		JMenuItem menuProdutos = new JMenuItem("Produtos");
		menuProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarProdutos();
			}
		});
		menuCadastros.add(menuProdutos);

		JSeparator separator_2 = new JSeparator();
		menuCadastros.add(separator_2);

		// **************************************************************
		// EVENTO DO MENU FORNECEDORES
		// **************************************************************
		JMenuItem menuFornecedores = new JMenuItem("Fornecedores");
		menuFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarFornecedores();
			}
		});
		menuCadastros.add(menuFornecedores);

		JMenu menuVendas = new JMenu("Vendas");
		menuBarra.add(menuVendas);

		// **************************************************************
		// EVENTO DO MENU REGISTRAR VENDAS
		// **************************************************************
		JMenuItem menuRegistrarConsultarVenda = new JMenuItem("Registrar");
		menuRegistrarConsultarVenda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarVendas();
			}
		});
		menuVendas.add(menuRegistrarConsultarVenda);

		JSeparator separator_3 = new JSeparator();
		menuVendas.add(separator_3);

		// **************************************************************
		// EVENTO DO MENU CONSULTAR VENDAS
		// **************************************************************
		JMenuItem mntmNewMenuItem = new JMenuItem("Consultar");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarVendas();
			}
		});
		menuVendas.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// **************************************************************
		// EVENTO DO BOTÃO CLIENTES
		// **************************************************************
		JButton btnClientes = new JButton("Clientes");
		btnClientes.setBounds(10, 50, 190, 80);
		contentPane.add(btnClientes);
		btnClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarClientes();
			}
		});
		btnClientes.setHorizontalAlignment(SwingConstants.LEFT);
		btnClientes.setIcon(new ImageIcon("F:\\Projetos\\Projetos Java\\Projetos Eclipse\\Workspace\\SistemDeVendas - ver. 0.0.3\\imagens\\clientes.gif"));

		// **************************************************************
		// EVENTO DO BOTÃO FORNECEDORES
		// **************************************************************
		JButton btnFornecedores = new JButton("Fornecedores");
		btnFornecedores.setBounds(10, 140, 190, 80);
		contentPane.add(btnFornecedores);
		btnFornecedores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarFornecedores();
			}
		});
		btnFornecedores.setHorizontalAlignment(SwingConstants.LEFT);
		btnFornecedores.setIcon(new ImageIcon("F:\\Projetos\\Projetos Java\\Projetos Eclipse\\Workspace\\SistemDeVendas - ver. 0.0.3\\imagens\\fornecedores.gif"));

		// **************************************************************
		// EVENTO DO BOTÃO PRODUTOS
		// **************************************************************
		JButton btnProdutos = new JButton("Produtos");
		btnProdutos.setBounds(10, 230, 190, 80);
		contentPane.add(btnProdutos);
		btnProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarProdutos();
			}
		});
		btnProdutos.setHorizontalAlignment(SwingConstants.LEFT);
		btnProdutos.setIcon(new ImageIcon("F:\\Projetos\\Projetos Java\\Projetos Eclipse\\Workspace\\SistemDeVendas - ver. 0.0.3\\imagens\\produtos.gif"));

		// **************************************************************
		// EVENTO DO BOTÃO REGISTRAR VENDAS
		// **************************************************************
		JButton btnVendas = new JButton("Registrar Vendas");
		btnVendas.setBounds(10, 320, 190, 80);
		contentPane.add(btnVendas);
		btnVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				registrarVendas();
			}
		});
		btnVendas.setHorizontalAlignment(SwingConstants.LEFT);
		btnVendas.setIcon(new ImageIcon("F:\\Projetos\\Projetos Java\\Projetos Eclipse\\Workspace\\SistemDeVendas - ver. 0.0.3\\imagens\\vendas.gif"));

		// **************************************************************
		// EVENTO DO BOTÃO CONSULTAR VENDAS
		// **************************************************************
		JButton btnConsultarVendas = new JButton("Consultar Vendas");
		btnConsultarVendas.setBounds(10, 410, 190, 80);
		contentPane.add(btnConsultarVendas);
		btnConsultarVendas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarVendas();
			}
		});
		btnConsultarVendas.setIcon(new ImageIcon("F:\\Projetos\\Projetos Java\\Projetos Eclipse\\Workspace\\SistemDeVendas - ver. 0.0.3\\imagens\\vendas.gif"));
		btnConsultarVendas.setHorizontalAlignment(SwingConstants.LEFT);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(248, 50, 1, 1);
		contentPane.add(layeredPane);
	}

	// **************************************************************
	// MÉTODO MOSTRAR CLIENTES
	// **************************************************************
	private void mostrarClientes() {

		if (clientes == null) {
			clientes = new ClientesForm();
			clientes.setVisible(true);
		} else {
			clientes.setVisible(true);
			clientes.setState(JFrame.NORMAL);
		}
	}

	// **************************************************************
	// MÉTODO MOSTRAR PRODUTOS
	// **************************************************************
	private void mostrarProdutos() {

		if (produtos == null) {
			produtos = new ProdutosForm();
			produtos.setVisible(true);
		} else {
			produtos.setVisible(true);
			produtos.setState(JFrame.NORMAL);
		}
	}

	// **************************************************************
	// MÉTODO MOSTRAR FORNECEDORES
	// **************************************************************
	private void mostrarFornecedores() {

		if (fornecedores == null) {
			fornecedores = new FornecedoresForm();
			fornecedores.setVisible(true);
		} else {
			fornecedores.setVisible(true);
			fornecedores.setState(JFrame.NORMAL);
		}
	}

	// **************************************************************
	// MÉTODO MOSTRAR VENDAS
	// **************************************************************
	private void registrarVendas() {

		if (regVendas == null) {
			regVendas = new RegistrarVendaForm();
			regVendas.setVisible(true);
		} else {
			regVendas.setVisible(true);
			regVendas.setState(JFrame.NORMAL);
		}
	}

	// **************************************************************
	// MÉTODO MOSTRAR VENDAS
	// **************************************************************
	private void consultarVendas() {

		if (conVendas == null) {
			conVendas = new ConsultarVendaForm();
			conVendas.setVisible(true);
		} else {
			conVendas.setVisible(true);
			conVendas.setState(JFrame.NORMAL);
		}
	}
}
