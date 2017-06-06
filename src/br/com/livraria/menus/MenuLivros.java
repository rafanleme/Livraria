package br.com.livraria.menus;

import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import br.com.livraria.dao.LivroDAO;
import br.com.livraria.entidades.Livro;
import br.com.livraria.entidades.Produto;

public class MenuLivros {

	public void exibirMenu(Scanner sc) {
		while(true){
			System.out.println("Menu de Livros");
			System.out.println("1- Listar");
			System.out.println("2- Incluir");
			System.out.println("3- Alterar");
			System.out.println("4- Excluir");
			System.out.println("5- Alterar Qtde");
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
			}else if(opcao.equals("5")){
				this.alterarQtde(sc);
			}

			else if(opcao.equals("9")){
				return;
			}
		}
	}
	
	private void alterarQtde(Scanner sc) {
		System.out.println("Digite o código do livro");
		String cod = sc.nextLine();
		LivroDAO dao = new LivroDAO();
		System.out.println(dao.alterarQtde(cod, sc));
		
	}

	private void excluir(Scanner sc) {
		System.out.println("Codigo a excluir: ");
		String cod = sc.nextLine();
		LivroDAO dao = new LivroDAO();
		dao.excluir(cod);
	}

	private void incluir(Scanner sc) {
		Livro l = new Livro();
		l.setCategoria("Livro");
		
		System.out.println("Incluir um Livro:");
		
		System.out.println("Código: ");
		l.setCodigo(sc.nextLine());
		
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
		
		LivroDAO dao = new LivroDAO();
		dao.inserir(l);
		
	}

	private void listar(Scanner sc){
		LivroDAO dao = new LivroDAO();
		List<Livro> list = dao.getList();
		
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

	private void alterar(Scanner sc){
		System.out.println("Digite o código do livro");
		String cod = sc.nextLine();
		LivroDAO dao = new LivroDAO();
		dao.alterar(cod, sc);
	}
}
