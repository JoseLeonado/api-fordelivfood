package com.jlcb.fordelivfood.api.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import com.jlcb.fordelivfood.api.model.EstadoDTO;
import com.jlcb.fordelivfood.domain.model.Estado;

public class EstadoDTOAssembler {
	
    @Autowired
    private ModelMapper modelMapper;
    
    public EstadoDTO toDTO(Estado estado) {
        return modelMapper.map(estado, EstadoDTO.class);
    }
    
    public List<EstadoDTO> toCollectionModel(List<Estado> estados) {
        return estados.stream()
                .map(estado -> toDTO(estado))
                .collect(Collectors.toList());
    }

}
