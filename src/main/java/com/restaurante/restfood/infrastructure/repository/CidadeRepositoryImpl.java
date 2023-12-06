package com.restaurante.restfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.restaurante.restfood.domain.model.Cidade;
import com.restaurante.restfood.domain.repository.CidadeRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {
	
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Cidade> listar() {
		return manager.createQuery("from Cidade", Cidade.class)
				.getResultList();
	}

	@Override
	public Cidade buscar(Long id) {
		return manager.find(Cidade.class, id);
	}

	@Override
	public Cidade salvar(Cidade cidade) {
		return manager.merge(cidade);
	}

	@Override
	public void remover(Cidade cidade) {
		cidade = buscar(cidade.getId());
		manager.remove(cidade);
		
	}

}
