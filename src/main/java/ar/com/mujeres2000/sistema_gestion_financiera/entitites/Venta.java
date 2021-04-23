package ar.com.mujeres2000.sistema_gestion_financiera.entitites;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name="venta")
public class Venta {
    @Id
    @Column(name="venta_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ventaId;
    private Integer usuarioId;
    private int productoId;
    private Date fecha;
    private double importe;
    @Column(name="costo_variable_venta")
    private double costoVariableVenta;
    private int cantidad;

    public Integer getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Integer usuarioId) {
        this.usuarioId = usuarioId;
    }

   
    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    public void setImporte(double importe) {
        this.importe = importe;
    }

    public void setCostoVariable(double costoVariable) {
        this.costoVariableVenta = costoVariable;
    }

    public Integer getVentaId() {
        return ventaId;
    }

    public void setVentaId(Integer ventaId) {
        this.ventaId = ventaId;
    }

    public double getImporte() {
        return importe;
    }

 
    public double getCostoVariableVenta() {
        return costoVariableVenta;
    }

    public void setCostoVariableVenta(double costoVariableVenta) {
        this.costoVariableVenta = costoVariableVenta;
    }

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
    }
}
