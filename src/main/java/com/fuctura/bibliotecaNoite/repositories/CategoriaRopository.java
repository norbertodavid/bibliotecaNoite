package com.fuctura.bibliotecaNoite.repositories;

import com.fuctura.bibliotecaNoite.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoriaRopository extends JpaRepository<Categoria, Long> {
    //Todas as consultas personalizadas são criadas aqui no Repository:

    //Mesmo sem o @Query essa consulta é válida aqui no Intellij
    Optional<Categoria> findByNome(String nome);
}
