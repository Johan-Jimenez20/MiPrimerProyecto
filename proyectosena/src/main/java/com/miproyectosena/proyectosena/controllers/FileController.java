package com.miproyectosena.proyectosena.controllers;

import java.net.MalformedURLException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FileController {

    @GetMapping("/imagen/{nombreArchivo:.+}")
    @ResponseBody
    public ResponseEntity<Resource> verImagen(@PathVariable String nombreArchivo) {
    try {
        Path ruta = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
        Resource recurso = new UrlResource(ruta.toUri());

        if (recurso.exists() || recurso.isReadable()) {
            return ResponseEntity.ok()
                    .header(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + recurso.getFilename() + "\"")
                    .body(recurso);
        } else {
            return ResponseEntity.notFound().build();
        }

    } catch (MalformedURLException e) {
        return ResponseEntity.badRequest().build();
    }
    }  
}