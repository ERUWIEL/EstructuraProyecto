package Estructuras.ArbolBST;

import Exception.EstructuraException;
import entidades.Estudiante;

/**
 * Esta clase representa un Arbol binario de busqueda.
 *
 * @author Sebastian Moreno
 */
public class ArbolBinarioBusqueda {

    private Nodo raiz;

    public void insertar(Estudiante estudiante) throws EstructuraException {
        raiz = insertarEstudiante(raiz, estudiante);
    }

    public Estudiante buscarPorMatricula(String matricula) {
        return buscarEstudiante(raiz, matricula);
    }

    private Estudiante buscarEstudiante(Nodo nodo, String matricula) {
        if (nodo == null) {
            return null;
        }
        int comparacion = matricula.compareTo(nodo.estudiante.getMatricula());
        if (comparacion == 0) {
            return nodo.estudiante;
        } else if (comparacion < 0) {
            return buscarEstudiante(nodo.izquierda, matricula);
        } else {
            return buscarEstudiante(nodo.derecha, matricula);
        }
    }

    private Nodo insertarEstudiante(Nodo actual, Estudiante estudiante) {
        if (actual == null) {
            return new Nodo(estudiante);
        }
        if (estudiante.getMatricula().compareTo(actual.estudiante.getMatricula()) < 0) {
            actual.izquierda = insertarEstudiante(actual.izquierda, estudiante);
        } else {
            actual.derecha = insertarEstudiante(actual.derecha, estudiante);
        }
        return actual;
    }

    public void inOrden() {
        inOrdenRec(raiz);
    }

    private void inOrdenRec(Nodo nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierda);
            System.out.println(nodo.estudiante);
            System.out.println("---------------------");
            inOrdenRec(nodo.derecha);
        }
    }
}
