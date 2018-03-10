package br.com.juan.View;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.juan.Dao.ConnectionFactory;
import br.com.juan.Dao.LoginDAO;

import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textNomeLogin;
	private JPasswordField passwordField;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ConnectionFactory conn = new ConnectionFactory();
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					ConnectionFactory.getConnection();
					JOptionPane.showMessageDialog(null, "Conexão efetuada com sucesso");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Falha ao conectar com o banco de dados");
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public TelaLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0)  {
				LoginDAO dao = new LoginDAO();
				
				String senha = new String(passwordField.getPassword());
				
				if (dao.checkLogin(textNomeLogin.getText(), senha)) {
					TelaPrincipal myframe = new TelaPrincipal();
					myframe.setVisible(true);
					dispose();
				}else{
					JOptionPane.showMessageDialog(null, "Credenciais Invalidas, tente novamente");
					textNomeLogin.setText("");
					passwordField.setText("");
				return;
				}
				dispose();
			}
		});
	
		btnEntrar.setBounds(10, 161, 134, 23);
		contentPane.add(btnEntrar);

		textNomeLogin = new JTextField();
		textNomeLogin.setBounds(10, 58, 134, 20);
		contentPane.add(textNomeLogin);
		textNomeLogin.setColumns(10);

		JLabel lblLogin = new JLabel("Usuário");
		lblLogin.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblLogin.setBounds(10, 33, 46, 14);
		contentPane.add(lblLogin);

		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSenha.setBounds(10, 89, 46, 14);
		contentPane.add(lblSenha);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 114, 134, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("Img/logoDJNC.png"));
		lblNewLabel.setBounds(192, 47, 200, 164);
		contentPane.add(lblNewLabel);
		
		JLabel lblDonJuanNight = new JLabel("DonJuan Night Club");
		lblDonJuanNight.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblDonJuanNight.setBounds(211, 22, 157, 14);
		contentPane.add(lblDonJuanNight);
	}
}
