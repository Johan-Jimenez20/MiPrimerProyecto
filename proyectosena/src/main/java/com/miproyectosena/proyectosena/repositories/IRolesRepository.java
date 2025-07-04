package com.miproyectosena.proyectosena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miproyectosena.proyectosena.models.Roles;

@Repository
public interface IRolesRepository extends JpaRepository<Roles, Long> {
    public Roles findByNombre(String nombre);
}
