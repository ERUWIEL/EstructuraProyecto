package Estructuras.ListaEnlazadaCircular;

/**
 *
 * Esta clase representa un nodo de una lista enlazada circular doble.
 * @author Luis Valenzuela
 */
public class NodoCircularDoble<T> {
    private T dato;
    private NodoCircularDoble<T> siguiente;
    private NodoCircularDoble<T> anterior;

    public NodoCircularDoble(T dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoCircularDoble<T> getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(NodoCircularDoble<T> siguiente) {
        this.siguiente = siguiente;
    }
    public NodoCircularDoble<T> getAnterior() {
        return anterior;
    }
    public void setAnterior(NodoCircularDoble<T> anterior) {
        this.anterior = anterior;
    }
}
