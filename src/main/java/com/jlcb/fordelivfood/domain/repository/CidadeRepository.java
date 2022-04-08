package com.jlcb.fordelivfood.domain.repository;

import java.util.List;

import com.jlcb.fordelivfood.domain.model.Cidade;

public interface CidadeRepository {

	List<Cidade> listar();
	
	Cidade buscar(Long id);
	
	Cidade salvar(Cidade cidade);
	
	void remover(Cidade cidade);
	
}