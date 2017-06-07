package br.com.livraria.entidades;

import java.io.Serializable;
import java.util.Calendar;

public class Computador implements Serializable {
	
	private String nroPc;
	private boolean ocupado;
	private Cliente cliente = new Cliente();
	private Calendar inicio;
	
	public Calendar getInicio() {
		return inicio;
	}
	public void setInicio(Calendar cal) {
		this.inicio = cal;
	}
	public String getNroPc() {
		return nroPc;
	}
	public void setNroPc(String nroPc) {
		this.nroPc = nroPc;
	}
	public boolean isOcupado() {
		return ocupado;
	}
	public void setOcupado(boolean ocupado) {
		this.ocupado = ocupado;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
}
