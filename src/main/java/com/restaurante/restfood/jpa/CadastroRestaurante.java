package com.restaurante.restfood.jpa;

import java.util.List;

import org.springframework.stereotype.Component;

import com.restaurante.restfood.domain.model.Restaurante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Component
public class CadastroRestaurante {

	@PersistenceContext
	private EntityManager manager;

	public List<Restaurante> listar() {
		return manager.createQuery("from Restaurante", Restaurante.class).getResultList();
	}
	
	public Restaurante buscar(long id) {
		return manager.find(Restaurante.class,id);
	}

	@Transactional
	public Restaurante adicionar(Restaurante restaurante) {
		return manager.merge(restaurante);
	}

}
