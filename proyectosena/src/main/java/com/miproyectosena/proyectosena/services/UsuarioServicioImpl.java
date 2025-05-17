package com.miproyectosena.proyectosena.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.miproyectosena.proyectosena.dto.UsuarioDTO;
import com.miproyectosena.proyectosena.models.Roles;
import com.miproyectosena.proyectosena.models.Usuario;
import com.miproyectosena.proyectosena.repositories.IRolesRepository;
import com.miproyectosena.proyectosena.repositories.IusuarioRepo;

@Service
public class UsuarioServicioImpl implements IUsuarioServicio{

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IRolesRepository iRolesRepository;

    @Autowired
    private IusuarioRepo iusuarioRepo;

    @Override
    public Usuario guardar(UsuarioDTO registroDTO) {

        Usuario usuario = new Usuario(
            registroDTO.getNombre(),
            registroDTO.getApellido(), 
            registroDTO.getCorreo(),
            registroDTO.getNumeroCelular(),
            passwordEncoder.encode(registroDTO.getPassword()));

        Set<Roles> roles = new HashSet<>();
        for (String nombreRol: registroDTO.getRolSeleccionado()){
            Roles rol = iRolesRepository.findByNombre(nombreRol);
            if(rol != null) {
                roles.add(rol);
            }
        }
        usuario.setRoles(roles);

        return iusuarioRepo.save(usuario);
    }

@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Usuario usuario = iusuarioRepo.findByCorreo(username);
       if (usuario == null) {
            throw new UsernameNotFoundException("Usuario o contraseña invalidos");
       }

    
       List<GrantedAuthority> authorities = usuario.getRoles()
            .stream()
            .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
            .collect(Collectors.toList());

        return new User (usuario.getCorreo(),usuario.getPassword(), authorities);
    }

}