package com.fuctura.bibliotecaNoite.controllers;

import com.fuctura.bibliotecaNoite.dtos.CategoriaDTO;
import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.services.CategoriaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired  //Instacia
    public CategoriaService categoriaSevirce;

    @Autowired
    private ModelMapper modelMapper;

    /*
    @GetMapping("/{id}") = buscar por id;
    @GetMapping = buscar por todos;
    @PostMapping = salvar um objeto;
    @PutMapping("/{id}") = alterar um objeto pelo id;
    @DeleteMapping("/{id}") = deletar um objeto pelo id;
    */

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> findById(@PathVariable Long id) {
        Categoria cat = categoriaSevirce.findById(id);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = categoriaSevirce.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj ->
                modelMapper.map(obj, CategoriaDTO.class)).collect(Collectors.toList()));
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria cat = categoriaSevirce.save(categoriaDTO);
        return ResponseEntity.ok().body(modelMapper.map(categoriaDTO, CategoriaDTO.class));
    }

    @PutMapping("/{id}")
    public Categoria upDate(@PathVariable Long id, @RequestBody Categoria categoria) {
        categoria.setId(id);
        Categoria cat = categoriaSevirce.upDate(categoria);
        return cat;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        categoriaSevirce.delete(id);
    }

}
