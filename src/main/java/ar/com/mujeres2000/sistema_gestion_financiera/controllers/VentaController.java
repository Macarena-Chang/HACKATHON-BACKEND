package ar.com.mujeres2000.sistema_gestion_financiera.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.mujeres2000.sistema_gestion_financiera.ExcelExporter.VentaExcelExporter;
import ar.com.mujeres2000.sistema_gestion_financiera.entitites.Venta;
import ar.com.mujeres2000.sistema_gestion_financiera.models.requests.VentaRequest;
import ar.com.mujeres2000.sistema_gestion_financiera.models.responses.GenericResponse;
import ar.com.mujeres2000.sistema_gestion_financiera.services.ProductoService;
import ar.com.mujeres2000.sistema_gestion_financiera.services.VentaService;

@RestController
public class VentaController {
    @Autowired
    VentaService ventaService;
    @Autowired
    ProductoService productoService;

    @PostMapping("/ventas")
    public ResponseEntity<?> saveVenta(@RequestBody VentaRequest ventaRequest) {

       Venta venta = new Venta();
       venta.setUsuarioId(1);
       venta.setProductoId(ventaRequest.getProductoId());
       venta.setFecha(ventaRequest.getFecha()); 
       venta.setImporte(productoService.buscarPorProductoId(ventaRequest.getProductoId()).getPrecio() * ventaRequest.getCantidad());
       venta.setCostoVariable(productoService.buscarPorProductoId(ventaRequest.getProductoId()).getCostoVariable()* ventaRequest.getCantidad()); 
       venta.setCantidad(ventaRequest.getCantidad());
       
        try {
            ventaService.saveVenta(venta);
            return ResponseEntity.ok().body(new GenericResponse(true, "Se guardo con exito! c:", venta.getVentaId()));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new GenericResponse(false, "No se guardo con exito! :c", 0));
        }
    }

    @DeleteMapping("/ventas/{id}")
    public ResponseEntity<?> borrarVenta(@PathVariable int id) {
        Venta venta = ventaService.buscarVentaPorId(id);
        if(venta !=null){
            ventaService.borrar(venta);

            
            GenericResponse resp = new GenericResponse();
            resp.isOk = true;
            resp.id = id;
            resp.message = "La venta se elimino conexito";

            return ResponseEntity.ok(resp);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    
    
    }


    @GetMapping("/ventas")
    public ResponseEntity<?> listarVentas() {

        return ResponseEntity.ok(ventaService.listarVentas());
    }


    @GetMapping("/ventas/export/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
         
        List<Venta> listaVentas = ventaService.listarVentas();
         
        VentaExcelExporter excelExporter = new VentaExcelExporter(listaVentas);
         
        excelExporter.export(response);    
    }  

    


      
 



    
}
