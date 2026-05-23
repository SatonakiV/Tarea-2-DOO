/**
 * Representa a un invitado a la reunión que no forma parte de los empleados de la empresa.
 */
public class InvitadoExterno implements Invitable {
    private String nombreCompleto;
    private String correo;

    public InvitadoExterno(String nombreCompleto, String correo) {
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
    }

    public String getNombreCompleto() { return nombreCompleto; }
    public void setNombreCompleto(String nombreCompleto) { this.nombreCompleto = nombreCompleto; }

    public String getCorreo() { return correo; }
    public void setCorreo(String correo) { this.correo = correo; }

    @Override
    public void invitar() {
        System.out.println("Enviando invitación a invitado externo: " + correo);
    }

    @Override
    public String toString() {
        return "Invitado Externo: " + nombreCompleto + " | Correo: " + correo;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        InvitadoExterno externo = (InvitadoExterno) obj;
        return correo.equals(externo.correo); // Los diferenciamos por su correo
    }
}