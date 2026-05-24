/**
 * Representa a un invitado a la reunión que no forma parte de los empleados de la empresa.
 */
public class InvitadoExterno implements Invitable {
    private String nombreCompleto;
    private String correo;
    /**
     * Constructor para crear un invitado que no es de la empresa.
     * @param nombreCompleto El nombre del invitado.
     * @param correo El correo del invitado.
     */
    public InvitadoExterno(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }
    /**
     * Obtiene el nombre del invitado.
     * @return Un string con el nombre completo.
     */
    public String getNombreCompleto() { return nombreCompleto; }
    /**
     * Cambia el nombre del invitado externo.
     * @param nombreCompleto El nuevo nombre.
     */
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }
    /**
     * Obtiene el correo del invitado externo.
     * @return Un string con el correo.
     */
    public String getCorreo() { return correo; }
    /**
     * Cambia el correo del invitado externo.
     * @param correo El nuevo correo.
     */
    public void setCorreo(String correo) { this.correo = correo; }
    /**
     * Simula el envio de una invitacion por consola a este externo.
     */
    @Override
    public void invitar() {
        System.out.println("Enviando invitación a invitado externo: " + correo);
    }
    /**
     * Genera un texto con los datos de este invitado.
     * @return Un string con el nombre y el correo.
     */
    @Override
    public String toString() {
        return "Invitado Externo: " + nombreCompleto + " | Correo: " + correo;
    }
    /**
     * Compara si dos invitados externos son la misma persona usando su correo.
     * @param obj El objeto a comparar.
     * @return True si tienen el mismo correo, false en caso contrario.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InvitadoExterno externo = (InvitadoExterno) obj;
        return correo.equals(externo.correo); // Los diferenciamos por su correo
    }
}