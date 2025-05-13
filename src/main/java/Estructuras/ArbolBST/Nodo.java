package Estructuras.ArbolBST;

import entidades.Estudiante;

/**
 * Clase que representa un nodo del Árbol Binario de Búsqueda (ABB), 
 * donde cada nodo contiene un objeto {@link Estudiante} como valor 
 * y referencias a sus nodos hijo izquierdo y derecho.
 * 
 * Este nodo se utiliza en la estructura {@code ArbolBinarioBusqueda}.
 * 
 * @author Sebastian Moreno
 */
public class Nodo {

    /** Estudiante almacenado en este nodo. */
    Estudiante estudiante;

    /** Referencia al nodo hijo izquierdo. */
    Nodo izquierda;

    /** Referencia al nodo hijo derecho. */
    Nodo derecha;

    /**
     * Constructor que crea un nodo con un estudiante dado.
     * Inicializa los nodos hijo izquierdo y derecho como {@code null}.
     * 
     * @param estudiante El estudiante que se almacenará en el nodo.
     */
    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.izquierda = null;
        this.derecha = null;
    }

}
