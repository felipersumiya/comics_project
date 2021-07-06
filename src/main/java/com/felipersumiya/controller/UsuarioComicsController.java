package com.felipersumiya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.Usuario;
import com.felipersumiya.dto.ComicsDto;
import com.felipersumiya.dto.UsuarioDto;
import com.felipersumiya.services.ComicsService;
import com.felipersumiya.services.UsuarioComicsService;
import com.felipersumiya.services.UsuarioService;

@RestController
@RequestMapping (value="/usuario-comics")
public class UsuarioComicsController {
	

	@Autowired
	private UsuarioComicsService usuarioComicsService;
	
	@Autowired
	private ComicsService comicsService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	//Permite o cadastro de Comic em usuário.

	@PutMapping (value = "/{id}")
	public ResponseEntity<UsuarioDto> insereComicUser (@PathVariable Long id, @RequestBody ComicsDto comicDto){
	
		Comics comic = comicsService.converteDto(comicDto);
		Usuario  usuario  = new Usuario();
		usuarioComicsService.inserirComicUsuario(id, comic);
		usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(new UsuarioDto(usuario));

	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<UsuarioDto> listaUsuarioComics(@PathVariable Long id ){
			
		Usuario usuario = usuarioService.findById(id);
				
		return ResponseEntity.ok().body(new UsuarioDto(usuario));
	}

}
