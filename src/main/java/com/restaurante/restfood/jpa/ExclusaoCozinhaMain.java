package com.restaurante.restfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.restaurante.restfood.RestfoodApiApplication;
import com.restaurante.restfood.domain.model.Cozinha;
import com.restaurante.restfood.domain.repository.CozinhaRepository;

public class ExclusaoCozinhaMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(
				RestfoodApiApplication.class).web(WebApplicationType.NONE).run(args);

		CozinhaRepository cozinhaRepository = applicationContext.getBean(CozinhaRepository.class);
		Cozinha cozinha = new Cozinha();
		cozinha.setId(1L);
		
		cozinhaRepository.remover(cozinha);

		

	}

}
