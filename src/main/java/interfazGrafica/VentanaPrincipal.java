
package interfazGrafica;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
//import javax.swing.JScrollPane;
//import javax.swing.JTextPane;

import Exception.EstructuraException;
import entidades.Direccion;
import entidades.Estudiante;
import interfaces.RegistroFachada;

/**
 * clase que inicia los metodos visuales
 * 
 * @author erwbyel
 */
public class VentanaPrincipal extends JFrame {
    private RegistroFachada manejador = new RegistroFachada();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        new VentanaPrincipal().setVisible(true);
    }

    private VentanaPrincipal() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Sistema Alumnos");
        setSize(880, 800);
        setResizable(false);
        setLayout(null);
        initComponents();
    }

    /**
     * Metodo para iniciar los componentes graficos
     */
    private void initComponents() {
        // creando barra
        JMenuBar menu = new JMenuBar();
        menu.setBackground(new Color(5, 109, 182));
        Font fuente = new Font("Oswald", Font.BOLD, 14);

        // boton para deshacer accion
        PButton btnDeshacer = new PButton("DESHACER");
        btnDeshacer.setPreferredSize(new Dimension(10, 15));
        btnDeshacer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        btnDeshacer.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                runBtnDeshacer();
            }
        });

        // Menu de estudiantes
        JMenu menuEstudiantes = new JMenu("Estudiantes");
        menuEstudiantes.setFont(fuente);
        menuEstudiantes.setForeground(Color.WHITE);
        menuEstudiantes.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JMenuItem opcionRegistrar = new JMenuItem("Registrar");
        opcionRegistrar.addActionListener((ActionEvent e) -> {
            registrarEstudiante();
        });
        JMenuItem opcionBuscarEstudiante = new JMenuItem("Buscar");
        opcionBuscarEstudiante.addActionListener((ActionEvent e) -> {
            buscarEstudiante();
        });
        menuEstudiantes.add(opcionRegistrar);
        menuEstudiantes.add(opcionBuscarEstudiante);

        // Menu de Cursos
        JMenu menuCursos = new JMenu("Cursos");
        menuCursos.setFont(fuente);
        menuCursos.setForeground(Color.WHITE);
        menuCursos.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JMenuItem opcionAgregarCurso = new JMenuItem("Agregar");
        opcionAgregarCurso.addActionListener((ActionEvent e) -> {
            agregarCurso();
        });
        JMenuItem opcionEliminarCurso = new JMenuItem("Eliminar");
        opcionEliminarCurso.addActionListener((ActionEvent e) -> {
            eliminarCurso();
        });
        JMenuItem opcionListarCurso = new JMenuItem("Listar");
        opcionListarCurso.addActionListener((ActionEvent e) -> {
            listarCursos();
        });
        menuCursos.add(opcionAgregarCurso);
        menuCursos.add(opcionEliminarCurso);
        menuCursos.add(opcionListarCurso);

        // Menu Inscripciones
        JMenu menuInscripciones = new JMenu("Inscripciones");
        menuInscripciones.setFont(fuente);
        menuInscripciones.setForeground(Color.WHITE);
        menuInscripciones.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JMenuItem opcionInscribirEstudiante = new JMenuItem("Inscribir Estudiante");
        opcionInscribirEstudiante.addActionListener((ActionEvent e) -> {
            inscribirEstudiante();
        });
        JMenuItem opcionListarInscripcionesRealizadas = new JMenuItem("Lista De Inscripciones");
        opcionListarInscripcionesRealizadas.addActionListener((ActionEvent e) -> {
            listarInscripciones();
        });
        JMenuItem opcionListarInscripcionesPendientes = new JMenuItem("Lista De Espera");
        opcionListarInscripcionesPendientes.addActionListener((ActionEvent e) -> {
            listarInscripcionesPendientes();
        });
        menuInscripciones.add(opcionInscribirEstudiante);
        menuInscripciones.add(opcionListarInscripcionesRealizadas);
        menuInscripciones.add(opcionListarInscripcionesPendientes);

        // Menu Calificaciones
        JMenu menuCalificaciones = new JMenu("Calificaciones");
        menuCalificaciones.setFont(fuente);
        menuCalificaciones.setForeground(Color.WHITE);
        menuCalificaciones.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JMenuItem opcionSolicitarCalificacion = new JMenuItem("Solicitar Calificacion");
        opcionListarInscripcionesRealizadas.addActionListener((ActionEvent e) -> {
            solicitarCalificacion();
        });
        JMenuItem opcionSiguienteSolicitud = new JMenuItem("Siguiente Solicitud");
        opcionInscribirEstudiante.addActionListener((ActionEvent e) -> {
            siguienteSolicitud();
        });
        menuCalificaciones.add(opcionSolicitarCalificacion);
        menuCalificaciones.add(opcionSiguienteSolicitud);

        // Menu Calificaciones
        JMenu menuReportes = new JMenu("Reportes");
        menuReportes.setFont(fuente);
        menuReportes.setForeground(Color.WHITE);
        menuReportes.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        JMenuItem opcionListarPromedio = new JMenuItem("Listar Por Promedio");
        opcionListarInscripcionesRealizadas.addActionListener((ActionEvent e) -> {
            listarPorPromedio();
        });
        JMenuItem opcionRotarLider = new JMenuItem("Rotar Rol Lider");
        opcionInscribirEstudiante.addActionListener((ActionEvent e) -> {
            rotarLider();
        });
        menuReportes.add(opcionListarPromedio);
        menuReportes.add(opcionRotarLider);

        // agregando grupos
        menu.add(btnDeshacer);
        menu.add(menuEstudiantes);
        menu.add(menuCursos);
        menu.add(menuInscripciones);
        menu.add(menuCalificaciones);
        menu.add(menuReportes);
        setJMenuBar(menu);

        JPanel pnlFondo = new JPanel();
        ImageIcon icono = new ImageIcon("src/main/resources/fondo.jpg");
        Image iconoFormateado = icono.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_SMOOTH);
        JLabel lblImagen = new JLabel(new ImageIcon(iconoFormateado));
        pnlFondo.add(lblImagen);
        pnlFondo.setBounds(0,0,getWidth(),getHeight());
        add(pnlFondo);
    }

    /**
     * metodo que maneja el evento de pulsar el boton de deshacer
     */
    private void runBtnDeshacer() {
        manejador.deshacerUltimaAccion();
        new POptionPane("Ultima Accion Eliminada").notificar();
    }

    private void registrarEstudiante(){
        String matricula = new POptionPane("Matricula Del Estudiante").obtener();
        String nombre = new POptionPane("Nombre Del Estudiante").obtener();
        String telefono = new POptionPane("Telefono Del Estudiante").obtener();
        String correo = new POptionPane("Correo Del Estudiante").obtener();
        String calle = new POptionPane("Calle Del Estudiante").obtener();
        String numero = new POptionPane("Numero Del Estudiante").obtener();
        String colonia = new POptionPane("Colonia Del Estudiante").obtener();
        String ciudad = new POptionPane("Cuidad Del Estudiante").obtener();
        Direccion direccion = new Direccion(calle,numero,colonia,ciudad);
        Estudiante estudiante = new Estudiante(matricula,nombre,telefono,correo,direccion);
        try {
            manejador.registrarEstudiante(estudiante);
            new POptionPane("Estudiante Registrado Exitosamente").notificar();
        } catch (EstructuraException e) {
            new POptionPane(e.getMessage()).error();
        }
    }

    private void buscarEstudiante() {
        String matricula = new POptionPane("Matricula Del Estudiante").obtener();
        try {
            Estudiante estudiante = manejador.mostrarEstudiante(matricula);
            new POptionPane(estudiante.toString()).notificar();
        } catch (EstructuraException e) {
            new POptionPane(e.getMessage()).error();
        }
    }

    
    private void agregarCurso() {
    }

    private void eliminarCurso() {
    }

    private void listarCursos() {
    }

    private void inscribirEstudiante() {
    }

    private void listarInscripciones() {
    }

    private void listarInscripcionesPendientes() {
    }

    private void solicitarCalificacion() {
    }

    private void siguienteSolicitud() {
    }

    private void listarPorPromedio() {
    }

    private void rotarLider() {
    }
}
