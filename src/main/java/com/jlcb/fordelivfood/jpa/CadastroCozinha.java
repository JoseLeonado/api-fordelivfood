package com.jlcb.fordelivfood.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.jlcb.fordelivfood.domain.model.Cozinha;

@Component
public class CadastroCozinha {

	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Cozinha> listar() {
		return entityManager.createQuery("FROM Cozinha", Cozinha.class)
				.getResultList();
	}
	
	public Cozinha buscar(Long id) {
		return entityManager.find(Cozinha.class, id);
	}
	
	@Transactional
	public Cozinha salvar(Cozinha cozinha) {
		return entityManager.merge(cozinha);
	}
	
	@Transactional
	public void remover(Cozinha cozinha) {
		cozinha = buscar(cozinha.getId());
		entityManager.remove(cozinha);
	}
	
}