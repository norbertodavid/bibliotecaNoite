/*
package com.fuctura.bibliotecaNoite.controllers;


import com.fuctura.bibliotecaNoite.models.Livro;
import com.fuctura.bibliotecaNoite.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livro")
public class LivroController {

    @Autowired
    public LivroService livroservice;


    @GetMapping("/{id}") = buscar por id;
    @GetMapping = buscar por todos;
    @PostMapping = salvar um objeto;
    @PutMapping("/{id}") = alterar um objeto pelo id;
    @DeleteMapping("/{id}") = deletar um objeto pelo id;


    @GetMapping("/{id}")
    public Livro findById(PathVariable Long id) {
        Livro liv = livroservice.findById(id);
        return liv;
    }

}
*/