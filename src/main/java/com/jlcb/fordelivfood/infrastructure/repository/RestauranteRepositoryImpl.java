package com.jlcb.fordelivfood.infrastructure.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jlcb.fordelivfood.domain.model.Restaurante;
import com.jlcb.fordelivfood.domain.repository.RestauranteRepository;

@Component
public class RestauranteRepositoryImpl implements RestauranteRepository {
	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Restaurante> listar() {
		return entityManager.createQuery("FROM Restaurante", Restaurante.class).getResultList();
	}

	@Override
	public Restaurante buscar(Long id) {
		return entityManager.find(Restaurante.class, id);
	}

	@Override
	@Transactional
	public Restaurante salvar(Restaurante restaurante) {
		return entityManager.merge(restaurante);
	}

	@Override
	@Transactional
	public void remover(Restaurante restaurante) {
		restaurante = buscar(restaurante.getId());
		entityManager.remove(restaurante);
	}

}