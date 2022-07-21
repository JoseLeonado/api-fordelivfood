package com.jlcb.fordelivfood.core.modelmapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jlcb.fordelivfood.api.model.EnderecoDTO;
import com.jlcb.fordelivfood.domain.model.Endereco;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		ModelMapper modelMapper = new ModelMapper();
		
		TypeMap<Endereco, EnderecoDTO> enderecoToEnderecoModelTypeMap = modelMapper.createTypeMap(Endereco.class, EnderecoDTO.class);
		
		enderecoToEnderecoModelTypeMap.<String>addMapping(
				enderecoSrc -> enderecoSrc.getCidade().getEstado().getNome(), 
				(enderecoDTODestino, value) -> enderecoDTODestino.getCidade().setEstado(value));
		
		return modelMapper;
	}
	
}
