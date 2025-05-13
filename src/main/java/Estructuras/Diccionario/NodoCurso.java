package Estructuras.Diccionario;

import entidades.Curso;

/**
 * Clase que representa un nodo de la estructura utilizada en {@link DiccionarioGenerico}.
 * Cada nodo almacena una pareja clave-valor y una referencia al siguiente nodo 
 * (utilizado para manejar colisiones con encadenamiento en la tabla hash).
 *
 * @param <K> Tipo de la clave.
 * @param <V> Tipo del valor.
 * 
 * Este nodo forma parte de una lista enlazada simple.
 * 
 * @author Sebastian Moreno
 */
public class NodoCurso<K, V> {

    /** Clave asociada al valor almacenado en este nodo. */
    K clave;

    /** Valor almacenado en el nodo. */
    V valor;

    /** Referencia al siguiente nodo en la lista enlazada. */
    NodoCurso<K, V> siguiente;

    /**
     * Constructor que crea un nodo con una clave y un valor determinados.
     * 
     * @param clave La clave a almacenar.
     * @param valor El valor asociado a la clave.
     */
    public NodoCurso(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
