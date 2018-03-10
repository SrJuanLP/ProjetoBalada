package br.com.juan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.juan.Controller.Clientes;
import br.com.juan.Controller.Login;
import br.com.juan.Controller.Produtos;

public class LoginDAO implements DaoGenerico <Login> {

	private Connection connection;
	
	public LoginDAO(){
		new ConnectionFactory();
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public boolean checkLogin(String login, String senha) {
		ResultSet rs = null;
		PreparedStatement stmt = null;
		boolean check = false;
		
		try {
			stmt = connection.prepareStatement("SELECT * FROM login WHERE usuario=? AND senha=?");
			stmt.setString(1, login);
			stmt.setString(2, senha);
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				JOptionPane.showMessageDialog(null, "Conectado");
				check = true;
			}
		} catch (SQLException e) {
			throw new IllegalAccessError("Erro ao encontrar dados na tabela");
		}finally{
			
		}
		return check;
	}

	@Override
	public void inserir(Login obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletar(Login obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void alterar(Login obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Login> buscarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Login buscarPorId(String rg) {
		// TODO Auto-generated method stub
		return null;
	}

}
