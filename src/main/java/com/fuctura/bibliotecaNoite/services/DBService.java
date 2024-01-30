package com.fuctura.bibliotecaNoite.services;

import com.fuctura.bibliotecaNoite.enuns.Tamanho;
import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.models.Livro;
import com.fuctura.bibliotecaNoite.repositories.CategoriaRopository;
import com.fuctura.bibliotecaNoite.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private LivroRepository livroRepository;  //Instacia a classe LivroRepository aqui.

    @Autowired
    private CategoriaRopository categoriaRopository;

    public void instanciaDB() {

        Categoria cat1 = new Categoria(null, "Informática", "Livros de TI");
        Categoria cat2 = new Categoria(null, "Ficção Científica", "Livros de Ficção Científica");
        Categoria cat3 = new Categoria(null, "Biografia", "Livros de Biografia");
        Categoria cat4 = new Categoria(null, "Terror", "Livros de Terror");

        Livro liv1 = new Livro(null, "Clean code", "Robertin Martin", "Lorem ipsum", Tamanho.MEDIO, cat1);
        Livro liv2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem ipsum", Tamanho.GRANDE, cat1);
        Livro liv3 = new Livro(null, "The time machine", "H. G. Wells", "Lorem ipsum", Tamanho.MEDIO, cat2);
        Livro liv4 = new Livro(null, "The war of the worlds", "H. G. Wells", "Lorem ipsum", Tamanho.PEQUENO, cat2);
        Livro liv5 = new Livro(null, "I, robot", "Isaac Asimov", "Lorem ipsum", Tamanho.GRANDE, cat2);
        Livro liv6 = new Livro(null, "Einstein", "David Bodanis", "Biografia de um gênio imperfeito", Tamanho.MEDIO, cat3);
        Livro liv7 = new Livro(null, "A Rainha vermelha", "Victoria Aveyard", "Uma sociedade dividida pelo sangue", Tamanho.GRANDE, cat4);

        //adiciona os livros na categoria:
        cat1.getLivros().addAll(Arrays.asList(liv1, liv2));
        cat2.getLivros().addAll(Arrays.asList(liv3, liv4, liv5));
        cat3.getLivros().addAll(Arrays.asList(liv6));
        cat4.getLivros().addAll(Arrays.asList(liv7));

        //salva todos no Banco, passando como parâmetros: as categorias e os livros:
        categoriaRopository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        livroRepository.saveAll(Arrays.asList(liv1, liv2, liv3, liv4, liv5, liv6, liv7));

    }
}
