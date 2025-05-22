package com.miproyectosena.proyectosena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.miproyectosena.proyectosena.models.Categoria;
import com.miproyectosena.proyectosena.repositories.ICategoriaRepository;

@Component
public class Categoria_datos implements CommandLineRunner  {

    @Autowired
    private ICategoriaRepository iCategoriaRepository;

    @Override
    public void run(String... args) throws Exception {
        if (iCategoriaRepository.count() == 0) {
            iCategoriaRepository.save(new Categoria("Ropa y accessorios"));
            iCategoriaRepository.save(new Categoria("Hogar"));
            iCategoriaRepository.save(new Categoria("Juguetes"));
            iCategoriaRepository.save(new Categoria("Deporte"));
            iCategoriaRepository.save(new Categoria("Tecnologia"));
        } 
    }
}


