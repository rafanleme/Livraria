package br.com.livraria.menus;

import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

import br.com.livraria.dao.ComputadorDAO;
import br.com.livraria.entidades.Computador;
import br.com.livraria.entidades.Produto;

public class MenuComputadores {
	
	private ComputadorDAO cDao = new ComputadorDAO();

	public void exibirMenu(Scanner sc) {
		while(true){
			System.out.println("Menu de Computadores");
			System.out.println("1- Listar");
			System.out.println("2- Incluir");
			System.out.println("3- Excluir");
			System.out.println("9- Voltar");
			String opcao = sc.nextLine();
			if(opcao.equals("1")){
				this.listar(sc);
			}else if(opcao.equals("2")){
				this.incluir(sc);
			}else if(opcao.equals("3")){
				this.excluir(sc);
			}else if(opcao.equals("9")){
				return;
			}
		}
	}

	private void excluir(Scanner sc) {
		System.out.println("Codigo a excluir: ");
		String cod = sc.nextLine();
		cDao.excluir(cod);
	}

	private void incluir(Scanner sc) {
		Computador c = new Computador();
				
		System.out.println("Incluir um Computador:");
		
		System.out.println("Nro Computador: ");
		c.setNroPc(sc.nextLine());
		
		c.setOcupado(false);
		
		cDao.inserir(c);
	}

	private void listar(Scanner sc){
		cDao.listar();	
	}
}
