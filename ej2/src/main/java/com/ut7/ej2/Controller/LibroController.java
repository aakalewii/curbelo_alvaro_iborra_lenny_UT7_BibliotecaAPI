package com.ut7.ej2.controller;

import com.ut7.ej2.model.Libro;
import com.ut7.ej2.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;


    // Obtener todos los libros
    @GetMapping
    public List<Libro> getAllLibros() {
        return libroService.getAllLibros();
    }

    // Obtener libro por id
    @GetMapping("/{id}")
    public Optional<Libro> getLibroById(@PathVariable Long id) {
        return libroService.getLibroById(id);
    }

    // Crear libro (vincular a autor)
    @PostMapping
    public Libro crearLibro(@RequestBody Libro libro) {
        return libroService.crearLibro(libro);
    }

    // Actualizar libro
    @PutMapping("/{id}")
    public void updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
        libroService.updateLibro(id, libro);
    }

    // Borrar libro
    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroService.deleteLibro(id);
    }
}