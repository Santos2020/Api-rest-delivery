package com.restaurante.restfood.api.controller;


import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.restfood.domain.exception.EntidadeNaoEncontradaException;
import com.restaurante.restfood.domain.exception.NegocioExceptio;
import com.restaurante.restfood.domain.model.Cidade;
import com.restaurante.restfood.domain.repository.CidadeRepository;
import com.restaurante.restfood.domain.service.CadastroCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private CadastroCidadeService cadastroCidade;

	@GetMapping
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	@GetMapping("/{cidadeId}")
	public Cidade buscar(@PathVariable Long cidadeId) {
		return cadastroCidade.buscarOuFalhar(cidadeId);
	}

//	@PostMapping
//	public ResponseEntity<?> adicionar(@RequestBody Cidade cidade) {
//		try {
//			cidade = cadastroCidade.salvar(cidade);
//			
//			return ResponseEntity.status(HttpStatus.CREATED)
//					.body(cidade);
//		} catch (EntidadeNaoEncontradaException e) {
//			return ResponseEntity.badRequest()
//					.body(e.getMessage());
//		}
//	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cidade adicionar(@RequestBody Cidade cidade) {
		return cadastroCidade.salvar(cidade);
	}

//	@PutMapping("/{cidadeId}")
//	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId,
//			@RequestBody Cidade cidade) {
//		try {
//			Cidade cidadeAtual = cidadeRepository.findById(cidadeId).orElse(null);
//			
//			if (cidadeAtual != null) {
//				BeanUtils.copyProperties(cidade, cidadeAtual, "id");
//				
//				cidadeAtual = cadastroCidade.salvar(cidadeAtual);
//				return ResponseEntity.ok(cidadeAtual);
//			}
//			
//			return ResponseEntity.notFound().build();
//		
//		} catch (EntidadeNaoEncontradaException e) {
//			return ResponseEntity.badRequest()
//					.body(e.getMessage());
//		}
//	}

//	@PutMapping("/{cidadeId}")
//	public ResponseEntity<?> atualizar(@PathVariable Long cidadeId, @RequestBody Cidade cidade) {
//
//		Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);
//		BeanUtils.copyProperties(cidade, cidadeAtual, "id");
//		try {
//			cidadeAtual = cadastroCidade.salvar(cidadeAtual);
//
//			return ResponseEntity.ok(cidadeAtual);
//
//		} catch (EntidadeNaoEncontradaException e) {
//			return ResponseEntity.badRequest().body(e.getMessage());
//
//		}
//	}
	
	@PutMapping("/{cidadeId}")
	public Cidade atualizar(@PathVariable Long cidadeId,
			@RequestBody Cidade cidade){
		Cidade cidadeAtual = cadastroCidade.buscarOuFalhar(cidadeId);
		
		BeanUtils.copyProperties(cidade, cidadeAtual, "id");
		
		try {
			return cadastroCidade.salvar(cidadeAtual);
		} catch (EntidadeNaoEncontradaException e) {
			throw new NegocioExceptio(e.getMessage());
		}
	}

	@DeleteMapping("/{cidadeId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long cidadeId) {
		cadastroCidade.excluir(cidadeId);
	}

}