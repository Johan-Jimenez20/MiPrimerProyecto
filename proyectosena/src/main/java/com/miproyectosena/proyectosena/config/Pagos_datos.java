package com.miproyectosena.proyectosena.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.miproyectosena.proyectosena.models.Pagos;
import com.miproyectosena.proyectosena.repositories.IPagosRepository;

@Component
public class Pagos_datos implements CommandLineRunner {

    @Autowired
    private IPagosRepository iPagosRepository;

    @Override
    public void run(String... args) throws Exception {
        if (iPagosRepository.findByNombrePagos("TC")== null){
            iPagosRepository.save(new Pagos("TC"));
        }
        if (iPagosRepository.findByNombrePagos("TD")== null){
            iPagosRepository.save(new Pagos("TD"));
        }
        if (iPagosRepository.findByNombrePagos("CE")== null){
            iPagosRepository.save(new Pagos("CE"));
        }
    }
}



