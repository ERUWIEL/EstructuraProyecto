package Estructuras.Pila;

/**
 * Clase genérica que implementa una pila (estructura LIFO - Last In First Out).
 * Utiliza nodos enlazados para permitir el almacenamiento dinámico de elementos.
 * 
 * @param <T> Tipo de dato que la pila va a almacenar.
 * 
 * Autor: Luis Valenzuela
 */
public class PilaGenerica<T> {
    private NodoPila<T> cima;
    private int tamanio;

    /**
     * Constructor que inicializa una pila vacía.
     */
    public PilaGenerica() {
        this.cima = null;
        this.tamanio = 0;
    }

    /**
     * Verifica si la pila está vacía.
     * 
     * @return true si no contiene elementos, false en caso contrario.
     */
    public boolean esVacia() {
        return tamanio == 0;
    }

    /**
     * Inserta un nuevo elemento en la cima de la pila.
     * 
     * @param dato Elemento que se va a apilar.
     */
    public void apilar(T dato) {
        NodoPila<T> nuevoNodo = new NodoPila<>(dato);
        nuevoNodo.setSiguiente(cima);
        cima = nuevoNodo;
        tamanio++;
    }

    /**
     * Elimina y devuelve el elemento que está en la cima de la pila.
     * 
     * @return Elemento desapilado.
     * @throws RuntimeException si la pila está vacía.
     */
    public T desapilar() {
        if (esVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        T dato = cima.getDato();
        cima = cima.getSiguiente();
        tamanio--;
        return dato;
    }

    /**
     * Devuelve el elemento en la cima de la pila sin eliminarlo.
     * 
     * @return Elemento en la cima.
     * @throws RuntimeException si la pila está vacía.
     */
    public T verCima() {
        if (esVacia()) {
            throw new RuntimeException("La pila está vacía");
        }
        return cima.getDato();
    }

    /**
     * Obtiene la cantidad de elementos almacenados en la pila.
     * 
     * @return Número de elementos en la pila.
     */
    public int getTamanio() {
        return tamanio;
    }
}
