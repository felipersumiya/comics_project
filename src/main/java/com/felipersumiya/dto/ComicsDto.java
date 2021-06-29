package com.felipersumiya.dto;

import java.util.ArrayList;
import java.util.List;

import com.felipersumiya.domain.Autor;
import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.Usuario;

public class ComicsDto {
	
	private Long id;
	private String titulo;
	private String isbn;
	private String descricao;
	private Double preco;
	private String diaDesconto;
	private boolean descontoAtivo;
	
	private List<Autor> autores = new ArrayList<>();

	private Usuario usuario;
	
	public ComicsDto() {
		
	}
	
	public  ComicsDto (Comics comics) {
		
		id= comics.getId();
		titulo = comics.getTitulo();
		isbn = comics.getIsbn();
		descricao = comics.getDescricao();
		preco = comics.getPreco();
		diaDesconto = comics.getDiaDesconto();
		descontoAtivo = comics.isDescontoAtivo();
		autores = comics.getAutores();
		usuario = comics.getUsuario();
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public String getDiaDesconto() {
		return diaDesconto;
	}

	public void setDiaDesconto(String diaDesconto) {
		this.diaDesconto = diaDesconto;
	}

	public boolean isDescontoAtivo() {
		return descontoAtivo;
	}

	public void setDescontoAtivo(boolean descontoAtivo) {
		this.descontoAtivo = descontoAtivo;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
	
	

}
