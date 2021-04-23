package ar.com.mujeres2000.sistema_gestion_financiera.models.responses;

public class GenericResponse {
    public boolean isOk;
    public String message;
    public Integer id;

    public GenericResponse(boolean isOk, String message, Integer id) {
        this.isOk = isOk;
        this.message = message;
        this.id = id;
    }
    
    public GenericResponse() {
    }
}
