package com.miproyectosena.proyectosena.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.miproyectosena.proyectosena.models.Producto;
import com.miproyectosena.proyectosena.models.Usuario;
import com.miproyectosena.proyectosena.repositories.IusuarioRepo;
import com.miproyectosena.proyectosena.services.ProductoServicioImpl;

@Controller
public class LoginController {

    
    @Autowired
    private ProductoServicioImpl productoServicioImpl;

    @Autowired
    private IusuarioRepo iusuarioRepo;

    @GetMapping ("/login")
        public String iniciarSesion(){
            return "login";
        }
    
    @GetMapping ("/")
    public String mostrarInicio(Model model, Principal principal) {
        List <Producto> productos;

        Usuario usuario = null;
        if (principal != null) {
            usuario = iusuarioRepo.findByCorreo(principal.getName());
        // Usuario no autenticado: puede ver todos
        productos = productoServicioImpl.obtenerTodosLosProductos();
        } 
        if (usuario == null) {
            productos = productoServicioImpl.obtenerTodosLosProductos();
        } else {
            productos = productoServicioImpl.obtenerProductosPorRol(usuario);
        }

        model.addAttribute("productos", productos);
        return "index";
        }
    }

