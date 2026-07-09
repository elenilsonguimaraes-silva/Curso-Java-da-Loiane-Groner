package com.elenilson.estruturasDeDadosJava.lista;

public class ListaEncadeada<T> {
	
	private No<T> inicio;
	private No<T> ultimo;
	private int tamanho = 0;
	
	private final int NAO_ENCONTRADO = -1;
	
	public void adiciona(T elemento) {
		No<T> celula = new No<T> (elemento);
		if(this.tamanho ==0) {
			this.inicio = celula;
		}else {
			this.ultimo.setProximo(celula);
		}
		this.ultimo = celula;
		this.tamanho++;
	}
	
	public void adicionaInicio(T elemento) {
		if(this.tamanho == 0) {
			No<T> novoNo = new No<>(elemento);
			this.inicio = novoNo;
			this.ultimo = novoNo;
			
		}else {
			//Umas das maneiras de criar o nó
			//No<T> novoNo = new No<>(elemento);
			//novoNo.setProximo(this.inicio);
			//Outra maneira de criar o nó, já com o inicio no construtor
			No<T> novoNo = new No<>(elemento, this.inicio);					
			this.inicio= novoNo;// linha de código usada nas duas maneira de criação desse nó nesse escopo!
		}
		this.tamanho++;
	}
	
	public void adiciona(int posicao, T elemento){		
		
		if(posicao < 0 || posicao > this.tamanho) {
			throw new IllegalArgumentException("Posição  Inválida!");
		}
		
		if(posicao == 0) { //está vazia
			this.adicionaInicio(elemento);
		}else if( posicao == this.tamanho) { // adiciona
			this.adiciona(elemento);
		}else { // Meio
			No<T> noAnterior = this.buscarNo(posicao);
			No<T> proximoNo = noAnterior.getProximo();
			No<T> novoNo = new No<>(elemento, proximoNo);
			noAnterior.setProximo(novoNo);
			this.tamanho++;
			
			
		}
		
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	public void limpa() {
		
		for(No<T> atual = this.inicio; atual != null;) {
			No<T> proximo = atual.getProximo();
			atual.setElmento(null);
			atual.setProximo(null);
			atual = proximo;
		}
		this.inicio = null;
		this.ultimo= null;
		this.tamanho = 0;
	}
	
	private No<T> buscarNo(int posicao){
		
		if(!(posicao >= 0 && posicao <= this.tamanho)) {
			throw new IllegalArgumentException("Posição não existe.");
		}
		
		No<T> noAtual = this.inicio;
		for(int i = 0; i <posicao; i++) {
			noAtual = noAtual.getProximo();
		}
		return noAtual;
	}
	
	public T buscaPorPosicao(int posicao) {
		
		 return this.buscarNo(posicao).getElmento();
	}
	
	public int busca(T elemento) {
		No<T> noAtual = this.inicio;
		int pos = 0;
		
		while(noAtual != null) {
			if(noAtual.getElmento().equals(elemento)) {
				return pos;
			}
			pos++;
			noAtual = noAtual.getProximo();
		}
		
		return NAO_ENCONTRADO;
	}
	
	
	
	@Override
	public String toString() {
		
		// [1, 2, 3, 4]
		
		if(this.tamanho == 0) {
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder("[");		
		//builder.append( "ListaEncadeada [inicio=").append(inicio).append("]");
		
		No<T> atual = this.inicio;
		for(int i = 0; i < this.tamanho -1;i++) {
			builder.append(atual.getElmento()).append(", ");
			atual = atual.getProximo();
		}
		builder.append(atual.getElmento()).append("]");
		/*
		builder.append(atual.getElmento()).append(", ");
		while(atual.getProximo() != null) {
			atual = atual.getProximo();
			builder.append(atual.getElmento()).append(", ");
		}
		*/
		return builder.toString();
	}
}
