package com.restaurante.restfood.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.restfood.domain.model.Cozinha;
import com.restaurante.restfood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/teste")
public class testeController {
	
	@Autowired
	private CozinhaRepository cozinhaRepository;
	
	@GetMapping("/cozinhas/por/nome")
	public List<Cozinha> cozinhaPorNome(@RequestParam("nome") String nome){
		return cozinhaRepository.findTodasByNomeContaining(nome);
	}
	
	@GetMapping("/cozinhas/unico-por/nome")
	public Optional<Cozinha> cozinhaNome(@RequestParam("nome") String nome){
		return cozinhaRepository.findByNome(nome);
	}

}
