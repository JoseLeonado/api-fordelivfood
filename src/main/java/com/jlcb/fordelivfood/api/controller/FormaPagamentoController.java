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

import com.jlcb.fordelivfood.api.assembler.FormaPagamentoDTOAssembler;
import com.jlcb.fordelivfood.api.assembler.FormaPagamentoInputDisassembler;
import com.jlcb.fordelivfood.api.model.FormaPagamentoDTO;
import com.jlcb.fordelivfood.api.model.input.FormaPagamentoInput;
import com.jlcb.fordelivfood.domain.model.FormaPagamento;
import com.jlcb.fordelivfood.domain.repository.FormaPagamentoRepository;
import com.jlcb.fordelivfood.domain.service.CadastroFormaPagamentoService;

@RestController
@RequestMapping("formas-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;
    
    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamento;
    
	@Autowired
	private FormaPagamentoDTOAssembler formaPagamentoDTOAssembler;

	@Autowired
	private FormaPagamentoInputDisassembler formaPagamentoInputDisassembler;   

    @GetMapping
    public List<FormaPagamentoDTO> listar() {
        List<FormaPagamento> todasFormasPagamentos = formaPagamentoRepository.findAll();
        
        return formaPagamentoDTOAssembler.toCollectionModel(todasFormasPagamentos);
    }
    
    @GetMapping("/{formaPagamentoId}")
    public FormaPagamentoDTO buscar(@PathVariable Long formaPagamentoId) {
        FormaPagamento formaPagamento = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);
        
        return formaPagamentoDTOAssembler.toDTO(formaPagamento);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FormaPagamentoDTO adicionar(@RequestBody @Valid FormaPagamentoInput formaPagamentoInput) {
        FormaPagamento formaPagamento = formaPagamentoInputDisassembler.toDomainObject(formaPagamentoInput);
        
        formaPagamento = cadastroFormaPagamento.salvar(formaPagamento);
        
        return formaPagamentoDTOAssembler.toDTO(formaPagamento);
    }
    
    @PutMapping("/{formaPagamentoId}")
    public FormaPagamentoDTO atualizar(@PathVariable Long formaPagamentoId,
            @RequestBody @Valid FormaPagamentoInput formaPagamentoInput) {
        FormaPagamento formaPagamentoAtual = cadastroFormaPagamento.buscarOuFalhar(formaPagamentoId);
        
        formaPagamentoInputDisassembler.copyToDomainObject(formaPagamentoInput, formaPagamentoAtual);
        
        formaPagamentoAtual = cadastroFormaPagamento.salvar(formaPagamentoAtual);
        
        return formaPagamentoDTOAssembler.toDTO(formaPagamentoAtual);
    }
    
    @DeleteMapping("/{formaPagamentoId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void remover(@PathVariable Long formaPagamentoId) {
        cadastroFormaPagamento.excluir(formaPagamentoId);	
    }   

}