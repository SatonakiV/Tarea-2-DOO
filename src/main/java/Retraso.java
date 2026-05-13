import java.time.Instant;

public class Retraso extends Asistencia{
    public Instant hora;

    public Retraso(Instant hora, Invitable participante) {
        super(participante);
        this.hora = hora;
    }

    public Instant getHora(){
        return hora;
    }
    public void setHora(Instant hora){
        this.hora = hora;
    }

    @Override
    public String toString(){
        return super.toString() + "- Llego tarde a las: " + hora.toString();
    }

}
