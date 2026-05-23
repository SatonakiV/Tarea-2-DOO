import org.junit.jupiter.api.Test;
import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import static org.junit.jupiter.api.Assertions.*;

public class InformeTest {

    @Test
    void testGenerarInformeCreaArchivoTxt() {
        // 1. PREPARAR: Creamos una reunión básica y una nota
        Departamento depto = new Departamento("Sistemas");
        Empleado organizador = new Empleado("99", "Lovelace", "Ada", "ada@empresa.cl", depto);

        ReunionVirtual reunion = new ReunionVirtual(
                LocalDate.now(),
                LocalTime.of(15, 0),
                Duration.ofMinutes(45),
                organizador,
                tipoReunion.TECNICA,
                "meet.google.com/abc"
        );
        reunion.agregarNota(new Nota("El sistema no debe fallar al compilar."));

        Informe gestorInforme = new Informe();

        // 2. EJECUTAR: Mandamos a generar el .txt
        gestorInforme.generarTxt(reunion);

        // 3. COMPROBAR: Verificamos que el archivo "Informe_reunion.txt" existe de verdad
        File archivoGenerado = new File("Informe_reunion.txt");

        assertTrue(archivoGenerado.exists(), "El archivo Informe_reunion.txt debería haberse creado en el disco");

        // (Opcional pero buena práctica: limpiar la evidencia después del test para que no ensucie tu proyecto)
        // archivoGenerado.delete(); 
    }
}