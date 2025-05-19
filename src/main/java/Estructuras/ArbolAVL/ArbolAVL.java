/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras.ArbolAVL;

import entidades.Estudiante;

/**
 *
 * @author Luis Valenzuela
 */
public class ArbolAVL {
    private NodoAVL raiz;

    public void insertar(double promedio, Estudiante estudiante) {
        raiz = insertar(raiz, promedio, estudiante);
    }

    private NodoAVL insertar(NodoAVL nodo, double promedio, Estudiante estudiante) {
        if (nodo == null) return new NodoAVL(promedio, estudiante);
        if (promedio < nodo.promedio) nodo.izquierda = insertar(nodo.izquierda, promedio, estudiante);
        else nodo.derecha = insertar(nodo.derecha, promedio, estudiante);

        nodo.altura = 1 + Math.max(altura(nodo.izquierda), altura(nodo.derecha));
        int balance = balance(nodo);

        // Rotaciones para balancear
        if (balance > 1 && promedio < nodo.izquierda.promedio) return rotarDerecha(nodo);
        if (balance < -1 && promedio > nodo.derecha.promedio) return rotarIzquierda(nodo);
        if (balance > 1 && promedio > nodo.izquierda.promedio) {
            nodo.izquierda = rotarIzquierda(nodo.izquierda);
            return rotarDerecha(nodo);
        }
        if (balance < -1 && promedio < nodo.derecha.promedio) {
            nodo.derecha = rotarDerecha(nodo.derecha);
            return rotarIzquierda(nodo);
        }
        return nodo;
    }

    private int altura(NodoAVL n) { return n == null ? 0 : n.altura; }
    private int balance(NodoAVL n) { return n == null ? 0 : altura(n.izquierda) - altura(n.derecha); }
    private NodoAVL rotarDerecha(NodoAVL y) {
        NodoAVL x = y.izquierda, T2 = x.derecha;
        x.derecha = y; y.izquierda = T2;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        return x;
    }
    private NodoAVL rotarIzquierda(NodoAVL x) {
        NodoAVL y = x.derecha, T2 = y.izquierda;
        y.izquierda = x; x.derecha = T2;
        x.altura = Math.max(altura(x.izquierda), altura(x.derecha)) + 1;
        y.altura = Math.max(altura(y.izquierda), altura(y.derecha)) + 1;
        return y;
    }

    public void imprimirInOrden() {
        imprimirInOrden(raiz);
    }
    private void imprimirInOrden(NodoAVL nodo) {
        if (nodo != null) {
            imprimirInOrden(nodo.izquierda);
            System.out.println("Promedio: " + nodo.promedio + " - " + nodo.estudiante.getNombreCompleto());
            imprimirInOrden(nodo.derecha);
        }
    }
}
