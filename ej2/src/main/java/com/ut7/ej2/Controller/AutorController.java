package com.ut7.ej2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ut7.ej2.model.Autor;
import com.ut7.ej2.repository.AutorRepository;

@RestController
@RequestMapping("/v1/autores")
public class AutorController {


    private AutorRepository autorRepository;

    // Listar autores
    @GetMapping
    public List<Autor> getAllAutores() {
        return autorRepository.findAll();
    }

    // Ver autor con sus libros
    @GetMapping("/{id}")
    public Optional<Autor> getAutorById(@PathVariable Long id) {
        return autorRepository.findById(id);
    }

    // Crear nuevo autor
    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorRepository.save(autor);
    }
}

//prueba klk