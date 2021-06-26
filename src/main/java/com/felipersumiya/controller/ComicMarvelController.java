package com.felipersumiya.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.felipersumiya.cloud.ComicMarvelService;
import com.felipersumiya.domain.json.ComicJson;


@RestController
@RequestMapping (value="/comics_marvel")
public class ComicMarvelController {
	
		
	@Autowired
	private ComicMarvelService service;

	@GetMapping
	public ResponseEntity<ComicJson> findAll() throws JsonMappingException, JsonProcessingException {

		ComicJson comics = service.buscaComics();
		System.out.println(comics.toString());
		System.out.println("code:");
		System.out.println(comics.getCode());
		System.out.println("offset:");
		System.out.println(comics.getData().getOffset());
		System.out.println("id:");
		System.out.println(comics.getData().getResults().get(0).getId());
        return comics != null ? ResponseEntity.ok().body(comics) : ResponseEntity.notFound().build(); 
	}			
}
