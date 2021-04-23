package ar.com.mujeres2000.sistema_gestion_financiera.services;

import java.util.*;
import java.util.stream.Collectors;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.mujeres2000.sistema_gestion_financiera.entitites.Producto;
import ar.com.mujeres2000.sistema_gestion_financiera.repositories.ProductoRepository;

@Service
public class ProductoService {
	@Autowired
	ProductoRepository productoRepo; 
	
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    public Producto crearProducto(String nombre, double precio, double costoVariable) {
        if(existeProducto(nombre)){
            throw new NonUniqueResultException();
        }else{
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setEstado(true);
            producto.setCostoVariable(costoVariable);
            saveProducto(producto);
            return producto;
        }
    }

    public boolean existeProducto(String nombre) {
        Producto producto = productoRepo.findByNombre(nombre);
        return producto != null && producto.isEstado();
    }

    public Producto buscarPorProductoId(int id){
        Optional<Producto> productoOptional = productoRepo.findById(id);
        if(productoOptional.isPresent()){
            return productoOptional.get();
        }
        return null;
    }

	public void actualizarPrecio(Producto producto, double precioNuevo, double costoVariable) {
        producto.setPrecio(precioNuevo);
        producto.setCostoVariable(costoVariable);
        saveProducto(producto);
    }
    
    public List<Producto> obtenerProductos() {
        List<Producto> productos = productoRepo.findAll();
        return productos.stream().filter(p -> p.isEstado() == true).collect(Collectors.toList());
    }
}
