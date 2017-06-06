package br.com.livraria;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import br.com.livraria.entidades.Livro;

public class Serial<T> {
	
	
	public void serializar(List<T> list, String arq){
		try{
			FileOutputStream fos = new FileOutputStream(arq);
			ObjectOutputStream ois = new ObjectOutputStream(fos);
			ois.writeObject(list); // Escreve a lista no arquivo
			ois.flush(); // Aguarda fim da escrita
			ois.close(); // Fecha o arquivo
		}catch (Exception e) {
			System.out.println("Erro ao gravar arquivo");
		}
	}
	
	
	public List<T> deserializa(String arq){
		List<T> list = new ArrayList<>();
		try{
			// Abre um arquivo para leitura
			FileInputStream fos = new FileInputStream(arq);
			ObjectInputStream ois = new ObjectInputStream(fos);
			
			// Leitura do arquivo com a lista de dados
			try {
				list = (List<T>) ois.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ois.close(); // Fecha o arquivo.
			
			return list;
		}
		catch (IOException e) {
			//System.out.println("Erro ao ler o arquivo" + e);
		}
		return null;
				
	}
}
