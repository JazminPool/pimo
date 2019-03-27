package e.jazmi.pimo.Atributos;

public class Atributos_Recordatorios {
    private String nombre, creacion, hora, descripcion;

    public Atributos_Recordatorios(){}

    public Atributos_Recordatorios(String nombre, String creacion, String hora, String descripcion){
        this.nombre     = nombre;
        this.creacion       = creacion;
        this.hora      = hora;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCreacion() {
        return creacion;
    }

    public void setCreacion(String creacion) {
        this.creacion = creacion;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
