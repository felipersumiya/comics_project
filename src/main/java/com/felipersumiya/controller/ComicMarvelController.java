package com.felipersumiya.controller;

import java.util.List;

import org.hibernate.loader.custom.CollectionFetchReturn;
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
import com.felipersumiya.services.ComicsService;


@RestController
@RequestMapping (value="/comics_marvel")
public class ComicMarvelController {
	
	//Atributo utilizado para a chamado o serviço externo. Utiliza o Spring Cloud Feign e chama a API da Marvel. 
	@Autowired
	private ComicMarvelService service;
	//Atributo que referencia a classe de serviços dos Comics.
	@Autowired
	private ComicsService comicService;

	
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
	
	@GetMapping (value = "/comicsList")
	public ResponseEntity<List<Comics>> buscarComics(){
		
		List<Comics> listComics;
		
		listComics = comicService.buscarLivrosBanco();
		

		for(Comics x : listComics) {
			
			System.out.println("*****Retorno que deve estar certo*** ---- Como está a lista de autores vinda do banco");
			System.out.println("Agora veremos se a lista está correta para ser inserida no banco");
			System.out.println("Título");
			System.out.println(x.getTitulo());
			System.out.println("número de autores");
			System.out.println(x.getAutores().size());
			
			for (Autor nome : x.getAutores()) {
				System.out.println("Autor:");
				System.out.println(nome.getNome());
			}
			//System.out.println("Autor:");
			//System.out.println(x.getAutores().get(0).getNome());
			
			
		}
		
		return ResponseEntity.ok().body(listComics);
		//return listaComics != null ? ResponseEntity.ok().body(listaComics) : ResponseEntity.notFound().build(); 
	}
	
}

