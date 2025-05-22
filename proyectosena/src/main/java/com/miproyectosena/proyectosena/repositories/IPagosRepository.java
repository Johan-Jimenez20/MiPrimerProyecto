package com.miproyectosena.proyectosena.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.miproyectosena.proyectosena.models.Pagos;

@Repository
public interface IPagosRepository extends JpaRepository <Pagos, Long> {
    public Pagos findByNombrePagos (String nombrePagos);
}