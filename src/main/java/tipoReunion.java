/**
 * Enum que define los distintos tipos de reunion disponibles en el sistema.
 */
public enum tipoReunion {
    /**
     * Tipo de reunion enfocada en aspectos tecnicos.
     */
    TECNICA(1),
    /**
     * Tipo de reunion enfocada en temas de marketing.
     */
    MARKETING(2),
    /**
     * Cualquier otro tipo de reunion que no encaje en las anteriores.
     */
    OTRO(3);

    private final int tipo;


    tipoReunion(int tipo) {
        this.tipo = tipo;
    }
    /**
     * Obtiene el identificador numerico asociado al tipo de reunion.
     * @return El entero que representa el tipo.
     */
    public int getTipo() {
        return tipo;
    }
}
