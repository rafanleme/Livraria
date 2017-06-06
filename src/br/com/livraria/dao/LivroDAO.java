package br.com.livraria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.livraria.Serial;
import br.com.livraria.entidades.Livro;
import br.com.livraria.interfaces.InterfaceDAO;

public class LivroDAO implements InterfaceDAO<Livro>{
	
	private List<Livro> list, listV;
	private Serial<Livro> serial;
	private String arq;
	private String arqVenda;
	
	public LivroDAO() {
		serial = new Serial<Livro>();
		list = new ArrayList<Livro>();
		arq = "arquivos/livros.dat";
		list = serial.deserializa(arq);
		arqVenda = "arquivos/vendaLivro.dat";
		listV = new ArrayList<Livro>();
		listV = serial.deserializa(arqVenda);
	}
	
	
	public Serial<Livro> getSerial() {
		return serial;
	}


	public void setSerial(Serial<Livro> serial) {
		this.serial = serial;
	}


	public String getArq() {
		return arq;
	}


	public void setArq(String arq) {
		this.arq = arq;
	}


	public List<Livro> getList() {
		return list;
	}
	
	public List<Livro> getListV() {
		return listV;
	}
	
	public void setList(ArrayList<Livro> list) {
		this.list = list;
	}

	@Override
	public boolean setLista(List<Livro> l) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void alterar(String cod, Scanner sc) {
		for(Livro l : list){
			if(l.getCodigo().equals(cod)){
				
				System.out.println("Alterar um Livro:");
				
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
				System.out.println("Alterado com sucesso.");
				return;
			}
			
		}
		System.out.println("Livro não encontrado");
	}

	@Override
	public void inserir(Livro l) {
		this.list.add(l);
		serial.serializar(list, arq);
	}

	@Override
	public void excluir(String cod) {
		for(Livro l : list){
			if(l.getCodigo().equals(cod)){
				list.remove(l);
				System.out.println("Livro " + l.getNome() 
						+ " excluído com sucesso");
				serial.serializar(list, arq);
				return;
			}
		}
		System.out.println("Livro não encontrado");
	}


	public String vender(Scanner sc, String cod) {
		for(Livro l : list){
			if(l.getCodigo().equals(cod)){
				Integer qtde = l.getQtde();
				if(qtde > 0){
					
					l.setQtde(qtde-1);
					serial.serializar(list, arq);
					Livro lv = l;
					lv.setQtde(1);
					listV.add(lv);
					serial.serializar(listV, arqVenda);
					return "Livro vendido com sucesso";
				}else{
					return "Sem saldo disponível em estoque";
				}
			}
		}
		return "Livro não encontrado";
	}


	public String alterarQtde(String cod, Scanner sc) {
		for(Livro l : list){
			if(l.getCodigo().equals(cod)){
				System.out.println("Digite a quantidade: ");
				l.setQtde(sc.nextInt());
				sc.nextLine();
				serial.serializar(list, arq);
				return "Livro alterado com sucesso";
			}
		}
		return "Livro não encontrado";
	}
}
