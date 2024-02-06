package com.fuctura.bibliotecaNoite.configs;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//essa classe é criada com o @Config para auxiliar no mapemanto, ou na rota, onde: O Banco faz uma
//busca na classe Categoria (principal), e retorna a CategoriaDTO com os dados manipulados de acordo
//com o que é fornecido pela Equipe DEV
@Configuration
public class ModelMapperConfig {

    @Bean //Torna essa classe e o @Config executável.
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}
