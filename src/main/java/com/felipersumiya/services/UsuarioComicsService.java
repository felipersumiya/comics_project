package com.felipersumiya.services;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipersumiya.domain.Autor;
import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.Usuario;
import com.felipersumiya.domain.json.ComicJson;
import com.felipersumiya.domain.json.Items;
import com.felipersumiya.domain.json.Results;
import com.felipersumiya.dto.ComicsDto;
import com.felipersumiya.repositories.AutorRepository;
import com.felipersumiya.repositories.ComicsRepository;
import com.felipersumiya.repositories.UsuarioRepository;


@Service
public class UsuarioComicsService {
	
	@Autowired
	private ComicsRepository comicsRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	public void inserComicUsuario(Long idUsuario, Comics comic) {
		
		//Comics comic = new Comics();
		Usuario usuario = new Usuario();
		Comics comicBd = new Comics();
		
		try {
				
			usuario = usuarioRepository.getById(idUsuario);
			comicBd = comicsRepository.getById(comic.getId());
			//salvar comic em usuario.
			//necessário verificar se já possui este livro antes de adicionar
			
			//alterarComicUsuario(comic, usuario);
			
			

			if(comicBd.getUsuario() == null) {
				
				//livro disponivel para ser cadastrado com usuario//adiciona as relações
				
				usuario.getComics().add(comicBd);
				comicBd.setUsuario(usuario);
				
				comicsRepository.save(comicBd);   //salva no banco o objeto populado con o Usuario
				usuarioRepository.save(usuario);
				
			}
			
		
		}catch (Exception e) {
				
				e.printStackTrace();
		}
		

		
	}
	
	
}

