package com.fuctura.bibliotecaNoite.dtos;

import com.fuctura.bibliotecaNoite.enuns.Tamanho;
import com.fuctura.bibliotecaNoite.models.Categoria;
import com.fuctura.bibliotecaNoite.models.Livro;

import javax.validation.constraints.NotBlank;

public class LivroDTO {

    //LivroDTO - Data Transfer Object - é uma forma de encapsular a classe principal: Livro, e devolver
    // O DTO ao front. Podendo manipular a forma como é enviada para o front.

    private Long id;

    @NotBlank(message = "O campo TÍTULO é obrigatório")
    private String titulo;

    @NotBlank(message = "O campo AUTOR é obrigatório")
    private String autor;

    @NotBlank(message = "O campo TEXTO é obrigatório")
    private String texto;
    private Tamanho tamanho;  //Chamei a classe Enum aqui dentro da classe Livro.
    private Categoria categoria;

    public LivroDTO() {
        //Construtor vazio, usado como boas práticas
    }

    //Construtor com parâmetros
    public LivroDTO(Long id, String titulo, String autor, String texto, Tamanho tamanho, Categoria categoria) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.texto = texto;
        this.tamanho = tamanho;
        this.categoria = categoria;
    }

    //Construtor de LivroDTO passando como parâmetros a Classe Livro com os seus atributos
    public LivroDTO(Livro livro) {
        this.id = livro.getId();
        this.titulo = livro.getTitulo();
        this.autor = livro.getAutor();
        this.texto = livro.getTexto();
        this.tamanho = livro.getTamanho();
        this.categoria = livro.getCategoria();
    }

    //Getters e Setters
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
