package com.felipersumiya.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.felipersumiya.domain.Autor;
import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.json.ComicJson;
import com.felipersumiya.domain.json.Items;
import com.felipersumiya.domain.json.Results;
import com.felipersumiya.repositories.AutorRepository;
import com.felipersumiya.repositories.ComicsRepository;


@Service
public class ComicsService {
	
	@Autowired
	private ComicsRepository comicRepository;
	
	@Autowired AutorRepository autorRepository;
	
	//inserir os livros (Comics) no banco de dados.
	public void inserirComics(ComicJson comicJson) {
		
		//insere a lista de livros obtida através do serviço externo
		List<Results> listLivrosMarvel = comicJson.getData().getResults();
		
		for (Results x: listLivrosMarvel) {
			
			System.out.println("Primeiro teste");
			System.out.println("titulo:");
			System.out.println(x.getTitle());
			
			
			for (Items nome1 : x.getCreators().getItems()) {
				System.out.println("############################## LOOK THERE######");
				System.out.println("Autor");
				System.out.println(nome1.getName());
				
			}
		}
		
		
		//lista que irei salvar no banco
		List<Comics> listComics = new ArrayList<>();
		
		
		for(Results y : listLivrosMarvel) {
			
			Comics comics = new Comics();
			List<Autor> autores = new ArrayList<>();
			System.out.println("passou aqui");
			List<Items> itens = y.getCreators().getItems();
			System.out.println("converteu lista");
			if(y.getCreators().getItems().isEmpty()) {
				System.out.println("entrou no if");
				
			}
			
			System.out.println("passou aqui");
			autores = convertList(itens);
			System.out.println("converteu lista");
			//comics.setId( Long.valueOf(y.getId()));
			comics.setDescricao(y.getDescription() != null ? y.getDescription().substring(0, 100) : "indefinido");
			comics.setTitulo(y.getTitle());
			comics.setIsbn(y.getIsbn());
			comics.setPreco(y.getPrices().get(0).getPrice());
			//conferir se aqui está sendo populado corretamente a lista de autores para cada comic
			
			
		//popular List<Autores>	
			for(Autor autor : autores) {
			comics.getAutores().add(autor);
			autor.setComic(comics);//adicion o comic no autor
			
			}
			//comics.getAutores().addAll(autores);//adiciona a lista de autores para cada Comic
	
	
			
			listComics.add(comics);// adiciona cada livro na lista de Comics
			
		
			
			//autores.get(0).setComic(comics);
			
			autorRepository.saveAll(autores);// adicona a lista de autores no banco de dados.
			
		}
		
		for(Comics x : listComics) {
			
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
		
		comicRepository.saveAll(listComics);
	}
	
	public List<Autor> convertList(List<Items> listI){
		
			System.out.println("metodo que converte--inicio");
			Autor a = new Autor();
			List<Autor> listA = new ArrayList<>();
			
			if(listI.isEmpty()) {
				
				System.out.println("Entrou na lista vazia");
				a.setNome("indefinido");
				listA.add(a);
				
				for(Items x : listI) {
					
					System.out.println("Entrou na lista vazia");
					a.setNome("indefinido");
					listA.add(a);
					
				}
			}
			
			for(Items x : listI) {
				
				Autor autor2= new Autor();
				autor2.setNome(x.getName());
				listA.add(autor2);
				
			}
			//listA.removeIf(null)
			
			return listA;
	}
	
	
	//traz todos os livros cadastrados no banco de dados
	public List<Comics> buscarLivrosBanco(){
		
		return comicRepository.findAll();
		
		
	}
	
	
	
}


