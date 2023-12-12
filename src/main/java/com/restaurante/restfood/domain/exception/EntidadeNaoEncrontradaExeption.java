package com.restaurante.restfood.domain.exception;

public class EntidadeNaoEncrontradaExeption extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EntidadeNaoEncrontradaExeption(String mensagem) {
		super(mensagem);
	}

}
