import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class ReunionTest {

    // Variables que usaremos en todos los tests
    private Departamento deptoVentas;
    private Empleado organizador;
    private Empleado emp1;
    private InvitadoExterno invitado1;
    private ReunionPresencial reunionFisica;

    @BeforeEach
    void setUp() {
        // 1. PREPARAR (Arrange): Armamos el escenario antes de cada test
        deptoVentas = new Departamento("Ventas");
        organizador = new Empleado("1", "Perez", "Juan", "juan@empresa.cl", deptoVentas);
        emp1 = new Empleado("2", "Gomez", "Ana", "ana@empresa.cl", deptoVentas);
        invitado1 = new InvitadoExterno("Carlos Lopez", "carlos@externo.cl");

        reunionFisica = new ReunionPresencial(
                LocalDate.now(),
                LocalTime.of(10, 0),
                Duration.ofMinutes(60),
                organizador,
                tipoReunion.TECNICA,
                "Sala A"
        );
    }

    @Test
    void testAgregarAsistenciaYCalcularPorcentaje() {
        // 1. PREPARAR: Agregamos invitaciones
        reunionFisica.agregarInvitacion(new Invitacion(reunionFisica.getHoraPrevista(), emp1));
        reunionFisica.agregarInvitacion(new Invitacion(reunionFisica.getHoraPrevista(), invitado1));

        // 2. EJECUTAR (Act): Solo Ana (emp1) asiste a la reunión
        reunionFisica.agregarAsistencia(new Asistencia(emp1));

        // 3. COMPROBAR (Assert): Verificamos que el sistema calculó todo bien
        // Esperamos 1 asistente
        assertEquals(1, reunionFisica.getNumeroAsistencias(), "Debería haber exactamente 1 asistente registrado");

        // Esperamos 50.0% de asistencia (1 de 2 invitados)
        assertEquals(50.0f, reunionFisica.getPorcentajeAsistencia(), "El porcentaje de asistencia debería ser 50.0%");

        // Esperamos 1 ausente (Carlos Lopez)
        assertEquals(1, reunionFisica.getAusencias().size(), "Debería haber exactamente 1 ausente");
    }

    @Test
    void testCalculoTiempoRealReunion() {
        // 1. PREPARAR y EJECUTAR
        reunionFisica.inicio(); // Fija la horaInicio a now()

        // Simulamos que la reunión terminó (aunque sea en el mismo milisegundo para el test)
        reunionFisica.finalizar(); // Fija la horaFin a now()

        // 3. COMPROBAR
        Duration tiempoReal = reunionFisica.calculoTiempoReal();
        assertNotNull(tiempoReal, "El tiempo real no debería ser nulo si la reunión inició y finalizó");
    }
}