import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

/**
 * Clase abstracta base que representa una reunion general.
 * Contiene la logica comun para manejar invitados, asistencia y estadisticas.
 */
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

    /**
     * Constructor de la clase abstracta Reunion.
     * @param fecha La fecha programada.
     * @param horaPrevista La hora de inicio prevista.
     * @param duracionPrevista La duracion estimada en minutos.
     * @param organizador El empleado que organiza la reunion.
     * @param tipoReunion El tipo de reunion (ej. operativa, estrategica).
     */
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

    /**
     * Registra la hora real de inicio de la reunion.
     */
    public void inicio(){
        horaInicio = LocalTime.now();

    }
    /**
     * Registra la hora real de finalizacion de la reunion.
     */
    public void finalizar(){
        horaFin = LocalTime.now();
    }
    /**
     * Retorna la lista completa de asistencias registradas.
     * @return Un ArrayList de objetos Asistencia.
     */
    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }
    /**
     * Filtra y devuelve solo los casos donde hubo retrasos.
     * @return Un ArrayList con los objetos de tipo Retraso.
     */
    public ArrayList<Retraso> getRetrasos(){
        ArrayList<Retraso> retrasos = new ArrayList<>();
        for(Asistencia as: asistencias){
            if(as instanceof Retraso){
                retrasos.add((Retraso) as);

            }
        }
        return retrasos;
    }
    /**
     * Calcula qué invitados no registraron asistencia.
     * @return Una lista con los participantes ausentes.
     */
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
    /**
     * Obtiene la cantidad total de asistentes.
     * @return El numero total de asistencias.
     */
    public int getNumeroAsistencias(){
        return asistencias.size();
    }
    /**
     * Calcula el porcentaje de asistencia respecto al total de invitaciones.
     * @return El porcentaje de asistencia como un numero float.
     */
    public float getPorcentajeAsistencia(){
        return (float) ((float)asistencias.size() / invitaciones.size()) * 100;
    }
    /**
     * Calcula la duracion real de la reunion (fin - inicio).
     * @return La duracion total como un objeto Duration.
     */
    public Duration calculoTiempoReal(){
        return Duration.between(horaInicio, horaFin);
    }

    //Getters y setters
    /**
     * Metodos Getters y Setters para los atributos de la clase.
     */
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
    /**
     * Metodos para agregar informacion a las listas.
     */
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
    /**
     * Genera un reporte completo de la reunion, incluyendo asistencias, ausentes y estadisticas.
     * @return Un string con toda la informacion formateada.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== Detalles de la Reunion ===\n");
        sb.append("Fecha: ").append(fecha).append("\n");
        sb.append("Hora Prevista: ").append(horaPrevista).append("\n");
        sb.append("Duracion Prevista: ").append(duracionPrevista.toMinutes()).append(" Minutos\n");
        sb.append("Tipo de Reunion: ").append(tipoReunion).append("\n");
        sb.append("Organizador: ").append(organizador.getNombre()).append(" ").append(organizador.getApellidos()).append("\n");
        sb.append("Hora de inicio: ").append(horaInicio != null ? horaInicio : "Aun no inicia...").append("\n");
        sb.append("Hora de final: ").append(horaFin != null ? horaFin : "Aun no termina...").append("\n");

        sb.append("\n--- Lista de Asistentes ---\n");
        if (asistencias.isEmpty()) {
            sb.append("No hay registros de asistencia aún.\n");
        } else {
            for (Asistencia as : asistencias) {
                sb.append("- ").append(as.toString()).append("\n");
            }
        }

        sb.append("\n--- Lista de Ausentes ---\n");
        ArrayList<Invitable> ausentes = getAusencias();
        if (ausentes.isEmpty()) {
            sb.append("No hay ausentes (o no se han enviado invitaciones).\n");
        } else {
            for (Invitable inv : ausentes) {
                sb.append("- ").append(inv.toString()).append("\n");
            }
        }

        sb.append("\n--- Estadisticas ---\n");
        sb.append("Asistencia total: ").append(getNumeroAsistencias()).append("\n");
        sb.append("Porcentaje de asistencia: ").append(String.format("%.1f", getPorcentajeAsistencia())).append("%\n");

        return sb.toString();
    }
}
