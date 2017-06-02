package br.com.livraria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.livraria.Serial;
import br.com.livraria.entidades.Cafe;
import br.com.livraria.interfaces.InterfaceDAO;

public class CafeDAO implements InterfaceDAO<Cafe>{
	
	private List<Cafe> list;
	private Serial<Cafe> serial;
	private String arq;
	
	public CafeDAO() {
		list = new ArrayList<Cafe>();
		serial = new Serial<Cafe>();
		arq = "arquivos/livros.dat";
		list = serial.deserializa(arq);
	}
	
	
	public Serial<Cafe> getSerial() {
		return serial;
	}


	public void setSerial(Serial<Cafe> serial) {
		this.serial = serial;
	}


	public String getArq() {
		return arq;
	}


	public void setArq(String arq) {
		this.arq = arq;
	}


	public List<Cafe> getList() {
		return list;
	}

	public void setList(ArrayList<Cafe> list) {
		this.list = list;
	}

	@Override
	public boolean setLista(List<Cafe> l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alterar(String cod, Scanner sc) {
		for(Cafe l : list){
			if(l.getCodigo().equals(cod)){
				
				System.out.println("Alterar um Cafe:");
				
				System.out.println("Nome do livro: ");
				l.setNome(sc.nextLine());
				
				System.out.println("Autor: ");
				l.setAutor(sc.nextLine());
				
				System.out.println("Editora: ");
				l.setAutor(sc.nextLine());
								
				System.out.println("Preço: ");
				l.setPreco(sc.nextDouble());
				sc.nextLine();
				
				System.out.println("Quantidade: ");
				l.setQtde(sc.nextInt());
				sc.nextLine();
				
				serial.serializar(list, arq);
				break;
			}
		}
		System.out.println("Alterado com sucesso.");	
	}

	@Override
	public void inserir(Cafe l) {
		this.list.add(l);
		serial.serializar(list, arq);
	}

	@Override
	public void excluir(String cod) {
		for(Cafe l : list){
			if(l.getCodigo().equals(cod)){
				list.remove(l);
				System.out.println("Cafe " + l.getNome() 
						+ " excluído com sucesso");
				serial.serializar(list, arq);
				return;
			}
		}
		System.out.println("Cafe não encontrado");
	}

	
}
