package com.miproyectosena.proyectosena.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="pagos")
public class Pagos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombrePagos;

    public Pagos() {
    }

    public Pagos(String nombrePagos) {
        this.nombrePagos = nombrePagos;
    }

    public Pagos(Long id, String nombrePagos) {
        this.id = id;
        this.nombrePagos = nombrePagos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePagos() {
        return nombrePagos;
    }

    public void setNombrePagos(String nombrePagos) {
        this.nombrePagos = nombrePagos;
    }

    

    

}
