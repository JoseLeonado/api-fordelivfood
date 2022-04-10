package com.jlcb.fordelivfood.domain.repository;

import java.util.List;

import com.jlcb.fordelivfood.domain.model.Estado;

public interface EstadoRepository {

	List<Estado> listar();
	
	Estado buscar(Long id);
	
	Estado salvar(Estado estado);
	
	void remover(Long id);
	
}