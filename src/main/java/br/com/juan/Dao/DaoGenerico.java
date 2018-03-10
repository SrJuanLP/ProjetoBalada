package br.com.juan.Dao;

import java.util.List;

import br.com.juan.Controller.Clientes;
import br.com.juan.Controller.Produtos;

public interface DaoGenerico<T> {
	
	public void inserir(T obj);
	
	public void deletar(T obj);
	
	public void alterar(T obj);
	
	List<T> buscarTodos();
	
	T buscarPorId(String rg);

	boolean checkLogin(String Login, String Senha);
}
