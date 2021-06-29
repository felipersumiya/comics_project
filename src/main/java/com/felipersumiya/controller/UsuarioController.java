package com.felipersumiya.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.felipersumiya.domain.Usuario;
import com.felipersumiya.services.UsuarioService;



@RestController
@RequestMapping (value="/usuarios")
public class UsuarioController {
	
	
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll(){
		
		List<Usuario> list = usuarioService.findAll();

		return ResponseEntity.ok().body(list);		
	}
	
	/**@GetMapping (value = "/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id ){
		
		User obj = userService.findById(id);
		
		return ResponseEntity.ok().body(obj);
	}**/
	
	
	@PostMapping
	public ResponseEntity<Void> insereUsuario( @RequestBody Usuario usuario){
			
		usuarioService.inserir(usuario);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("{/id}").buildAndExpand(usuario.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	/*@PostMapping
	public ResponseEntity<Void> insertDTO( @RequestBody ClienteDto clienteDto){
		
		Cliente cliente = clienteService.fromDTO(clienteDto);
		clienteService.insert(cliente);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clienteDto.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}*/
	

}
