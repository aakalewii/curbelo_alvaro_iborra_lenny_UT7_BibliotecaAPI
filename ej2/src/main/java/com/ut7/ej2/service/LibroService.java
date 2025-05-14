package com.ut7.ej2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ut7.ej2.model.Autor;
import com.ut7.ej2.model.Libro;
import com.ut7.ej2.repository.AutorRepository;
import com.ut7.ej2.repository.LibroRepository;

@Service
public class LibroService {
    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
    }

    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    public Optional<Libro> getLibroById(Long id) {
        return libroRepository.findById(id);
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    public void updateLibro(Long id, Libro libro) {
        libro.setId(id);
        libroRepository.save(libro);
    }
    
    public Libro crearLibro(Libro libro) {
        if (libro.getAutor() != null && libro.getAutor().getId() != null) {
            Autor autor = autorRepository.findById(libro.getAutor().getId())
                    .orElseThrow(() -> new RuntimeException("Autor no encontrado"));
            libro.setAutor(autor);
        } else {
            libro.setAutor(null);
        }
        return libroRepository.save(libro);
    }

}
