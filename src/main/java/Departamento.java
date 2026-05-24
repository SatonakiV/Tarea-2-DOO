/**
 * Clase que representa un departamento de la empresa.
 * Agrupa a varios empleados y puede ser invitado a una reunion.
 */
import java.util.ArrayList;


public class Departamento implements Invitable {

    private String nombre;
    private ArrayList<Empleado> empleados;

    /**
     * Constructor de la clase departamento.
     * @param nombre El nombre del departamento.
     */
    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /**
     * Obtiene el nombre del departamento.
     * @return Un string con el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Cambia el nombre del departamento.
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la lista de empleados que pertenece al departamento.
     * @return Un Arraylist con los empleados.
     */
    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Cambia la lista completa de empleados del departamento.
     * @param empleados El nuevo Arraylist de empleados.
     */
    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    /**
     * Agrega un nuevo empleado a la lista del departamento.
     * @param empleado El objeto empleado que se va a agregar.
     */
    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    /**
     * Invita a todos los empleados del departamento a la reunion.
     * Recorre la lista y llama al metodo invitar de cada empleado.
     */
    @Override
    public void invitar() {
        for(Empleado empleado : empleados) {
            empleado.invitar();
        }
    }

    /**
     * Genera un texto con el nombre del departamento y su cantidad de empleados.
     * @return Un string con la informacion basica del departamento.
     */
    @Override
    public String toString() {
        return "Departamento de {"+ nombre + "}" + " , cantidad de empleados: " + empleados.size();
    }



}
