package Estructuras.Diccionario;

/**
 * Clase que representa un diccionario genérico implementado con una tabla hash
 * utilizando listas enlazadas para resolver colisiones (hashing con encadenamiento).
 *
 * @param <K> Tipo de las claves.
 * @param <V> Tipo de los valores asociados a las claves.
 * 
 * Este diccionario permite agregar, eliminar, obtener y mostrar elementos mediante su clave.
 * 
 * @author Sebastian Moreno
 */
public class DiccionarioGenerico<K, V> {

    /** Tabla hash donde se almacenan los nodos del diccionario. */
    private NodoCurso<K, V>[] tabla;

    /** Tamaño de la tabla hash. */
    private int tamaño;

    /**
     * Constructor que inicializa la tabla con el tamaño especificado.
     *
     * @param tamaño El tamaño de la tabla hash.
     */
    public DiccionarioGenerico(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new NodoCurso[tamaño];
    }

    /**
     * Función hash para obtener el índice correspondiente a una clave.
     *
     * @param clave La clave a convertir en índice.
     * @return Índice dentro de la tabla hash.
     */
    private int obtenerIndice(K clave) {
        return Math.abs(clave.hashCode()) % tamaño;
    }

    /**
     * Agrega una nueva pareja clave-valor al diccionario.
     * Si ya existen elementos en la misma posición, se enlazan al final de la lista.
     *
     * @param clave La clave del nuevo elemento.
     * @param valor El valor asociado a la clave.
     */
    public void agregar(K clave, V valor) {
        int indice = obtenerIndice(clave);
        NodoCurso<K, V> nuevoNodo = new NodoCurso<>(clave, valor);

        if (tabla[indice] == null) {
            tabla[indice] = nuevoNodo;
        } else {
            NodoCurso<K, V> actual = tabla[indice];
            while (actual.siguiente != null) {
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
    }

    /**
     * Elimina un elemento del diccionario dado su clave.
     * Si la clave no existe, muestra un mensaje indicándolo.
     *
     * @param clave La clave del elemento a eliminar.
     */
    public void eliminar(K clave) {
        int indice = obtenerIndice(clave);
        NodoCurso<K, V> actual = tabla[indice];
        NodoCurso<K, V> anterior = null;

        while (actual != null && !actual.clave.equals(clave)) {
            anterior = actual;
            actual = actual.siguiente;
        }

        if (actual == null) {
            System.out.println("Elemento no encontrado.");
            return;
        }

        if (anterior == null) {
            tabla[indice] = actual.siguiente;
        } else {
            anterior.siguiente = actual.siguiente;
        }
        System.out.println("Elemento eliminado: " + actual.valor);
    }

    /**
     * Obtiene el valor asociado a una clave específica.
     *
     * @param clave La clave del elemento a obtener.
     * @return El valor correspondiente a la clave, o {@code null} si no se encuentra.
     */
    public V obtener(K clave) {
        int indice = obtenerIndice(clave);
        NodoCurso<K, V> actual = tabla[indice];

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }

        return null; // No se encontró la clave
    }

    /**
     * Muestra en consola todos los elementos del diccionario.
     * Imprime cada pareja clave-valor.
     */
    public void mostrar() {
        for (int i = 0; i < tamaño; i++) {
            NodoCurso<K, V> actual = tabla[i];
            while (actual != null) {
                System.out.println("Clave: " + actual.clave + ", Valor: " + actual.valor);
                actual = actual.siguiente;
            }
        }
    }
}
