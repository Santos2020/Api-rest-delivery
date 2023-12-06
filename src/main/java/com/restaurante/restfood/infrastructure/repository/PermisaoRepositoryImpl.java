package com.restaurante.restfood.infrastructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.restaurante.restfood.domain.model.Permissao;
import com.restaurante.restfood.domain.repository.PermissaoRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Component
public class PermisaoRepositoryImpl implements PermissaoRepository {

	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Permissao> listar() {
		return manager.createQuery("from Permissao", Permissao.class).getResultList();
	}

	@Override
	public Permissao buscar(Long id) {
		return manager.find(Permissao.class, id);
	}

	@Override
	public Permissao salvar(Permissao permissao) {
		return manager.merge(permissao);
	}

	@Override
	public void remover(Permissao permissao) {
		permissao = buscar(permissao.getId());
		manager.remove(permissao);

	}

}
