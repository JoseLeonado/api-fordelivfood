package com.jlcb.fordelivfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlcb.fordelivfood.domain.exception.EntidadeNaoEncontradaException;
import com.jlcb.fordelivfood.domain.model.Cozinha;
import com.jlcb.fordelivfood.domain.model.Restaurante;
import com.jlcb.fordelivfood.domain.repository.CozinhaRepository;
import com.jlcb.fordelivfood.domain.repository.RestauranteRepository;

@Service
public class CadastroRestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId)
				.orElseThrow(() -> new EntidadeNaoEncontradaException(
						String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

		restaurante.setCozinha(cozinha);

		return restauranteRepository.salvar(restaurante);
	}

}