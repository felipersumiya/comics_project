package com.felipersumiya.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipersumiya.domain.Autor;
import com.felipersumiya.domain.Comics;
import com.felipersumiya.domain.Usuario;
import com.felipersumiya.repositories.AutorRepository;
import com.felipersumiya.repositories.ComicsRepository;
import com.felipersumiya.repositories.UsuarioRepository;


@Configuration
@Profile ("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private ComicsRepository comicsRepository;
	
	@Autowired
	private AutorRepository autorRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		Usuario u1 = new Usuario(null, "Jill", "345.345.345-23", "teste1@teste", "20/02/2019");
		Usuario u2 = new Usuario(null, "João", "345.545.345-23", "teste2@teste", "21/02/2019");
		Usuario u3 = new Usuario(null, "Maria", "345.345.555-23", "teste3@teste", "22/02/2019");
		Usuario u4 = new Usuario(null, "Leandro", "345.345.945-23", "teste4@teste", "23/02/2019");
		

		Comics c3 = new Comics(null, "Resident Evil2", "4343", "Foda", 9.0);
		Comics c4 = new Comics(null, "Resident Evil3", "4343", "Foda", 9.0);
		Comics c5 = new Comics(null, "Resident Evil4", "4343", "Foda", 9.0);
		Comics c6 = new Comics(null, "Resident Evil5", "4343", "Foda", 9.0);
		Comics c7 = new Comics(null, "Resident Evil6", "4343", "Foda", 9.0);
		
		Autor a1 = new Autor("Hernandez");
		Autor a2 = new Autor("Fabio");
		Autor a3 = new Autor("rafael");
		Autor a5 = new Autor("Bruno");
		Autor a6 = new Autor("CAio");
		Autor a7 = new Autor("Felipe");
		
		/*c3.getAutores().add(a1);
		a1.getComics().add(c3);
		
		c4.getAutores().add(a2);
		a2.getComics().add(c4);
		
		c5.getAutores().add(a3);
		a3.getComics().add(c5);
		
		c6.getAutores().add(a5);
		a5.getComics().add(c6);
		
		c7.getAutores().add(a6);
		a6.getComics().add(c7);*/
		

		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
		//comicsRepository.saveAll(Arrays.asList(c3,c4,c5,c6,c7));
		//autorRepository.saveAll(Arrays.asList(a1,a2,a3,a5,a6));
	
	
		
	}

}
