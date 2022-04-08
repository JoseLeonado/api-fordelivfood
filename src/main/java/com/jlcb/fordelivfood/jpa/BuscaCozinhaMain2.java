package com.jlcb.fordelivfood.jpa;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.jlcb.fordelivfood.ApiFordelivfoodApplication;
import com.jlcb.fordelivfood.domain.model.Cozinha;

public class BuscaCozinhaMain2 {

	public static void main(String[] args) {
		ApplicationContext applicationContext = new SpringApplicationBuilder(ApiFordelivfoodApplication.class)
				.web(WebApplicationType.NONE).run(args);

		CadastroCozinha cadastroCozinha = applicationContext.getBean(CadastroCozinha.class);

		Cozinha cozinha = cadastroCozinha.buscar(1L);

		System.out.println(cozinha.getNome());
	}

}