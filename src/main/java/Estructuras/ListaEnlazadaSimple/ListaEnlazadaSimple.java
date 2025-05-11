
package Estructuras.ListaEnlazadaSimple;

/**
 *
 * @author Sebastian Moreno
 */
public class ListaEnlazadaSimple<T> {

    private NodoListaEnlazada<T> cabeza;
    private int size;

    public ListaEnlazadaSimple() {
        cabeza = null;
        size = 0;
    }

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

    public int tamanio() {
        return size;
    }

    public void mostrarLista() {
        NodoListaEnlazada<T> actual = cabeza;
        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }
    }
}
