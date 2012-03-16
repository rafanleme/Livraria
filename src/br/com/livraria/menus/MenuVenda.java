package br.com.livraria.menus;

import java.util.Scanner;

import br.com.livraria.dao.CafeDAO;
import br.com.livraria.entidades.Cafe;

public class MenuVenda {

	public void exibirMenu(Scanner sc) {
		while(true){
			System.out.println("Menu de Vendas");
			System.out.println("1- Vender Cafe");
			//System.out.println("2- Incluir");
			//System.out.println("3- Alterar");
			//System.out.println("4- Excluir");
			System.out.println("5- Voltar");
			String opcao = sc.nextLine();
			if(opcao.equals("1")){
				this.venderCafe(sc);
			}else if(opcao.equals("2")){
				//this.incluir(sc);
			}else if(opcao.equals("3")){
				//this.alterar(sc);
			}else if(opcao.equals("4")){
				//this.excluir(sc);
			}
			else if(opcao.equals("5")){
				return;
			}
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
