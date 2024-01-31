package com.fuctura.bibliotecaNoite.services;

import com.fuctura.bibliotecaNoite.dtos.CategoriaDTO;
import com.fuctura.bibliotecaNoite.exceptions.ObjectNotFoundException;
import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.repositories.CategoriaRopository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRopository categoriaRepository;

    @Autowired
    private ModelMapper modelMapper;

    public Categoria findById(Long id) {
        //Quando for fazer uma busca de um objeto, usamos o Optional
        Optional<Categoria> cat = categoriaRepository.findById(id);

        //Outra forma de usar,com a forma do Lambda:
        //return cat.orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada!"));

        if(cat.isPresent()) {
            return cat.get();
        }
        throw new ObjectNotFoundException("Categoria não encontrada abestado!");
    }

    public List<Categoria> findAll() {
        return categoriaRepository.findAll();
    }

    public Categoria save(CategoriaDTO categoriaDTO) {
        categoriaDTO.setId(null);
        return categoriaRepository.save(modelMapper.map(categoriaDTO, Categoria.class));
    }

    public Categoria upDate(Categoria categoria) {
        return categoriaRepository.save(categoria);
    }

    public void delete(Long id) {
        categoriaRepository.deleteById(id);
    }

}
