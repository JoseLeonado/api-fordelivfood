package com.jlcb.fordelivfood.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jlcb.fordelivfood.domain.repository.CozinhaRepository;

@RestController
@RequestMapping("/testes")
public class TesteController {

	@Autowired
	private CozinhaRepository cozinhaRepository;
	
//	@GetMapping("/cozinhas/por-nome")
//	public List<Cozinha> cozinhasPorNome(@RequestParam("nome") String nome) {
//		return cozinhaRepository.consultarPorNome(nome);
//	}
	
}