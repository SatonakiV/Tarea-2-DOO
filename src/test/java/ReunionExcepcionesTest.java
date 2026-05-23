import org.junit.jupiter.api.Test;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class ReunionExcepcionesTest {

    @Test
    void testCalculoTiempoRealFallaSiNoHaFinalizado() {
        // 1. PREPARAR: Creamos una reunión básica
        Departamento depto = new Departamento("Ventas");
        Empleado organizador = new Empleado("1", "Perez", "Juan", "j@empresa.cl", depto);
        ReunionPresencial reunion = new ReunionPresencial(
                LocalDate.now(),
                LocalTime.of(10, 0),
                Duration.ofMinutes(60),
                organizador,
                tipoReunion.TECNICA,
                "Sala 1"
        );

        // 2. EJECUTAR: Iniciamos la reunión, pero A PROPÓSITO no la finalizamos
        reunion.inicio();
        // reunion.finalizar(); <-- Comentado a propósito para forzar el error

        // 3. COMPROBAR: Verificamos que Java lance una excepción NullPointerException 
        // al intentar calcular el tiempo con una variable en null.
        assertThrows(NullPointerException.class, () -> {
            reunion.calculoTiempoReal();
        }, "Debería lanzar NullPointerException si se calcula el tiempo sin haber finalizado la reunión");
    }
}