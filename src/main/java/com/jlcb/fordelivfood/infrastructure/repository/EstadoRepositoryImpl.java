package com.jlcb.fordelivfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jlcb.fordelivfood.domain.model.Estado;
import com.jlcb.fordelivfood.domain.repository.EstadoRepository;

@Component
public class EstadoRepositoryImpl implements EstadoRepository {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Estado> listar() {
		return entityManager.createQuery("FROM Estado", Estado.class).getResultList();
	}
	
	@Override
	public Estado buscar(Long id) {
		return entityManager.find(Estado.class, id);
	}
	
	@Override
	@Transactional
	public Estado salvar(Estado estado) {
		return entityManager.merge(estado);
	}
	
	@Override
	@Transactional
	public void remover(Estado estado) {
		estado = buscar(estado.getId());
		entityManager.remove(estado);
	}

}