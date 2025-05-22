package com.miproyectosena.proyectosena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.miproyectosena.proyectosena.models.Categoria;

@Repository
public interface ICategoriaRepository extends JpaRepository <Categoria, Long> {
    public Categoria findByNombreCategoria (String nombreCategoria);
}

