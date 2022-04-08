package com.jlcb.fordelivfood.domain.repository;

import java.util.List;

import com.jlcb.fordelivfood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {
	
	List<FormaPagamento> listar();
	
	FormaPagamento buscar(Long id);
	
	FormaPagamento salvar(FormaPagamento formaPagamento);
	
	void remover(FormaPagamento formaPagamento);

}