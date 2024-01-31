package com.fuctura.bibliotecaNoite.dtos;

import com.fuctura.bibliotecaNoite.models.Livro;

import java.util.ArrayList;
import java.util.List;

public class CategoriaDTO {

    //CategoriaDTO - Data Transfer Object - é uma forma de encapsular a classe principal, Categoria e devolve-la
    //ao front, podendo manipular a forma como eu envio para o front.

    private Long id;
    private String nome;
    private String descricao;

    //Exemplo que aqui, não envio a classe Livros, só envio a classe Categoria.

    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String nome, String descricao) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
    }

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
