package e.jazmi.pimo.Atributos;

public class Atributos_Nota {

    private String titulo_nota;
    private String nota;

    public Atributos_Nota(){ }

    public Atributos_Nota(String titulo_nota, String nota) {
        this.titulo_nota = titulo_nota;
        this.nota = nota;
    }

    public String getTitulo_nota() {
        return titulo_nota;
    }

    public void setTitulo_nota(String titulo_nota) {
        this.titulo_nota = titulo_nota;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
}
