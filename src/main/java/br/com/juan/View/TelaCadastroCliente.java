package br.com.juan.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.juan.Controller.Clientes;
import br.com.juan.Dao.ClientesDAO;

import javax.swing.SwingConstants;
import javax.swing.JMenuBar;
import java.awt.Font;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

public class TelaCadastroCliente extends JFrame {

	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textRG;
	private JTextField textIdade;
	private JTextField textCPF;
	private JTextField textSexo;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroCliente frame = new TelaCadastroCliente();
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
	public TelaCadastroCliente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, -15, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(10, 10, 10, 10));
		contentPane.getMaximumSize();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome :");
		lblNome.setBounds(24, 88, 46, 14);
		contentPane.add(lblNome);
		
		JLabel lblRG = new JLabel("RG :");
		lblRG.setBounds(24, 113, 46, 14);
		contentPane.add(lblRG);
		
		JLabel lblIdade = new JLabel("Idade :");
		lblIdade.setBounds(24, 163, 46, 14);
		contentPane.add(lblIdade);
		
		JLabel lblCep = new JLabel("CPF :");
		lblCep.setBounds(24, 138, 46, 14);
		contentPane.add(lblCep);
		
		JLabel lblSexo = new JLabel("Sexo :");
		lblSexo.setBounds(24, 188, 46, 14);
		contentPane.add(lblSexo);
		
		textNome = new JTextField();
		textNome.setBounds(68, 85, 163, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textRG = new JTextField();
		textRG.setBounds(68, 110, 163, 20);
		contentPane.add(textRG);
		textRG.setColumns(10);
		
		textIdade = new JTextField();
		textIdade.setBounds(68, 160, 46, 20);
		contentPane.add(textIdade);
		textIdade.setColumns(10);
		
		textCPF = new JTextField();
		textCPF.setBounds(68, 135, 163, 20);
		contentPane.add(textCPF);
		textCPF.setColumns(10);
		
		JLabel lblCadastroDeClientes = new JLabel("Cadastro de Clientes");
		lblCadastroDeClientes.setFont(new Font("Arial", Font.BOLD, 14));
		lblCadastroDeClientes.setBounds(99, 39, 174, 14);
		contentPane.add(lblCadastroDeClientes);
		
		JButton btnCadastroNormal = new JButton("Cadastrar");
		btnCadastroNormal.setBounds(10, 227, 114, 23);
		btnCadastroNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ClientesDAO dao = new ClientesDAO();
				Clientes clientes = new Clientes();
				
				clientes.setNome(textNome.getText());
				int rg = Integer.parseInt(textRG.getText());
				clientes.setRg(rg);
				int cpf = Integer.parseInt(textCPF.getText());
				clientes.setCpf(cpf);
				int idade = Integer.parseInt(textIdade.getText());
				clientes.setIdade(idade);
				clientes.setSexo(textSexo.getText());
				dao.inserir(clientes);
				JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
			}
		});
		contentPane.add(btnCadastroNormal);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(285, 227, 103, 23);
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaPrincipal myframe = new TelaPrincipal();
				myframe.setVisible(true);
				dispose();
			}
		});
		contentPane.add(btnVoltar);
		
		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.setBounds(152, 227, 114, 23);
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textNome.setText("");
				textRG.setText("");
				textCPF.setText("");
				textIdade.setText("");
			}
		});
		contentPane.add(btnLimpar);
		
		
		
		textSexo = new JTextField();
		textSexo.setBounds(68, 185, 163, 20);
		contentPane.add(textSexo);
		textSexo.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 1366, 21);
		contentPane.add(menuBar);
		
		JMenu menu = new JMenu("Home");
		menu.setForeground(Color.BLACK);
		menuBar.add(menu);
		
		JMenuItem menuItem = new JMenuItem("Sair");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		menu.add(mntmSobre);
		menu.add(menuItem);
		
		JMenu menu_2 = new JMenu("Clientes");
		menu_2.setForeground(Color.BLACK);
		menuBar.add(menu_2);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				return;
			}
		});
		menu_2.add(mntmCadastrar);
		
		JMenuItem mntmVerificar = new JMenuItem("Verificar");
		mntmVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaClientes myframe = new TelaListaClientes();
				myframe.setVisible(true);
				dispose();
				
			}
		});
		menu_2.add(mntmVerificar);
		
		JMenu menu_3 = new JMenu("Produtos");
		menu_3.setForeground(Color.BLACK);
		menuBar.add(menu_3);
		
		JMenuItem menuItem_3 = new JMenuItem("Cadastrar");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaCadastroProdutos myframe = new TelaCadastroProdutos();
				myframe.setVisible(true);
				dispose();
			}
		});
		menu_3.add(menuItem_3);
		
		JMenuItem mntmVerificar_1 = new JMenuItem("Verificar");
		mntmVerificar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaProdutos myframe = new TelaListaProdutos();
				myframe.setVisible(true);
				dispose();
			}
		});
		menu_3.add(mntmVerificar_1);
		
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
		
		
        
	}
}	
		
	


	
		
	

