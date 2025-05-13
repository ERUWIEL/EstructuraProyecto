package Estructuras.ListaEnlazadaSimple;

/**
 * Clase que representa un nodo de una lista enlazada simple.
 * Cada nodo almacena un dato genérico y una referencia al siguiente nodo.
 *
 * @param <T> Tipo del dato almacenado en el nodo.
 * 
 * Esta clase es utilizada por {@link ListaEnlazadaSimple}.
 * 
 * @author Sebastian Moreno
 */
public class NodoListaEnlazada<T> {

    /** Dato almacenado en el nodo. */
    T dato;

    /** Referencia al siguiente nodo de la lista. */
    NodoListaEnlazada<T> siguiente;

    /**
     * Constructor que crea un nodo con el dato proporcionado.
     * El campo {@code siguiente} se inicializa como {@code null}.
     *
     * @param dato El dato a almacenar en el nodo.
     */
    public NodoListaEnlazada(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
