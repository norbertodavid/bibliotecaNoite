package com.fuctura.bibliotecaNoite.repositories;

import com.fuctura.bibliotecaNoite.models.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRopository extends JpaRepository<Categoria, Long> {
}
