package com.jlcb.fordelivfood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.jlcb.fordelivfood.domain.model.Restaurante;
import com.jlcb.fordelivfood.domain.repository.RestauranteRepositoryQueries;

@Repository
public class RestauranteRepositoryImpl implements RestauranteRepositoryQueries {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		
		StringBuilder jpql = new StringBuilder();
		jpql.append("FROM Restaurante WHERE 0 = 0 ");
		
		Map<String, Object> parametros = new HashMap<>();
		
		if (StringUtils.hasLength(nome)) {
			jpql.append("AND nome LIKE :nome ");
			parametros.put("nome", "%" + nome + "%");
		}
		
		if (taxaFreteInicial != null) {
			jpql.append("AND taxaFrete >= :taxaInicial ");
			parametros.put("taxaInicial", taxaFreteInicial);
		}
		
		if (taxaFreteFinal != null) {
			jpql.append("AND taxaFrete <= :taxaFinal ");
			parametros.put("taxaFinal", taxaFreteFinal);
		}
		
		TypedQuery<Restaurante> query = entityManager.createQuery(jpql.toString(), Restaurante.class);
				
		parametros.forEach((chave, valor) -> query.setParameter(chave, valor));

		return query.getResultList();
	}
	
}