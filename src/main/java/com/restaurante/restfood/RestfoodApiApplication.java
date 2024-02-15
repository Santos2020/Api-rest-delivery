package com.restaurante.restfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.restaurante.restfood.infrastructure.repository.CustomJpaRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories(repositoryBaseClass = CustomJpaRepositoryImpl.class)
public class RestfoodApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfoodApiApplication.class, args);
	}

}
