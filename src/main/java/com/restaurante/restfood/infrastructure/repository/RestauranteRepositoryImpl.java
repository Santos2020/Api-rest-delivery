package com.restaurante.restfood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restaurante.restfood.domain.model.Restaurante;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {

		CriteriaBuilder build = manager.getCriteriaBuilder();

		CriteriaQuery<Restaurante> criteria = build.createQuery(Restaurante.class);
		criteria.from(Restaurante.class);

		TypedQuery<Restaurante> query = manager.createQuery(criteria);
		return query.getResultList();

	}

}

