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


@Service
public class ComicsService {
	
	@Autowired
	private ComicsRepository comicRepository;
	
	@Autowired 
	private AutorRepository autorRepository;
	
	private final static String DOMINGO = "domingo";
	private final static String SEGUNDA = "segunda-feira";
	private final static String TERCA = "terça-feira";
	private final static String QUARTA = "quarta-feira";
	private final static String QUINTA = "quinta-feira";
	private final static String SEXTA = "sexta-feira";
	private final static String SABADO = "sábado";
	private final static String DESC_INATIVO = "Não possui desconto.";
	private final static String DIA_INEXISTENTE = "Dia inexistente";
	private final static String INDISPONIVEL = "Indisponível";
	
	private final static char ZERO = '0';
	private final static char UM = '1';
	private final static char DOIS = '2';
	private final static char TRES = '3';
	private final static char QUATRO = '4';
	private final static char CINCO = '5';
	private final static char SEIS = '6';
	private final static char SETE = '7';
	private final static char OITO = '8';
	private final static char NOVE = '9';
	
	
	
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
			autores = convertList(itens);//converte a lista de Items(obtida na API da Marvel) para a o tipo <Autor>. Presente em nosso modelo de dados.
	
			System.out.println("converteu lista");
			comics.setDescricao(y.getDescription() != null ? y.getDescription().substring(0, 100) : "Indisponível");
			comics.setTitulo(y.getTitle());
			comics.setIsbn(y.getIsbn().isEmpty() ? "Indisponível" : y.getIsbn());
			comics.setPreco(y.getPrices().get(0).getPrice());
		
			/***********************************************************************************
			////Inicio do bloco para separação. Deve ser colocado no endpoint que devolve a lista de comic depoiis de já inserida no banco de dados.
			
			//setando novo atributo
			comics.setDiaDesconto(ComicsService.definirDiaDesconto(comics.getIsbn()));
			
			//setando desconto ativo
			comics.setDescontoAtivo(ComicsService.definirDescontoAtivo(comics.getDiaDesconto()));
			
			//verificar se o preço do livro será com desconto
			if (comics.isDescontoAtivo() == true) {
				//somente desconta o valor caso seja o dia de desconto
				comics.setPreco(ComicsService.aplicaDesconto(comics.getPreco()));
			}
			
			//Fim do BLOCO///////////////////////////////////////////////////////////////
			/*************************************************************************************/
	
			//Popula a lista de autores no objeto comics.
			for(Autor autor : autores) {
			comics.getAutores().add(autor);//adiciona autor em comics.
			autor.setComic(comics);//relaciona cada autor a um comic(livro.)Na classe de autores.
			
			}
		
			listComics.add(comics);// adiciona cada livro na lista de Comics
			
