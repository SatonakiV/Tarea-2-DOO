import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Clase que representa una reunion presencial.
 * Hereda de Reunion y añade la ubicacion fisica (sala).
 */
public class ReunionPresencial extends Reunion {

    private String sala;
    /**
     * Constructor de la reunion presencial.
     * @param fecha La fecha del encuentro.
     * @param horaPrevista Hora de inicio programada.
     * @param duracionPrevista Duracion estimada.
     * @param organizador Empleado que organiza.
     * @param tipoReunion El tipo de reunion.
     * @param sala Nombre o numero de la sala fisica.
     */
    public ReunionPresencial(LocalDate fecha, LocalTime horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String sala) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala = sala;
    }
    /**
     * Obtiene el nombre de la sala.
     * @return String con la sala.
     */
    public String getSala() {
        return sala;
    }
    /**
     * Cambia la sala de la reunion.
     * @param sala El nuevo nombre de la sala.
     */
    public void setSala(String sala) {
        this.sala = sala;
    }
    /**
     * Genera un reporte de la reunion incluyendo la modalidad presencial y la sala.
     * @return Un string con toda la informacion.
     */
    @Override
    public String toString() {

        return super.toString() +
                "\nModalidad: Presencial" +
                "\nSala: " + sala;
    }
}