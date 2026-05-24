import java.time.Instant;
/**
 * Clase que guarda un apunte o nota tomada durante la reunion.
 */
public class Nota {
    private String contenido;
    private Instant horaAnotacion;
    /**
     * Constructor de la clase Nota. Guarda el texto y registra la hora actual.
     * @param contenido El texto del apunte.
     */
    public Nota(String contenido) {
        this.contenido = contenido;
        horaAnotacion = Instant.now();
    }
    /**
     * Modifica el texto de la nota.
     * @param contenido El nuevo texto.
     */
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    /**
     * Obtiene el texto de la nota
     * @return Un string con el contenido.
     */
    public String getContenido() {
        return contenido;
    }
    /**
     * Obtiene la hora exacta en la que se creo la nota
     * @return Un objeto Instant con la hora.
     */
    public Instant getHoraAnotacion() {
        return horaAnotacion;
    }
    /**
     * Cambia la hora de registro de la nota.
     * @param horaAnotacion La nueva hora.
     */
    public void setHoraAnotacion(Instant horaAnotacion) {
        this.horaAnotacion = horaAnotacion;
    }
    /**
     * Genera un texto mostrando la hora de la anotacion y lo que se escribio
     * @return Un string con el formato de la nota.
     */
    @Override
    public String toString() {
        return "Anotación hecha a las " + "[" + horaAnotacion + "]" +  " - " + contenido;
    }

}
