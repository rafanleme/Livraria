package br.com.livraria.menus;

import java.util.List;
import java.util.Scanner;

import br.com.livraria.dao.CafeDAO;
import br.com.livraria.dao.LivroDAO;
import br.com.livraria.entidades.Cafe;
import br.com.livraria.entidades.Livro;

public class MenuVenda {

	public void exibirMenu(Scanner sc) {
		while(true){
			System.out.println("Menu de Vendas");
			System.out.println("1- Vender Cafe");
			System.out.println("2- Vender Livro");
			System.out.println("3- Listar Vendas");
			System.out.println("9- Voltar");
			String opcao = sc.nextLine();
			if(opcao.equals("1")){
				this.venderCafe(sc);
				break;
			}else if(opcao.equals("2")){
				this.venderLivro(sc);
				break;
			}else if(opcao.equals("3")){
				this.listar(sc);
				break;
			}
			else if(opcao.equals("9")){
				return;
			}
		}
	}

	private void venderLivro(Scanner sc) {
		LivroDAO ldao = new LivroDAO();
		System.out.println("Didite o codigo do livro: ");
		
		String resp = ldao.vender(sc, sc.nextLine());
		
		System.out.println(resp);
		
	}

	private void listar(Scanner sc) {
		LivroDAO ldao = new LivroDAO();
		List<Livro> listL = ldao.getListV();
		
		System.out.println("Vendas de Livros");
		if (!listL.isEmpty()){		
			for(Livro l : listL){
				System.out.println("Código: " + l.getCodigo()
						+ " Livro: " + l.getNome()
						+ " Autor: " + l.getAutor()
						+ " Preco: " + l.getPreco());
			}
		}else{
			System.out.println("Nenhuma venda realizada");
		}
		System.out.println("");
		CafeDAO cdao = new CafeDAO();
		List<Cafe> listC = cdao.getList();
		System.out.println("Vendas de Cafés");
		if (!listC.isEmpty()){		
			for(Cafe c : listC){
				System.out.println("Código: " + c.getCodigo()
						+ " Tamanho: " + c.getTamanho()
						+ " Preco: " + c.getPreco());
			}
		}else{
			System.out.println("Nenhuma venda realizada");
		}
		
	}

	private void venderCafe(Scanner sc) {
		Cafe c = new Cafe();
		
		System.out.println("Codigo da venda: ");
		c.setCodigo(sc.nextLine());
		
		System.out.println("Qual o tamanho (G,M,P)?: ");
		c.setTamanho(sc.nextLine());
		
		System.out.println("Vai leite (S,N)?: ");
		if(sc.nextLine().equals("S")) c.setLeite(true);
		else c.setLeite(false);
		
		System.out.println("Café forte (S,N)?: ");
		if(sc.nextLine().equals("S")) c.setForte(true);
		else c.setForte(false);
		
		switch (c.getTamanho()){
		case "G":
			c.setPreco(5.00);
			break;
		case "M":
			c.setPreco(4.00);
			break;
		case "P":
			c.setPreco(3.50);
		}
		
		System.out.println("Valor a pagar: " + c.getPreco());
		System.out.println("Digite valor pago: ");
		Double pago = sc.nextDouble();
		sc.hasNextLine();
		System.out.println("Troco = " + (pago - c.getPreco()));
		
		CafeDAO cDao = new CafeDAO();
		cDao.inserir(c);
		
	}
	
	
}
