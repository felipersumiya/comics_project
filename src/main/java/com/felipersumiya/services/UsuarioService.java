package com.felipersumiya.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipersumiya.domain.Usuario;
import com.felipersumiya.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {

		return usuarioRepository.findAll();

	}

	/**
	public User findById(Long id) {

		Optional<User> obj = userRepository.findById(id);

		return obj.orElseThrow(() -> new ResourceNotFoundException(id));

	}**/

	public Usuario inserir(Usuario usuario) {

		return usuarioRepository.save(usuario);

	}

}
