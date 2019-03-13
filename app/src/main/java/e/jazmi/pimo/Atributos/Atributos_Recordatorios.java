package e.jazmi.pimo.Atributos;

public class Atributos_Recordatorios {
    private String titulo_recordatorio, hora_recordatorio, fecha_recordatorio, comentario_recordatorio;

    public Atributos_Recordatorios(){}

    public Atributos_Recordatorios(String titulo_recordatorio, String hora_recordatorio, String fecha_recordatorio, String comentario_recordatorio){
        this.titulo_recordatorio     = titulo_recordatorio;
        this.hora_recordatorio       = hora_recordatorio;
        this.fecha_recordatorio      = fecha_recordatorio;
        this.comentario_recordatorio = comentario_recordatorio;
    }

    public String getTitulo_recordatorio() {
        return titulo_recordatorio;
    }

    public void setTitulo_recordatorio(String titulo_recordatorio) {
        this.titulo_recordatorio = titulo_recordatorio;
    }

    public String getHora_recordatorio() {
        return hora_recordatorio;
    }

    public void setHora_recordatorio(String hora_recordatorio) {
        this.hora_recordatorio = hora_recordatorio;
    }

    public String getFecha_recordatorio() {
        return fecha_recordatorio;
    }

    public void setFecha_recordatorio(String fecha_recordatorio) {
        this.fecha_recordatorio = fecha_recordatorio;
    }

    public String getComentario_recordatorio() {
        return comentario_recordatorio;
    }

    public void setComentario_recordatorio(String comentario_recordatorio) {
        this.comentario_recordatorio = comentario_recordatorio;
    }
}
