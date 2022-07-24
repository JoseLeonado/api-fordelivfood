package com.jlcb.fordelivfood.domain.repository;

import org.springframework.stereotype.Repository;

import com.jlcb.fordelivfood.domain.model.Usuario;

@Repository
public interface UsuarioRepository extends CustomJpaRepository<Usuario, Long> {

}
