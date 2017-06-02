package br.com.livraria.interfaces;

import br.com.livraria.entidades.Produto;

public interface InterfaceProduto {
	
	abstract boolean vender();
	
	abstract boolean comprar();
	
	abstract boolean baixaEstoque();
	
	abstract void consultarEstoque();
	
}
