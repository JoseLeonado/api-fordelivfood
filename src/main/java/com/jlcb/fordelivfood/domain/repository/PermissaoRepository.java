package com.jlcb.fordelivfood.domain.repository;

import java.util.List;

import com.jlcb.fordelivfood.domain.model.Permissao;

public interface PermissaoRepository {

	List<Permissao> listar();
	
	Permissao buscar(Long id);
	
	Permissao salvar(Permissao permissao);
	
	void remover(Permissao permissao);
	
}