package br.com.livraria.entidades;

import java.io.Serializable;

public class Livro extends Produto implements Serializable {
	
	
	private String autor;
	private String editora;
	
	
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getEditora() {
		return editora;
	}
	public void setEditora(String editora) {
		this.editora = editora;
	}
	
	
	
}
