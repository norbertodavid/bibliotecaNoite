package com.fuctura.bibliotecaNoite.controllers;

import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    public CategoriaService categoriaSevirce;

    /*
    @GetMapping("/{id}") = buscar por id;
    @GetMapping = buscar por todos;
    @PostMapping = salvar um objeto;
    @PutMapping("/{id}") = alterar um objeto pelo id;
    @DeleteMapping("/{id}") = deletar um objeto pelo id;
    */

    @GetMapping("/{id}")
    public Categoria findById(@PathVariable Long id) {
        Categoria cat = categoriaSevirce.findById(id);
        return cat;
    }

}
