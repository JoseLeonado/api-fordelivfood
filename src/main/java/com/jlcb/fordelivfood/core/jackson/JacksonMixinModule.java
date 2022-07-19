package com.jlcb.fordelivfood.core.jackson;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.module.SimpleModule;
import com.jlcb.fordelivfood.api.model.mixin.CidadeMixin;
import com.jlcb.fordelivfood.api.model.mixin.CozinhaMixin;
import com.jlcb.fordelivfood.domain.model.Cidade;
import com.jlcb.fordelivfood.domain.model.Cozinha;

@Component
public class JacksonMixinModule extends SimpleModule {

	private static final long serialVersionUID = 1L;
	
	public JacksonMixinModule() {
		setMixInAnnotation(Cidade.class, CidadeMixin.class);
		setMixInAnnotation(Cozinha.class, CozinhaMixin.class);
	}

}