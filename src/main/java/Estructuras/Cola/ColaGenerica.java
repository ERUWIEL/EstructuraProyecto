package Estructuras.Cola;

/**
 * Clase genérica que implementa una cola (estructura FIFO - First In First Out).
 * Utiliza nodos enlazados para el manejo dinámico de los elementos.
 * 
 * @param <T> Tipo de datos que la cola almacenará.
 * 
 * Autor: Luis Valenzuela
 */
public class ColaGenerica<T> {

    private NodoCola<T> frente;
    private NodoCola<T> fin;
    private int tamanio;

    /**
     * Constructor que inicializa una cola vacía.
     */
    public ColaGenerica() {
        this.frente = null;
        this.fin = null;
        this.tamanio = 0;
    }

    /**
     * Verifica si la cola está vacía.
     * 
     * @return true si no contiene elementos, false en caso contrario.
     */
    public boolean estaVacia() {
        return tamanio == 0;
    }

    /**
     * Inserta un nuevo elemento al final de la cola.
     * 
     * @param dato Elemento que se va a encolar.
     */
    public void encolar(T dato) {
        NodoCola<T> nuevoNodo = new NodoCola<>(dato);
        if (estaVacia()) {
            frente = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
        }
        fin = nuevoNodo;
        tamanio++;
    }

    /**
     * Elimina y devuelve el elemento del frente de la cola.
     * 
     * @return Elemento que fue desencolado.
     * @throws RuntimeException si la cola está vacía.
     */
    public T desencolar() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        T dato = frente.getDato();
        frente = frente.getSiguiente();
        tamanio--;
        if (estaVacia()) {
            fin = null;
        }
        return dato;
    }

    /**
     * Devuelve el número de elementos almacenados en la cola.
     * 
     * @return Tamaño de la cola.
     */
    public int getTamanio() {
        return tamanio;
    }

    /**
     * Devuelve el elemento en el frente de la cola sin eliminarlo.
     * 
     * @return Elemento al frente.
     * @throws RuntimeException si la cola está vacía.
     */
    public T peek() {
        if (estaVacia()) {
            throw new RuntimeException("La cola está vacía");
        }
        return frente.getDato();
    }
}
