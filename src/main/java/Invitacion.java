import java.time.LocalTime;
/**
 * Clase que representa la invitacion enviada a un participante.
 */
public class Invitacion {
    private LocalTime hora;
    private Invitable invitado;
    /**
     * Constructor de la clase Invitacion.
     * @param hora La hora a la que se envio la invitacion.
     * @param invitado El destinatario de la invitacion.
     */
    public Invitacion(LocalTime hora, Invitable invitado) {
        this.hora = hora;      // Ahora sí guarda la hora que le pasas
        this.invitado = invitado;
    }
    /**
     * Obtiene la hora en la que se hizo la invitacion.
     * @return Un objeto LocalTime con la hora.
     */
    public LocalTime getHora() {
        return hora;
    }
    /**
     * Cambia la hora de la invitacion.
     * @param hora La nueva hora.
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    /**
     * Obtiene a la persona o grupo invitado.
     * @return El objeto Invitable.
     */
    public Invitable getInvitado() {
        return invitado;
    }
    /**
     * Cambia el destinatario de la invitacion.
     * @param invitado El nuevo invitado.
     */
    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }
    /**
     * Genera un resumen de texto sobre la invitacion.
     * @return Un string con los detalles de a quien se invito y a que hora.
     */
    @Override
    public String toString() {
        return "Invitación enviada a : " + invitado.toString() + " a las " + hora;
    }
}