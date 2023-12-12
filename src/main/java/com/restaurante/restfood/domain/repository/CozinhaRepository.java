package com.restaurante.restfood.domain.repository;

import java.util.List;

import com.restaurante.restfood.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();

	Cozinha buscar(Long id);

	Cozinha salvar(Cozinha cozinha);

	void remover(Long id);

}
