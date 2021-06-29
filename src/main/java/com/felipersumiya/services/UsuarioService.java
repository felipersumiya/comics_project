package com.felipersumiya.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.SqlReturnUpdateCount;
import org.springframework.stereotype.Service;

import com.felipersumiya.domain.Usuario;
import com.felipersumiya.dto.UsuarioDto;
import com.felipersumiya.repositories.UsuarioRepository;



@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioRepository usuarioRepository;

	
	public List<Usuario> findAll() {

		return usuarioRepository.findAll();

	}
	
	public Usuario findById(Long id) {
		
		Optional<Usuario> usuario =  usuarioRepository.findById(id);	
		return usuario.get();
		
	}

	public Usuario inserir(Usuario usuario) {

		return usuarioRepository.save(usuario);

	}
	
	
	public Usuario converteDto (UsuarioDto usuarioDto) {
		
		 return new Usuario(usuarioDto.getId(), usuarioDto.getNome(), usuarioDto.getCpf(), usuarioDto.getEmail(), usuarioDto.getDataNascimento());
		
	}
	

}
