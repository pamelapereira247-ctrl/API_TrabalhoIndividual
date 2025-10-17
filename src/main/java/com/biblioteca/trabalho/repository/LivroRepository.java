package com.biblioteca.trabalho.repository;

import com.biblioteca.trabalho.entity.Livro; 
import org.springframework.data.jpa.repository.JpaRepository; 

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}