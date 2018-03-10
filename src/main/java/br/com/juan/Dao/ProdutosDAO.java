package br.com.juan.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import br.com.juan.Controller.Clientes;
import br.com.juan.Controller.Produtos;

public class ProdutosDAO implements DaoGenerico<Produtos> {

	private Connection connection = null;

	public ProdutosDAO() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void inserir(Produtos obj) {
		String sql = "INSERT INTO produtos(nome, marca, preço, fornecedor) VALUES (?,?,?,?)";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, obj.getNomeProduto());
			stmt.setString(2, obj.getMarcaProduto());
			stmt.setDouble(3, obj.getPrecoProduto());
			stmt.setString(4, obj.getFornecedor());
			stmt.executeUpdate();
		} catch (SQLException e) {
			System.err.println("Erro ao cadastrar produtos na base:" + e);
		}finally{
			ConnectionFactory.closeConnection();
		}
	}

	@Override
	public void deletar(Produtos obj) {
		String querySQL = "delete from produtos where nome = ? ";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(querySQL);
			stmt.setString(1, obj.getNomeProduto());
			stmt.execute();
		} catch (Exception e) {
			System.err.println("Falha ao deletar arquivos do banco de dados : "+e);
		}finally{
			ConnectionFactory.closeConnection();
		}
	}

	@Override
	public void alterar(Produtos obj) {
		String sql = "UPDATE produtos SET nome=?, marca=?, preço=?, fornecedor = ? WHERE nome = ?";
		PreparedStatement stmt = null;
		try {
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, obj.getNomeProduto());
			stmt.setString(2, obj.getMarcaProduto());
			stmt.setDouble(3, obj.getPrecoProduto());
			stmt.setString(4, obj.getFornecedor());
			stmt.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		}finally{
			ConnectionFactory.closeConnection();
		}
	}

	@Override
	public List<Produtos> buscarTodos() {
		
		List<Produtos>produtos = new ArrayList<Produtos>();
		
		try {
			Statement stmt = connection.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM clientes");
			while(rs.next()) {
				String nome = rs.getString("nome");
				String marca = rs.getString("marca");
				double preco = rs.getDouble("preço");
				String fornecedor = rs.getString("fornecedor");
				produtos.add(new Produtos(nome,marca,preco,fornecedor));
			}
		} catch (Exception e) {
			System.err.println("Erro ao buscar produtos no banco de dados"+e);
		}finally{
			ConnectionFactory.closeConnection();
		}
		return produtos;
	}

	@Override
	public boolean checkLogin(String Login, String Senha) {
		return false;
	}

	@Override
	public Produtos buscarPorId(String nome) {
		Produtos produto = new Produtos();
		
		try {
			PreparedStatement stmt = connection.prepareStatement("select * from produtos where nome =?");
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			
			while (rs.next()) {
				produto.setMarcaProduto(rs.getString(2));
				produto.setPrecoProduto(rs.getDouble(3));
				produto.setFornecedor(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			ConnectionFactory.closeConnection();
		}
		return produto;
	}

	}
