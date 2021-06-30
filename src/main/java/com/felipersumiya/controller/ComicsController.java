package com.felipersumiya.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.felipersumiya.cloud.ComicMarvelService;
import com.felipersumiya.domain.Autor;
import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.json.ComicJson;
import com.felipersumiya.dto.ComicsDto;
import com.felipersumiya.services.ComicsService;



@RestController
@RequestMapping (value="/comics_marvel")
public class ComicsController {
	
	//Atributo utilizado para a chamado o serviço externo. Utiliza o Spring Cloud Feign e chama a API da Marvel. 
	@Autowired
	private ComicMarvelService service;
	//Atributo que referencia a classe de serviços dos Comics.
	@Autowired
	private ComicsService comicService;

	// Será um método Post e irá inserios os dados da API Marvel no banco de dados da aplicação.
	@GetMapping
	public ResponseEntity<ComicJson> cadastrarComics() throws JsonMappingException, JsonProcessingException {

		//Traz o Json com os comics da API da marvel e converte para nossa classe ComicJson.
		//Obtém através do Spring Cloud Feign
		ComicJson comics = service.buscaComics();
		List<Comics> listaComics;
		//Cadastra os comics no banco de dados.
		comicService.inserirComics(comics);	
		
		//Retorna a lista de livros que foi inserida no banco de dados
		//listaComics = comicService.buscarLivrosBanco();
		
		//return listaComics != null ? ResponseEntity.ok().body(listaComics) : ResponseEntity.notFound().build(); 
		
        return comics != null ? ResponseEntity.ok().body(comics) : ResponseEntity.notFound().build(); 
	}	
	//Modificar este mara trazer lista com o iD de usuário.
	@GetMapping (value = "/comicsList")
	public ResponseEntity<List<ComicsDto>> buscarComics(){
		
	
		
		List<Comics> listComics = comicService.buscarLivrosBanco();
		List<ComicsDto> listDto = listComics.stream().map(x -> new ComicsDto(x)).collect(Collectors.toList());
		
		
		return ResponseEntity.ok().body(listDto);
		
	}
		
}

