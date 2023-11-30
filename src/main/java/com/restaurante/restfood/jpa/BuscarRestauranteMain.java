package com.restaurante.restfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.restaurante.restfood.RestfoodApiApplication;
import com.restaurante.restfood.domain.model.Restaurante;

public class BuscarRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(
				RestfoodApiApplication.class).web(WebApplicationType.NONE).run(args);

		CadastroRestaurante cadastroRestaurante = applicationContext.getBean(CadastroRestaurante.class);

		Restaurante restaurantes = cadastroRestaurante.buscar(1L);

		System.out.println(restaurantes.getNome());

	}

}
