import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;

public class ReunionPresencial extends Reunion {

    private String sala;

    public ReunionPresencial(LocalDate fecha, LocalTime horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion, String sala) {
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }

    @Override
    public String toString() {

        return super.toString() +
                "\nModalidad: Presencial" +
                "\nSala: " + sala;
    }
}