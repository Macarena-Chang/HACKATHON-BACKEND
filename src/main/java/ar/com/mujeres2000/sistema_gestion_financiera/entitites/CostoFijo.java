package ar.com.mujeres2000.sistema_gestion_financiera.entitites;

import java.util.Date;

import javax.persistence.*;

import antlr.collections.List;

@Entity
@Table(name = "Costo_fijo")
public class CostoFijo {

    
    @Id
    @Column(name="costo_fijo_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int costoFijoId;
    private int usuarioId;
    private Date fecha;
    private String nombre;
    private double monto;
    private boolean esHogar;

    public int getCostoFijoId() {
        return costoFijoId;
    }

    public void setCostoFijoId(int costoFijoId) {
        this.costoFijoId = costoFijoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public boolean isEsHogar() {
        return esHogar;
    }

    public void setEsHogar(boolean esHogar) {
        this.esHogar = esHogar;
    }

   




    
}
