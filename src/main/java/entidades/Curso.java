package entidades;

import Estructuras.ListaEnlazadaSimple.ListaEnlazadaSimple;

/**
 * Esta clase representa un Curso de el sistema.
 *
 * @author Sebastian Moreno
 */
public class Curso {

    private String clave;
    private String nombre;
    private int capacidadMaxima;
    private ListaEnlazadaSimple<Estudiante> inscritos;
    private ListaEnlazadaSimple<Estudiante> listaEspera;

    public Curso() {
    }

    public Curso(String clave, String nombre, int capacidadMaxima) {
        this.clave = clave;
        this.nombre = nombre;
        this.capacidadMaxima = capacidadMaxima;
        this.inscritos = new ListaEnlazadaSimple<>();
        this.listaEspera = new ListaEnlazadaSimple<>();
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCapacidadMaxima(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
    }

    public void inscribirEstudiante(Estudiante estudiante) {
        if (inscritos.tamanio() < capacidadMaxima) {
            inscritos.agregarFinal(estudiante);
            System.out.println("Estudiante inscrito correctamente en el curso " + nombre);
        } else {
            listaEspera.agregarFinal(estudiante);
            System.out.println("Curso lleno. Estudiante añadido a la lista de espera.");
        }
    }

    public void mostrarInscritos() {
        System.out.println("Estudiantes inscritos en " + nombre + ":");
        inscritos.mostrarLista();
    }

    public void mostrarListaEspera() {
        System.out.println("Lista de espera para " + nombre + ":");
        listaEspera.mostrarLista();
    }

    public boolean hayCupo() {
        return inscritos.tamanio() < capacidadMaxima;
    }

    @Override
    public String toString() {
        return "Clave: " + clave + ", Nombre: " + nombre;
    }
}
