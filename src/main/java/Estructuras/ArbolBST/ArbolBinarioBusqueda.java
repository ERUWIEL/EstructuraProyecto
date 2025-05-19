package Estructuras.ArbolBST;

import Exception.EstructuraException;
import entidades.Estudiante;

/**
 * Clase que representa un Árbol Binario de Búsqueda (ABB), donde se pueden insertar 
 * y buscar objetos de tipo {@link Estudiante} utilizando su matrícula como clave.
 * 
 * El árbol mantiene el orden alfabético de las matrículas de los estudiantes.
 * 
 * @author Sebastian Moreno
 */
public class ArbolBinarioBusqueda {

    /** Nodo raíz del árbol binario de búsqueda. */
    private Nodo raiz;

    /**
     * Inserta un nuevo estudiante en el árbol.
     * 
     * @param estudiante El estudiante a insertar.
     * @throws EstructuraException Si ocurre un error al insertar (actualmente no se lanza explícitamente).
     */
    public void insertar(Estudiante estudiante) throws EstructuraException {
        raiz = insertarEstudiante(raiz, estudiante);
    }
    
    public void eliminar(Estudiante estudiante){
        this.raiz=eliminarEstudiante(this.raiz, estudiante);
    }
    

    /**
     * Busca un estudiante en el árbol usando su matrícula.
     * 
     * @param matricula La matrícula del estudiante a buscar.
     * @return El objeto {@link Estudiante} si se encuentra; de lo contrario, {@code null}.
     */
    public Estudiante buscarPorMatricula(String matricula) {
        return buscarEstudiante(raiz, matricula);
    }

    /**
     * Método recursivo que busca un estudiante a partir de un nodo y una matrícula.
     * 
     * @param nodo Nodo actual en el recorrido.
     * @param matricula Matrícula del estudiante buscado.
     * @return El estudiante encontrado o {@code null} si no existe.
     */
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

    /**
     * Método recursivo que inserta un estudiante en el árbol respetando el orden.
     * 
     * @param actual Nodo actual durante la inserción.
     * @param estudiante Estudiante a insertar.
     * @return Nodo actualizado con el nuevo estudiante insertado.
     */
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
    
    /**
     * Elimina un estudiante del árbol usando su matrícula.
     * 
     * @param nodo Nodo actual en el recorrido.
     * @param estudiante Estudiante a eliminar.
     * @return Nodo actualizado después de la eliminación.
     */
    private Nodo eliminarEstudiante(Nodo nodo, Estudiante estudiante) {
        if (nodo == null) {
            return null;
        }
        int comparacion = estudiante.getMatricula().compareTo(nodo.estudiante.getMatricula());
        if (comparacion < 0) {
            nodo.izquierda = eliminarEstudiante(nodo.izquierda, estudiante);
        } else if (comparacion > 0) {
            nodo.derecha = eliminarEstudiante(nodo.derecha, estudiante);
        } else {
            // Nodo encontrado
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            } else {
                // Nodo con dos hijos: buscar el sucesor in-order
                Nodo sucesor = encontrarMinimo(nodo.derecha);
                nodo.estudiante = sucesor.estudiante;
                nodo.derecha = eliminarEstudiante(nodo.derecha, sucesor.estudiante);
            }
        }
        return nodo;
    }

    /**
     * Encuentra el nodo con el valor mínimo en el subárbol dado.
     * 
     * @param nodo Nodo raíz del subárbol.
     * @return Nodo con el valor mínimo.
     */
    private Nodo encontrarMinimo(Nodo nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }

    /**
     * Muestra en consola los estudiantes del árbol en orden ascendente por matrícula.
     */
    public void inOrden() {
        inOrdenRec(raiz);
    }

    /**
     * Recorre el árbol en orden (inOrden) e imprime los estudiantes.
     * 
     * @param nodo Nodo actual del recorrido.
     */
    private void inOrdenRec(Nodo nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierda);
            System.out.println(nodo.estudiante);
            System.out.println("---------------------");
            inOrdenRec(nodo.derecha);
        }
    }

    public Nodo getRaiz() {
        return raiz;
    }
   
}
