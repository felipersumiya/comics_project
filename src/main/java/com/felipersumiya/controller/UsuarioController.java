package com.felipersumiya.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipersumiya.domain.Usuario;
import com.felipersumiya.dto.UsuarioDto;
import com.felipersumiya.services.UsuarioService;



@RestController
@RequestMapping (value="/usuarios")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<UsuarioDto>> buscarUsuarios(){
		
		List<Usuario> lista = usuarioService.findAll();
		List<UsuarioDto> listaDto = lista.stream().map( x -> new UsuarioDto(x)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listaDto);		
	}
	
	@GetMapping (value = "/{id}")
	public ResponseEntity<UsuarioDto> findById(@PathVariable Long id ){
		
		
		Usuario usuario = usuarioService.findById(id);
				
		
		return ResponseEntity.ok().body(new UsuarioDto(usuario));
	}
	
	@PostMapping
	public ResponseEntity<Void> insereUsuarioDTO( @RequestBody UsuarioDto usuarioDto){
			
		Usuario usuario = usuarioService.converteDto(usuarioDto); 
		usuarioService.inserir(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(usuarioDto.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
			
		}
	
	
	// criar método mostra a lista de livros para um Usuário @GetMappinh
	
	
	
	
	
	
	//criar método adicionar livros para um usuário @post
	/**@PostMapping
	public ResponseEntity<Void> insereComicUser (@RequestBody UsuarioDto usuarioDto, ComicsDto comicDto){
	
	
	Usuario usuario = usuarioService.converteDto(usuarioDto);
	List<Comics> listaComics = listComicDto.stream().map(x -> new Comics(x)).collect(Collectors.toList());
	
	//chame o método aqui
	
	return ResponseEntity.ok().build();
	

	}**/
	
}
