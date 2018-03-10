package br.com.juan.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.juan.Controller.Produtos;
import br.com.juan.Dao.ProdutosDAO;

public class TelaCadastroProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeProduto;
	private JTextField textMarcaProduto;
	private JTextField textPrecoProduto;
	private JTextField textFornecedor;
	
	/**
	 * @wbp.nonvisual location=181,339
	 */
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroProdutos frame = new TelaCadastroProdutos();
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
	public TelaCadastroProdutos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1365, 32);
		menuBar.setBackground(Color.WHITE);
		contentPane.add(menuBar);

		JMenu menuHome = new JMenu("Home");
		menuHome.setForeground(Color.BLACK);
		menuBar.add(menuHome);

		JMenu menu_6 = new JMenu("Relatórios");
		menu_6.setForeground(Color.BLACK);
		menu_6.setBackground(Color.WHITE);
		menuHome.add(menu_6);

		JMenuItem menuItem_6 = new JMenuItem("Sair");
		menuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menuHome.add(menuItem_6);

		JMenu menuCadastrar = new JMenu("Cadastrar");
		menuCadastrar.setForeground(Color.BLACK);
		menuBar.add(menuCadastrar);

		JMenu menu_4 = new JMenu("Cliente");
		menuCadastrar.add(menu_4);

		JMenuItem menuItem_5 = new JMenuItem("VIP");
		menu_4.add(menuItem_5);
		
		JMenuItem mntmVerificar = new JMenuItem("Verificar");
		mntmVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaClientes myframe = new TelaListaClientes();
				myframe.setVisible(true);
				dispose();
			}
		});
		menuCadastrar.add(mntmVerificar);

		JMenu menuProdutos = new JMenu("Produtos");
		menuProdutos.setForeground(Color.BLACK);
		menuBar.add(menuProdutos);

		JMenuItem menuItem_4 = new JMenuItem("Cadastrar");
		menuProdutos.add(menuItem_4);
		
		JMenuItem menuDeletar = new JMenuItem("Verificar");
		menuDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaProdutos myframe = new TelaListaProdutos();
				myframe.setVisible(true);
				dispose();
			}
		});
		menuProdutos.add(menuDeletar);

		JMenu menuComandas = new JMenu("Comandas");
		menuComandas.setForeground(Color.BLACK);
		menuBar.add(menuComandas);

		JMenuItem menuItem_1 = new JMenuItem("Fluxo de Comandas");
		menuComandas.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("Comandas em Uso");
		menuComandas.add(menuItem_2);

		JMenu menuRelatórios = new JMenu("Relatórios");
		menuRelatórios.setForeground(Color.BLACK);
		menuRelatórios.setBackground(Color.WHITE);
		menuBar.add(menuRelatórios);

		JMenuItem menuItem = new JMenuItem("Gerar Relatórios");
		menuRelatórios.add(menuItem);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(35, 76, 46, 14);
		contentPane.add(lblNome);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(35, 101, 46, 14);
		contentPane.add(lblMarca);

		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(35, 126, 46, 14);
		contentPane.add(lblPreo);

		JLabel lblFornecedor = new JLabel("Fornecedor");
		lblFornecedor.setBounds(35, 151, 67, 14);
		contentPane.add(lblFornecedor);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 196, 99, 23);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				ProdutosDAO dao = new ProdutosDAO();
				Produtos produtos = new Produtos();
				
				double PrecoProduto = Double.parseDouble(textPrecoProduto.getText());

				// Setando os valores inseridos pelo user
				produtos.setNomeProduto(textNomeProduto.getText());
				produtos.setMarcaProduto(textMarcaProduto.getText());
				produtos.setPrecoProduto(PrecoProduto);
				produtos.setFornecedor(textFornecedor.getText());
				dao.inserir(produtos);

				//Condição para verificar os campos e cadastrar o produto
				if ((textNomeProduto.getText().isEmpty()) || (textMarcaProduto.getText().isEmpty())
					||	(textPrecoProduto.getText().isEmpty()) || (textFornecedor.getText().isEmpty())) {
					JOptionPane.showMessageDialog(null, "Preencher todos os campos");
					
				}else{
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
					textNomeProduto.setText("");
					textMarcaProduto.setText("");
					textPrecoProduto.setText("");
					textFornecedor.setText("");
				}
			}
		});
		contentPane.add(btnCadastrar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(119, 196, 99, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//textIdProduto.setText("");
				textNomeProduto.setText("");
				textMarcaProduto.setText("");
				textPrecoProduto.setText("");
				textFornecedor.setText("");
			}
		});
		contentPane.add(btnLimpar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(227, 196, 99, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal telaprincipal = new TelaPrincipal();
				telaprincipal.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVoltar);

		textNomeProduto = new JTextField();
		textNomeProduto.setBounds(120, 73, 115, 20);
		contentPane.add(textNomeProduto);
		textNomeProduto.setColumns(10);

		textMarcaProduto = new JTextField();
		textMarcaProduto.setBounds(120, 98, 115, 20);
		contentPane.add(textMarcaProduto);
		textMarcaProduto.setColumns(10);

		textPrecoProduto = new JTextField();
		textPrecoProduto.setBounds(120, 123, 86, 20);
		contentPane.add(textPrecoProduto);
		textPrecoProduto.setColumns(10);

		textFornecedor = new JTextField();
		textFornecedor.setBounds(120, 148, 86, 20);
		contentPane.add(textFornecedor);
		textFornecedor.setColumns(10);
		
		JLabel lblCadastroDeProdutos = new JLabel("Cadastro de Produtos");
		lblCadastroDeProdutos.setFont(new Font("Arial", Font.BOLD, 14));
		lblCadastroDeProdutos.setBounds(96, 43, 176, 14);
		contentPane.add(lblCadastroDeProdutos);
		
		
	}
}
