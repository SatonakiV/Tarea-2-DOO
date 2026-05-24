/**
 * Clase que guarda la asistencia de un invitado a la reunion.
 */
public class Asistencia {

    private Invitable participante;

    /**
     * Constructor de la clase asistencia.
     * @param participante El participante que asiste a la reunion.
     */
    public Asistencia(Invitable participante) {
        this.participante = participante;
    }

    /**
     * Obtiene al participante asociado a esta asistencia.
     * @return El objeto invitable que representa al participante.
     */
    public Invitable getParticipante() {
        return participante;
    }

    /**
     * Modifica al participante de esta asistencia.
     * @param participante El nuevo participante a registrar.
     */
    public void setParticipante(Invitable participante) {
        this.participante = participante;
    }

    /**
     * Genera un texto indicando que el participante esta presente
     * @return Un string con la palabra presente y los datos del participante.
     */

    @Override
    public String toString() {
        return "Presente: " + participante.toString();
    }
}
