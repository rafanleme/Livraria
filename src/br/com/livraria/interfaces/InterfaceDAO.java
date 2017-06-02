package br.com.livraria.interfaces;

import java.util.List;
import java.util.Scanner;

public interface InterfaceDAO<T> {
	
	abstract List<T> getList();
	
	abstract boolean setLista(List<T> o);
	
	abstract void alterar(String s, Scanner sc);
	
	abstract void inserir(T o);
	
	abstract void excluir(String o);
}
