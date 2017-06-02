package br.com.livraria.entidades;

import java.io.Serializable;

public class Cafe extends Produto implements Serializable {
	
	private boolean forte;
	private String tamanho;
	private boolean leite;
	
	public boolean isForte() {
		return forte;
	}
	public void setForte(boolean forte) {
		this.forte = forte;
	}
	public String getTamanho() {
		return tamanho;
	}
	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}
	public boolean isLeite() {
		return leite;
	}
	public void setLeite(boolean leite) {
		this.leite = leite;
	}
}
