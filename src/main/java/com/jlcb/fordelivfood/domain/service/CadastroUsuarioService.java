package com.jlcb.fordelivfood.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jlcb.fordelivfood.domain.exception.NegocioException;
import com.jlcb.fordelivfood.domain.exception.UsuarioNaoEncontradoException;
import com.jlcb.fordelivfood.domain.model.Usuario;
import com.jlcb.fordelivfood.domain.repository.UsuarioRepository;

@Service
public class CadastroUsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Transactional
	public Usuario salvar(Usuario usuario) {
		usuarioRepository.detach(usuario);
		
		Optional<Usuario> usuarioExistente = usuarioRepository.findByEmail(usuario.getEmail());
		
		if (usuarioExistente.isPresent() && !usuarioExistente.get().equals(usuario)) {
			throw new NegocioException(String.format("Já existe um usuário cadastrado com o e-mail %s", usuario.getEmail()));
		}
		
		return usuarioRepository.save(usuario);
	}
	
	@Transactional
	public void alterarSenha(Long usuarioId, String senhaAtual, String novaSenha) {
		Usuario usuario = buscarOuFalhar(usuarioId);
		
		if (usuario.senhaNaoCoincideCom(senhaAtual)) {
			throw new NegocioException("Senha atual informada não coincide com a senha do usuário.");
		}
		
		usuario.setSenha(novaSenha);
	}
	
    public Usuario buscarOuFalhar(Long usuarioId) {
        return usuarioRepository.findById(usuarioId)
            .orElseThrow(() -> new UsuarioNaoEncontradoException(usuarioId));
    }  
	
}