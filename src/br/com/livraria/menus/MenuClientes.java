package br.com.livraria.menus;

import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import br.com.livraria.dao.ClienteDAO;
import br.com.livraria.entidades.Cliente;
import br.com.livraria.entidades.Produto;

public class MenuClientes {

	public void exibirMenu(Scanner sc) {
		while(true){
			System.out.println("Menu de Clientes");
			System.out.println("1- Listar");
			System.out.println("2- Incluir");
			System.out.println("3- Alterar");
			System.out.println("4- Excluir");
			System.out.println("9- Voltar");
			String opcao = sc.nextLine();
			if(opcao.equals("1")){
				this.listar(sc);
			}else if(opcao.equals("2")){
				this.incluir(sc);
			}else if(opcao.equals("3")){
				this.alterar(sc);
			}else if(opcao.equals("4")){
				this.excluir(sc);
			}else if(opcao.equals("9")){
				return;
			}
		}
	}

	private void excluir(Scanner sc) {
		System.out.println("Codigo a excluir: ");
		String cod = sc.nextLine();
		ClienteDAO dao = new ClienteDAO();
		dao.excluir(cod);
	}

	private void incluir(Scanner sc) {
		Cliente c = new Cliente();
				
		System.out.println("Incluir um Cliente:");
		
		System.out.println("Código: ");
		c.setCodigo(sc.nextLine());
		
		System.out.println("Nome do Cliente: ");
		c.setNome(sc.nextLine());
		
		System.out.println("Telefone: ");
		c.setTelefone(sc.nextLine());
		
		ClienteDAO dao = new ClienteDAO();
		dao.inserir(c);
		
	}

	private void listar(Scanner sc){
		ClienteDAO dao = new ClienteDAO();
		List<Cliente> list = dao.getList();
		
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

	private void alterar(Scanner sc){
		System.out.println("Digite o código do Cliente");
		String cod = sc.nextLine();
		ClienteDAO dao = new ClienteDAO();
		dao.alterar(cod, sc);
	}
}
