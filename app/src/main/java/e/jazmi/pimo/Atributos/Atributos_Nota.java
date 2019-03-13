package e.jazmi.pimo.Atributos;

import com.google.gson.annotations.SerializedName;

public class Atributos_Nota {

    @SerializedName("titulo")
    private String titulo;
    @SerializedName("descripcion")
    private String descripcion;

    public Atributos_Nota(){ }

    public Atributos_Nota(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.descripcion = descripcion;
    }
}
