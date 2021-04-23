package ar.com.mujeres2000.sistema_gestion_financiera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import antlr.collections.List;
import ar.com.mujeres2000.sistema_gestion_financiera.entitites.CostoFijo;
import ar.com.mujeres2000.sistema_gestion_financiera.entitites.Producto;

@Repository
public interface CostoFijoRepository extends JpaRepository<CostoFijo, Integer>{

    @Query(value = "SELECT coalesce(sum(monto),0) FROM CostoFijo c WHERE  YEAR(c.fecha) = ?1 AND MONTH(c.fecha) = ?2")
    public double totalCostosFijos(int anio, int mes);
}
