/**
 * Clase que representa a un empleado de la empresa.
 * Un empleado puede ser invitado a reuniones y pertenece a un departamento.
 */
public class Empleado implements Invitable {

    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private Departamento departamento;
    /**
     * Constructor de la clase Empleado.
     * @param id El identificador unico del empleado.
     * @param apellidos Los apellidos del empleado.
     * @param nombre El nombre del empleado.
     * @param correo El correo electronico del empleado.
     * @param departamento El departamento donde trabaja.
     */
    public Empleado(String id, String apellidos, String nombre, String correo, Departamento departamento) {
        this.id = id;
        this.apellidos = apellidos;
        this.nombre = nombre;
        this.correo = correo;
        this.departamento = departamento;
    }
    /**
     * Obtiene el ID del empleado.
     * @return Un string con el ID
     */
    public String getId() {
        return id;
    }
    /**
     * Cambia el ID del empleado.
     * @param id El nuevo ID.
     */
    public void setId(String id) {
        this.id = id;
    }
    /**
     * Obtiene los apellidos del empleado.
     * @return Un string con los apellidos.
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Cambia los apellidos del empleado.
     * @param apellidos Los nuevos apellidos.
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    /**
     * Obtiene el nombre del empleado.
     * @return Un string con el nombre.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Cambia el nombre del empleado.
     * @param nombre El nuevo nombre.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Obtiene el correo del empleado.
     * @return Un string con el correo.
     */
    public String getCorreo() {
        return correo;
    }
    /**
     * Cambia el correo del empleado.
     * @param correo El nuevo correo.
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }
    /**
     * Obtiene el departamento al que pertenece el empleado.
     * @return El objeto Departamento.
     */
    public Departamento getDepartamento() {
        return departamento;
    }
    /**
     * Cambia el departamento del empleado.
     * @param departamento El nuevo departamento.
     */
    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }
    /**
     * Simula enviar una invitacion imprimiendo un mensaje en consola.
     */
    @Override
    public void invitar() {
        System.out.println("Enviando invitación a: " + correo);
    }
    /**
     * Genera un resumen con los datos del empleado y el nombre de su departamento.
     * @return Un string con la informacion del empleado.
     */
    @Override
    public String toString() {
        String nombreDepto = "Sin asignar";
        if (departamento != null) {
            nombreDepto = departamento.getNombre();
        }
        return "Empleado: " + nombre + " " + apellidos + " (ID: " + id + ") - Depto: " + nombreDepto;
    }
    /**
     * Compara si dos empleados son iguales basandose en su ID.
     * @param obj El objeto con el que se va a comparar.
     * @return True si tienen el mismo ID, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Empleado empleado = (Empleado) obj;
        return id.equals(empleado.id); // Dos empleados son iguales si su ID es igual
    }
}