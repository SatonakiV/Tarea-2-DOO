import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DepartamentoTest {

    @Test
    void testAgregarEmpleadosYContarCorrectamente() {
        // 1. PREPARAR: Creamos un departamento y un par de empleados
        Departamento marketing = new Departamento("Marketing");
        Empleado emp1 = new Empleado("1", "Gomez", "Ana", "ana@empresa.cl", marketing);
        Empleado emp2 = new Empleado("2", "Perez", "Juan", "juan@empresa.cl", marketing);

        // 2. EJECUTAR: Los agregamos a la lista interna del departamento
        marketing.agregarEmpleado(emp1);
        marketing.agregarEmpleado(emp2);

        // 3. COMPROBAR: Verificamos que el nombre esté bien y que haya exactamente 2 empleados
        assertEquals("Marketing", marketing.getNombre(), "El nombre del departamento debe coincidir");
        assertEquals(2, marketing.getEmpleados().size(), "El departamento debería tener exactamente 2 empleados registrados");
    }
}