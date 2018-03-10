package br.com.juan.View;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			private void setExtendedState(int maximizedBoth) {
				// TODO Auto-generated method stub
				
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.setForeground(Color.BLACK);
		menuBar.add(mnHome);
		
		JMenuItem mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		mnHome.add(mntmSobre);
		mnHome.add(mntmSair);
		
		JMenu mnCadastrar_1 = new JMenu("Clientes");
		mnCadastrar_1.setForeground(Color.BLACK);
		menuBar.add(mnCadastrar_1);
		
		JMenuItem mntmCliente = new JMenuItem("Cadastrar");
		mntmCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCliente myframe = new TelaCadastroCliente();
				myframe.setVisible(true);
				dispose();
			}
		});
		mnCadastrar_1.add(mntmCliente);
		
		JMenuItem mntmVerificar = new JMenuItem("Verificar");
		mntmVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaListaClientes myframe = new TelaListaClientes();
				myframe.setVisible(true);
				dispose();
			}
		});
		mnCadastrar_1.add(mntmVerificar);
		
		JMenuItem mntmNormal = new JMenuItem("Normal");
		mntmNormal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		
		JMenu mnProdutos = new JMenu("Produtos");
		mnProdutos.setForeground(Color.BLACK);
		menuBar.add(mnProdutos);
		
		JMenuItem mntmCadastrar = new JMenuItem("Cadastrar");
		mntmCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroProdutos myframe = new TelaCadastroProdutos();
				myframe.setVisible(true);
				dispose();
			}
		});
		mnProdutos.add(mntmCadastrar);
		
		JMenuItem mntmDeletarProdutos = new JMenuItem("Verificar");
		mntmDeletarProdutos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaListaProdutos myframe = new TelaListaProdutos();
				myframe.setVisible(true);
				dispose();
			}
		});
		mnProdutos.add(mntmDeletarProdutos);
		
		JMenu mnComandas = new JMenu("Comandas");
		mnComandas.setForeground(Color.BLACK);
		menuBar.add(mnComandas);
		
		JMenuItem mntmFluxoDeComandas = new JMenuItem("Fluxo de Comandas");
		mnComandas.add(mntmFluxoDeComandas);
		
		JMenuItem mntmComandasEmUso = new JMenuItem("Comandas em Uso");
		mnComandas.add(mntmComandasEmUso);
		
		JMenu mnRelatrios = new JMenu("Relatórios");
		mnRelatrios.setForeground(Color.BLACK);
		mnRelatrios.setBackground(Color.WHITE);
		menuBar.add(mnRelatrios);
		
		JMenuItem mntmGerarRelatrios = new JMenuItem("Gerar Relatórios");
		mnRelatrios.add(mntmGerarRelatrios);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Img/logoDJNC.png"));
		lblNewLabel.setBounds(99, 25, 237, 204);
		contentPane.add(lblNewLabel);
		
		JLabel lblDonJuanNight = new JLabel("Don Juan Night Club");
		lblDonJuanNight.setFont(new Font("Arial", Font.BOLD, 16));
		lblDonJuanNight.setBounds(126, 0, 171, 14);
		contentPane.add(lblDonJuanNight);
	}
}
