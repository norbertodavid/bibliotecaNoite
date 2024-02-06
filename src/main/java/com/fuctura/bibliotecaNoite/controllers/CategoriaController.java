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

    @Autowired  //Instacia a Categoria Service aqui no Controller
    public CategoriaService categoriaSevirce;

    @Autowired  //Instancia o ModelMapper aqui no Controller
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
        //Classe Categoria(principal) recebe um comando do Service de encontrar por ID
        Categoria cat = categoriaSevirce.findById(id);

        //Retorna com um responseEntity, que no corpo, retorna um mapeamento do modelMapper que faz um clone dos dois parâmetros descritos: Categoria e CategoriaDTO
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> findAll() {
        List<Categoria> list = categoriaSevirce.findAll();
        return ResponseEntity.ok().body(list.stream().map(obj -> modelMapper.map(obj, CategoriaDTO.class)).collect(Collectors.toList()));
        //Retorna um ResponseEntity, que no corpo, traz um streame mapeado como obj,qua quando é passado pelo modelmapper, faz um clone do objeto com a classe CategoriaDTO.
    }

    @PostMapping
    public ResponseEntity<CategoriaDTO> save(@RequestBody CategoriaDTO categoriaDTO) {
        Categoria cat = categoriaSevirce.save(categoriaDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> upDate(@PathVariable Long id, @RequestBody CategoriaDTO categoriaDTO) {
        //Esa função passada aqui, permite alterar um valor por ID
        categoriaDTO.setId(id);
        //Aqui é chamado um service da Classe Categoria(principal) chamando afunção upDate passando como parâmetro o RequestBody de CategoriaDTO
        Categoria cat = categoriaSevirce.upDate(categoriaDTO);
        return ResponseEntity.ok().body(modelMapper.map(cat, CategoriaDTO.class));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        categoriaSevirce.delete(id);
        return ResponseEntity.noContent().build();
    }

}
