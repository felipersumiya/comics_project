package com.felipersumiya.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.felipersumiya.domain.Comics;

public interface ComicsRepository extends JpaRepository<Comics, Long>{
	
}
