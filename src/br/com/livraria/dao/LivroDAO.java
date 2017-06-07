package br.com.livraria.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import br.com.livraria.Serial;
import br.com.livraria.entidades.Livro;
import br.com.livraria.entidades.VendaLivro;
import br.com.livraria.interfaces.InterfaceDAO;

public class LivroDAO implements InterfaceDAO<Livro>{
	
	private List<Livro> list;
	private List<VendaLivro> listV;
	private Serial<Livro> serial;
	private Serial<VendaLivro> serialV;
	private String arq;
	private String arqVenda;
	
	public LivroDAO() {
		serial = new Serial<Livro>();
		serialV = new Serial<VendaLivro>();
		arq = "arquivos/livros.dat";
		list = serial.deserializa(arq);
		if(list == null) list = new ArrayList<Livro>();
		
		arqVenda = "arquivos/vendaLivro.dat";
		listV = serialV.deserializa(arqVenda);
		if(listV == null) listV = new ArrayList<VendaLivro>();
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
	
	public List<VendaLivro> getListV() {
		return listV;
	}
	
	public void setList(ArrayList<Livro> list) {
		this.list = list;
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
				l.setEditora(sc.nextLine());
								
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
	
	public VendaLivro getVendaLivro(Livro l) {
		VendaLivro vl = new VendaLivro();
		vl.setAutor(l.getAutor());
		vl.setCategoria(l.getCategoria());
		vl.setCodigo(l.getCodigo());
		vl.setEditora(l.getEditora());
		vl.setNome(l.getNome());
		vl.setPreco(l.getPreco());
		vl.setQtde(1);
		return vl;
	}


	public String vender(Scanner sc, String cod) {
		for(Livro l : list){
			if(l.getCodigo().equals(cod)){
				Integer qtde = l.getQtde();
				if(qtde > 0){
					l.setQtde(qtde-1);
					serial.serializar(list, arq);
					ClienteDAO cDao = new ClienteDAO();
					cDao.listar();
					VendaLivro lv = this.getVendaLivro(l);
					System.out.println("Escolha um cliente (codigo): ");
					lv.getCliente().setCodigo(sc.nextLine()); 
					Date data = new Date();
					lv.setDataCompra(data);
					listV.add(lv);
					serialV.serializar(listV, arqVenda);
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


	public void listar() {
		if (!list.isEmpty()){		
			for(Livro l : list){
				System.out.println("Código: " + l.getCodigo()
						+ " Livro: " + l.getNome()
						+ " Autor: " + l.getAutor()
						+ " Qtde: " + l.getQtde()
						+ " Preco: " + l.getPreco());
						
			}
		}else{
			System.out.println("Nenhum livro cadastrado");
		}
	}
}
