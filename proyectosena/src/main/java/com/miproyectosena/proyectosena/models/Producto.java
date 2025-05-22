package com.miproyectosena.proyectosena.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreProducto")
    private String nombreProducto;
    @Column(name = "ruta_imagen")
    private  String rutaImagen;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "costo")
    private int costo;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    @ManyToMany (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable (
        name = "producto_pagos",
        joinColumns = @JoinColumn(name ="producto_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "pagos_id", referencedColumnName = "id")
    )

    private Set<Pagos> pagos = new HashSet<>();

    public Producto() {
    }

    public Producto(Long id, String nombreProducto, String rutaImagen, String descripcion, int costo,
            Categoria categoria, Set<Pagos> pagos) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
        this.costo = costo;
        this.categoria = categoria;
        this.pagos = pagos;
    }

    public Producto(String nombreProducto, String rutaImagen, String descripcion, int costo, Categoria categoria,
            Set<Pagos> pagos) {
        this.nombreProducto = nombreProducto;
        this.rutaImagen = rutaImagen;
        this.descripcion = descripcion;
        this.costo = costo;
        this.categoria = categoria;
        this.pagos = pagos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }    

    public Set<Pagos> getPagos() {
        return pagos;
    }

    public void setPagos(Set<Pagos> pagos) {
        this.pagos = pagos;
    }

}
