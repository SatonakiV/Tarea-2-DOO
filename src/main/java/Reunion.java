import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;


abstract class Reunion {
    private LocalDate fecha;
    private LocalTime horaPrevista;
    private Duration duracionPrevista;
    private LocalTime horaInicio;
    private LocalTime horaFin;



    private ArrayList<Invitacion> invitaciones;
    private ArrayList<Asistencia> asistencias;
    private ArrayList<Nota>  notas;
    private Empleado organizador;
    private tipoReunion tipoReunion;


    public Reunion(LocalDate fecha, LocalTime horaPrevista, Duration duracionPrevista, Empleado organizador, tipoReunion tipoReunion) {
        this.invitaciones = new ArrayList<>();
        this.asistencias = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.organizador = organizador;
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.tipoReunion = tipoReunion;

    }


    //Metodos
    public void inicio(){
        horaInicio = LocalTime.now();

    }

    public void finalizar(){
        horaFin = LocalTime.now();
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    public ArrayList<Retraso> getRetrasos(){
        ArrayList<Retraso> retrasos = new ArrayList<>();
        for(Asistencia as: asistencias){
            if(as instanceof Retraso){
                retrasos.add((Retraso) as);

            }
        }
        return retrasos;
    }

    public ArrayList<Invitable> getAusencias() {
        ArrayList<Invitable> Ausentes = new ArrayList<>();
        for (Invitacion invitacione : invitaciones) {
            Invitable Invitado = invitacione.getInvitado();
            boolean asistio = false;

            for (Asistencia asistencia : asistencias) {
                if ((invitacione.getInvitado()).equals(asistencia.getParticipante())) {
                    asistio = true;
                    break;
                }
            }

            if(asistio == false){
                Ausentes.add(Invitado);
            }
        }


        return Ausentes;
    }

    public int getNumeroAsistencias(){
        return asistencias.size();
    }

    public float getPorcentajeAsistencia(){
        return (float) ((float)asistencias.size() / invitaciones.size()) * 100;
    }

    public Duration calculoTiempoReal(){
        return Duration.between(horaInicio, horaFin);
    }

    //Getters y setters

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHoraPrevista() {
        return horaPrevista;
    }

    public void setHoraPrevista(LocalTime horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(LocalTime horaInicio) {
        this.horaInicio = horaInicio;
    }

    public LocalTime getHoraFin() {
        return horaFin;
    }

    public void setHoraFin(LocalTime horaFin) {
        this.horaFin = horaFin;
    }

    public Empleado getOrganizador() {
        return organizador;
    }

    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    public tipoReunion getTipoReunion() {
        return tipoReunion;
    }

    public void setTipoReunion(tipoReunion tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    public ArrayList<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    public void setInvitaciones(ArrayList<Invitacion> invitaciones) {
        this.invitaciones = invitaciones;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    public void setAsistencias(ArrayList<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    //Metodos add

    public void agregarInvitacion(Invitacion invitacion){
        this.invitaciones.add(invitacion);
    }

    public void agregarAsistencia(Asistencia asistencia){
        this.asistencias.add(asistencia);
    }

    public void agregarNota(Nota nota){
        this.notas.add(nota);
    }
    @Override
    public String toString(){
        return "Detalles de la Reunion"
                + "\nFecha: " + fecha +
                "\nHora Prevista: " + horaPrevista +
                "\nDuracion Prevista: " + duracionPrevista.toMinutes() + "Minutos" +
                "\nTipo de Reunion: " + tipoReunion.getTipo() +
                "\nOrganizador: " + organizador.getNombre() +
                "\nHora de inicio: " + (horaInicio != null ? horaInicio : "Aun no inicia esta reunion...") +
                "\nHora de final: " + (horaFin != null ? horaFin : "La reunion aun no termina...") +
                "\nEstadisticas de la reunion: " +
                "\n Asistencia total: " + getNumeroAsistencias() +
                "\n Ausentes: " + getAusencias().size() +
                "\n Porcentaje de asistencia: " + getPorcentajeAsistencia();


    }

}
