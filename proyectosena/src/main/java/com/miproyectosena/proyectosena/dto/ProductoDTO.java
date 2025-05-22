package com.miproyectosena.proyectosena.dto;

import java.util.List;

public class ProductoDTO {

    private Long id;
    private String nombreProducto;
    private String ruta_imagen;
    private String descripcion;
    private int costo;
    private List<String> categoriaSeleccionada;
    private List<String> pagoSeleccionado;

    public ProductoDTO() {
    }

    public ProductoDTO(List<String> categoriaSeleccionada, List<String> pagoSeleccionado) {
        this.categoriaSeleccionada = categoriaSeleccionada;
        this.pagoSeleccionado = pagoSeleccionado;
    }

    public ProductoDTO(String nombreProducto, String ruta_imagen, String descripcion, int costo,
            List<String> categoriaSeleccionada, List<String> pagoSeleccionado) {
        this.nombreProducto = nombreProducto;
        this.ruta_imagen = ruta_imagen;
        this.descripcion = descripcion;
        this.costo = costo;
        this.categoriaSeleccionada = categoriaSeleccionada;
        this.pagoSeleccionado = pagoSeleccionado;
    }

    public ProductoDTO(Long id, String nombreProducto, String ruta_imagen, String descripcion, int costo,
            List<String> categoriaSeleccionada, List<String> pagoSeleccionado) {
        this.id = id;
        this.nombreProducto = nombreProducto;
        this.ruta_imagen = ruta_imagen;
        this.descripcion = descripcion;
        this.costo = costo;
        this.categoriaSeleccionada = categoriaSeleccionada;
        this.pagoSeleccionado = pagoSeleccionado;
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
    public String getRuta_imagen() {
        return ruta_imagen;
    }
    public void setRuta_imagen(String ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
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
    public List<String> getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }
    public void setCategoriaSeleccionada(List<String> categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }
    public List<String> getPagoSeleccionado() {
        return pagoSeleccionado;
    }
    public void setPagoSeleccionado(List<String> pagoSeleccionado) {
        this.pagoSeleccionado = pagoSeleccionado;
    }

        

}
