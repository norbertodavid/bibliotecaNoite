package com.fuctura.bibliotecaNoite.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
//O pacote: models, juntamente com: classes e atributos, são os primeiros a serem criados

@Entity  // Torna a classe real no Banco de Dados
@Table(name = "TB_Categoria")  // Renomeia as DataBases do Banco
public class Categoria {

    @Id  //Anottation importante para definir os Id's e a estratégia de cada classe.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;


    @OneToMany(mappedBy = "categoria")  //relaciona de 1 para N e passa como parâmetro, o mapeamento por categoria
    @JsonIgnore  //Após a requisição, com essa anotation é feito uma pausa.
    private List<Livro> livros = new ArrayList<>();  //instaciou a classe livros aqui

    //Construtor vazio, criado como boas práticas
    public Categoria() {
    }

    //Construtor com parâmetros
    public Categoria(Long id, String nome, String descricao) {
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

    public List<Livro> getLivros() {
        return livros;
    }

    public void setLivros(List<Livro> livros) {
        this.livros = livros;
    }
}
