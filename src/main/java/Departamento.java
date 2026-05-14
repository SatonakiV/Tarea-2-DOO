import java.util.ArrayList;


public class Departamento implements Invitable {

    private String nombre;
    private ArrayList<Empleado> empleados;

    public Departamento(String nombre) {
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(ArrayList<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    @Override
    public void invitar() {
        for(Empleado empleado : empleados) {
            empleado.invitar();
        }
    }

    @Override
    public String toString() {
        return "Departamento de {"+ nombre + "}" + " , cantidad de empleados: " + empleados.size();
    }



}
