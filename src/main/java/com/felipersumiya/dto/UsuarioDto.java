package com.felipersumiya.dto;

import java.util.ArrayList;
import java.util.List;


import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.Usuario;


public class UsuarioDto {
	
	private Long id;
	private String nome;
	private String cpf;
	private String email;
	private String dataNascimento;
	private List<Comics> comics = new ArrayList<>();
	
	
	
	public UsuarioDto() {
		
	}
	
	public UsuarioDto(Usuario usuario) {

		id = usuario.getId();
		nome = usuario.getNome();
		cpf = usuario.getCpf();
		email = usuario.getEmail();
		dataNascimento = usuario.getDataNascimento();
		comics= usuario.getComics();
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public List<Comics> getComics() {
		return comics;
	}

	
}
