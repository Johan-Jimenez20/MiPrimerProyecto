package com.miproyectosena.proyectosena.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class ProductoDTO {

    private Long id;
    private String usuario;
    private String nombreProducto;
    private MultipartFile imagen;
    private String descripcion;
    private int costo;
    private Long categoria_id;
    private List<String> pagoSeleccionado;

    public ProductoDTO() {
    }

    public ProductoDTO(Long categoria_id, List<String> pagoSeleccionado) {
        this.categoria_id = categoria_id;
        this.pagoSeleccionado = pagoSeleccionado;
    }

    public ProductoDTO(String usuario, String nombreProducto, MultipartFile imagen, String descripcion, int costo,
            Long categoria_id, List<String> pagoSeleccionado) {
        this.usuario = usuario;
        this.nombreProducto = nombreProducto;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.costo = costo;
        this.categoria_id = categoria_id;
        this.pagoSeleccionado = pagoSeleccionado;
    }

    public ProductoDTO(Long id, String usuario, String nombreProducto, MultipartFile imagen, String descripcion,
            int costo, Long categoria_id, List<String> pagoSeleccionado) {
        this.id = id;
        this.usuario = usuario;
        this.nombreProducto = nombreProducto;
        this.imagen = imagen;
        this.descripcion = descripcion;
        this.costo = costo;
        this.categoria_id = categoria_id;
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

    public MultipartFile getImagen() {
        return imagen;
    }

    public void setImagen(MultipartFile imagen) {
        this.imagen = imagen;
    }

    public Long getCategoria_id() {
        return categoria_id;
    }

    public void setCategoria_id(Long categoria_id) {
        this.categoria_id = categoria_id;
    }

}
