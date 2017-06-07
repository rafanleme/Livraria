package br.com.livraria.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import br.com.livraria.Serial;
import br.com.livraria.entidades.Computador;
import br.com.livraria.interfaces.InterfaceDAO;

public class ComputadorDAO implements InterfaceDAO<Computador>{
	
	private List<Computador> list;
	private Serial<Computador> serial;
	private String arq;
	
	public ComputadorDAO() {
		serial = new Serial<Computador>();
		arq = "arquivos/computadores.dat";
		list = serial.deserializa(arq);
		if(list == null) list = new ArrayList<Computador>();
	}
	
	public String getArq() {
		return arq;
	}


	public void setArq(String arq) {
		this.arq = arq;
	}


	public List<Computador> getList() {
		return list;
	}
	
	
	public void setList(ArrayList<Computador> list) {
		this.list = list;
	}

	public void listarLivres() {
		if (!list.isEmpty()){		
			for(Computador c : list){
				if(!c.isOcupado()){
					System.out.println(c.getNroPc()
							+ " Livre");
				}
			}
		}else{
			System.out.println("Nenhum Computador cadastrado");
		}
	}
	
	public boolean listarOcupados() {
		boolean pass = false;
		if (!list.isEmpty()){		
			for(Computador c : list){
				
				if(c.isOcupado()){
					System.out.println(c.getNroPc()
							+ " Ocupado pelo cliente " 
							+ c.getCliente().getNome()
							+ " Tempo: " + verificarTempo(c));
					pass = true;
				}
			}
		}else{
			System.out.println("Nenhum Computador cadastrado");
		}
		return pass;
	}
	
	public void listar(){
		if (!list.isEmpty()){		
			for(Computador c : list){
				if(c.isOcupado()){
					System.out.println(c.getNroPc()
							+ " Ocupado pelo cliente " 
							+ c.getCliente().getNome()
							+ " Tempo: " + verificarTempo(c));
				}
				else{
					System.out.println(c.getNroPc()
							+ " Livre");
				}
			}
		}else{
			System.out.println("Nenhum Computador cadastrado");
		}
	}
	
	private String verificarTempo(Computador comp){
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
		long inicio = comp.getInicio().getTimeInMillis();
		long agora = Calendar.getInstance().getTimeInMillis();
		long tempo = agora - inicio;
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		cal.add(Calendar.SECOND, Integer.parseInt("" + (tempo / 1000)));

		return sdf.format(cal.getTime());
	}
	
	private String verificarTempoM(Computador comp){
		SimpleDateFormat sdf = new SimpleDateFormat("mm");
		long inicio = comp.getInicio().getTimeInMillis();
		long agora = Calendar.getInstance().getTimeInMillis();
		long tempo = agora - inicio;
		Calendar cal = Calendar.getInstance();
		
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);

		cal.add(Calendar.SECOND, Integer.parseInt("" + (tempo / 1000)));

		return sdf.format(cal.getTime());
	}

	@Override
	public void alterar(String cod, Scanner sc) {
		//Não implementável para computadores
	}

	@Override
	public void inserir(Computador c) {
		this.list.add(c);
		serial.serializar(list, arq);
	}

	@Override
	public void excluir(String cod) {
		for(Computador l : list){
			if(l.getNroPc().equals(cod)){
				list.remove(l);
				System.out.println("Computador " + l.getNroPc() 
						+ " excluído com sucesso");
				serial.serializar(list, arq);
				return;
			}
		}
		System.out.println("Computador não encontrado");
	}

	public void alocarCliente(Scanner sc, String nroPc) {
		for(Computador c : list){
			if(c.getNroPc().equals(nroPc)){
				if(!c.isOcupado()){
					ClienteDAO cDao = new ClienteDAO();
					cDao.listar();
					System.out.println("Escolha o cliente: ");
					c.setCliente(cDao.buscaPorCodigo(sc.nextLine()));
					c.setOcupado(true);
					c.setInicio(Calendar.getInstance());
					serial.serializar(list, arq);
				}
			}
		}
		
	}
	
	private String verificarValor(Computador comp){
		Integer tempo = Integer.parseInt(verificarTempoM(comp));
		Double valor = tempo * 0.05;
		return valor.toString();
		
	}

	public void encerrarSessao(Scanner sc, String nroPc) {
		for(Computador c : list){
			if(c.getNroPc().equals(nroPc)){
				if(c.isOcupado()){
					System.out.println("Valor a pagar: " + verificarValor(c));
					c.setCliente(null);
					c.setInicio(null);
					c.setOcupado(false);
					serial.serializar(list, arq);
				}
			}
		}
	}


	
	
	
}
