package com.elenilson.estruturasDeDadosJava.pilha.labs;

import com.elenilson.estruturasDeDadosJava.pilha.Pilha;

public class Exercicio6_Correcao_Loiane {

	public static void main(String[] args) {
		
		imprimeResultado("A + B");
		imprimeResultado("A + B + (C - D)");
		imprimeResultado("{[()]}[](){}");
		imprimeResultado("{[(]}[](){}");
		imprimeResultado("A + B +c - D)");
		imprimeResultado("(((");
		

	}
	public static void imprimeResultado(String expressao) {
		System.out.println(expressao + " está  balanceado? " +
				verificaSimbolosBalanceados(expressao));
	}
	
	final static String ABRE = "([{";
	final static String FECHA = ")]}";
	public static boolean verificaSimbolosBalanceados(String expressao) {
		
		
		Pilha<Character> pilha = new Pilha<>();		
		int index = 0;
		char simbolo, topo;
		
		while(index < expressao.length()) {
			simbolo = expressao.charAt(index);
			
			if(ABRE.indexOf(simbolo) > -1) {
				pilha.empilha(simbolo);
			}else if(FECHA.indexOf(simbolo) > -1) {
				
				if(pilha.estaVazia()) {
					return false;
				}else {
					topo = pilha.desempilha();
					if(ABRE.indexOf(topo) != FECHA.indexOf(simbolo)) {
						return false;
					}
				}
			}			
			
			index++;
		}
		
		return pilha.estaVazia();
	}

}
