package ar.com.mujeres2000.sistema_gestion_financiera.controllers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import ar.com.mujeres2000.sistema_gestion_financiera.models.responses.BalanceResponse;
import ar.com.mujeres2000.sistema_gestion_financiera.services.ReporteService;
@RestController
public class ReporteController {
    @Autowired
    ReporteService reporteService;

    @PostMapping("/balance")
        public BalanceResponse getReporteBalance(@RequestBody BalanceResponse request ) {

        double costosVariables = reporteService.obtenerCostosVariablesVentas(request.getFecha());
        double totalVentas= reporteService.obtenerImporteTotalVentas(request.getFecha());      
        double costosFijos = reporteService.obtenerCostosFijos(request.getFecha());
        double costosTotales = costosVariables+ costosFijos;

        BalanceResponse balanceResponse = new BalanceResponse();
        balanceResponse.setTotalVentas(totalVentas);        
        balanceResponse.setCostosTotales(costosFijos + costosVariables ); //sumar costos fijos para mes/año y costos variables del mes/año de cada producto.
        balanceResponse.setGanancias(totalVentas - costosTotales); //Ventas - costosTotales.
        
        return balanceResponse;
    }
    
}
