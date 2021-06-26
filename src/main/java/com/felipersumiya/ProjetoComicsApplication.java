package com.felipersumiya;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients
public class ProjetoComicsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoComicsApplication.class, args);
	}

}
