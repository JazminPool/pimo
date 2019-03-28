package e.jazmi.pimo.Atributos;

import com.google.gson.annotations.SerializedName;

public class Atributos_Nota {

    @SerializedName("titulo")
    private String titulo;
    @SerializedName("hora")
    private String hora;
    @SerializedName("descripcion")
    private String descripcion;


    public Atributos_Nota(String titulo, String descripcion,String hora) {
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.hora = hora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getHora() {return hora; }

    public void setHora(String hora) {this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = descripcion;
    }

}
