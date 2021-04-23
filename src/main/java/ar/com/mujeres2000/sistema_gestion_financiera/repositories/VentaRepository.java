package ar.com.mujeres2000.sistema_gestion_financiera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.mujeres2000.sistema_gestion_financiera.entitites.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer> {

    @Query(value = "SELECT  coalesce(sum(importe),0) FROM Venta v WHERE  YEAR(v.fecha) = ?1 AND MONTH(v.fecha) = ?2")
    public double totalImporteVentas(int anio, int mes);

    @Query(value = "SELECT coalesce(sum(costoVariableVenta),0) FROM Venta v WHERE  YEAR(v.fecha) = ?1 AND MONTH(v.fecha) = ?2")
    public double totalCostoVariableVentas(int anio, int mes);


    




    
}
