package com.restaurante.restfood.notificacao;

import org.springframework.stereotype.Component;

import com.restaurante.restfood.modelo.Cliente;

@TipoDoNotificador(NivelUrgencia.URGENTE)
@Component
public class NotificadorSMS implements Notificador {

	
	@Override
	public void notificar(Cliente cliente, String mensagem) {

		System.out.printf("Notificando %s por SMS atraves do telefone %s: %s\n", cliente.getNome(),
				cliente.getTelefone(), mensagem);
	}

}