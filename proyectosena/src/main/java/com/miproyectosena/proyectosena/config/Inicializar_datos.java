package com.miproyectosena.proyectosena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.miproyectosena.proyectosena.models.Roles;
import com.miproyectosena.proyectosena.repositories.IRolesRepository;

@Component
public class Inicializar_datos implements CommandLineRunner {

    @Autowired
    private IRolesRepository iRolesRepository;

    @Override
    public void run(String... args) throws Exception {
        if (iRolesRepository.findByNombre("ROLE_COMPRADOR") == null) {
            iRolesRepository.save(new Roles("ROLE_COMPRADOR"));
        }
        if (iRolesRepository.findByNombre("ROLE_VENDEDOR") == null) {
            iRolesRepository.save(new Roles("ROLE_VENDEDOR"));
        }
    }
}

