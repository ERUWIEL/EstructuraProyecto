/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Luis Valenzuela
 */
public class Accion {
    public enum Tipo { REGISTRO, INSCRIPCION, CALIFICACION }
    private Tipo tipo;
    private Object datoAnterior; // Puede ser Estudiante, Curso, o datos previos de calificación
    private Object datoActual;   // Puede ser Estudiante, Curso, o datos nuevos de calificación

    public Accion(Tipo tipo, Object datoAnterior, Object datoActual) {
        this.tipo = tipo;
        this.datoAnterior = datoAnterior;
        this.datoActual = datoActual;
    }

    public Tipo getTipo() { return tipo; }
    public Object getDatoAnterior() { return datoAnterior; }
    public Object getDatoActual() { return datoActual; }
}
