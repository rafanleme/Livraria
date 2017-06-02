package br.com.livraria.entidades;

import java.io.Serializable;

import br.com.livraria.interfaces.InterfaceProduto;

public class Produto implements InterfaceProduto,Serializable  {
	
	private String codigo;
	private String nome;
	private String categoria;
	private Double preco;
	private Integer qtde;
	
	
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String tipo) {
		this.categoria = tipo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public Integer getQtde() {
		return qtde;
	}

	public void setQtde(Integer qtde) {
		this.qtde = qtde;
	}

	@Override
	public boolean vender(){
		if(qtde != 0){
			System.out.println(this.getCategoria() + " " 
						+ this.getNome() + " vendido por " 
						+ this.getPreco());
			return this.baixaEstoque();
		}else{
			System.out.println("Sem saldo para este produto");
			return false;
		}
	}

	@Override
	public boolean comprar() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean baixaEstoque() {
		qtde--;
		return true;
	}

	@Override
	public void consultarEstoque() {
		System.out.println("Há " + this.getQtde() 
					+ " " + this.getCategoria() + "(s) - " 
					+ this.getNome() + " em estoque.");
	}

}
