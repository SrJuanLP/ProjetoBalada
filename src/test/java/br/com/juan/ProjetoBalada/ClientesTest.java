package br.com.juan.ProjetoBalada;
import br.com.juan.Controller.Clientes;
import br.com.juan.Dao.ClientesDAO;
import junit.framework.TestCase;

public class ClientesTest extends TestCase {
	
	private String nome;
	private int rg;
	private int idade;
	private int cpf;
	private String sexo;
	
	public void ClientesDAOTest(){
		
	}
	
	public void CadastrarClienteTest(){
		Clientes clientes = new Clientes();
		nome = "Test";
		rg = 123;
		idade = 10;
		cpf = 98;
		sexo = "masculino";
		clientes.setNome(nome);
		clientes.setRg(rg);
		clientes.setIdade(idade);
		clientes.setCpf(cpf);
		clientes.setSexo(sexo);
		ClientesDAO clientesDAO = new ClientesDAO();
		
		try {
			
			clientesDAO.inserir(clientes);
		} catch (Exception e) {
			System.err.print(e);
		}
	}

}
