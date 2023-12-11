package com.restaurante.restfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.restfood.domain.model.Permissao;
import com.restaurante.restfood.domain.repository.PermissaoRepository;

@RestController
@RequestMapping("/permissao")
public class PermissaoController {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@GetMapping
	public List<Permissao> listar() {
		return permissaoRepository.listar();
	}

	@GetMapping("/{permissaoId}")
	public ResponseEntity<Permissao> buscar(@PathVariable Long permissaoId) {
		Permissao permissao = permissaoRepository.buscar(permissaoId);

		if (permissao != null) {
			return ResponseEntity.ok(permissao);
		}
		return ResponseEntity.notFound().build();

	}

	@PostMapping
	public Permissao adicionar(@RequestBody Permissao permissao) {
		return permissaoRepository.salvar(permissao);
	}

	@PutMapping("/{permissaoId}")
	public ResponseEntity<Permissao> adicionar(@PathVariable Long permissaoId, @RequestBody Permissao permissao) {

		Permissao permissaoAtual = permissaoRepository.buscar(permissaoId);

		if (permissao != null) {
			BeanUtils.copyProperties(permissao, permissaoAtual);
			return ResponseEntity.ok(permissaoAtual);
		}
		return ResponseEntity.ok().build();

	}

}
