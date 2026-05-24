import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
/**
 * Clase que representa una reunion virtual.
 * Hereda de reunion y añade el enlace de la videollamada.
 */
public class ReunionVirtual extends Reunion {

    private String enlace;
    /**
     * Constructor de la reunion virtual.
     * @param fecha La fecha del encuentro.
     * @param horaPrevista Hora de inicio programada.
     * @param duracionPrevista Duracion estimada.
     * @param organizador Empleado que organiza.
     * @param tipoReunion El tipo de reunion.
     * @param enlace URL o link de la videollamada.
     */
    public ReunionVirtual(LocalDate fecha, LocalTime horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.enlace = enlace;
    }
    /**
     * Obtiene el link de la reunion.
     * @return String con el enlace.
     */
    public String getEnlace() {
        return enlace;
    }
    /**
     * Cambia el link de la reunion.
     * @param enlace El nuevo enlace web.
     */
    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }
    /**
     * Genera un reporte de la reunion incluyendo la modalidad virtual y el enlace.
     * @return Un string con toda la informacion.
     */
    @Override
    public String toString() {
        return super.toString() +
                "\nModalidad: Virtual" +
                "\nEnlace: " + enlace;
    }
}