package com.ut7.ej2.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ut7.ej2.service.LibroService;

@RestController
@RequestMapping("/v1/libros")
public class LibroController {

    @Autowired
    private LibroService libroService;

    

        
}