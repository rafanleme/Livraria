package br.com.livraria.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.com.livraria.Serial;
import br.com.livraria.entidades.Cliente;
import br.com.livraria.interfaces.InterfaceDAO;

public class ClienteDAO implements InterfaceDAO<Cliente>{
	
	private List<Cliente> list;
	private Serial<Cliente> serial;
	private String arq;
	private String arqVenda;
	
	public ClienteDAO() {
		serial = new Serial<Cliente>();
		arq = "arquivos/Clientes.dat";
		list = serial.deserializa(arq);
		if(list == null) list = new ArrayList<Cliente>();
	}
	
	public String getArq() {
		return arq;
	}


	public void setArq(String arq) {
		this.arq = arq;
	}


	public List<Cliente> getList() {
		return list;
	}
	
	
	public void setList(ArrayList<Cliente> list) {
		this.list = list;
	}

	public void listar(){
		if (!list.isEmpty()){		
			for(Cliente l : list){
				System.out.println("Código: " + l.getCodigo()
						+ " Cliente: " + l.getNome()
						+ " Telefone: " + l.getTelefone());
			}
		}else{
			System.out.println("Nenhum Cliente cadastrado");
		}
	}

	@Override
	public void alterar(String cod, Scanner sc) {
		for(Cliente c : list){
			if(c.getCodigo().equals(cod)){
				
				System.out.println("Alterar um Cliente");
				
				System.out.println("Nome do Cliente: ");
				c.setNome(sc.nextLine());
				
				System.out.println("Telefone: ");
				c.setTelefone(sc.nextLine());
				
				serial.serializar(list, arq);
				System.out.println("Alterado com sucesso.");
				return;
			}
			
		}
		System.out.println("Cliente não encontrado");
	}

	@Override
	public void inserir(Cliente c) {
		this.list.add(c);
		serial.serializar(list, arq);
	}

	@Override
	public void excluir(String cod) {
		for(Cliente l : list){
			if(l.getCodigo().equals(cod)){
				list.remove(l);
				System.out.println("Cliente " + l.getNome() 
						+ " excluído com sucesso");
				serial.serializar(list, arq);
				return;
			}
		}
		System.out.println("Cliente não encontrado");
	}

	public Cliente buscaPorCodigo(String cod){
		for(Cliente c : list){
			if(c.getCodigo().equals(cod)){
				return c;
			}
		}
		return null;
	}
	
}
