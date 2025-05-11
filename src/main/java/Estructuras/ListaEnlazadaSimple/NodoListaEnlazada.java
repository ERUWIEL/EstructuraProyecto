
package Estructuras.ListaEnlazadaSimple;

/**
 *
 * @author Sebastian Moreno
 */
public class NodoListaEnlazada<T> {

    T dato;
    NodoListaEnlazada<T> siguiente;

    public NodoListaEnlazada(T dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
