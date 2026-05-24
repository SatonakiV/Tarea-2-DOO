import java.time.LocalTime;
/**
 * Clase que representa la asistencia de un participante que llego tarde.
 * Hereda de la clase Asistencia.
 */
public class Retraso extends Asistencia {
    private LocalTime hora;
    /**
     * Constructor de la clase Retraso.
     * @param hora La hora exacta a la que llego el participante.
     * @param participante El invitado que llego atrasado.
     */
    public Retraso(LocalTime hora, Invitable participante) {
        super(participante);
        this.hora = hora;
    }
    /**
     * Obtiene la hora a la que llego el participante
     * @return Un objeto LocalTime con la hora de llegada.
     */
    public LocalTime getHora() {
        return hora;
    }
    /**
     * Cambia la hora de llegada del participante.
     * @param hora La nueva hora de llegada
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    /**
     * Genera un texto indicando que el participante esta presente pero llego tarde.
     * @return Un string con la informacion de la asistencia y la hora del retraso.
     */
    @Override
    public String toString() {
        return super.toString() + " - Llego tarde a las: " + hora;
    }
}