package com.jlcb.fordelivfood.domain.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jlcb.fordelivfood.domain.model.Produto;
import com.jlcb.fordelivfood.domain.model.Restaurante;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    @Query("FROM Produto WHERE restaurante.id = :restaurante AND id = :produto")
    Optional<Produto> findById(@Param("restaurante") Long restauranteId, @Param("produto") Long produtoId);
    
    List<Produto> findByRestaurante(Restaurante restaurante);
    
}     