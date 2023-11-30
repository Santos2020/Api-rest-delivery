package com.restaurante.restfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.restaurante.restfood.RestfoodApiApplication;
import com.restaurante.restfood.domain.model.Restaurante;

public class InclusaoRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(
				RestfoodApiApplication.class).web(WebApplicationType.NONE).run(args);

		CadastroRestaurante cadastroRestaurantes = applicationContext.getBean(CadastroRestaurante.class);

		Restaurante restaurantes1 = new Restaurante();
		restaurantes1.setNome("Jim Jim");

		Restaurante restaurantes2 = new Restaurante();
		restaurantes2.setNome("Raposo");

		cadastroRestaurantes.adicionar(restaurantes1);
		cadastroRestaurantes.adicionar(restaurantes2);

	}

}
