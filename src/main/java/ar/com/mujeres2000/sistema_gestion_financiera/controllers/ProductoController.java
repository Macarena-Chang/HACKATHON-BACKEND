package ar.com.mujeres2000.sistema_gestion_financiera.controllers;

import java.util.*;

import javax.persistence.NonUniqueResultException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ar.com.mujeres2000.sistema_gestion_financiera.entitites.Producto;
import ar.com.mujeres2000.sistema_gestion_financiera.models.requests.MontoNuevo;
import ar.com.mujeres2000.sistema_gestion_financiera.models.requests.ProductoRequest;
import ar.com.mujeres2000.sistema_gestion_financiera.models.responses.GenericResponse;
import ar.com.mujeres2000.sistema_gestion_financiera.services.ProductoService;

@RestController
public class ProductoController {
    
    @Autowired
    ProductoService productoService;

    @PostMapping("/productos")
    public ResponseEntity<GenericResponse> crearProducto(@RequestBody ProductoRequest pR) {
        try {
            Producto producto = productoService.crearProducto(pR.nombre, pR.precio, pR.costoVariable);
            return ResponseEntity.ok().body(new GenericResponse(true, "Producto agregado con exito", producto.getProductoId()));
        } catch (NonUniqueResultException e) {
            return ResponseEntity.badRequest().body(new GenericResponse(false, "No puede registrar dos productos con el mismo nombre!", 0));
        }catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse(false, "No se creado con exito", 0));
        }
    }
    
    @PutMapping("/productos/actualizarPrecio/{id}")
    public ResponseEntity<?> actualizarPrecioProducto(@PathVariable int id, @RequestBody MontoNuevo montoNuevo) {

        Producto producto = productoService.buscarPorProductoId(id);

        if (producto != null) {
            productoService.actualizarPrecio(producto, montoNuevo.montoNuevo, montoNuevo.costoVariable);

            GenericResponse resp = new GenericResponse();
            resp.isOk = true;
            resp.id = producto.getProductoId();
            resp.message = "El precio y el costo variable del producto se actualizo con exito";

            return ResponseEntity.ok(resp);
        
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/productos")
    public ResponseEntity<List<Producto>> listarProducto() {
        return ResponseEntity.ok(productoService.obtenerProductos());
    }

    @DeleteMapping("/productos/{id}")
    public ResponseEntity<GenericResponse> bajarProducto(@PathVariable int id) {
        try {
            Producto producto = productoService.buscarPorProductoId(id);
            producto.setEstado(false);
            productoService.saveProducto(producto);
            return ResponseEntity.ok().body(new GenericResponse(true, "Producto dado de baja con exito", producto.getProductoId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse(false, "No se dio de baja con exito! :c", 0));
        }
    }
}
