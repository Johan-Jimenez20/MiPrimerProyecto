package com.miproyectosena.proyectosena.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import com.miproyectosena.proyectosena.dto.ProductoDTO;
import com.miproyectosena.proyectosena.models.Usuario;
import com.miproyectosena.proyectosena.repositories.ICategoriaRepository;
import com.miproyectosena.proyectosena.repositories.IPagosRepository;
import com.miproyectosena.proyectosena.repositories.IusuarioRepo;
import com.miproyectosena.proyectosena.services.ProductoServicioImpl;

@Controller
@RequestMapping("/producto")
public class ProductoController {

    @Autowired
    private IusuarioRepo iusuarioRepo;

    @Autowired
    private ProductoServicioImpl productoServicioImpl;

    @Autowired 
    private ICategoriaRepository iCategoriaRepository;

    @Autowired
    private IPagosRepository iPagosRepository;

    @GetMapping("/nuevo")
    public String mostrarFormularioProducto(Model model) {

        model.addAttribute("productoDTO", new ProductoDTO());

        model.addAttribute("categoria", iCategoriaRepository.findAll());

        model.addAttribute("pagos", iPagosRepository.findAll());

        return "ingresoProducto"; 
    }

    @PostMapping("/guardar")
    public String guardarProducto (@ModelAttribute ProductoDTO productoDTO,
    @RequestParam ("imagen") MultipartFile imagen,

    Principal principal) {
        Usuario usuario = iusuarioRepo.findByCorreo(principal.getName());
        productoServicioImpl.guardarProducto(productoDTO, usuario, imagen);
        return "redirect:/producto/nuevo?exito=true";
    }
}
