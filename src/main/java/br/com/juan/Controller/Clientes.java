package br.com.juan.Controller;

public class Clientes {
	
	private String nome;
	private int rg;
	private int idade;
	private int cpf;
	private String sexo;
	
	
	public Clientes(String nome, int rg){
		this.nome=nome;
		this.rg=rg;
	}
	
	public Clientes(){}
	
	public Clientes(String nome, int rg, int idade, int cpf, String sexo) {
		this.nome=nome;
		this.rg=rg;
		this.idade=idade;
		this.cpf=cpf;
		this.sexo=sexo;
	}
	
	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public int getRg() {
		return rg;
	}
	public void setRg(int rg) {
		this.rg = rg;
	}
	public int getCpf() {
		return cpf;
	}
	public void setCpf(int cpf) {
		this.cpf = cpf;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNome() {
		return nome;
	}
	
	
}
