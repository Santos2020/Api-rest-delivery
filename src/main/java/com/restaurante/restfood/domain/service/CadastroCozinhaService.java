package com.restaurante.restfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.restaurante.restfood.domain.exception.EntidadeEmUsoExeption;
import com.restaurante.restfood.domain.exception.EntidadeNaoEncrontradaExeption;
import com.restaurante.restfood.domain.model.Cozinha;
import com.restaurante.restfood.domain.repository.CozinhaRepository;

@Service
public class CadastroCozinhaService {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Cozinha salvar(Cozinha cozinha) {
		return cozinhaRepository.salvar(cozinha);

	}

	public void excluir(Long cozinhaId) {
		try {
			cozinhaRepository.remover(cozinhaId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncrontradaExeption(
					String.format("Não existem cadastro de cozinha %d", cozinhaId));
	
		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoExeption(
					String.format("Cozinha de código %d não pode ser removida, pois esta em uso", cozinhaId));

		}
	}
}
