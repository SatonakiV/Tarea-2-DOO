import java.time.Instant;

public class Nota {
    private String contenido;
    private Instant horaAnotacion;


    public Nota(String contenido) {
        this.contenido = contenido;
        horaAnotacion = Instant.now();
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public String getContenido() {
        return contenido;
    }



    public Instant getHoraAnotacion() {
        return horaAnotacion;
    }

    public void setHoraAnotacion(Instant horaAnotacion) {
        this.horaAnotacion = horaAnotacion;
    }

    @Override
    public String toString() {
        return "Anotación hecha a las " + "[" + horaAnotacion + "]" +  " - " + contenido;
    }

}
