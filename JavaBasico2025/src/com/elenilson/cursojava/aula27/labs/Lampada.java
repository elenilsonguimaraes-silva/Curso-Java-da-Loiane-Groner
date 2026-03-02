package com.elenilson.cursojava.aula27.labs;

public class Lampada {
	
	String modelo;
	String tensao;
	int potencia;
	String corLuz;
	int garantiaMeses;
	String[] tipoLampada;
	boolean ligada = false;
	
	void ligarLampada() {
		ligada = true;
	}
	void desligarLampada() {
		ligada = false;
	}
	
	void verificarEstadoLampada() {
		if(ligada) {
			System.out.println("A lâmpada está ligada");
		}else{
			System.out.println("A lâmpada está desligada");
		}
	}
	void mudarEstadoLampada(){
		if(ligada) {
			desligarLampada();
		}else {
			ligarLampada();
		}
	}	

}
