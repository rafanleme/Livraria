package br.com.livraria.menus;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import br.com.livraria.dao.CafeDAO;
import br.com.livraria.dao.ComputadorDAO;
import br.com.livraria.dao.LivroDAO;
import br.com.livraria.entidades.Cafe;
import br.com.livraria.entidades.Livro;
import br.com.livraria.entidades.VendaLivro;

public class MenuLanHouse {
	
	private ComputadorDAO pcDao = new ComputadorDAO();
	
	public void exibirMenu(Scanner sc) {
		while(true){
			System.out.println("Menu de LanHouse");
			System.out.println("1- Listar Computadores");
			System.out.println("2- Alocar Cliente");
			System.out.println("3- Encerrar Sessão");
			System.out.println("9- Voltar");
			String opcao = sc.nextLine();
			if(opcao.equals("1")){
				this.listarComputadores(sc);
			}else if(opcao.equals("2")){
				this.alocarCliente(sc);
				break;
			}else if(opcao.equals("3")){
				this.encerrarSessao(sc);
			}
			else if(opcao.equals("9")){
				return;
			}
		}
	}

	private void encerrarSessao(Scanner sc) {
		if(pcDao.listarOcupados()){
			System.out.println("Escolha um computador: ");
			pcDao.encerrarSessao(sc, sc.nextLine());
		}else{
			System.out.println("Nenhum computador ocupado!");
		}
		
	}

	private void listarComputadores(Scanner sc) {
		pcDao.listar();
	}

	private void alocarCliente(Scanner sc) {
		pcDao.listarLivres();
		System.out.println("Escolha o computador: ");
		
		pcDao.alocarCliente(sc, sc.nextLine());
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
