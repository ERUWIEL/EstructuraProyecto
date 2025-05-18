package entidades;

import Estructuras.ListaEnlazadaCircular.CircularDoble;
import Estructuras.ListaEnlazadaCircular.CircularSimple;
import Estructuras.ListaEnlazadaSimple.ListaEnlazadaSimple;

/**
 * Clase que representa un curso dentro del sistema. Cada curso tiene una clave,
 * un nombre, una capacidad máxima de estudiantes, una lista de estudiantes
 * inscritos y una lista de espera.
 *
 * Los estudiantes que exceden la capacidad máxima son añadidos a la lista de
 * espera.
 *
 * @author Sebastian Moreno
 */
public class Curso {

    /**
     * Clave única que identifica al curso.
     */
    private String clave;

    /**
     * Nombre del curso.
     */
    private String nombre;

    /**
     * Número máximo de estudiantes que pueden inscribirse en el curso.
     */
    private int capacidadMaxima;

    /**
     * Lista de estudiantes actualmente inscritos en el curso.
     */
    private ListaEnlazadaSimple<Estudiante> inscritos;

    /**
     * Lista de estudiantes en espera para ingresar al curso.
     */
    private CircularDoble<Estudiante> listaEspera;

    private CircularSimple<Estudiante> listaConRoles = new CircularSimple<>();

    /**
     * Constructor vacío requerido por algunos frameworks o para inicialización
     * manual.
     */
    public Curso() {
    }

    /**
     * Constructor que inicializa un curso con sus datos básicos.
     *
     * @param clave Clave única del curso.
     * @param nombre Nombre del curso.
     * @param capacidadMaxima Número máximo de estudiantes permitidos.
     */
    public Curso(String clave, String nombre, int capacidadMaxima) {
        this.clave = clave;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.inscritos = new ListaEnlazadaSimple<>();
        this.listaEspera = new CircularDoble<>();
    }

    // Getters y Setters
    /**
     * @return La clave del curso.
     */
    public String getClave() {
        return clave;
    }

    /**
     * @return El nombre del curso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return La capacidad máxima de estudiantes.
     */
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    /**
     * Establece la clave del curso.
     *
     * @param clave Nueva clave del curso.
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * Establece el nombre del curso.
     *
     * @param nombre Nuevo nombre del curso.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece la capacidad máxima de estudiantes del curso.
     *
     * @param capacidadMaxima Nueva capacidad máxima.
     */
    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    /**
     * Intenta inscribir a un estudiante en el curso. Si hay cupo, se inscribe;
     * si no, se añade a la lista de espera.
     *
     * @param estudiante Estudiante a inscribir.
     */
    public void inscribirEstudiante(Estudiante estudiante) {
        if (inscritos.tamanio() < capacidadMaxima) {
            inscritos.agregarFinal(estudiante);

            // Verificar si es el primer estudiante en la lista de roles
            if (listaConRoles.getCabeza() == null) {
                estudiante.setEsLider(true); // Primer estudiante es el líder
            } else {
                estudiante.setEsLider(false); // Los demás no lo son
            }

            listaConRoles.agregar(estudiante);

            System.out.println("Estudiante inscrito correctamente en el curso " + nombre);
        } else {
            listaEspera.agregar(estudiante);
            System.out.println("Curso lleno. Estudiante añadido a la lista de espera.");
        }
    }

    /**
     * Muestra la lista de estudiantes inscritos en el curso.
     */
    public void mostrarInscritos() {
        System.out.println("Estudiantes inscritos en " + nombre + ":");
        inscritos.mostrarLista();
    }

    /**
     * Muestra la lista de estudiantes en espera del curso.
     */
    public void mostrarListaEspera() {
        System.out.println("Lista de espera para " + nombre + ":");
        listaEspera.mostrar();
    }

    /**
     * Indica si aún hay cupo disponible para inscribir estudiantes.
     *
     * @return {@code true} si hay cupo; {@code false} en caso contrario.
     */
    public boolean hayCupo() {
        return inscritos.tamanio() < capacidadMaxima;
    }

    public CircularSimple<Estudiante> getListaConRoles() {
        return listaConRoles;
    }

    public void setListaConRoles(CircularSimple<Estudiante> listaConRoles) {
        this.listaConRoles = listaConRoles;
    }

    /**
     * Retorna una representación en cadena del curso, mostrando clave y nombre.
     *
     * @return Cadena representando el curso.
     */
    @Override
    public String toString() {
        return "Clave: " + clave + ", Nombre: " + nombre;
    }
}
