package br.com.juan.Controller;

public class Login {
	
	private String senha ;
	private String login ;
	
	public Login (String login){
		this.login = login;
	}
	
	public Login(String senha, String login) {
		this.senha = senha;
		this.login = login;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;
	}
	
	public String getSenha() {
		return senha;
	}
	
	
}
