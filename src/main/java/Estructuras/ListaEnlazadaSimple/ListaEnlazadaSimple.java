package Estructuras.ListaEnlazadaSimple;

/**
 * Clase que representa una lista enlazada simple genérica.
 * Permite almacenar elementos de cualquier tipo, agregar elementos al final,
 * obtener el tamaño de la lista y mostrar su contenido.
 * 
 * @param <T> Tipo de los elementos almacenados en la lista.
 * 
 * Esta implementación usa nodos enlazados linealmente en una sola dirección.
 * 
 * @author Sebastian Moreno
 */
public class ListaEnlazadaSimple<T> {

    /** Nodo que representa el inicio de la lista. */
    private NodoListaEnlazada<T> cabeza;

    /** Cantidad de elementos en la lista. */
    private int size;

    /**
     * Constructor que inicializa una lista vacía.
     */
    public ListaEnlazadaSimple() {
        cabeza = null;
        size = 0;
    }

    /**
     * Agrega un nuevo elemento al final de la lista.
     *
     * @param dato El elemento que se desea agregar.
     */
    public void agregarFinal(T dato) {
        NodoListaEnlazada<T> nuevo = new NodoListaEnlazada<>(dato);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            NodoListaEnlazada<T> actual = cabeza;
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevo;
        }
        size++;
    }

    /**
     * Retorna el tamaño (cantidad de elementos) de la lista.
     *
     * @return Número de elementos en la lista.
     */
    public int tamanio() {
        return size;
    }

    /**
     * Muestra en consola todos los elementos almacenados en la lista.
     */
    public void mostrarLista() {
        NodoListaEnlazada<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
