package com.jlcb.fordelivfood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jlcb.fordelivfood.api.assembler.EstadoDTOAssembler;
import com.jlcb.fordelivfood.api.assembler.EstadoInputDisassembler;
import com.jlcb.fordelivfood.api.model.EstadoDTO;
import com.jlcb.fordelivfood.api.model.input.EstadoInput;
import com.jlcb.fordelivfood.domain.model.Estado;
import com.jlcb.fordelivfood.domain.repository.EstadoRepository;
import com.jlcb.fordelivfood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CadastroEstadoService cadastroEstado;
	
	@Autowired
	private EstadoDTOAssembler estadoDTOAssembler;

	@Autowired
	private EstadoInputDisassembler estadoInputDisassembler;   

	@GetMapping
	public List<EstadoDTO> listar() {
	    List<Estado> todosEstados = estadoRepository.findAll();
		return estadoDTOAssembler.toCollectionModel(todosEstados);
	}

	@GetMapping("/{estadoId}")
	public EstadoDTO buscar(@PathVariable Long estadoId) {
		Estado estado = cadastroEstado.buscarOuFalhar(estadoId);
		return estadoDTOAssembler.toDTO(estado);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoDTO adicionar(@RequestBody @Valid EstadoInput estadoInput) {
		Estado estado = estadoInputDisassembler.toDomainObject(estadoInput);
		
		estado = cadastroEstado.salvar(estado);
		
		return estadoDTOAssembler.toDTO(estado);
	}

	@PutMapping("/{estadoId}")
	public EstadoDTO atualizar(@PathVariable Long estadoId,
	        @RequestBody @Valid EstadoInput estadoInput) {
	    Estado estadoAtual = cadastroEstado.buscarOuFalhar(estadoId);
	    
	    estadoInputDisassembler.copyToDomainObject(estadoInput, estadoAtual);
	    
	    estadoAtual = cadastroEstado.salvar(estadoAtual);
	    
	    return estadoDTOAssembler.toDTO(estadoAtual);
	} 

	@DeleteMapping("/{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long estadoId) {
	    cadastroEstado.excluir(estadoId);	
	}

}