			//Salva a lista de autores obtidos através da API da Marvel no banco de dados.
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
		
			
		}
		
		//Salva os livros obtidos através da API no nosso banco de dados.
		comicRepository.saveAll(listComics);
	}
	
	public List<Autor> convertList(List<Items> listI){
		
			System.out.println("metodo que converte--inicio");
			Autor a = new Autor();
			List<Autor> listA = new ArrayList<>();
			
			if(listI.isEmpty()) {
				
				System.out.println("Entrou na lista vazia");
				a.setNome("Indisponível");
				listA.add(a);
				
				for(Items x : listI) {
					
					System.out.println("Entrou na lista vazia");
					a.setNome("Indisponível");
					listA.add(a);
					
				}
			}
			
			for(Items x : listI) {
				
				Autor autor2= new Autor();
				autor2.setNome(x.getName());
				listA.add(autor2);
				
			}	
			
			return listA;
	}
	
	
	//traz todos os livros cadastrados no banco de dados
	//****TALVEz modificar este método e deixar somente trazer os livros do banco, sem considerar os descontos.
	public List<Comics> buscarLivrosBanco(){
		
		//O novo bloc deve ser colocado aqui
		List<Comics> listaComics =  comicRepository.findAll();
		
		

		for(Comics x : listaComics) {

			
			//setando novo atributo
			x.setDiaDesconto(ComicsService.definirDiaDesconto(x.getIsbn()));
			
			//setando desconto ativo
			x.setDescontoAtivo(ComicsService.definirDescontoAtivo(x.getDiaDesconto()));
			
			//verificar se o preço do livro será com desconto
			if (x.isDescontoAtivo() == true) {
				//somente desconta o valor caso seja o dia de desconto
				x.setPreco(ComicsService.aplicaDesconto(x.getPreco()));
			}
			
		}
		comicRepository.saveAll(listaComics);
		
		return listaComics;
		
	}
	
	//Realizar a aplicação do desconto APENAS quando escolher para lista para um USUÁRIO ESPECÌFCO
	
	
	public static String definirDiaDesconto(String isbn) {
		
		char ultimoDig;
		String diaDescontoAtivo= DESC_INATIVO;
		
		if(isbn != INDISPONIVEL) {
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ ENTROU$$$$");
			ultimoDig = isbn.charAt(isbn.length() - 1);
			System.out.println("VALOR##############ULTIMO DIG:");
			System.out.println(ultimoDig);
		
			if(ultimoDig == ZERO || ultimoDig == UM ) {
			
				diaDescontoAtivo = SEGUNDA;
			}
		
			if(ultimoDig == DOIS || ultimoDig == TRES ) {
			
				diaDescontoAtivo = TERCA;
			}
		
			if(ultimoDig == QUATRO || ultimoDig == CINCO ) {
			
				diaDescontoAtivo = QUARTA;
			}
	
			if(ultimoDig == SEIS || ultimoDig == SETE ) {
		
				diaDescontoAtivo = QUINTA;
			}
	
			if(ultimoDig == OITO || ultimoDig == NOVE ) {
		
				diaDescontoAtivo = SEXTA;
			}
		
		}
		
		return diaDescontoAtivo;			
	}	
	
	
	public static boolean definirDescontoAtivo(String diaDescontoIsbn) {
		
		GregorianCalendar gcalendar = new GregorianCalendar();
		int diaSemanaN;
		String diaSemana;
		diaSemanaN = gcalendar.get(gcalendar.DAY_OF_WEEK);	
		diaSemana = converteDiaSemana(diaSemanaN);
		
		
		if (diaSemana == diaDescontoIsbn) {
			
			return true;
			
		}
		
		
		
		return false;
	}
	
	public static String converteDiaSemana(int dia) {
		
		if (dia == 1){
			
			return DOMINGO;
					
		}
		
		if (dia == 2){
			
			return SEGUNDA;
					
		}
		
		if (dia == 3){
			
			return TERCA;
					
		}
		
		if (dia == 4){
			
			return QUARTA;
					
		}
		
		if (dia == 5){
			
			return QUINTA;
					
		}
		
		if (dia == 6){
			
			return SEXTA;
					
		}
		
		if (dia == 7){
			return DOMINGO;
					
		}
		
		
		return DIA_INEXISTENTE;
	}
	
	public static Double aplicaDesconto(Double preco) {
		
		return preco = preco * 0.9;
		
	}
	
	public Comics converteDto (ComicsDto comicDto) {
		
		return new Comics(comicDto.getId(), comicDto.getTitulo(),comicDto.getIsbn(), comicDto.getDescricao(), comicDto.getPreco());
	
	}
	
	public void alterarComicUsuario(Comics comicNew, Usuario usuario) {
		// aqui Coloquei alterar em vez de inserir porque o livro já existe no BD.
		//Não poderá ser incluso novos livros e nem alterar informações importantes, apenas o usuario.
		try {
		Comics comicBd = comicRepository.getById(comicNew.getId());//recupera o Comic do BD, caso haja.
		
		if(comicBd.getUsuario() == null) {
			
			//livro disponivel para ser cadastrado com usuario
			comicBd.setUsuario(usuario);
			alteraDadosUsuario(comicBd, comicNew, usuario);//passa os dados do objeto novo para o objeto BD
			comicRepository.save(comicBd);//salva no banco o objeto populado con o Usuario
			
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
		
	}
			
}


