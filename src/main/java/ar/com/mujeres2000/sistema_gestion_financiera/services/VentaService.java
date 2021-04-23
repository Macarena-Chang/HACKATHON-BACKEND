package ar.com.mujeres2000.sistema_gestion_financiera.services;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import ar.com.mujeres2000.sistema_gestion_financiera.entitites.Venta;
import ar.com.mujeres2000.sistema_gestion_financiera.repositories.VentaRepository;

@Service
public class VentaService {
	@Autowired
	VentaRepository ventaRepo; 
	
    public void saveVenta(Venta venta) {
        ventaRepo.save(venta);
    }

	public Venta buscarVentaPorId(int id) {
        Optional<Venta> ventaOp = ventaRepo.findById(id);
        if(ventaOp.isPresent()){
            return ventaOp.get();
        }
        return null; 
	}

	public void borrar(Venta venta) {
        ventaRepo.delete(venta);
	}

    //esta es la lista que vamos a exportar a excel.
	public  List<Venta>  listarVentas() {
		return ventaRepo.findAll(Sort.by("fecha").descending());
	}

	
}
