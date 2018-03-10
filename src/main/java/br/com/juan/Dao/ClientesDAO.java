package br.com.juan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Statement;

import br.com.juan.Controller.Clientes;
import br.com.juan.Controller.Produtos;

public class ClientesDAO implements DaoGenerico<Clientes> {

	public ResultSet rs = null;

	private Connection connection = null;

	public ClientesDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Clientes obj) {
		String sql = "INSERT INTO clientes(nomeCliente, rg, idade, sexo, cpf) VALUES (?,?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setInt(2, obj.getRg());
			stmt.setInt(3, obj.getIdade());
			stmt.setString(4, obj.getSexo());
			stmt.setInt(5, obj.getCpf());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar produtos na base:" + e);
		}finally{
			
		}
	}

	@Override
	public void deletar(Clientes obj) {
		String querySQL = "DELETE FROM clientes WHERE nomeCliente = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(querySQL);
			stmt.setString(1, obj.getNome());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	@Override
	public void alterar(Clientes obj) {
		String sql = "UPDATE clientes SET nomeCliente = ?, idade = ?, sexo= ?, cpf = ? WHERE rg = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, obj.getNome());
			stmt.setInt(5, obj.getRg());
			stmt.setInt(2, obj.getIdade());
			stmt.setString(3, obj.getSexo());
			stmt.setInt(4, obj.getCpf());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e);
		}finally{
			ConnectionFactory.closeConnection();
		}
	}
	
	@Override
	public Clientes buscarPorId(String rg) {
		Clientes cliente = new Clientes();
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from clientes where rg = ?");
			stmt.setString(1, rg);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				cliente.setNome(rs.getString(1));
				cliente.setIdade(rs.getInt(3));
				cliente.setSexo(rs.getString(4));
				cliente.setCpf(rs.getInt(5));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection();
		}
		return cliente;
	}

	@Override
	public List<Clientes> buscarTodos() {
		List<Clientes> clientes = new ArrayList<Clientes>();
		try {
			Statement stmt = (Statement) connection.createStatement();
			rs = stmt.executeQuery("SELECT * FROM clientes");
			while (rs.next()) {
				String nomeCliente = rs.getString("nomeCliente");
				int rg = rs.getInt("rg");
				int idade = rs.getInt("idade");
				String sexo = rs.getString("sexo");
				int cpf = rs.getInt("cpf");
				clientes.add(new Clientes(nomeCliente, rg, idade, cpf, sexo));
			}
		} catch (Exception e) {
			System.err.println("Erro ao buscar clientes no banco de dados " + e);
		}finally{
			ConnectionFactory.closeConnection();
		}
		return clientes;
	}

	@Override
	public boolean checkLogin(String Login, String Senha) {
		return false;
	}

}