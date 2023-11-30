package com.restaurante.restfood.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import com.restaurante.restfood.domain.model.Cozinha;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class CadastroCozinha {

	@PersistenceContext
	private EntityManager manager;

	public List<Cozinha> listar() {
		return manager.createQuery("from Cozinha", Cozinha.class).getResultList();
	}

	public Cozinha buscar(Long id) {
		return manager.find(Cozinha.class, id);

	}

	@Transactional
	public Cozinha adicionar(Cozinha conzinha) {
		return manager.merge(conzinha);
	}

}
