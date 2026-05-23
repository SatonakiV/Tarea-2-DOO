import java.time.LocalTime;

public class Invitacion {
    private LocalTime hora;
    private Invitable invitado;

    public Invitacion(LocalTime hora, Invitable invitado) {
        this.hora = hora;      // Ahora sí guarda la hora que le pasas
        this.invitado = invitado;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public Invitable getInvitado() {
        return invitado;
    }

    public void setInvitado(Invitable invitado) {
        this.invitado = invitado;
    }

    @Override
    public String toString() {
        return "Invitación enviada a : " + invitado.toString() + " a las " + hora;
    }
}