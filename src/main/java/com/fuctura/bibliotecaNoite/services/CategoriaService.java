package com.fuctura.bibliotecaNoite.services;

import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.repositories.CategoriaRopository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRopository categoriaRepository;

    public Categoria findById(Long id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        return cat.get();
    }

}
