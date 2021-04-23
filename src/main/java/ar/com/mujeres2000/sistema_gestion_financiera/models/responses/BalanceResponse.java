package ar.com.mujeres2000.sistema_gestion_financiera.models.responses;

import java.time.LocalDate;
import java.util.Date;

public class BalanceResponse {
    private double ganancias; 
    private double costosTotales;
    private double totalVentas;

    private LocalDate fecha;

    public double getGanancias() {
        return ganancias;
    }

    public void setGanancias(double ganancias) {
        this.ganancias = ganancias;
    }

    public double getCostosTotales() {
        return costosTotales;
    }

    public void setCostosTotales(double costosTotales) {
        this.costosTotales = costosTotales;
    }

    public double getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(double totalVentas) {
        this.totalVentas = totalVentas;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }



    
}
