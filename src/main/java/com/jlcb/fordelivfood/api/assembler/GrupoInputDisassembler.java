package com.jlcb.fordelivfood.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jlcb.fordelivfood.api.model.input.GrupoInput;
import com.jlcb.fordelivfood.domain.model.Grupo;

@Component
public class GrupoInputDisassembler {

    @Autowired
    private ModelMapper modelMapper;
    
    public Grupo toDomainObject(GrupoInput grupoInput) {
    	return modelMapper.map(grupoInput, Grupo.class);
    }
    
    public void copyToDomainObject(GrupoInput grupoInput, Grupo grupo) {
    	modelMapper.map(grupoInput, grupo);
    }
    
} 
