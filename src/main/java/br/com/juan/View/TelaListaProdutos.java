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
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.juan.Controller.Clientes;
import br.com.juan.Controller.Produtos;
import br.com.juan.Dao.ProdutosDAO;

public class TelaListaProdutos extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFieldMarca;
	private JTextField textFieldPreco;
	private JTextField textFieldFornecedor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaProdutos frame = new TelaListaProdutos();
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
	public TelaListaProdutos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 434, 21);
		contentPane.add(menuBar);

		JMenu menu = new JMenu("Home");
		menu.setForeground(Color.BLACK);
		menuBar.add(menu);

		JMenu menu_1 = new JMenu("Relatórios");
		menu_1.setForeground(Color.BLACK);
		menu_1.setBackground(Color.WHITE);
		menu.add(menu_1);

		JMenuItem menuItem = new JMenuItem("Sair");
		menu.add(menuItem);

		JMenu menu_2 = new JMenu("Clientes");
		menu_2.setForeground(Color.BLACK);
		menuBar.add(menu_2);

		JMenuItem menuItem_1 = new JMenuItem("Cliente");
		menu_2.add(menuItem_1);

		JMenuItem menuItem_2 = new JMenuItem("Deletar");
		menu_2.add(menuItem_2);

		JMenu menu_3 = new JMenu("Produtos");
		menu_3.setForeground(Color.BLACK);
		menuBar.add(menu_3);

		JMenuItem menuItem_3 = new JMenuItem("Cadastrar");
		menu_3.add(menuItem_3);

		JMenuItem menuItem_4 = new JMenuItem("Deletar");
		menu_3.add(menuItem_4);

		JMenuItem menuItem_5 = new JMenuItem("Alterar");
		menu_3.add(menuItem_5);

		JMenu menu_4 = new JMenu("Comandas");
		menu_4.setForeground(Color.BLACK);
		menuBar.add(menu_4);

		JMenuItem menuItem_6 = new JMenuItem("Fluxo de Comandas");
		menu_4.add(menuItem_6);

		JMenuItem menuItem_7 = new JMenuItem("Comandas em Uso");
		menu_4.add(menuItem_7);

		JMenu menu_5 = new JMenu("Relatórios");
		menu_5.setForeground(Color.BLACK);
		menu_5.setBackground(Color.WHITE);
		menuBar.add(menu_5);

		JMenuItem menuItem_8 = new JMenuItem("Gerar Relatórios");
		menu_5.add(menuItem_8);

		JLabel lblListarProdutos = new JLabel("Listar Produtos");
		lblListarProdutos.setFont(new Font("Arial", Font.BOLD, 14));
		lblListarProdutos.setBounds(136, 32, 128, 14);
		contentPane.add(lblListarProdutos);

		JLabel lblPesquisePeloNome = new JLabel("Pesquise pelo nome");
		lblPesquisePeloNome.setBounds(23, 59, 94, 14);
		contentPane.add(lblPesquisePeloNome);

		textFieldNome = new JTextField();
		textFieldNome.setBounds(146, 57, 118, 20);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);

		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BuscarTodos();
			}
		});
		btnBuscar.setBounds(292, 55, 89, 23);
		contentPane.add(btnBuscar);

		JLabel lblNome = new JLabel("Marca");
		lblNome.setBounds(23, 103, 59, 14);
		contentPane.add(lblNome);

		textFieldMarca = new JTextField();
		textFieldMarca.setBounds(103, 100, 118, 20);
		contentPane.add(textFieldMarca);
		textFieldMarca.setColumns(10);

		JLabel lblPreo = new JLabel("Preço");
		lblPreo.setBounds(23, 128, 46, 14);
		contentPane.add(lblPreo);

		textFieldPreco = new JTextField();
		textFieldPreco.setBounds(103, 125, 118, 20);
		contentPane.add(textFieldPreco);
		textFieldPreco.setColumns(10);

		JLabel lblNewLabel = new JLabel("Fornecedor");
		lblNewLabel.setBounds(23, 153, 72, 14);
		contentPane.add(lblNewLabel);

		textFieldFornecedor = new JTextField();
		textFieldFornecedor.setBounds(103, 150, 118, 20);
		contentPane.add(textFieldFornecedor);
		textFieldFornecedor.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPrincipal myframe = new TelaPrincipal();
				myframe.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(292, 89, 89, 23);
		contentPane.add(btnVoltar);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldNome.setText("");
				textFieldMarca.setText("");
				textFieldPreco.setText("");
				textFieldFornecedor.setText("");
			}
		});
		btnLimpar.setBounds(23, 199, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnCadastrarNovoProduto = new JButton("Alterar");
		btnCadastrarNovoProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarProduto();
			}
		});
		btnCadastrarNovoProduto.setBounds(136, 199, 105, 23);
		contentPane.add(btnCadastrarNovoProduto);

		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DeletarProdutos();
			}	
		});
		btnDeletar.setBounds(262, 199, 105, 23);
		contentPane.add(btnDeletar);
	}

	public void BuscarTodos() {

		ProdutosDAO produtosDAO = new ProdutosDAO();
		final Produtos produtos = produtosDAO.buscarPorId(textFieldNome.getText());

		textFieldMarca.setText(produtos.getMarcaProduto());
		String preco = Double.toString(produtos.getPrecoProduto());
		textFieldPreco.setText(preco);
		textFieldFornecedor.setText(produtos.getFornecedor());

		if (textFieldNome.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Dados não encontrado");
			return;
		} else {
			JOptionPane.showMessageDialog(null, "Dados encontrado");
		}
	}

	public void AlterarProduto(){
		ProdutosDAO produtosDAO = new ProdutosDAO();
		Produtos produtos = new Produtos();

		produtos.setNomeProduto(textFieldNome.getText());
		produtos.setMarcaProduto(textFieldMarca.getText());
		double preco = Double.parseDouble(textFieldPreco.getText());
		produtos.setPrecoProduto(preco);
		produtos.setFornecedor(textFieldFornecedor.getText());;
		produtosDAO.alterar(produtos);
		JOptionPane.showMessageDialog(null, "Dado alterado");
		textFieldNome.setText("");
		textFieldMarca.setText("");
		textFieldPreco.setText("");
		textFieldFornecedor.setText("");
	}
	
	public void DeletarProdutos(){
		Produtos produtos = new Produtos();
		ProdutosDAO produtosDAO = new ProdutosDAO();

		produtos.setNomeProduto(textFieldNome.getText());


		if ((textFieldNome.getText().isEmpty())) {
			JOptionPane.showMessageDialog(null, "Preencher o campo nome do produto");

		}else{
			produtosDAO.deletar(produtos);
			JOptionPane.showMessageDialog(null, "Produto Deletado com sucesso");
			textFieldNome.setText("");
			textFieldMarca.setText("");
			textFieldPreco.setText("");
			textFieldFornecedor.setText("");
		}
	}
}
