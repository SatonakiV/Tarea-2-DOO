import java.time.LocalTime;

public class Retraso extends Asistencia {
    private LocalTime hora;

    public Retraso(LocalTime hora, Invitable participante) {
        super(participante);
        this.hora = hora;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return super.toString() + " - Llego tarde a las: " + hora;
    }
}