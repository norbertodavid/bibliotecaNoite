/*
package com.fuctura.bibliotecaNoite.services;

import com.fuctura.bibliotecaNoite.models.Livro;
import com.fuctura.bibliotecaNoite.repositories.CategoriaRopository;
import com.fuctura.bibliotecaNoite.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livrorepository;

    public Livro findById(Long id) {
        Optional<Livro> liv = livrorepository.findById(id);
        return liv.get();
    }

}
*/