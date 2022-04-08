package com.jlcb.fordelivfood.domain.repository;

import java.util.List;

import com.jlcb.fordelivfood.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> listar();
	
	Restaurante buscar(Long id);
	
	Restaurante salvar(Restaurante restaurante);
	
	void remover(Restaurante restaurante);
	
}