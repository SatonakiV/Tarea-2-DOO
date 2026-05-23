import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NotaTest {

    @Test
    void testCreacionNotaGuardaContenidoYHoraAutomatica() {
        // 1. PREPARAR y EJECUTAR: Creamos una nota simple
        String mensaje = "Recordar actualizar el diagrama UML con el InvitadoExterno";
        Nota nuevaNota = new Nota(mensaje);

        // 3. COMPROBAR: 
        // Primero, verificamos que el texto se guardó exactamente igual
        assertEquals(mensaje, nuevaNota.getContenido(), "El contenido de la nota debe ser idéntico al ingresado");

        // Segundo, verificamos que la hora de anotación NO sea nula
        // (es decir, que el Instant.now() de tu constructor funcionó)
        assertNotNull(nuevaNota.getHoraAnotacion(), "La nota debe registrar automáticamente la hora al ser instanciada");

        // Tercero, verificamos que el toString() no devuelva un texto vacío
        assertFalse(nuevaNota.toString().isEmpty(), "El método toString de la nota no debería estar vacío");
    }
}