package com.miproyectosena.proyectosena.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.thymeleaf.extras.springsecurity6.dialect.SpringSecurityDialect;

import com.miproyectosena.proyectosena.services.IUsuarioServicio;

@Configuration
@EnableWebSecurity
public class UsuarioSeguridad {
    
    @Autowired 
    private IUsuarioServicio iUsuarioServicio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Bean
    public SpringSecurityDialect springSecurityDialect(){
    return new SpringSecurityDialect();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(iUsuarioServicio);
        auth.setPasswordEncoder(passwordEncoder);
        return auth;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http 
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/imagen/").permitAll()
                .requestMatchers("/registro**", "/js/**", "/css/**", "/img/**").permitAll().anyRequest().authenticated()
            )
            .formLogin (form -> form
            .loginPage ("/login")
            .defaultSuccessUrl("/",true)
            .permitAll()
            )
            .logout (logout -> logout
            .invalidateHttpSession(true)
            .clearAuthentication(true)
            .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
            .logoutSuccessUrl("/login?logout")
            .permitAll()
            );

    return http.build();
    }
}

