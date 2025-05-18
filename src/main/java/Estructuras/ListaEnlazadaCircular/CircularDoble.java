package Estructuras.ListaEnlazadaCircular;
/**
 * Esta clase representa una lista enlazada circular doble.
 *
 * @param <T> Tipo de dato que contendrá la lista
 * @author Luis Valenzuela
 */

public class CircularDoble<T> {
    private NodoCircularDoble<T> cabeza;
    private NodoCircularDoble<T> cola;
    private int size;

    public CircularDoble() {
        this.cabeza = null;
        this.cola = null;
        this.size = 0;
    }

    public void agregar(T dato) {
        NodoCircularDoble<T> nuevoNodo = new NodoCircularDoble<>(dato);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
            cabeza.setSiguiente(cabeza);
            cabeza.setAnterior(cabeza);
        } else {
            nuevoNodo.setSiguiente(cabeza);
            nuevoNodo.setAnterior(cola);
            cola.setSiguiente(nuevoNodo);
            cabeza.setAnterior(nuevoNodo);
            cola = nuevoNodo;
        }
        size++;
    }

    public void eliminar(T dato) {
        if (cabeza == null) {
            return; // Lista vacía
        }
        NodoCircularDoble<T> actual = cabeza;
        boolean primeraVuelta = true;
        while (actual != cabeza || primeraVuelta) {
            primeraVuelta = false;
            if (actual.getDato().equals(dato)) {
                if (actual == cabeza && actual == cola) {
                    cabeza = null;
                    cola = null;
                } else if (actual == cabeza) {
                    cabeza = cabeza.getSiguiente();
                    cabeza.setAnterior(cola);
                    cola.setSiguiente(cabeza);
                } else if (actual == cola) {
                    cola = cola.getAnterior();
                    cola.setSiguiente(cabeza);
                    cabeza.setAnterior(cola);
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                size--;
                return; // Salir después de eliminar el nodo
            }
            actual = actual.getSiguiente();
        }
        // Si llegamos aquí, el dato no estaba en la lista
        System.out.println("El dato " + dato + " no se encontró en la lista.");
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void mostrar() {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }
        NodoCircularDoble<T> actual = cabeza;
        boolean primeraVuelta = true;
        while (actual != cabeza || primeraVuelta) {
            primeraVuelta = false;
            System.out.print(actual.getDato() + " ");
            actual = actual.getSiguiente();
        }
        System.out.println();
    }
}

