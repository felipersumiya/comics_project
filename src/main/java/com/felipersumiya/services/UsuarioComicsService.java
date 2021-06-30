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
			
			System.out.println("*********Início");
			usuario = usuarioRepository.getById(idUsuario);
			System.out.println("****obteve o objeto usuario do banco");
			comicBd = comicsRepository.getById(comic.getId());
			//salvar comic em usuario.
			//necessário verificar se já possui este livro antes de adicionar
			
			//alterarComicUsuario(comic, usuario);
			
			

			if(comicBd.getUsuario() == null) {
				
				//livro disponivel para ser cadastrado com usuario//adiciona as relações
				usuario.getComics().add(comicBd);
				comicBd.setUsuario(usuario);
				//alteraDadosUsuario(comicBd, comicNew, usuario);//passa os dados do objeto novo para o objeto BD
				comicsRepository.save(comicBd);//salva no banco o objeto populado con o Usuario
				usuarioRepository.save(usuario);
				
			}
			
			/***
			
			usuario.getComics().add(comic);
			usuarioRepository.save(usuario);
			//necessario fazer a comunicação com o ComicService.
			
			//este método que incluirá e irá verificar se o comic já não possui um usuário existente
			alterarComicUsuario(comic, usuario);
			
		//	comic.setUsuario(usuario);
			//comicsRepository.save(comic);
		
		**/
		
		}catch (Exception e) {
				
				e.printStackTrace();
		}
		

		
	}
	

	/*public void alterarComicUsuario(Comics comicNew, Usuario usuario) {
		// aqui Coloquei alterar em vez de inserir porque o livro já existe no BD.
		//Não poderá ser incluso novos livros e nem alterar informações importantes, apenas o usuario.
		try {
		Comics comicBd = comicsRepository.getById(comicNew.getId());//recupera o Comic do BD, caso haja.
		
		if(comicBd.getUsuario() == null) {
			
			//livro disponivel para ser cadastrado com usuario
			usuario.getComics().add(comicBd);
			comicBd.setUsuario(usuario);
			alteraDadosUsuario(comicBd, comicNew, usuario);//passa os dados do objeto novo para o objeto BD
			comicsRepository.save(comicBd);//salva no banco o objeto populado con o Usuario
			usuarioRepository.save(usuario);
			
		}
		
		//***Este livro não está disponível, pois já está vinculado a outro usuário.
		
	
		
		}catch (Exception e) {
			
			//caso não encontre o objeto Comic no banco
			//ID inconsistente
			e.printStackTrace();
		}
				// recupera o comic do banco
				//compara para ver se é o mesmo e se possui algum id de usuario
				//Se possuir. inserir(updata) usuario em Comic
				//Inserir Comic em usuario
				
	}
	
	public void alteraDadosUsuario (Comics comicBd , Comics comicsNew, Usuario usuario) {//Com a premissa de que exista o atributo usuário .
		
		comicBd.setTitulo(comicsNew.getTitulo());
		comicBd.setIsbn(comicsNew.getIsbn());
		comicBd.setDescricao(comicsNew.getDescricao());
		comicBd.setPreco(comicsNew.getPreco());
		comicBd.setUsuario(comicsNew.getUsuario());
		
	}*/
		

}

