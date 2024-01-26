package com.fuctura.bibliotecaNoite.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuctura.bibliotecaNoite.enuns.Tamanho;

import javax.persistence.*;

//O pacote: models, juntamente com: classes e atributos, são os primeiros a serem criados
@Entity
@Table(name = "TB_Livro")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String texto;

    private Tamanho tamanho;

    @ManyToOne
    @JoinColumn(name = "categoria_id") //Essa anotation, faz uma ligação entre as duas tabelas: Categoria e Livros
    @JsonIgnore  //Após a requisição, ele pausa.
    private Categoria categoria;

    public Livro() {
    }

    public Livro(Long id, String titulo, String autor, String texto, Tamanho tamanho, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.tamanho = tamanho;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
}
