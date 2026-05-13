import java.time.Instant;

public class Invitacion {
    private Instant hora;

    private Invitable invitado;

    public Invitacion(Instant hora, Invitable invitado) {
        this.invitado = invitado;
        this.hora = Instant.now();

    }

    public Instant getHora() {
        return hora;
    }

    public Invitable getInvitado() {
        return invitado;
    }

    public void setHora(Instant hora) {
        this.hora = hora;

    }

    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }

    @Override
    public String toString() {
        return "Invitación enviada a : " + invitado.toString() + " a las " + hora;
    }
}
