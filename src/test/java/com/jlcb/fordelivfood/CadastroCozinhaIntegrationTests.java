package com.jlcb.fordelivfood;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.ConstraintViolationException;

import com.jlcb.fordelivfood.domain.exception.CozinhaNaoEncontradaException;
import com.jlcb.fordelivfood.domain.exception.EntidadeEmUsoException;
import com.jlcb.fordelivfood.domain.model.Cozinha;
import com.jlcb.fordelivfood.domain.service.CadastroCozinhaService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class CadastroCozinhaIntegrationTests {
	
	@Autowired
	private CadastroCozinhaService service;

	@Test
	public void deveAtribuirId_QuandoCadastrarCozinhaComDadosCorretos() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome("Chinesa");
		
		novaCozinha = service.salvar(novaCozinha);
		
		assertThat(novaCozinha).isNotNull();
		assertThat(novaCozinha.getId()).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoCadastrarCozinhaSemNome() {
		Cozinha novaCozinha = new Cozinha();
		novaCozinha.setNome(null);

		ConstraintViolationException erroEsperado =
				Assertions.assertThrows(ConstraintViolationException.class, () -> {
					service.salvar(novaCozinha);
				});

		assertThat(erroEsperado).isNotNull();
	}
	
	@Test
	public void deveFalhar_QuandoExcluirCozinhaEmUso() {
        EntidadeEmUsoException exception = Assertions.assertThrows(EntidadeEmUsoException.class, () -> {
            service.excluir(1L);
         });
         assertThat(exception).isNotNull();
	}
	
	@Test
	public void deveFalhar_quandoExcluirCozinhaInexistente() {
        CozinhaNaoEncontradaException exception = Assertions.assertThrows(CozinhaNaoEncontradaException.class, () -> {
            service.excluir(100L);
        });
        assertThat(exception).isNotNull();
	}
}
