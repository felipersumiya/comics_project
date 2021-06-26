package com.felipersumiya.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.felipersumiya.domain.Usuario;
import com.felipersumiya.repositories.UsuarioRepository;


@Configuration
@Profile ("test")
public class TesteConfig implements CommandLineRunner {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public void run(String... args) throws Exception {
	
		Usuario u1 = new Usuario(null, "Jill", "345.345.345-23", "teste1@teste", "20/02/2019");
		Usuario u2 = new Usuario(null, "João", "345.545.345-23", "teste2@teste", "21/02/2019");
		Usuario u3 = new Usuario(null, "Maria", "345.345.555-23", "teste3@teste", "22/02/2019");
		Usuario u4 = new Usuario(null, "Leandro", "345.345.945-23", "teste4@teste", "23/02/2019");
		
		
		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
	
		
	
	
		
	}

}
