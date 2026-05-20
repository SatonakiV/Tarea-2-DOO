import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReunionVirtual extends Reunion {

    private String enlace;

    public ReunionVirtual(LocalDate fecha, LocalTime horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String enlace) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.enlace = enlace;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nModalidad: Virtual" +
                "\nEnlace: " + enlace;
    }
}