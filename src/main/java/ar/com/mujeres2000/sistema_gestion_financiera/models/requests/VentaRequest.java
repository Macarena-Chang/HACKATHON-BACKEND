package ar.com.mujeres2000.sistema_gestion_financiera.models.requests;

import java.sql.Date;

public class VentaRequest {

    
    private int productoId;
    private Date fecha;
    private int cantidad;

  
  

    public int getProductoId() {
        return productoId;
    }

    public void setProductoId(int productoId) {
        this.productoId = productoId;
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




}
