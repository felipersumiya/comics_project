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
	
		Usuario u1 = new Usuario(null, "Fernando Abreu", "355.222.332-20", "fabreu@gmail.com", "20/02/1980");
		Usuario u2 = new Usuario(null, "João Castelani", "345.346.300-19", "joao_castellani@gmail.com", "21/06/1989");
		Usuario u3 = new Usuario(null, "Rafael Cardoso", "379.345.200-50", "rcardoso89@gmail.com", "22/08/1978");
		Usuario u4 = new Usuario(null, "Leandro Vieira", "359.345.945-10", "lvieira86@gmail.com", "23/03/1999");

		usuarioRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
			
	}

}
