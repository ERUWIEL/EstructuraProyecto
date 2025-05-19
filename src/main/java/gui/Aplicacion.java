/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Sebastian Moreno
 */
public class Aplicacion {
    
    private JFrame framePrincipal;
    private MenuPrincipal pantallaMenuPrincipal;
    private PantallaEstudiantes pantallaEstudiantes;
    private MenuCursos menuCursos;
    private Inscripciones menuI;
    private Calificaciones c;
    private Reportes r;

    public Aplicacion() {
        framePrincipal = new JFrame("Sistema Escuela");
        framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framePrincipal.setSize(1150, 700);
        framePrincipal.setLocationRelativeTo(null);
        
        pantallaMenuPrincipal = new MenuPrincipal(this);
        pantallaEstudiantes = new PantallaEstudiantes(this);
        menuCursos = new MenuCursos(this);
        menuI = new Inscripciones(this);
        c = new Calificaciones(this);
        r = new Reportes(this);
    }
    
    private void cambiarPantalla(JPanel nuevaPantalla) {
        framePrincipal.getContentPane().removeAll(); // Eliminar contenido anterior
        framePrincipal.getContentPane().add(nuevaPantalla);
        framePrincipal.revalidate();
        framePrincipal.repaint();
        framePrincipal.setVisible(true);
    }
    
    public void mostrarPantallaPrincipal() {
        cambiarPantalla(pantallaMenuPrincipal);
    }
    
    public void mostrarPantallaEstudiantes() {
        cambiarPantalla(pantallaEstudiantes);
    }
    
    public void mostrarMenuCursos() {
        cambiarPantalla(menuCursos);
    }

    public void mostrarMenuInscripciones() {
        cambiarPantalla(menuI);
    }
    
    public void mostrarMenuCalificaciones() {
        cambiarPantalla(c);
    }
    
    public void mostrarReportes(){
        cambiarPantalla(r);
    }
}
