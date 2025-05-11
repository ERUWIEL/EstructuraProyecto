package prueba;

import Estructuras.ArbolBST.ArbolBinarioBusqueda;
import Estructuras.Diccionario.DiccionarioGenerico;
import Estructuras.ListaEnlazadaSimple.ListaEnlazadaSimple;
import Exception.EstructuraException;
import entidades.Curso;
import entidades.Direccion;
import entidades.Estudiante;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Moreno
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static ArbolBinarioBusqueda arbolEstudiantes = new ArbolBinarioBusqueda();
    static DiccionarioGenerico<String, Curso> diccionarioCursos = new DiccionarioGenerico<>(20);
    static ListaEnlazadaSimple listaEnlazada = new ListaEnlazadaSimple();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=== MENÚ PRINCIPAL ===");
            System.out.println("1. Estudiantes");
            System.out.println("2. Cursos");
            System.out.println("3. Inscripciones");
            System.out.println("4. Calificaciones");
            System.out.println("5. Acciones");
            System.out.println("6. Reportes");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuEstudiantes(scanner);
                    break;
                case 2:
                    menuCursos(scanner);
                    break;
                case 3:
                    menuInscripciones(scanner);
                    break;
                case 4:
                    menuCalificaciones(scanner);
                    break;
                case 5:
                    menuAcciones(scanner);
                    break;
                case 6:
                    menuReportes(scanner);
                    break;
                case 7:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        } while (opcion != 7);

        scanner.close();
    }

    public static void menuEstudiantes(Scanner scanner) {

        System.out.println("\nSelecciona una opcion: ");
        System.out.println("1. Registrar estudiante");
        System.out.println("2. Buscar estudiante por matrícula");

        int opcion = scanner.nextInt();
        if (opcion == 1) {
            try {
                registrarEstudiante(scanner, arbolEstudiantes);
            } catch (EstructuraException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            mostrarEstudiante(scanner, arbolEstudiantes);
        }

    }

    public static void menuCursos(Scanner scanner) {
        System.out.println("\nSelecciona una opción: ");
        System.out.println("1. Agregar curso");
        System.out.println("2. Eliminar curso");
        System.out.println("3. Listar cursos");

        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        if (opcion == 1) {
            agregarCurso(scanner, diccionarioCursos);  // Llamar al método para agregar curso
        } else if (opcion == 2) {
            eliminarCurso(scanner, diccionarioCursos);  // Llamar al método para eliminar curso
        } else if (opcion == 3) {
            listarCursos(diccionarioCursos);  // Llamar al método para listar cursos
        } else {
            System.out.println("Selecciona una opción correcta");
        }
    }

    public static void menuInscripciones(Scanner scanner) {
        System.out.println("\nSelecciona una opción: ");
        System.out.println("1. Inscribir estudiante en curso");
        System.out.println("2. Mostrar lista de inscritos de un curso");
        System.out.println("3. Mostrar lista de espera de un curso");

        int opcion = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer

        if (opcion == 1) {
            inscribirEstudianteACurso(scanner);  // Llamar al método para agregar curso
        } else if (opcion == 2) {
            mostrarListaInscritos(scanner);
        } else if (opcion == 3) {
            mostrarListaEspera(scanner);
        } else {
            System.out.println("Selecciona una opción correcta");
        }
    }

    public static void menuCalificaciones(Scanner scanner) {
        System.out.println("4.1 Enviar solicitud de calificación (colas)");
        System.out.println("4.2 Procesar siguiente solicitud");
    }

    public static void menuAcciones(Scanner scanner) {
        System.out.println("5.1 Deshacer última acción");
    }

    public static void menuReportes(Scanner scanner) {
        System.out.println("6.1 Listar estudiantes ordenados por promedio");
        System.out.println("6.2 Rotar rol de tutor/líder de proyecto");
    }

    // METODOS ESPECIFICOS CON FUNCIONALIDAD.
    //1. Registro de estudiantes
    public static void registrarEstudiante(Scanner scanner, ArbolBinarioBusqueda arbol) throws EstructuraException {
        scanner.nextLine(); // Limpiar buffer

        System.out.print("Matrícula: ");
        String matricula = scanner.nextLine();

        System.out.print("Nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.print("Teléfono: ");
        String telefono = scanner.nextLine();

        System.out.print("Correo electrónico: ");
        String correo = scanner.nextLine();

        System.out.print("Calle: ");
        String calle = scanner.nextLine();

        System.out.print("Número: ");
        String numero = scanner.nextLine();

        System.out.print("Colonia: ");
        String colonia = scanner.nextLine();

        System.out.print("Ciudad: ");
        String ciudad = scanner.nextLine();

        Direccion direccion = new Direccion(calle, numero, colonia, ciudad);
        Estudiante nuevo = new Estudiante(matricula, nombre, telefono, correo, direccion);

        try {
            arbol.insertar(nuevo);
        } catch (EstructuraException ex) {
            throw new EstructuraException("Ocurrio un error registrando un nuevo estudiante." + ex.getLocalizedMessage());
        }

        System.out.println("Estudiante registrado exitosamente.");
    }

    //2. Búsqueda de estudiante por matrícula
    public static void mostrarEstudiante(Scanner scanner, ArbolBinarioBusqueda arbol) {
        scanner.nextLine();

        System.out.print("Ingrese matrícula del estudiante: ");
        String matricula = scanner.nextLine();

        Estudiante estudiante = arbol.buscarPorMatricula(matricula);
        if (estudiante != null) {
            System.out.println("=== Estudiante encontrado ===");
            System.out.println(estudiante);

            // Si luego agregas calificaciones:
            // System.out.println("Calificaciones: " + Arrays.toString(estudiante.getCalificaciones()));
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    //3. . Listado de estudiantes ordenados por promedio (PENDIENTE , ESTE SUPONGO SE HACE AL FINAL.)
    //4. Gestión de catálogo de cursos
    public static void agregarCurso(Scanner scanner, DiccionarioGenerico<String, Curso> diccionarioCursos) {
        System.out.print("Ingrese la clave del curso: ");
        String claveCurso = scanner.nextLine();  // Leer clave del curso
        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine();  // Leer nombre del curso
        System.out.println("Ingrese la cantidad maxima permitida de alumnos para el curso:");
        int capacidad = scanner.nextInt();  // Leer nombre del curso

        // Crear el objeto Curso
        Curso nuevoCurso = new Curso(claveCurso, nombreCurso, capacidad);

        // Agregar el curso al diccionario
        diccionarioCursos.agregar(claveCurso, nuevoCurso);
        System.out.println("Curso agregado con éxito.");
    }

    public static void eliminarCurso(Scanner scanner, DiccionarioGenerico<String, Curso> diccionarioCursos) {
        System.out.print("Ingrese la clave del curso a eliminar: ");
        String claveCurso = scanner.nextLine();  // Leer la clave del curso

        // Eliminar el curso del diccionario
        diccionarioCursos.eliminar(claveCurso);
    }

    public static void listarCursos(DiccionarioGenerico<String, Curso> diccionarioCursos) {
        System.out.println("Listado de todos los cursos registrados:");

        // Mostrar todos los cursos
        diccionarioCursos.mostrar();
    }

    //5.Inscripción de estudiantes en cursos
    public static void inscribirEstudianteACurso(Scanner scanner) {

        System.out.print("Ingrese matrícula del estudiante: ");
        String matricula = scanner.nextLine();

        Estudiante estudiante = arbolEstudiantes.buscarPorMatricula(matricula);
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.print("Ingrese la clave del curso: ");
        String claveCurso = scanner.nextLine();

        Curso curso = diccionarioCursos.obtener(claveCurso);
        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        if (curso.hayCupo()) {
            curso.inscribirEstudiante(estudiante);
        } else {
            curso.inscribirEstudiante(estudiante);
        }
    }

    public static void mostrarListaInscritos(Scanner scanner) {
        System.out.print("Ingrese la clave del curso: ");
        String clave = scanner.nextLine();

        Curso curso = diccionarioCursos.obtener(clave);
        if (curso != null) {
            System.out.println("Estudiantes inscritos:");
            curso.mostrarInscritos();  // Este método debe imprimir los elementos de la lista
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    public static void mostrarListaEspera(Scanner scanner) {
        System.out.print("Ingrese la clave del curso: ");
        String clave = scanner.nextLine();

        Curso curso = diccionarioCursos.obtener(clave);
        if (curso != null) {
            System.out.println("Lista de espera:");
            curso.mostrarListaEspera();  // Este método también debe existir en tu lista
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

}
