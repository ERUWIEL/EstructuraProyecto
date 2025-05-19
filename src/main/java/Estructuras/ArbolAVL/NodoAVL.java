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
public class NodoAVL {
    double promedio;
    Estudiante estudiante;
    NodoAVL izquierda, derecha;
    int altura;

    public NodoAVL(double promedio, Estudiante estudiante) {
        this.promedio = promedio;
        this.estudiante = estudiante;
        this.altura = 1;
    }
}
