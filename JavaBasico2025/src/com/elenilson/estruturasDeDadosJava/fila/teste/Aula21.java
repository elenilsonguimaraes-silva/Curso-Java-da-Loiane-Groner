package com.elenilson.estruturasDeDadosJava.fila.teste;

import com.elenilson.estruturasDeDadosJava.fila.Fila;

public class Aula21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fila<Integer> fila = new Fila<>();
		
		fila.enfileirar(3);
		fila.enfileirar(1);
		fila.enfileirar(2);
		
		
		System.out.println(fila.espiar());
		
		System.out.println(fila);

	}

}
