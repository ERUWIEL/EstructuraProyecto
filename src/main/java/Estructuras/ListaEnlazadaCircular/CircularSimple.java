package Estructuras.ListaEnlazadaCircular;

/**
 * Esta clase representa una lista enlazada circular simple
 *
 * @author Luis Valenzuela
 */
public class CircularSimple<T> {

    private NodoCircularSimple<T> cabeza;
    private NodoCircularSimple<T> cola;
    private int size;

    public CircularSimple() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    public void agregar(T dato) {
        NodoCircularSimple<T> nuevoNodo = new NodoCircularSimple<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cabeza.setSiguiente(cabeza);
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cola.setSiguiente(nuevoNodo);
            cola = nuevoNodo;
        }
        size++;
    }

    public void eliminar(T dato) {
        if (cabeza == null) {
            return; // Lista vacía
        }
        NodoCircularSimple<T> actual = cabeza;
        boolean primeraVuelta = true;
        while (actual != cabeza || primeraVuelta) {
            primeraVuelta = false;
            if (actual.getDato().equals(dato)) {
                if (actual == cabeza && actual == cola) {
                    cabeza = null;
                    cola = null;
                } else if (actual == cabeza) {
                    cabeza = cabeza.getSiguiente();
                    cola.setSiguiente(cabeza);
                } else if (actual == cola) {
                    NodoCircularSimple<T> temp = cabeza;
                    while (temp.getSiguiente() != cola) {
                        temp = temp.getSiguiente();
                    }
                    temp.setSiguiente(cabeza);
                    cola = temp;
                } else {
                    NodoCircularSimple<T> anterior = cabeza;
                    while (anterior.getSiguiente() != actual) {
                        anterior = anterior.getSiguiente();
                    }
                    anterior.setSiguiente(actual.getSiguiente());
                }
                size--;
                return; // Salir después de eliminar el nodo
            }
            actual = actual.getSiguiente();
        }
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircularSimple<T> actual = cabeza;
        boolean primeraVuelta = true;
        while (actual != cabeza || primeraVuelta) {
            primeraVuelta = false;
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }

    public NodoCircularSimple<T> getCabeza() {
        return cabeza;
    }

    public void setCabeza(NodoCircularSimple<T> cabeza) {
        this.cabeza = cabeza;
    }

    public NodoCircularSimple<T> getCola() {
        return cola;
    }

    public void setCola(NodoCircularSimple<T> cola) {
        this.cola = cola;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    
    
}
