package com.restaurante.restfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.restaurante.restfood.domain.model.FormaPagamento;
import com.restaurante.restfood.domain.repository.FormaPagamentoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class FormaPagamentoRepositoryImpl implements FormaPagamentoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<FormaPagamento> listar() {
		return manager.createQuery("from FormaPagamento", FormaPagamento.class).getResultList();
	}

	@Override
	public FormaPagamento buscar(Long id) {
		return manager.find(FormaPagamento.class, id);
	}

	@Override
	public FormaPagamento salvar(FormaPagamento formaPagamento) {
		return manager.merge(formaPagamento);
	}

	@Override
	public void remover(FormaPagamento formaPagamento) {
		formaPagamento = buscar(formaPagamento.getId());
		manager.remove(formaPagamento);

	}

}
