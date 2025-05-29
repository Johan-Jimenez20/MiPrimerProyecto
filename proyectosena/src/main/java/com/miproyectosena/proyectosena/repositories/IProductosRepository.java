package com.miproyectosena.proyectosena.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miproyectosena.proyectosena.models.Producto;
import com.miproyectosena.proyectosena.models.Usuario;

@Repository
public interface IProductosRepository extends JpaRepository <Producto, Long> {
    List<Producto> findByUsuario(Usuario usuario);
}
