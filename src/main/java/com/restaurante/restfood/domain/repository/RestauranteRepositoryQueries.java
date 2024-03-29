package com.restaurante.restfood.domain.repository;

import java.math.BigDecimal;
import java.util.List;

import com.restaurante.restfood.domain.model.Restaurante;

public interface RestauranteRepositoryQueries {

	List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal);

	List<Restaurante> findComFreteGratis(String nome);

	List<Restaurante> taxaFreteGratis(String nome);

}
