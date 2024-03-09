package com.fuctura.bibliotecaNoite.dtos;

import com.fuctura.bibliotecaNoite.models.Livro;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {

    //CategoriaDTO - Data Transfer Object - é uma forma de encapsular a classe principal: Categoria, e devolver
    // o DTO ao front. Podendo manipular a forma como é enviada para o front.

    private Long id;
    @NotBlank(message = "O campo NOME é obrigatório")
    @Length(min = 3, max = 15, message = "Deve conter entre 3 a 15 caracteres")
    private String nome;

    @NotBlank(message = "O campo DESCRIÇÃO é obrigatório")
    @Length(min = 10, max = 100, message = "Deve conter entre 10 a 100 caracteres")
    private String descricao;

    //Um exemplo da CategoriaDTO é que, não são enviados a lista de Livros quando é feita a requisição, como é visto
    // aqui. Só serão enviados os atributos de cada categoria.

    public CategoriaDTO() {
        //Construtor vazio, usado como boas práticas
    }

    //Construtor com parâmetros
    public CategoriaDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
