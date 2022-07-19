package com.jlcb.fordelivfood.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jlcb.fordelivfood.api.model.RestauranteDTO;
import com.jlcb.fordelivfood.domain.model.Restaurante;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		modelMapper.createTypeMap(Restaurante.class, RestauranteDTO.class)
			.addMapping(Restaurante::getTaxaFrete, RestauranteDTO::setPrecoFrete);
		
		return modelMapper;
	}
	
}
