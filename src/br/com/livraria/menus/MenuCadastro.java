package br.com.livraria.menus;

import java.util.List;
import java.util.Scanner;

public class MenuCadastro {

	public void exibirMenu(Scanner sc) {
		while(true){
			System.out.println("Menu de Cadastros");
			System.out.println("1- Livros");
			System.out.println("2- Clientes");
			System.out.println("3- Computadores");
			//System.out.println("4- Excluir");
			System.out.println("9- Voltar");
			String opcao = sc.nextLine();
			if(opcao.equals("1")){
				MenuLivros ml = new MenuLivros();
				ml.exibirMenu(sc);
			}else if(opcao.equals("2")){
				MenuClientes mc = new MenuClientes();
				mc.exibirMenu(sc);
			}else if(opcao.equals("3")){
				MenuComputadores mc = new MenuComputadores();
				mc.exibirMenu(sc);
			}else if(opcao.equals("9")){
				return;
			}
		}
	}

}
