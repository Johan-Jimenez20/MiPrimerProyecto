package com.miproyectosena.proyectosena.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.miproyectosena.proyectosena.dto.ProductoDTO;
import com.miproyectosena.proyectosena.models.Categoria;
import com.miproyectosena.proyectosena.models.Pagos;
import com.miproyectosena.proyectosena.models.Producto;
import com.miproyectosena.proyectosena.models.Usuario;
import com.miproyectosena.proyectosena.repositories.ICategoriaRepository;
import com.miproyectosena.proyectosena.repositories.IPagosRepository;
import com.miproyectosena.proyectosena.repositories.IProductosRepository;


@Service
public class ProductoServicioImpl  {

    @Autowired
    private IProductosRepository iProductosRepository;

    @Autowired 
    private IPagosRepository iPagosRepository;

    @Autowired ICategoriaRepository iCategoriaRepository;

    public List<Producto> getProductosDelUsuario(Usuario usuario) {
        return iProductosRepository.findByUsuario(usuario);
    }

    public Producto guardarProducto(ProductoDTO dto, Usuario usuario, MultipartFile imagen) {
        Producto producto = new Producto();
        producto.setNombreProducto(dto.getNombreProducto());
        producto.setDescripcion(dto.getDescripcion());
        producto.setCosto(dto.getCosto());
        producto.setUsuario(usuario);

        if (imagen != null && !imagen.isEmpty()) {
            try {
                String nombreArchivo = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
                Path ruta = Paths.get("uploads").resolve(nombreArchivo).toAbsolutePath();
                Files.createDirectories(ruta.getParent());
                Files.copy(imagen.getInputStream(), ruta, StandardCopyOption.REPLACE_EXISTING);
                producto.setImagen(nombreArchivo);
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }

         Categoria categoria = iCategoriaRepository.findById(dto.getCategoria_id()).orElseThrow(() -> new IllegalArgumentException("Categoría no válida"));
        producto.setCategoria(categoria);

        Set<Pagos> pagos = new HashSet<>();
        for (String nombrePagos: dto.getPagoSeleccionado()) {
            Pagos pago = iPagosRepository.findByNombrePagos(nombrePagos);
            if (pago != null) {
                pagos.add(pago);
            }
        }

    return iProductosRepository.save(producto);

    }

    public List<Producto> obtenerTodosLosProductos() {
        return iProductosRepository.findAll();
    
    }
}
