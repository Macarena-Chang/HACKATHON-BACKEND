package ar.com.mujeres2000.sistema_gestion_financiera.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mujeres2000.sistema_gestion_financiera.entitites.CostoFijo;
import ar.com.mujeres2000.sistema_gestion_financiera.services.CostoFijoService;
import ar.com.mujeres2000.sistema_gestion_financiera.models.requests.MontoNuevo;
import ar.com.mujeres2000.sistema_gestion_financiera.models.responses.GenericResponse;

@RestController
public class CostoFijoController {

	 @Autowired 
	 CostoFijoService costoFijoService;
	 
	 @PostMapping("/costoFijo")
	    public ResponseEntity<?> saveCostoFijo(@RequestBody CostoFijo costoFijo) {
	        try {
	        	costoFijoService.saveCostoFijo(costoFijo);
	            return ResponseEntity.ok().body(new GenericResponse(true, "Se guardo con exito prod con exito", costoFijo.getCostoFijoId()));
	        } catch (Exception e) {
	            
	            return ResponseEntity.badRequest().body(new GenericResponse(false, "No se guardo con exito! :c", 0));
	        }
	    }
	 
	 @GetMapping("/costoFijo")
	    public ResponseEntity<List<CostoFijo>> listarCostoFijo() {
	        return ResponseEntity.ok(costoFijoService.obtenerCostoFijo());
	    }
	 
	 @PutMapping("/costoFijo/actualizarMonto/{id}")
	    public ResponseEntity<?> actualizarCostoFijoMonto(@PathVariable int id, @RequestBody MontoNuevo montoNuevo) {

		 CostoFijo costoFijo = costoFijoService.buscarPorCostoFijoId(id);

	        if (costoFijo != null) {
	        	costoFijoService.actualizarCostoFijoMonto(costoFijo , montoNuevo.getMontoNuevo());

	            GenericResponse resp = new GenericResponse();
	            resp.isOk = true;
	            resp.id = costoFijo.getCostoFijoId();
	            resp.message ="El monto del Costo fijo se actualizo con exito";

	            return ResponseEntity.ok(resp);
	        
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	 
	 @DeleteMapping("/costoFijo/{id}")
	    public ResponseEntity<?> borrarcostoFijo(@PathVariable int id) {
	        CostoFijo costoFijo = costoFijoService.buscarPorCostoFijoId(id);
	        if(costoFijo !=null){
	        	costoFijoService.borrar(costoFijo);

	            
	            GenericResponse resp = new GenericResponse();
	            resp.isOk = true;
	            resp.id = id;
	            resp.message = "La venta se elimino conexito";

	            return ResponseEntity.ok(resp);
	        }
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    
	    
	    }
	 

}
