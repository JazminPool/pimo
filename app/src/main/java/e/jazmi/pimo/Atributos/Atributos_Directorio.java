package e.jazmi.pimo.Atributos;

public class Atributos_Directorio {
    private String nombre_profesor, materia_profesor, correo_profesor, telefono_profesor;

    public Atributos_Directorio(){}

    public Atributos_Directorio(String materia_profesor, String nombre_profesor){
        this.nombre_profesor   = nombre_profesor;
        this.materia_profesor  = materia_profesor;
//        this.correo_profesor   = correo_profesor;
//        this.telefono_profesor = telefono_profesor;
    }



    public String getNombre_profesor() {
        return nombre_profesor;
    }

    public void setNombre_profesor(String nombre_profesor) {
        this.nombre_profesor = nombre_profesor;
    }

    public String getMateria_profesor() {
        return materia_profesor;
    }

    public void setMateria_profesor(String materia_profesor) {
        this.materia_profesor = materia_profesor;
    }
//
//    public String getCorreo_profesor() {
//        return correo_profesor;
//    }
//
//    public void setCorreo_profesor(String correo_profesor) {
//        this.correo_profesor = correo_profesor;
//    }
//
//    public String getTelefono_profesor() {
//        return telefono_profesor;
//    }
//
//    public void setTelefono_profesor(String telefono_profesor) {
//        this.telefono_profesor = telefono_profesor;
//    }
}
