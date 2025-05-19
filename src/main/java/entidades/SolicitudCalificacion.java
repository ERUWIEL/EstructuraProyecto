/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Luis Valenzuela
 */
public class SolicitudCalificacion {
    private String matriculaEstudiante;
    private int indiceCalificacion;
    private double nuevaCalificacion;

    public SolicitudCalificacion(String matricula, int indice, double calificacion) {
        this.matriculaEstudiante = matricula;
        this.indiceCalificacion = indice;
        this.nuevaCalificacion = calificacion;
    }

    public String getMatriculaEstudiante() { return matriculaEstudiante; }
    public int getIndiceCalificacion() { return indiceCalificacion; }
    public double getNuevaCalificacion() { return nuevaCalificacion; }
}
