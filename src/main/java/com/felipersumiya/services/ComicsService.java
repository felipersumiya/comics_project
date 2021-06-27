package com.felipersumiya.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.json.ComicJson;
import com.felipersumiya.domain.json.Items;
import com.felipersumiya.domain.json.Results;
import com.felipersumiya.repositories.ComicsRepository;

@Service
public class ComicsService {
	
	@Autowired
	private ComicsRepository comicRepository;
	
	//inserir os livros (Comics) no banco de dados.
	public void inserirComics(ComicJson comicJson) {
		
		//insere a lista de livros obtida através do serviço externo
		List<Results> listLivrosMarvel = comicJson.getData().getResults();
		
		for (Results x: listLivrosMarvel) {
			
			System.out.println("Primeiro teste");
			System.out.println("titulo:");
			System.out.println(x.getTitle());
		}
		
		
		//lista que irei salvar no banco
		List<Comics> listComics = new ArrayList<>();
		
		
		for(Results x : listLivrosMarvel) {
			
			Comics comics = new Comics();
			List<Items> autores = new ArrayList<>();
			comics.setId( Long.valueOf(x.getId()));
			comics.setTitulo(x.getTitle());
			comics.setIsbn(x.getIsbn());
			comics.setPreco(x.getPrices().get(0).getPrice());
			comics.setAutores(x.getCreators().getItems());
			
			listComics.add(comics);
		}
		
		for(Comics x : listComics) {
			
			System.out.println("Agora veremos se a lista está correta para ser inserida no banco");
			System.out.println("Título");
			System.out.println(x.getTitulo());
			System.out.println("número de autores");
			System.out.println(x.getAutores().size());
			
		
			
		}
	}

}
