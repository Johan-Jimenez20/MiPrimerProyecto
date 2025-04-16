package com.miproyectosena.proyectosena.dto;

public class UsuarioDTO {
    
    private Long id;
    private String nombre;
    private String apellido;
    private String correo;
    private String numeroCelular;
    private String password;

    public UsuarioDTO() {
    }

    public UsuarioDTO(String correo) {
        this.correo = correo;
    }

    public UsuarioDTO(String nombre, String apellido, String correo, String numeroCelular, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
        this.password = password;
    }

    public UsuarioDTO(Long id, String nombre, String apellido, String correo, String numeroCelular, String password) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
        this.password = password;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    public String getNumeroCelular() {
        return numeroCelular;
    }
    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    

}
