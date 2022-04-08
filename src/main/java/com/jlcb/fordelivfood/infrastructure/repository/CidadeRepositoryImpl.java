package com.jlcb.fordelivfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jlcb.fordelivfood.domain.model.Cidade;
import com.jlcb.fordelivfood.domain.repository.CidadeRepository;

@Component
public class CidadeRepositoryImpl implements CidadeRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Cidade> listar() {
		return entityManager.createQuery("FROM Cidade", Cidade.class).getResultList();
	}
	
	@Override
	public Cidade buscar(Long id) {
		return entityManager.find(Cidade.class, id);
	}
	
	@Override
	@Transactional
	public Cidade salvar(Cidade cidade) {
		return entityManager.merge(cidade);
	}
	
	@Override
	@Transactional
	public void remover(Cidade cidade) {
		cidade = buscar(cidade.getId());
		entityManager.remove(cidade);
	}

}