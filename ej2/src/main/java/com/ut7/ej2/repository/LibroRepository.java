package com.ut7.ej2.repository;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.ut7.ej2.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> { 
    List<Libro> findByTituloContainingIgnoreCase(String titulo, Sort sort);
    List<Libro> findByAnioPublicacion(int anioPublicacion, Sort sort);
    List<Libro> findByTituloContainingIgnoreCaseAndAnioPublicacion(String titulo, int anioPublicacion, Sort sort);
    List<Libro> findAll(Sort sort);
}


