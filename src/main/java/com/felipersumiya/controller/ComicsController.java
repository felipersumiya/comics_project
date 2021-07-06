package com.felipersumiya.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.felipersumiya.cloud.ComicMarvelService;
import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.json.ComicJson;
import com.felipersumiya.dto.ComicsDto;
import com.felipersumiya.services.ComicsService;



@RestController
@RequestMapping (value="/comics-marvel")
public class ComicsController {
	
	//Atributo utilizado para a chamado o serviço externo. Utiliza o Spring Cloud Feign e chama a API da Marvel. 
	@Autowired
	private ComicMarvelService service;
	//Atributo que referencia a classe de serviços dos Comics.
	@Autowired
	private ComicsService comicService;

	/*Será um método Post e irá inserios os dados da API Marvel no banco de dados da aplicação.*/
	@PostMapping
	public ResponseEntity<Void> cadastrarComics() throws JsonMappingException, JsonProcessingException {

		/**Traz o Json com os comics da API da marvel e converte para nossa classe ComicJson.
		Obtém através do Spring Cloud Feign*/
		
		ComicJson comics = service.buscaComics();
		List<Comics> listaComics;
		/*Cadastra os comics no banco de dados.*/
		comicService.inserirComics(comics);	
		
       // return comics != null ? ResponseEntity.ok().body(comics) : ResponseEntity.notFound().build(); 
		//return ResponseEntity.created(uri).build();
		//verificar o status de retorno.
		return ResponseEntity.ok().build();
	}	
	
	@GetMapping (value = "/comicsList")
	public ResponseEntity<List<ComicsDto>> buscarComics(){
		
	
		
		List<Comics> listComics = comicService.buscarLivrosBanco();
		List<ComicsDto> listDto = listComics.stream().map(x -> new ComicsDto(x)).collect(Collectors.toList());
		
		
		return ResponseEntity.ok().body(listDto);
		
	}
	
	@GetMapping (value = "/comicsList/{id}")
	public ResponseEntity<ComicsDto> buscarComicsId(@PathVariable Long id){
		
		Comics comic = comicService.findById(id);
		
		return ResponseEntity.ok().body(new ComicsDto(comic));
		
	}
		
}

