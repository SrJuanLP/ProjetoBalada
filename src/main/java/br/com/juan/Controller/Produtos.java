package br.com.juan.Controller;

public class Produtos {
	
	
	private String nomeProduto;
	private String marcaProduto;
	private String fornecedor;
	private double precoProduto;
	
	
	public Produtos() {
		// TODO Auto-generated constructor stub
	}
	public Produtos(String nomeProduto, String marcaProduto, double precoProduto,  String fornecedor) {
		this.nomeProduto = nomeProduto;
		this.marcaProduto = marcaProduto;
		this.precoProduto = precoProduto;
		this.fornecedor = fornecedor;
	}
	
	public String getFornecedor() {
		return fornecedor;
	}
	public void setFornecedor(String fornecedor) {
		this.fornecedor = fornecedor;
	}

	public double getPrecoProduto() {
		return precoProduto;
	}
	public void setPrecoProduto(double precoProduto) {
		this.precoProduto = precoProduto;
	}
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}
	public String getMarcaProduto() {
		return marcaProduto;
	}
	public void setMarcaProduto(String marcaProduto) {
		this.marcaProduto = marcaProduto;
	}
	
	
}
