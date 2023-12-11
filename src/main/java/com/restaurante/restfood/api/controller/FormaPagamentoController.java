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

import com.restaurante.restfood.domain.model.FormaPagamento;
import com.restaurante.restfood.domain.repository.FormaPagamentoRepository;

@RestController
@RequestMapping("/formaPagamentos")
public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@GetMapping
	public List<FormaPagamento> listar() {
		return formaPagamentoRepository.listar();

	}

	@GetMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamento> buscar(@PathVariable Long formaPagamentoId) {
		FormaPagamento formaPagamento = formaPagamentoRepository.buscar(formaPagamentoId);

		return ResponseEntity.ok(formaPagamento);

	}

	@PostMapping
	public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
		return formaPagamentoRepository.salvar(formaPagamento);
	}

	@PutMapping("/{formaPagamentoId}")
	public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long formaPagamentoId,
			@RequestBody FormaPagamento formaPagamento) {

		FormaPagamento formaPagamentoAtual = formaPagamentoRepository.buscar(formaPagamentoId);
		if (formaPagamento != null) {
			BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual);

			return ResponseEntity.ok(formaPagamentoAtual);
		}
		return ResponseEntity.ok().build();

	}
}
