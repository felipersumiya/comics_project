package com.felipersumiya.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.felipersumiya.domain.Usuario;
import com.felipersumiya.dto.UsuarioDto;
import com.felipersumiya.repositories.UsuarioRepository;
import com.felipersumiya.services.exceptions.DatabaseException;
import com.felipersumiya.services.exceptions.ResourceNotFoundException;



@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<Usuario> findAll() {

		return usuarioRepository.findAll();

	}
	
	public Usuario findById(Long id) {
		
		Optional<Usuario> usuario =  usuarioRepository.findById(id);	
		return usuario.orElseThrow(() -> new ResourceNotFoundException(id));
		
	}

	public Usuario inserir(Usuario usuario) {

		try {
			
			return usuarioRepository.save(usuario);
		
		}catch (DataIntegrityViolationException e) {
			
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Usuario converteDto (UsuarioDto usuarioDto) {
		
		 return new Usuario(usuarioDto.getId(), usuarioDto.getNome(), usuarioDto.getCpf(), usuarioDto.getEmail(), usuarioDto.getDataNascimento());
		
	}
	
	
}
