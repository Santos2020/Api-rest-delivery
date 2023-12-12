package com.restaurante.restfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.restaurante.restfood.domain.exception.EntidadeEmUsoExeption;
import com.restaurante.restfood.domain.exception.EntidadeNaoEncrontradaExeption;
import com.restaurante.restfood.domain.model.Restaurante;
import com.restaurante.restfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	public Restaurante salvar(Restaurante restaurante) {
		return restauranteRepository.salvar(restaurante);
	}

	public void excluir(Long restauranteId) {
		try {

			restauranteRepository.remover(restauranteId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncrontradaExeption(
					String.format("Não existem cadastro de Restaurante %d", restauranteId));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoExeption(
					String.format("Restaurante de código %d não pode ser removida, pois esta em uso", restauranteId));
		}

	}

}
