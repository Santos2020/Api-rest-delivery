package com.restaurante.restfood.notificacao;

import com.restaurante.restfood.modelo.Cliente;

public interface Notificador {

	void notificar(Cliente cliente, String mensagem);

}