package com.restaurante.restfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.restaurante.restfood.domain.exception.EntidadeEmUsoExeption;
import com.restaurante.restfood.domain.exception.EntidadeNaoEncrontradaExeption;
import com.restaurante.restfood.domain.model.Estado;
import com.restaurante.restfood.domain.repository.EstadoRepository;

@Service
public class CadastroEstadoService {

	@Autowired
	private EstadoRepository estadoRepository;

	public Estado salvar(Estado estado) {
		return estadoRepository.save(estado);

	}

	public void excluir(Long estadoId) {
		try {

			estadoRepository.deleteById(estadoId);
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncrontradaExeption(
					String.format("Não existem cadastro de estado %d", estadoId, estadoId));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoExeption(
					String.format("Estadoa de código %d não pode ser removida, pois esta em uso", estadoId, null));
		}
	}

}
