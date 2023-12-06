package com.restaurante.restfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.restaurante.restfood.RestfoodApiApplication;
import com.restaurante.restfood.domain.model.Cidade;
import com.restaurante.restfood.domain.repository.CidadeRepository;

public class ConsultaCidadeMain {

	public static void main(String[] args) {

		ApplicationContext applicationContext = (ApplicationContext) new SpringApplicationBuilder(
				RestfoodApiApplication.class).web(WebApplicationType.NONE).run(args);

		CidadeRepository cidadeRepository = applicationContext.getBean(CidadeRepository.class);
		List<Cidade> cidades = cidadeRepository.listar();

		for (Cidade cidade : cidades) {
			System.out.println(cidade.getNome());
		}

	}

}
