package com.fuctura.bibliotecaNoite.repositories;

import com.fuctura.bibliotecaNoite.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRopository extends JpaRepository<Categoria, Long> {
    //Todas as consultas personalizadas são criadas aqui no Repository:

    //Mesmo sem o @Query essa consulta é válida aqui no IntelliJ
    Optional<Categoria> findByNome(String nome);

    //Busque pelo nome da categoria (podendo pesquisar pelo início das letras
    // do nome, ignorando o restante)
    Optional<Categoria> findByNomeContainingIgnoreCase(String nome);

}
