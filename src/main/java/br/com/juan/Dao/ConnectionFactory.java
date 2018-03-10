package br.com.juan.Dao;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class ConnectionFactory {
	
	final static String url = "jdbc:mysql://localhost:3306/balada_bd";
	final static String user = "root";
	final static String password = "";
	
	public static Connection getConnection(){
		try {
			System.out.println("Conected");
			return (Connection) DriverManager.getConnection(url, user, password);
			
		} catch (SQLException e) {
			throw new IllegalAccessError("Nao foi possivel efetuar a conexao");
		}
	}
	
	public static void closeConnection(){
		closeConnection();
	}

}
