package com.restaurante.restfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.restaurante.restfood.RestfoodApiApplication;
import com.restaurante.restfood.domain.model.Restaurante;

public class ConsultaRestauranteMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(
				RestfoodApiApplication.class).web(WebApplicationType.NONE).run(args);

		CadastroRestaurante cadastroRestaurante = applicationContext.getBean(CadastroRestaurante.class);

		List<Restaurante> restaurantes = cadastroRestaurante.listar();

		for (Restaurante restaurante : restaurantes) {
			System.out.println(restaurante.getNome());
		}

	}

}
