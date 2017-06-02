package br.com.livraria.menus;

import java.util.List;
import java.util.Scanner;

public class MenuCadastro {

	public void exibirMenu(Scanner sc) {
		while(true){
			System.out.println("Menu de Cadastros");
			System.out.println("1- Livros");
			//System.out.println("2- Incluir");
			//System.out.println("3- Alterar");
			//System.out.println("4- Excluir");
			//System.out.println("5- Voltar");
			String opcao = sc.nextLine();
			if(opcao.equals("1")){
				MenuLivros ml = new MenuLivros();
				ml.exibirMenu(sc);
			}else if(opcao.equals("2")){
				
			}else if(opcao.equals("5")){
				return;
			}
		}
	}

}
