package com.fuctura.bibliotecaNoite.controllers;


import com.fuctura.bibliotecaNoite.dtos.LivroDTO;
import com.fuctura.bibliotecaNoite.models.Livro;
import com.fuctura.bibliotecaNoite.services.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/livro")
public class LivroController {

    @Autowired
    public LivroService livroService;

    /*
    @GetMapping("/{id}") = buscar por id;
    @GetMapping = buscar por todos;
    @PostMapping = salvar um objeto;
    @PutMapping("/{id}") = alterar um objeto pelo id;
    @DeleteMapping("/{id}") = deletar um objeto pelo id;
    */

    @GetMapping("/{id}")
    public ResponseEntity<LivroDTO> findById(@PathVariable Long id) {
        Livro livro = livroService.findById(id);
        return ResponseEntity.ok().body(new LivroDTO(livro));
        //como testar:
        //localhost:8080/livro/"id do livro específico da busca"
    }

    @GetMapping
    public ResponseEntity<List<LivroDTO>> findAllLivrosByCategoria(@RequestParam(value = "categoria",
            defaultValue = "0") Long id) {

        List<Livro> list = livroService.findAll(id);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
        //A consulta ficará:
        // localhost:8080/livro?categoria="id da categoria que vai trazer todos os livros que ela possui"
    }

    @GetMapping("/categoria/{nome}")
    public ResponseEntity<List<LivroDTO>> findAllLivrosByCategoriaNome(@PathVariable String nome) {
        List<Livro> list = livroService.findAllLivrosByCategoriaNome(nome);
        return ResponseEntity.ok().body(list.stream().map(obj -> new LivroDTO(obj)).collect(Collectors.toList()));
        //como testar:
        // localhost:8080/livro/categoria/"tres ou quatro primeiras letras do nome da categoria"
    }

    @PostMapping
    public ResponseEntity<LivroDTO> save(@Valid @RequestParam(value = "categoria", defaultValue = "0") Long id_cat,
                                         @RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.save(id_cat, livroDTO);
        return ResponseEntity.ok().body(new LivroDTO(livro));
        //como testar:
        //localhost:8080/livro?categoria="id da categoria que vai salvar os dados do Novo Livro"
    }

    @PutMapping("/{id}")
    public ResponseEntity<LivroDTO> upDate(@PathVariable Long id, @Valid @RequestBody LivroDTO livroDTO) {
        Livro livro = livroService.upDate(id, livroDTO);
        return ResponseEntity.ok().body(new LivroDTO(livro));
        //como testar:
        //localhost:8080/livro/"id do livro que serão alterados os dados"
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        livroService.delete(id);
        return ResponseEntity.noContent().build();
        //como testar:
        //localhost:8080/livro/"id do livro que será deletado"
    }

}
