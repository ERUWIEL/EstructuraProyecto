
package interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextPane;

import interfaces.RegistroFachada;

/**
 * clase que inicia los metodos visuales
 * @author erwbyel
 */
public class VentanaPrincipal extends JFrame {
    private RegistroFachada manejador = new RegistroFachada();
    private JPanel pnlContenido;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new VentanaPrincipal().setVisible(true);
    }

    private VentanaPrincipal(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema Alumnos");
        setSize(880, 800);
        setLayout(new BorderLayout());
        initComponents();
    }
    
    /**
     * Metodo para iniciar los componentes graficos
     */
    private void initComponents(){
        //creando barra
        JMenuBar menu = new JMenuBar();
        menu.setBackground(new Color(5,109,182));
        menu.setPreferredSize(new Dimension(600,40));
        Font fuente = new Font("Oswald",Font.BOLD,14);

        // boton para deshacer accion
        JButton btnDeshacer = new JButton("DESHACER");
        btnDeshacer.setFont(fuente);
        btnDeshacer.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 30));
        btnDeshacer.addActionListener((ActionEvent e) -> {
            runBtnDeshacer();
        });

        //Menu de estudiantes
        JMenu menuEstudiantes = new JMenu("Estudiantes");
        menuEstudiantes.setFont(fuente);
        menuEstudiantes.setForeground(Color.WHITE);
        menuEstudiantes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JMenuItem opcionRegistrar = new JMenuItem("Registrar");
        opcionRegistrar.addActionListener((ActionEvent e) -> {
            //accionMenuNuevo();
        });
        JMenuItem opcionBuscarEstudiante = new JMenuItem("Buscar");
        opcionBuscarEstudiante.addActionListener((ActionEvent e) -> {
            //accionMenuAbrir();
        });
        menuEstudiantes.add(opcionRegistrar);
        menuEstudiantes.add(opcionBuscarEstudiante);


        //Menu de Cursos
        JMenu menuCursos = new JMenu("Cursos");
        menuCursos.setFont(fuente);
        menuCursos.setForeground(Color.WHITE);
        menuCursos.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JMenuItem opcionAgregarCurso = new JMenuItem("Agregar");
        opcionAgregarCurso.addActionListener((ActionEvent e) -> {
            //accionMenuGuardar();
        });
        JMenuItem opcionEliminarCurso = new JMenuItem("Eliminar");
        opcionEliminarCurso.addActionListener((ActionEvent e) -> {
            //accionMenuGuardarComo();
        });
        JMenuItem opcionListarCurso = new JMenuItem("Listar");
        opcionListarCurso.addActionListener((ActionEvent e) -> {
            //accionMenuEliminar();
        });
        menuCursos.add(opcionAgregarCurso);
        menuCursos.add(opcionEliminarCurso);
        menuCursos.add(opcionListarCurso);


        //Menu Inscripciones
        JMenu menuInscripciones = new JMenu("Inscripciones");
        menuInscripciones.setFont(fuente);
        menuInscripciones.setForeground(Color.WHITE);
        menuInscripciones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JMenuItem opcionInscribirEstudiante = new JMenuItem("Inscribir Estudiante");
        opcionInscribirEstudiante.addActionListener((ActionEvent e) -> {
            //accionMenuGuardar();
        });
        //Boton Archivo/GuardarComo
        JMenuItem opcionListarInscripcionesRealizadas = new JMenuItem("Lista De Inscripciones");
        opcionListarInscripcionesRealizadas.addActionListener((ActionEvent e) -> {
            //accionMenuGuardarComo();
        });
        JMenuItem opcionListarInscripcionesPendientes = new JMenuItem("Lista De Espera");
        opcionListarInscripcionesPendientes.addActionListener((ActionEvent e) -> {
            //accionMenuEliminar();
        });
        menuInscripciones.add(opcionInscribirEstudiante);
        menuInscripciones.add(opcionListarInscripcionesRealizadas);
        menuInscripciones.add(opcionListarInscripcionesPendientes);


        //Menu Calificaciones
        JMenu menuCalificaciones = new JMenu("Calificaciones");
        menuCalificaciones.setFont(fuente);
        menuCalificaciones.setForeground(Color.WHITE);
        menuCalificaciones.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JMenuItem opcionSolicitarCalificacion = new JMenuItem("Solicitar Calificacion");
        opcionListarInscripcionesRealizadas.addActionListener((ActionEvent e) -> {
            //accionMenuGuardarComo();
        });
        JMenuItem opcionSiguienteSolicitud = new JMenuItem("Siguiente Solicitud");
        opcionInscribirEstudiante.addActionListener((ActionEvent e) -> {
            //accionMenuGuardar();
        });
        menuCalificaciones.add(opcionSolicitarCalificacion);
        menuCalificaciones.add(opcionSiguienteSolicitud);

        //Menu Calificaciones
        JMenu menuReportes = new JMenu("Reportes");
        menuReportes.setFont(fuente);
        menuReportes.setForeground(Color.WHITE);
        menuReportes.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        JMenuItem opcionListarPromedio = new JMenuItem("Listar Por Promedio");
        opcionListarInscripcionesRealizadas.addActionListener((ActionEvent e) -> {
            //accionMenuGuardarComo();
        });
        JMenuItem opcionRotarLider = new JMenuItem("Rotar Rol Lider");
        opcionInscribirEstudiante.addActionListener((ActionEvent e) -> {
            //accionMenuGuardar();
        });
        menuReportes.add(opcionListarPromedio);
        menuReportes.add(opcionRotarLider);

        //agregando grupos
        menu.add(btnDeshacer);
        menu.add(menuEstudiantes);
        menu.add(menuCursos);
        menu.add(menuInscripciones);
        menu.add(menuCalificaciones);
        menu.add(menuReportes);

        setJMenuBar(menu);
        //Area De Texto/Scroll
        //JScrollPane scrollPane = new JScrollPane(pnlTexto);
        //add(scrollPane);

        JPanel pnlInicio = new JPanel();
        ImageIcon icono = new ImageIcon("src/main/resources/fondo.jpg");
        Image iconoFormateado = icono.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel lblImagen = new JLabel(new ImageIcon(iconoFormateado));
        pnlInicio.add(lblImagen);

        pnlContenido = pnlInicio;
        add(pnlContenido, BorderLayout.CENTER);
    }

    private void runBtnDeshacer(){
        manejador.deshacerUltimaAccion();
        new POptionPane("Ultima Accion Eliminada").notificar();
    }


}
