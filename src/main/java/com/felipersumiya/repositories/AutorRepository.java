package com.felipersumiya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipersumiya.domain.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{
	
}
