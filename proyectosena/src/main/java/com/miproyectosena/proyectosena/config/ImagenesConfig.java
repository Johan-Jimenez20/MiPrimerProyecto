package com.miproyectosena.proyectosena.config;

import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class ImagenesConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers (@NonNull ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploads/**")
            .addResourceLocations("file:uploads/");
    }
}
