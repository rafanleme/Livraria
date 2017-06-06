package br.com.livraria.menus;

import java.io.IOException;
import java.util.Scanner;


public class MenuPrincipal {

	public void exibirMenu() throws IOException, InterruptedException {
		while(true){
			System.out.println("Menu Principal");
			System.out.println("1- Cadastro");
			System.out.println("2- Vendas");
			System.out.println("9- Sair");
			Scanner sc = new Scanner(System.in);
			String opcao = sc.nextLine();
			
			if(opcao.equals("1")){
				MenuCadastro mCad = new MenuCadastro();
				mCad.exibirMenu(sc);
			}else if(opcao.equals("2")){
				MenuVenda mVen = new MenuVenda();
				mVen.exibirMenu(sc);	
			}
			else if(opcao.equals("9")){
				sc.close();
				return;
			}
		}
		
	}

}
