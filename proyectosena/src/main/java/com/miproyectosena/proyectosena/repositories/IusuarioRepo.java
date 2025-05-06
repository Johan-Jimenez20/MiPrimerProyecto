package com.miproyectosena.proyectosena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.miproyectosena.proyectosena.models.Usuario;
    
@Repository
public interface IusuarioRepo extends JpaRepository<Usuario, Long> {
    public Usuario findByCorreo (String correo);
}

