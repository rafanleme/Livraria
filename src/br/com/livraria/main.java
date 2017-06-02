package br.com.livraria;

import java.io.IOException;

import br.com.livraria.menus.MenuPrincipal;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MenuPrincipal mp = new MenuPrincipal();
		try {
			
			mp.exibirMenu();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
