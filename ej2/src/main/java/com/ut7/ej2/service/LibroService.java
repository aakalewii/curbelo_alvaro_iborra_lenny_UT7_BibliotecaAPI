package com.ut7.ej2.service;

import com.ut7.ej2.model.Libro;
import com.ut7.ej2.repository.LibroRepository;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
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
}
