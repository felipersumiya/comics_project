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
			autores = convertList(y.getCreators().getItems());
			System.out.println("converteu lista");
			comics.setId( Long.valueOf(y.getId()));
			comics.setDescricao(y.getDescription() != null ? y.getDescription().substring(0, 100) : "indefinido");
			comics.setTitulo(y.getTitle());
			comics.setIsbn(y.getIsbn());
			comics.setPreco(y.getPrices().get(0).getPrice());
			comics.getAutores().addAll(autores);
			//comics.getAutores().add(y.getCreators().getItems());
			//comics.setAutores(y.getCreators().getItems());
			//comics.setAutores(y.getCreators().getItems().stream().map(x -> new List<>()).collect(Collectors.toList()));
			//comics.setAutores(x.getCreators().getItems());
		
			
			/**List<User> list = userService.findAll();
			
			List<UserDTO> listDto = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
			**/
			
			listComics.add(comics);
		}
		
		for(Comics x : listComics) {
			
			System.out.println("Agora veremos se a lista está correta para ser inserida no banco");
			System.out.println("Título");
			System.out.println(x.getTitulo());
			System.out.println("número de autores");
			System.out.println(x.getAutores().size());
			System.out.println("Autor:");
			System.out.println(x.getAutores().get(0).getNome());
			
			
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
				
				a.setNome(x.getName());
				listA.add(a);
				
			}
			
			return listA;
		}
	}


