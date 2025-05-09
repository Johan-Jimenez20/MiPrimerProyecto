package com.miproyectosena.proyectosena.services;

import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.miproyectosena.proyectosena.dto.UsuarioDTO;
import com.miproyectosena.proyectosena.models.Usuario;
import com.miproyectosena.proyectosena.repositories.IusuarioRepo;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IusuarioRepo iusuarioRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario usuario = iusuarioRepo.findByCorreo(username);
       if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña invalidos");
       }
       return new User(usuario.getCorreo(),usuario.getPassword(), Collections.emptyList());
    }

    @Override
    public Usuario guardar(UsuarioDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getCorreo(), registroDTO.getNumeroCelular(), passwordEncoder.encode(registroDTO.getPassword()), registroDTO.getRoles());
        
        return iusuarioRepo.save(usuario);
    }
}
