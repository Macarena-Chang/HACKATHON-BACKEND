package ar.com.mujeres2000.sistema_gestion_financiera.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.mujeres2000.sistema_gestion_financiera.entitites.Producto;

@Repository
public interface  ProductoRepository extends JpaRepository<Producto, Integer> {
    Producto findByNombre(String nombre);
}
