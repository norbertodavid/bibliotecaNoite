package com.fuctura.bibliotecaNoite.services;

import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.repositories.CategoriaRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRopository categoriaRepository;

    public Categoria findById(Long id) {
        //Quando for fazer uma busca de um objeto, usamos o Optional
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.get();
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public Categoria upDate(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

}
