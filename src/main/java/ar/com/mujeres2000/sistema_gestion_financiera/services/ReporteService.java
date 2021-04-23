package ar.com.mujeres2000.sistema_gestion_financiera.services;

import java.time.LocalDate;
import java.util.Date;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;

import ar.com.mujeres2000.sistema_gestion_financiera.repositories.*;
@Service
public class ReporteService {
    @Autowired
    VentaRepository ventaRepo;
    @Autowired
    CostoFijoRepository costoFijoRepo;

    public double obtenerImporteTotalVentas(LocalDate fecha){
      
        return ventaRepo.totalImporteVentas(fecha.getYear(),fecha.getMonthValue());
       // return ventaRepo.totalImporteVentasDiciembre();
    }

	public double obtenerCostosVariablesVentas(LocalDate fecha) {
		return ventaRepo.totalCostoVariableVentas(fecha.getYear(),fecha.getMonthValue());
    }
    
    public double obtenerCostosFijos(LocalDate fecha) {
		return costoFijoRepo.totalCostosFijos(fecha.getYear(),fecha.getMonthValue());
	}

	   
   
	




    
}
