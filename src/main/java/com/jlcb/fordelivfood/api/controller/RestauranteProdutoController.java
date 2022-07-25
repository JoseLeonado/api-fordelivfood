package com.jlcb.fordelivfood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.jlcb.fordelivfood.api.assembler.ProdutoDTOAssembler;
import com.jlcb.fordelivfood.api.assembler.ProdutoInputDisassembler;
import com.jlcb.fordelivfood.api.model.ProdutoDTO;
import com.jlcb.fordelivfood.api.model.input.ProdutoInput;
import com.jlcb.fordelivfood.domain.model.Produto;
import com.jlcb.fordelivfood.domain.model.Restaurante;
import com.jlcb.fordelivfood.domain.repository.ProdutoRepository;
import com.jlcb.fordelivfood.domain.service.CadastroProdutoService;
import com.jlcb.fordelivfood.domain.service.CadastroRestauranteService;

@RestController
@RequestMapping("/restaurantes/{restauranteId}/produtos")
public class RestauranteProdutoController {
	
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private CadastroProdutoService cadastroProduto;
    
    @Autowired
    private CadastroRestauranteService cadastroRestaurante;
    
    @Autowired
    private ProdutoDTOAssembler produtoDTOAssembler;
    
    @Autowired
    private ProdutoInputDisassembler produtoInputDisassembler;
    
    @GetMapping
    public List<ProdutoDTO> listar(@PathVariable Long restauranteId) {
    	Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);
    	
    	List<Produto> todosProdutos = produtoRepository.findByRestaurante(restaurante);
    	
    	return produtoDTOAssembler.toCollectionDTO(todosProdutos);
    }
    
    @GetMapping("/{produtoId}")
    public ProdutoDTO buscar(@PathVariable Long restauranteId, @PathVariable Long produtoId) {
        Produto produto = cadastroProduto.buscarOuFalhar(restauranteId, produtoId);
        
        return produtoDTOAssembler.toDTO(produto);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProdutoDTO adicionar(@PathVariable Long restauranteId, @RequestBody @Valid ProdutoInput produtoInput) {
    	Restaurante restaurante = cadastroRestaurante.buscarOuFalhar(restauranteId);
    	
    	Produto produto = produtoInputDisassembler.toDomainObject(produtoInput);
    	produto.setRestaurante(restaurante);
    	
    	produto = cadastroProduto.salvar(produto);
    	
    	return produtoDTOAssembler.toDTO(produto);
    }
    
    @PutMapping("/{produtoId}")
    public ProdutoDTO atualizar(@PathVariable Long restauranteId, @PathVariable Long produtoId, @RequestBody @Valid ProdutoInput produtoInput) {
        Produto produtoAtual = cadastroProduto.buscarOuFalhar(restauranteId, produtoId);
        
        produtoInputDisassembler.copyToDomainObject(produtoInput, produtoAtual);
        
        produtoAtual = cadastroProduto.salvar(produtoAtual);
        
        return produtoDTOAssembler.toDTO(produtoAtual);
    }   

}
