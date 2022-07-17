package com.jlcb.fordelivfood.api.model.mixin;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.jlcb.fordelivfood.domain.model.Restaurante;

public abstract class CozinhaMixin {
	
	@JsonIgnore
	private List<Restaurante> restaurantes;
	
}
