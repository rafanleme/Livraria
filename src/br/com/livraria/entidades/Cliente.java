package br.com.livraria.entidades;

import java.io.Serializable;

public class Cliente extends Pessoa implements Serializable {
	
	private String codigo;
	private String telefone;
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String registro) {
		this.codigo = registro;
	}

}