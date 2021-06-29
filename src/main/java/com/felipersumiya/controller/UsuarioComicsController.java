package com.felipersumiya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping (value="/usuario_comics")
public class UsuarioComicsController {
	

	@Autowired
	private UsuarioComicsService usuarioComicsService;
	
	@Autowired
	private ComicsService comicsService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	//criar método adicionar livros para um usuário @post
	
	/*
	 	@PutMapping (value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User obj){ 
	 * 
	 * 
		obj = userService.update(id, obj);
		return ResponseEntity.ok().body(obj);
	 * 
	 
	 */
	
	@PutMapping (value = "/{id}")
	public ResponseEntity<Usuario> insereComicUser (@PathVariable Long id, @RequestBody ComicsDto comicDto){
	
		Comics comic = comicsService.converteDto(comicDto);
		Usuario  usuario  = new Usuario();
		System.out.println("$$$$$$$$entrou aqui");
		usuarioComicsService.inserComicUsuario(id, comic);
		System.out.println("$$$ aqui tbm");
		usuario = usuarioService.findById(id);
		
		System.out.println("Dados usuario");
		System.out.println("id");
		System.out.println(usuario.getId());
		System.out.println("nome");
		System.out.println(usuario.getNome());
		System.out.println("%%%%% e aqui?'");
		System.out.println("%%%%% e aqui?'");
		return ResponseEntity.ok().body(usuario);
	

	}
	
	

}
