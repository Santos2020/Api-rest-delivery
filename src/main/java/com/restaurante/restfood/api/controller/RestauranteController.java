package com.restaurante.restfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.restaurante.restfood.domain.exception.EntidadeEmUsoExeption;
import com.restaurante.restfood.domain.exception.EntidadeNaoEncrontradaExeption;
import com.restaurante.restfood.domain.model.Restaurante;
import com.restaurante.restfood.domain.repository.RestauranteRepository;
import com.restaurante.restfood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

	@Autowired
	private RestauranteRepository restauranteRepository;
	
	@Autowired
	private CadastroRestauranteService cadastroRestaurante;

	@GetMapping
	public List<Restaurante> listar() {
		return restauranteRepository.listar();
	}

	@GetMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> buscar(@PathVariable Long restauranteId) {
		Restaurante restaurante = restauranteRepository.buscar(restauranteId);

		if (restaurante != null) {
			return ResponseEntity.ok(restaurante);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Restaurante adicionar(@RequestBody Restaurante restaurante) {
		return restauranteRepository.salvar(restaurante);
	}

	@PutMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> atualizar(@PathVariable Long restauranteId,
			@RequestBody Restaurante restaurante) {

		Restaurante restauranteAtual = restauranteRepository.buscar(restauranteId);
		if (restaurante != null) {
			BeanUtils.copyProperties(restaurante, restauranteAtual, "id");

			restauranteRepository.salvar(restauranteAtual);
			return ResponseEntity.ok(restauranteAtual);

		}
		return ResponseEntity.ok().build();
		
	}
	
	@DeleteMapping("/{restauranteId}")
	public ResponseEntity<Restaurante> remove(@PathVariable Long restauranteId){
		try {
		
		cadastroRestaurante.excluir(restauranteId);
		
		return ResponseEntity.noContent().build();
		} catch (EntidadeEmUsoExeption e) {
			
			return ResponseEntity.notFound().build();
		} catch ( EntidadeNaoEncrontradaExeption e) {
			 
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		} 
			
	}
	
}
