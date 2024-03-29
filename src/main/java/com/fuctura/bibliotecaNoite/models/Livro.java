package com.fuctura.bibliotecaNoite.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fuctura.bibliotecaNoite.dtos.LivroDTO;
import com.fuctura.bibliotecaNoite.enuns.Tamanho;

import javax.persistence.*;

//O pacote: models, juntamente com: classes e atributos, são os primeiros a serem criados
@Entity  // Torna a classe real no Banco de Dados
@Table(name = "TB_Livro")  // Renomeia as DataBases do Banco
public class Livro {

    @Id  //Anottation importante para definir os Id's e a estratégia de cada classe.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String autor;
    private String texto;

    private Tamanho tamanho;  //Chamei a classe Enum aqui dentro da classe Livro.

    @ManyToOne
    @JoinColumn(name = "categoria_id") //Essa anotation, faz uma ligação entre as duas tabelas: Categoria e Livros
    @JsonIgnore  //Após a requisição, com essa anotation é feito uma pausa.
    private Categoria categoria;  //Chamei a classe categoria dentro da classe Livro

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

    public Livro(LivroDTO livroDTO) {
        this.id = livroDTO.getId();
        this.titulo = livroDTO.getTitulo();
        this.autor = livroDTO.getAutor();
        this.texto = livroDTO.getTexto();
        this.tamanho = livroDTO.getTamanho();
        this.categoria = livroDTO.getCategoria();
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
