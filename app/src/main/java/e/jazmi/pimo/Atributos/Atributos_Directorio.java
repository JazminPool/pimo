package e.jazmi.pimo.Atributos;

import com.google.gson.annotations.SerializedName;

public class Atributos_Directorio {

    @SerializedName("nombre")
    private String nombre;
    @SerializedName("carrera")
    private String carrera;
    @SerializedName("materia")
    private String materia;
    @SerializedName("turno")
    private String turno;
    @SerializedName("correo")
    private String correo;
    @SerializedName("celular")
    private String celular;

    public Atributos_Directorio(String nombre, String carrera, String materia, String turno, String correo, String celular) {
        this.nombre = nombre;
        this.carrera = carrera;
        this.materia = materia;
        this.turno = turno;
        this.correo = correo;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
