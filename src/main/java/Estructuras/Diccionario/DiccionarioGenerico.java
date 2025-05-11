/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Diccionario;

/**
 *
 * @author Sebastian Moreno
 */
public class DiccionarioGenerico<K, V> {

    private NodoCurso<K, V>[] tabla;
    private int tamaño;

    public DiccionarioGenerico(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new NodoCurso[tamaño];
    }

    // Función de hash simple
    private int obtenerIndice(K clave) {
        return Math.abs(clave.hashCode()) % tamaño;
    }

    // Agregar valor
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

    // Eliminar valor por clave
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

    // Mostrar todos los valores
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
