package Estructuras.ArbolBST;

import entidades.Estudiante;

/**
 * Esta clase representa un nodo para el arbol de busqueda, utilizando estudiantes como valores de el mismo.
 * @author Sebastian Moreno
 */
public class Nodo {

    Estudiante estudiante;
    Nodo izquierda, derecha;

    public Nodo(Estudiante estudiante) {
        this.estudiante = estudiante;
        this.izquierda = null;
        this.derecha = null;
    }

}
