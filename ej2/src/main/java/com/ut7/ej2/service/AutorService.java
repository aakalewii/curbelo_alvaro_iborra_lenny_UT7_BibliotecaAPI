package com.ut7.ej2.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ut7.ej2.model.Autor;
import com.ut7.ej2.repository.AutorRepository;

@Service
public class AutorService {

    @Autowired
    private AutorRepository autorRepository;

    // Listar todos los autores

    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    // Buscar autor por ID

    public Optional<Autor> getAutorById(Long id) {
        return autorRepository.findById(id);
    }

    // Crear nuevo autor

    public Autor crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }
}