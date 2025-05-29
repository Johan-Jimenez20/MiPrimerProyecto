package com.miproyectosena.proyectosena.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductoDTO {

    private Long id;
    private String usuario;
    private String nombreProducto;
    private MultipartFile ruta_imagen;
    private String descripcion;
    private int costo;
    private Long categoriaSeleccionada;
    private List<String> pagoSeleccionado;

    public ProductoDTO() {
    }

    public ProductoDTO(Long categoriaSeleccionada, List<String> pagoSeleccionado) {
        this.categoriaSeleccionada = categoriaSeleccionada;
        this.pagoSeleccionado = pagoSeleccionado;
    }

    public ProductoDTO(String usuario, String nombreProducto, MultipartFile ruta_imagen, String descripcion, int costo,
            Long categoriaSeleccionada, List<String> pagoSeleccionado) {
        this.usuario = usuario;
        this.nombreProducto = nombreProducto;
        this.ruta_imagen = ruta_imagen;
        this.descripcion = descripcion;
        this.costo = costo;
        this.categoriaSeleccionada = categoriaSeleccionada;
        this.pagoSeleccionado = pagoSeleccionado;
    }

    public ProductoDTO(Long id, String usuario, String nombreProducto, MultipartFile ruta_imagen, String descripcion,
            int costo, Long categoriaSeleccionada, List<String> pagoSeleccionado) {
        this.id = id;
        this.usuario = usuario;
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
    public Long getCategoriaSeleccionada() {
        return categoriaSeleccionada;
    }
    public void setCategoriaSeleccionada(Long categoriaSeleccionada) {
        this.categoriaSeleccionada = categoriaSeleccionada;
    }
    public List<String> getPagoSeleccionado() {
        return pagoSeleccionado;
    }
    public void setPagoSeleccionado(List<String> pagoSeleccionado) {
        this.pagoSeleccionado = pagoSeleccionado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public MultipartFile getRuta_imagen() {
        return ruta_imagen;
    }

    public void setRuta_imagen(MultipartFile ruta_imagen) {
        this.ruta_imagen = ruta_imagen;
    }

}
