package com.felipersumiya.dto;

import com.felipersumiya.domain.Autor;
import com.felipersumiya.domain.Comics;

public class AutorDto {
	
	private Long id;
	private String nome;
	private Comics comic;
	
	
	public AutorDto() {
	
	}
	
	public AutorDto (Autor autor) {
		id = autor.getId();
		nome = autor.getNome();
		comic = autor.getComic();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Comics getComic() {
		return comic;
	}


	public void setComic(Comics comic) {
		this.comic = comic;
	}
	
	
}
