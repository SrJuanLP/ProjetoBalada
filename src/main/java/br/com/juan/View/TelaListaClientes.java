package br.com.juan.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

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

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

import br.com.juan.Controller.Clientes;
import br.com.juan.Dao.ClientesDAO;

import java.awt.Font;

public class TelaListaClientes extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeCliente;
	private JTextField textRGCliente;
	private JTextField textIdade;
	private JTextField textSexoCliente;
	private JTextField textCPFCliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaListaClientes frame = new TelaListaClientes();
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
	public TelaListaClientes() {
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

		JLabel lblListaClientes = new JLabel("Lista Clientes");
		lblListaClientes.setFont(new Font("Arial", Font.BOLD, 14));
		lblListaClientes.setBounds(155, 32, 119, 14);
		contentPane.add(lblListaClientes);

		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(19, 117, 46, 14);
		contentPane.add(lblNome);

		JLabel lblRg = new JLabel("Pesquise pelo RG");
		lblRg.setBounds(19, 70, 118, 14);
		contentPane.add(lblRg);

		JLabel lblIdade = new JLabel("Idade");
		lblIdade.setBounds(191, 117, 36, 14);
		contentPane.add(lblIdade);

		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(19, 142, 46, 14);
		contentPane.add(lblSexo);

		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(191, 142, 46, 14);
		contentPane.add(lblCpf);

		JButton btnListar = new JButton("Buscar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				BuscarDados();
			}
		});
		btnListar.setBounds(318, 66, 106, 23);
		contentPane.add(btnListar);

		textNomeCliente = new JTextField();
		textNomeCliente.setEnabled(true);
		textNomeCliente.setBounds(75, 114, 106, 20);
		contentPane.add(textNomeCliente);
		textNomeCliente.setColumns(10);

		textRGCliente = new JTextField();
		textRGCliente.setEditable(true);
		textRGCliente.setBounds(135, 67, 173, 20);
		contentPane.add(textRGCliente);
		textRGCliente.setColumns(10);

		textIdade = new JTextField();
		textIdade.setEnabled(true);
		textIdade.setBounds(224, 114, 86, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);

		textSexoCliente = new JTextField();
		textSexoCliente.setEnabled(true);
		textSexoCliente.setBounds(75, 139, 106, 20);
		contentPane.add(textSexoCliente);
		textSexoCliente.setColumns(10);

		textCPFCliente = new JTextField();
		textCPFCliente.setEnabled(true);
		textCPFCliente.setBounds(224, 139, 86, 20);
		contentPane.add(textCPFCliente);
		textCPFCliente.setColumns(10);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal myframe = new TelaPrincipal();
				myframe.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setBounds(318, 113, 106, 23);
		contentPane.add(btnVoltar);

		JButton btnVoltar_1 = new JButton("Limpar");
		btnVoltar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNomeCliente.setText("");
				textRGCliente.setText("");
				textSexoCliente.setText("");
				textCPFCliente.setText("");
				textIdade.setText("");
			}
		});
		btnVoltar_1.setBounds(19, 194, 109, 23);
		contentPane.add(btnVoltar_1);

		JButton btnAlterarCliente = new JButton("Alterar");
		btnAlterarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AlterarCliente();
			}
		});
		btnAlterarCliente.setBounds(155, 194, 119, 23);
		contentPane.add(btnAlterarCliente);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnDeletar.setBounds(294, 194, 106, 23);
		contentPane.add(btnDeletar);
	}

	public void BuscarDados() {

		ClientesDAO clientesDAO = new ClientesDAO();
		final Clientes cliente = clientesDAO.buscarPorId(textRGCliente.getText());

		textNomeCliente.setText(cliente.getNome());
		String idade = Integer.toString(cliente.getIdade());
		textIdade.setText(idade);
		textSexoCliente.setText(cliente.getSexo());
		String CPF = Integer.toString(cliente.getCpf());
		textCPFCliente.setText(CPF);

		if(textNomeCliente.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Dados não encontrado!");
		}else{
			JOptionPane.showMessageDialog(null, "Dados Encontrado!");
		}
	}

	public void AlterarCliente(){
		ClientesDAO clientesDAO = new ClientesDAO();
		Clientes clientes = new Clientes();

		int rgCliente = Integer.parseInt(textRGCliente.getText());
		clientes.setRg(rgCliente);
		clientes.setNome(textNomeCliente.getText());	
		clientes.setSexo(textSexoCliente.getText());
		int idadeCliente = Integer.parseInt(textIdade.getText());
		clientes.setIdade(idadeCliente);
		int cpf = Integer.parseInt(textCPFCliente.getText());
		clientes.setCpf(cpf);
			
		clientesDAO.alterar(clientes);
		
		JOptionPane.showMessageDialog(null, "Cliente Alterado com sucesso");
		textRGCliente.setText("");
		textNomeCliente.setText("");
	    textIdade.setText("");
	    textSexoCliente.setText("");
	    textCPFCliente.setText("");
	}
}
