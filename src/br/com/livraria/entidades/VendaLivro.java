package br.com.livraria.entidades;

import java.io.Serializable;
import java.util.Date;

public class VendaLivro extends Produto implements Serializable {
	
	
	private Date dataCompra;
	private Cliente cliente;
	
	public Date getDataCompra() {
		return dataCompra;
	}
	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
}
