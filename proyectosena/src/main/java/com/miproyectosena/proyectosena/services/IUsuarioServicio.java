package com.miproyectosena.proyectosena.services;

import org.springframework.security.core.userdetails.UserDetailsService;
import com.miproyectosena.proyectosena.dto.UsuarioDTO;
import com.miproyectosena.proyectosena.models.Usuario;

public interface IUsuarioServicio  extends UserDetailsService {
    public Usuario guardar(UsuarioDTO registroDTO);
}
