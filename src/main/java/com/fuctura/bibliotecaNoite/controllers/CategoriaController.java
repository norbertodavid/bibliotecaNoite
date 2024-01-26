package com.fuctura.bibliotecaNoite.controllers;

import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired  //Instacia
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

    @GetMapping
    public List<Categoria> findAll() {
        List<Categoria> list = categoriaSevirce.findAll();
        return list;
    }

    @PostMapping
    public Categoria save(@RequestBody Categoria categoria) {
        Categoria cat = categoriaSevirce.save(categoria);
        return cat;
    }

}
