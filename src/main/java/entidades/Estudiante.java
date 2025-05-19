package entidades;

import java.util.ArrayList;

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
    
    private ArrayList<Double> calificaciones = new ArrayList<>(); // Agregado para manejar calificaciones

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

    public ArrayList<Double> getCalificaciones() {
        return calificaciones;
    }
    
    public double getCalificacion(int indice) {
        if (indice < 0 || indice >= calificaciones.size()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        return calificaciones.get(indice);
    }
    

    public void setCalificaciones(ArrayList<Double> calificaciones) {
        this.calificaciones = calificaciones;
    }
    
    public void actualizarCalificacion(int indice, double nuevaCalificacion) {
        // Si el índice es válido, actualiza; si no, agrega calificaciones hasta llegar al índice
        while (calificaciones.size() <= indice) {
            calificaciones.add(0.0); // O el valor por defecto que prefieras
        }
        calificaciones.set(indice, nuevaCalificacion);
    }
    
    public double calcularPromedioRecursivo() {
        return calcularPromedioRecursivo(0, 0.0);
    }

    private double calcularPromedioRecursivo(int indice, double suma) {
        if (indice >= calificaciones.size() || calificaciones.size() == 0) {
            return calificaciones.size() == 0 ? 0.0 : suma / calificaciones.size();
        }
        return calcularPromedioRecursivo(indice + 1, suma + calificaciones.get(indice));
    }
    
    /**
     * Retorna una representación en cadena del estudiante, incluyendo todos sus datos.
     * 
     * @return Cadena con la información del estudiante.
     */
    @Override
    public String toString() {
        return 
                 matricula +
                "," + nombreCompleto +
                "," + telefono +
                "," + correoElectronico +
                "," + direccion;
    }
}
