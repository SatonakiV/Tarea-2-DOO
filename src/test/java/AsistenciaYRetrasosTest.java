import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class AsistenciaYRetrasosTest {

    private ReunionVirtual reunion;
    private Empleado emp1;
    private InvitadoExterno ext1;

    @BeforeEach
    void setUp() {
        // 1. PREPARAR: Escenario base
        Departamento deptoIT = new Departamento("TI");
        Empleado organizador = new Empleado("1", "Jefe", "Jefe", "jefe@empresa.cl", deptoIT);
        reunion = new ReunionVirtual(LocalDate.now(), LocalTime.of(9, 0), Duration.ofMinutes(30), organizador, tipoReunion.OTRO, "Link");

        // Tenemos un empleado normal y un invitado externo
        emp1 = new Empleado("2", "Gomez", "Ana", "ana@empresa.cl", deptoIT);
        ext1 = new InvitadoExterno("Juan Perez", "juan@externo.cl");

        // Invitamos a ambos
        reunion.agregarInvitacion(new Invitacion(LocalTime.of(9, 0), emp1));
        reunion.agregarInvitacion(new Invitacion(LocalTime.of(9, 0), ext1));
    }

    @Test
    void testNadieAsisteGeneraCeroPorcentajeYTodosAusentes() {
        // 2. EJECUTAR: No agregamos NINGUNA asistencia. La reunión queda vacía.

        // 3. COMPROBAR: Casos Extremos
        assertEquals(0, reunion.getNumeroAsistencias(), "No debería haber asistencias");
        assertEquals(2, reunion.getAusencias().size(), "Si nadie asiste, ambos deben ser marcados como ausentes");
        assertEquals(0.0f, reunion.getPorcentajeAsistencia(), "El porcentaje debe ser 0.0%");
    }

    @Test
    void testRetrasoSeCuentaComoAsistenciaYDejaUnAusente() {
        // 2. EJECUTAR: El invitado externo llega tarde. Ana simplemente no asiste.
        // OJO: Le pasamos un LocalTime distinto para simular la tardanza
        reunion.agregarAsistencia(new Retraso(LocalTime.of(9, 15), ext1));

        // 3. COMPROBAR
        // Aunque llegó tarde, el retraso debe sumarse al contador total de asistencia
        assertEquals(1, reunion.getNumeroAsistencias(), "El retraso debe contar como 1 asistencia");

        // Verificamos que se haya guardado específicamente en la lista de retrasos
        assertEquals(1, reunion.getRetrasos().size(), "Debe haber exactamente 1 persona atrasada");

        // Verificamos que nuestra lógica de .equals() detectó que Ana faltó
        assertEquals(1, reunion.getAusencias().size(), "Ana debería ser la única ausente");

        // El porcentaje debería ser 50% (1 de 2)
        assertEquals(50.0f, reunion.getPorcentajeAsistencia(), "El porcentaje debe ser 50.0%");
    }
}