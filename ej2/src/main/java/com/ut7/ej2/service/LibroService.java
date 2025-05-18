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

    // Listar todos los libros

    public List<Libro> getAllLibros() {
        return libroRepository.findAll();
    }

    // Buscar libro por ID

    public Optional<Libro> getLibroById(Long id) {
        return libroRepository.findById(id);
    }

    // Guardar libro

    public Libro saveLibro(Libro libro) {
        return libroRepository.save(libro);
    }

    // Eliminar libro por ID

    public void deleteLibro(Long id) {
        libroRepository.deleteById(id);
    }

    // Actualizar libro 

    public void updateLibro(Long id, Libro libro) {
        libro.setId(id);
        libroRepository.save(libro);
    }
    
    public Libro crearLibro(Libro libro) {
        // Vincula el libro a un autor si existe, si no, lo deja en null
        if (libro.getAutor() != null && libro.getAutor().getId() != null) {
            Autor autor = autorRepository.findById(libro.getAutor().getId()).orElse(null);
            libro.setAutor(autor);
        } else {
            libro.setAutor(null);
        }
        return libroRepository.save(libro);// Crear nuevo libro
    }

}
