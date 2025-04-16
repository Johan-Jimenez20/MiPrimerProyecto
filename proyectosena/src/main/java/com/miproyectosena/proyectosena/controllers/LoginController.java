package com.miproyectosena.proyectosena.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping ("/login")
        public String iniciarSesion(){
            return "login";
        }
    
    @GetMapping ("/")
        public String verPaginaDeInicio (){
            return "index";
        }
}
