package ar.com.mujeres2000.sistema_gestion_financiera.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ar.com.mujeres2000.sistema_gestion_financiera.entitites.CostoFijo;
import ar.com.mujeres2000.sistema_gestion_financiera.repositories.CostoFijoRepository;

@Service
public class CostoFijoService {

	@Autowired
	CostoFijoRepository costoFijoRepo;
	
	public void saveCostoFijo(CostoFijo costoFijo) {
		 costoFijoRepo.save(costoFijo);
    }

    public CostoFijo buscarPorCostoFijoId(int id){
        Optional<CostoFijo> costoFijoOptional = costoFijoRepo.findById(id);
        if(costoFijoOptional.isPresent()){
            return costoFijoOptional.get();
        }
        return null; 
    }
    
    public void borrar(CostoFijo costoFijo) {
    	costoFijoRepo.delete(costoFijo);
	}
    
    public List<CostoFijo> obtenerCostoFijo() {
        return costoFijoRepo.findAll();
    
    }
    
    public void actualizarCostoFijoMonto(CostoFijo costoFijo, double precioNuevo) {
        costoFijo.setMonto(precioNuevo);
        saveCostoFijo(costoFijo);
    }
    
 


}

