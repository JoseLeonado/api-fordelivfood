package com.jlcb.fordelivfood.api.model.mixin;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.jlcb.fordelivfood.domain.model.Estado;

public abstract class CidadeMixin {
	
	@JsonIgnoreProperties(value = "nome", allowGetters = true)
	private Estado estado;

}
