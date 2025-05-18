package entidades;

/**
 * Clase que representa a un estudiante dentro del sistema.
 * Cada estudiante cuenta con una matrícula, nombre completo, teléfono, correo electrónico y una dirección.
 * 
 * Esta clase es utilizada, por ejemplo, para inscribir estudiantes a cursos y almacenarlos en estructuras.
 * 
 * @see Direccion
 * @author Sebastian Moreno
 */
public class Estudiante {

    /** Matrícula única que identifica al estudiante. */
    private String matricula;

    /** Nombre completo del estudiante. */
    private String nombreCompleto;

    /** Número telefónico del estudiante. */
    private String telefono;

    /** Correo electrónico del estudiante. */
    private String correoElectronico;

    /** Dirección del estudiante. */
    private Direccion direccion;
    
    private boolean esLider;

    /**
     * Constructor vacío para inicialización manual o frameworks que lo requieran.
     */
    public Estudiante() {
    }

    /**
     * Constructor que inicializa todos los campos del estudiante.
     *
     * @param matricula         Matrícula única del estudiante.
     * @param nombreCompleto    Nombre completo.
     * @param telefono          Número telefónico.
     * @param correoElectronico Correo electrónico.
     * @param direccion         Dirección del estudiante.
     */
    public Estudiante(String matricula, String nombreCompleto, String telefono, String correoElectronico, Direccion direccion) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }

    /** @return Matrícula del estudiante. */
    public String getMatricula() {
        return matricula;
    }

    /** @param matricula Nueva matrícula del estudiante. */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    /** @return Nombre completo del estudiante. */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /** @param nombreCompleto Nuevo nombre completo. */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /** @return Teléfono del estudiante. */
    public String getTelefono() {
        return telefono;
    }

    /** @param telefono Nuevo número telefónico. */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /** @return Correo electrónico del estudiante. */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /** @param correoElectronico Nuevo correo electrónico. */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /** @return Dirección del estudiante. */
    public Direccion getDireccion() {
        return direccion;
    }

    /** @param direccion Nueva dirección. */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    public boolean isEsLider() {
        return esLider;
    }

    public void setEsLider(boolean esLider) {
        this.esLider = esLider;
    }

    
    
    /**
     * Retorna una representación en cadena del estudiante, incluyendo todos sus datos.
     * 
     * @return Cadena con la información del estudiante.
     */
    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula=" + matricula +
                ", nombreCompleto=" + nombreCompleto +
                ", telefono=" + telefono +
                ", correoElectronico=" + correoElectronico +
                ", direccion=" + direccion +
                '}';
    }
}
