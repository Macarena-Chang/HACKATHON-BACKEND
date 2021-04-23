package ar.com.mujeres2000.sistema_gestion_financiera.entitites;

import javax.persistence.*;

@Entity
@Table(name = "producto")
public class Producto {
    
    @Id
    @Column(name="producto_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productoId;
    private String nombre;
    private double precio;
    @Column(name="costo_variable")
    private double costoVariable;
    @Column(name = "estado")
    private boolean estado;

    public int getProductoId() {
        return productoId;
    }
    
    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCostoVariable() {
        return costoVariable;
    }

    public void setCostoVariable(double costoVariable) {
        this.costoVariable = costoVariable;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

}
