package com.ut7.ej2.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ut7.ej2.model.Libro;
import com.ut7.ej2.service.LibroService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/v1/libros")
public class LibroController {


    private final LibroService libroService;

    

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

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

    @GetMapping("/buscar")
    public ResponseEntity<List<Libro>> search(
            @RequestParam(value = "titulo", required = false) String titulo,
            @RequestParam(value = "anio", required = false) Integer anio,
            @RequestParam(value = "sortBy", defaultValue = "id") String sortBy,
            @RequestParam(value = "order", defaultValue = "asc") String order
    ) {
            Sort.Direction dir = order.equalsIgnoreCase("desc")
            ? Sort.Direction.DESC
            : Sort.Direction.ASC;    

            Sort sort = Sort.by(dir, sortBy);

            List<Libro> resultados = libroService.buscarLibros(titulo, anio, sort);
            return ResponseEntity.ok(resultados);

    }
    
}