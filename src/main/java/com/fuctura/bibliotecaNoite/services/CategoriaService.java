package com.fuctura.bibliotecaNoite.services;

import com.fuctura.bibliotecaNoite.exceptions.ObjectNotFoundException;
import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.repositories.CategoriaRopository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Esta classe é responsável por enviar os comandos para o Banco.
@Service
public class CategoriaService {

    //É implementado o Repository aqui. Que executa o Comando no Banco.
    @Autowired
    private CategoriaRopository categoriaRepository;

    //É implementado o ModelMapper aqui. Que é o responsável por mapear as resposta das Categoria Principal
    //e da CategoriaDTO.
    @Autowired
    private ModelMapper modelMapper;

    public Categoria findById(Long id) {
        Optional<Categoria> cat = categoriaRepository.findById(id);
        //Se a categoria existir, retorne.
        if(cat.isPresent()) {
            return cat.get();
        }
        //Se não, mostre essa mensagem de erro.
        throw new ObjectNotFoundException("Deu erro Boy!");
    }





}
