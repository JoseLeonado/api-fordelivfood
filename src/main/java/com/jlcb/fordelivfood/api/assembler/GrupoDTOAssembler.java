package com.jlcb.fordelivfood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jlcb.fordelivfood.api.model.GrupoDTO;
import com.jlcb.fordelivfood.domain.model.Grupo;

@Component
public class GrupoDTOAssembler {
	
    @Autowired
    private ModelMapper modelMapper;
    
    public GrupoDTO toDTO(Grupo grupo) {
    	return modelMapper.map(grupo, GrupoDTO.class);
    }

    public List<GrupoDTO> toCollectionDTO(List<Grupo> grupos) {
    	return grupos.stream()
    			.map(grupo -> toDTO(grupo))
    			.collect(Collectors.toList());
    }
}
