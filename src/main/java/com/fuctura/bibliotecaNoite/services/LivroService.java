package com.fuctura.bibliotecaNoite.services;

import com.fuctura.bibliotecaNoite.dtos.LivroDTO;
import com.fuctura.bibliotecaNoite.exceptions.ObjectNotFoundException;
import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.models.Livro;
import com.fuctura.bibliotecaNoite.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private CategoriaService categoriaService;

    public Livro findById(Long id) {
        Optional<Livro> livro = livroRepository.findById(id);
        if(livro.isPresent()) {
            return livro.get();
        }
        throw new ObjectNotFoundException("Livro não encontrado!");

        //como testar:
        //localhost:8080/livro/"id do livro específico da busca"
    }

    public List<Livro> findAll(Long id_cat) {
        categoriaService.findById(id_cat);
        return livroRepository.findAllLivroByCategoria(id_cat);

        //A consulta ficará:
        // localhost:8080/livro?categoria="id da categoria que vai trazer todos os livros que ela possui"
    }


    public List<Livro> findAllLivrosByCategoriaNome(String nome) {
        categoriaService.buscarPorNome(nome);
        return livroRepository.findByCategoriaNomeContainingIgnoreCase(nome);

        //como testar:
        // localhost:8080/livro/categoria/"tres ou quatro primeiras letras do nome da categoria"
    }


    public Livro save(Long idCat, LivroDTO livroDTO) {
        livroDTO.setId(null);
        Categoria cat = categoriaService.findById(idCat);
        livroDTO.setCategoria(cat);
        return livroRepository.save(new Livro(livroDTO));

        //como testar:
        //localhost:8080/livro?categoria="id da categoria que vai salvar os dados do Novo Livro"
    }

    public Livro upDate(Long id, LivroDTO livroDTO) {
        //usamos a verificação findById, se caso o livro não existir mostra a mensagem modificada.
        Livro livro = findById(id);
        livroDTO.setId(id);
        //Aqui usamos o método criado abaixo
        upDateDados(livro, livroDTO);
        return livroRepository.save(livro);

        //como testar:
        //localhost:8080/livro/"id do livro que serão alterados os dados"
    }


    public void delete(Long id) {
        findById(id);
        livroRepository.deleteById(id);

        //como testar:
        //localhost:8080/livro/"id do livro que será deletado"
    }

    //esse método é criado para alterar os dados da classe LivroDTO em Livro(Classe Principal)
    private void upDateDados(Livro livro, LivroDTO livroDTO) {
        livro.setId(livroDTO.getId());
        livro.setTitulo(livroDTO.getTitulo());
        livro.setAutor(livroDTO.getAutor());
        livro.setTexto(livroDTO.getTexto());
        livro.setTamanho(livroDTO.getTamanho());
        livro.setCategoria(livroDTO.getCategoria());
    }

}
