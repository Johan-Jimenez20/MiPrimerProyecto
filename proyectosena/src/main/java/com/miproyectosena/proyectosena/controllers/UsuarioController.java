package com.miproyectosena.proyectosena.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.miproyectosena.proyectosena.dto.UsuarioDTO;
import com.miproyectosena.proyectosena.services.IUsuarioServicio;

@Controller
@RequestMapping("/registro")
public class UsuarioController {

    @Autowired
    private IUsuarioServicio iUsuarioServicio;

    @ModelAttribute("usuario")
    public UsuarioDTO retornarNuevUsuarioDTO(){
        return new UsuarioDTO();
    }

    @GetMapping
    public String mostrarFormularioDeRegistro(){
        return "registro";
    }

    @PostMapping
    public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioDTO registroDTO){
        iUsuarioServicio.guardar(registroDTO);
        return "redirect:/registro?exito=true";
    }
}
