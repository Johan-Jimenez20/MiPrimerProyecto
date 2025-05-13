package com.miproyectosena.proyectosena.models;

import java.util.HashSet;
import java.util.List;
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
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table (name="registro", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "correo")
    private String correo;
    @Column(name = "numeroCelular")
    private String numeroCelular;
    @Column(name = "password")
    private String password;

    @ManyToMany (fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable (
        name = "usuarios_roles",
        joinColumns = @JoinColumn(name ="usuario_id", referencedColumnName = "id"),
        inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id")
    )

    private Set<Roles> roles = new HashSet<>();


    public Usuario(String string, String string2, String string3, String string4, String string5, List<String> list) {
    }
   
    public Usuario(String nombre, String apellido, String correo, String numeroCelular, String password,
            Set<Roles> roles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
        this.password = password;
        this.roles = roles;
    }

    public Usuario(String nombre, String apellido, String correo, String numeroCelular, String password) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
        this.password = password;
    }

    public Usuario(Long id, String nombre, String apellido, String correo, String numeroCelular, String password,
            Set<Roles> roles) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.numeroCelular = numeroCelular;
        this.password = password;
        this.roles = roles;
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

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles=roles;
    }

    @Override
    public String toString() {
        return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
                + ", numeroCelular=" + numeroCelular + ", password=" + password + "]";
    }
    
}
