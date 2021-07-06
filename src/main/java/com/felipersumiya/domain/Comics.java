package com.felipersumiya.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.felipersumiya.dto.ComicsDto;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table (name ="tb_comics")
public class Comics implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue (strategy  = GenerationType.IDENTITY)
	private Long id;
	private String titulo;
	private String isbn;
	private String descricao;
	private Double preco;
	private String diaDesconto;
	private boolean descontoAtivo;
	

	@OneToMany (mappedBy = "comic")
	private List<Autor> autores = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Comics() {
		
	}

	public Comics(Long id, String titulo, String isbn, String descricao, Double preco) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.isbn = isbn;
		this.descricao = descricao;
		this.preco = preco;

	}
	
	public Comics (ComicsDto comicsDto) {
		this.id = comicsDto.getId();
		this.titulo = comicsDto.getTitulo();
		this.isbn = comicsDto.getIsbn();
		this.descricao = comicsDto.getDescricao();
		this.preco = comicsDto.getPreco();

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

	public List<Autor> getAutores() {
		return autores;
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
	

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comics other = (Comics) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
