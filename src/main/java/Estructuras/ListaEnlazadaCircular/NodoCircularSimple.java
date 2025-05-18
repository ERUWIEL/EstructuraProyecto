package Estructuras.ListaEnlazadaCircular;

/**
 *
 * @author Luis Valenzuela
 */

public class NodoCircularSimple<T> {
    private T dato;
    private NodoCircularSimple<T> siguiente;

    public NodoCircularSimple(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public NodoCircularSimple<T> getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoCircularSimple<T> siguiente) {
        this.siguiente = siguiente;
    }
}
