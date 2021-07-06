package com.felipersumiya.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.Usuario;
import com.felipersumiya.repositories.ComicsRepository;
import com.felipersumiya.repositories.UsuarioRepository;


@Service
public class UsuarioComicsService {
	
	@Autowired
	private ComicsRepository comicsRepository;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	

	public void inserirComicUsuario(Long idUsuario, Comics comic) {
		
		Usuario usuario = new Usuario();
		Comics comicBd = new Comics();
		
		try {
				
			usuario = usuarioRepository.getById(idUsuario);
			comicBd = comicsRepository.getById(comic.getId());
			
			//salvar comic em usuario.
			//necessário verificar se já possui este livro antes de adicionar
			
		
			if(comicBd.getUsuario() == null) {
				
				//livro disponível para ser cadastrado com usuario//adiciona as relações
				
				usuario.getComics().add(comicBd);
				comicBd.setUsuario(usuario);
				
				comicsRepository.save(comicBd);   //salva no banco o objeto populado com o Usuario
				usuarioRepository.save(usuario);
				
			}
			
		
		}catch (Exception e) {
				
				e.printStackTrace();
		}
		

		
	}
	
	
}

