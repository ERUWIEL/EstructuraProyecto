/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.Diccionario;

import entidades.Curso;

/**
 * Esta clase representa un nodo
 *
 * @author Sebastian Moreno
 */
public class NodoCurso<K, V> {
    K clave;
    V valor;
    NodoCurso<K, V> siguiente;

    public NodoCurso(K clave, V valor) {
        this.clave = clave;
        this.valor = valor;
        this.siguiente = null;
    }
}
