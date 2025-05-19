package prueba;

import Estructuras.ArbolAVL.ArbolAVL;
import Estructuras.ArbolBST.ArbolBinarioBusqueda;
import Estructuras.Cola.ColaGenerica;
import Estructuras.Diccionario.DiccionarioGenerico;
import Estructuras.ListaEnlazadaCircular.CircularDoble;
import Estructuras.ListaEnlazadaCircular.CircularSimple;
import Estructuras.ListaEnlazadaCircular.NodoCircularSimple;
import Estructuras.ListaEnlazadaSimple.ListaEnlazadaSimple;
import Estructuras.Pila.PilaGenerica;
import Exception.EstructuraException;
import entidades.Accion;
import entidades.Curso;
import entidades.Direccion;
import entidades.Estudiante;
import entidades.SolicitudCalificacion;
import entidades.SolicitudCalificacion;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase principal que gestiona el sistema de registro de estudiantes, cursos,
 * inscripciones y otros procesos asociados a la gestión académica.
 *
 * Utiliza diversas estructuras de datos como: - ArbolBinarioBusqueda para
 * almacenar estudiantes. - DiccionarioGenerico para almacenar cursos. -
 * ListaEnlazadaSimple para manejar listas relacionadas (aunque no utilizada en
 * su totalidad en este ejemplo).
 *
 * @author Sebastian Moreno
 */
public class Main {

    // Estructuras de datos globales
    static ArbolBinarioBusqueda arbolEstudiantes = new ArbolBinarioBusqueda(); // Árbol para almacenar estudiantes
    static DiccionarioGenerico<String, Curso> diccionarioCursos = new DiccionarioGenerico<>(20); // Diccionario para
                                                                                                 // cursos
    static ListaEnlazadaSimple listaEnlazada = new ListaEnlazadaSimple(); // Lista enlazada (por si se utiliza más
                                                                          // adelante)
    static ColaGenerica<SolicitudCalificacion> colaSolicitudes = new ColaGenerica<>();

    static PilaGenerica<Accion> pilaAcciones = new PilaGenerica<>();

    /**
     * Método principal que muestra el menú principal y gestiona la interacción
     * con el usuario. Se mantiene ejecutándose hasta que el usuario seleccione
     * la opción de salir.
     *
     * @param args Argumentos de la línea de comandos
     */
    public static void main(String[] args) {

        // Crear 3 estudiantes de ejemplo
        Direccion dir1 = new Direccion("Calle 1", "123", "Centro", "CiudadA");
        Direccion dir2 = new Direccion("Calle 2", "456", "Norte", "CiudadB");
        Direccion dir3 = new Direccion("Calle 3", "789", "Sur", "CiudadC");

        Estudiante est1 = new Estudiante("111", "Juan Pérez", "6621234567", "juan@mail.com", dir1);
        Estudiante est2 = new Estudiante("222", "Ana López", "6622345678", "ana@mail.com", dir2);
        Estudiante est3 = new Estudiante("333", "Luis Ruiz", "6623456789", "luis@mail.com", dir3);

        // Insertar los estudiantes en el árbol global
        try {
            arbolEstudiantes.insertar(est1);
            arbolEstudiantes.insertar(est2);
            arbolEstudiantes.insertar(est3);

            est1.actualizarCalificacion(0, 8.5);
            est1.actualizarCalificacion(1, 9.0);
            est1.actualizarCalificacion(2, 7.5);

            est2.actualizarCalificacion(0, 7.0);
            est2.actualizarCalificacion(1, 8.0);
            est2.actualizarCalificacion(2, 8.5);

            est3.actualizarCalificacion(0, 9.5);
            est3.actualizarCalificacion(1, 9.0);
            est3.actualizarCalificacion(2, 8.0);
        } catch (EstructuraException ex) {
            System.out.println("Error al insertar estudiantes de ejemplo: " + ex.getMessage());
        }

        // Crear un curso de ejemplo
        Curso cursoEjemplo = new Curso("111", "Estructura de Datos", 30);
        diccionarioCursos.agregar("111", cursoEjemplo);

        // Inscribir a los 3 estudiantes en el curso
        cursoEjemplo.inscribirEstudiante(est1);
        cursoEjemplo.inscribirEstudiante(est2);
        cursoEjemplo.inscribirEstudiante(est3);

        Scanner scanner = new Scanner(System.in);
        int opcion;

        // Menú principal con opciones
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

            // Llamada al menú según la opción seleccionada
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

    // MENÚ DE ESTUDIANTES
    public static void menuEstudiantes(Scanner scanner) {
        System.out.println("\nSelecciona una opción: ");
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

    // MENÚ DE CURSOS
    public static void menuCursos(Scanner scanner) {
        System.out.println("\nSelecciona una opción: ");
        System.out.println("1. Agregar curso");
        System.out.println("2. Eliminar curso");
        System.out.println("3. Listar cursos");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (opcion == 1) {
            agregarCurso(scanner, diccionarioCursos); // Llamar al método para agregar curso
        } else if (opcion == 2) {
            eliminarCurso(scanner, diccionarioCursos); // Llamar al método para eliminar curso
        } else if (opcion == 3) {
            listarCursos(diccionarioCursos); // Llamar al método para listar cursos
        } else {
            System.out.println("Selecciona una opción correcta");
        }
    }

    // MENÚ DE INSCRIPCIONES
    public static void menuInscripciones(Scanner scanner) {
        System.out.println("\nSelecciona una opción: ");
        System.out.println("1. Inscribir estudiante en curso");
        System.out.println("2. Mostrar lista de inscritos de un curso");
        System.out.println("3. Mostrar lista de espera de un curso");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (opcion == 1) {
            inscribirEstudianteACurso(scanner); // Llamar al método para agregar curso
        } else if (opcion == 2) {
            mostrarListaInscritos(scanner);
        } else if (opcion == 3) {
            mostrarListaEspera(scanner);
        } else {
            System.out.println("Selecciona una opción correcta");
        }
    }

    // MENÚ DE CALIFICACIONES
    public static void menuCalificaciones(Scanner scanner) {
        System.out.println("\nSelecciona una opción: ");
        System.out.println("1. Enviar solicitud de calificación");
        System.out.println("2. Procesar siguiente solicitud");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar buffer

        if (opcion == 1) {
            enviarSolicitudCalificacion(scanner);
        } else if (opcion == 2) {
            procesarSiguienteSolicitud();
        } else {
            System.out.println("Opción inválida.");
        }
    }

    // MENÚ DE ACCIONES (por implementar)
    public static void menuAcciones(Scanner scanner) {
        System.out.println("\nSelecciona una opción: ");
        System.out.println("1. Deshacer última acción");
        int opcion = scanner.nextInt();
        if (opcion == 1) {
            deshacerUltimaAccion();
        } else {
            System.out.println("Selecciona una opción correcta");
        }
    }

    // MENÚ DE REPORTES (por implementar)
    public static void menuReportes(Scanner scanner) {
        System.out.println("\nSelecciona una opción: ");
        System.out.println("1. Listar estudiantes ordenados por promedio");
        System.out.println("2. Rotar rol de tutor/líder de proyecto");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (opcion == 1) {
            reportePromedios(); // Llamar al método para agregar curso
        } else if (opcion == 2) {
            rotarRol(scanner);
        } else {
            System.out.println("Selecciona una opción correcta");
        }

    }

    // Métodos específicos para la funcionalidad:
    // 1. Registrar estudiante
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
            arbol.insertar(nuevo); // Insertar estudiante en el árbol

            // Registrar la acción en la pila
            Accion accion = new Accion(Accion.Tipo.REGISTRO, null, nuevo);
            pilaAcciones.apilar(accion);
        } catch (EstructuraException ex) {
            throw new EstructuraException(
                    "Ocurrió un error registrando un nuevo estudiante." + ex.getLocalizedMessage());
        }

        System.out.println("Estudiante registrado exitosamente.");
    }

    // 2. Buscar estudiante por matrícula
    public static void mostrarEstudiante(Scanner scanner, ArbolBinarioBusqueda arbol) {
        scanner.nextLine();

        System.out.print("Ingrese matrícula del estudiante: ");
        String matricula = scanner.nextLine();

        Estudiante estudiante = arbol.buscarPorMatricula(matricula); // Buscar estudiante en el árbol
        if (estudiante != null) {
            System.out.println("=== Estudiante encontrado ===");
            System.out.println(estudiante);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    // 3. Gestionar cursos
    public static void agregarCurso(Scanner scanner, DiccionarioGenerico<String, Curso> diccionarioCursos) {
        System.out.print("Ingrese la clave del curso: ");
        String claveCurso = scanner.nextLine(); // Leer clave del curso
        System.out.print("Ingrese el nombre del curso: ");
        String nombreCurso = scanner.nextLine(); // Leer nombre del curso
        System.out.println("Ingrese la cantidad máxima permitida de alumnos para el curso:");
        int capacidad = scanner.nextInt(); // Leer capacidad máxima del curso

        Curso nuevoCurso = new Curso(claveCurso, nombreCurso, capacidad); // Crear nuevo curso
        diccionarioCursos.agregar(claveCurso, nuevoCurso); // Agregar curso al diccionario
        System.out.println("Curso agregado con éxito.");
    }

    // Eliminar curso
    public static void eliminarCurso(Scanner scanner, DiccionarioGenerico<String, Curso> diccionarioCursos) {
        System.out.print("Ingrese la clave del curso a eliminar: ");
        String claveCurso = scanner.nextLine(); // Leer la clave del curso

        diccionarioCursos.eliminar(claveCurso); // Eliminar el curso del diccionario
    }

    // Listar cursos
    public static void listarCursos(DiccionarioGenerico<String, Curso> diccionarioCursos) {
        System.out.println("Listado de todos los cursos registrados:");
        diccionarioCursos.mostrar(); // Mostrar todos los cursos en el diccionario
    }

    // Inscribir estudiante en curso
    public static void inscribirEstudianteACurso(Scanner scanner) {
        System.out.print("Ingrese matrícula del estudiante: ");
        String matricula = scanner.nextLine();

        Estudiante estudiante = arbolEstudiantes.buscarPorMatricula(matricula); // Buscar estudiante
        if (estudiante == null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }

        System.out.print("Ingrese la clave del curso: ");
        String claveCurso = scanner.nextLine();

        Curso curso = diccionarioCursos.obtener(claveCurso); // Buscar curso
        if (curso == null) {
            System.out.println("Curso no encontrado.");
            return;
        }

        if (curso.hayCupo()) {
            // Antes de inscribir
            Accion accion = new Accion(Accion.Tipo.INSCRIPCION, null, estudiante);
            pilaAcciones.apilar(accion);
            curso.inscribirEstudiante(estudiante); // Inscribir estudiante si hay cupo
        } else {
            curso.inscribirEstudiante(estudiante); // Agregar estudiante a lista de espera si no hay cupo
        }
    }

    // Mostrar lista de inscritos
    public static void mostrarListaInscritos(Scanner scanner) {
        System.out.print("Ingrese la clave del curso: ");
        String clave = scanner.nextLine();

        Curso curso = diccionarioCursos.obtener(clave); // Obtener curso por clave
        if (curso != null) {
            System.out.println("Estudiantes inscritos:");
            curso.mostrarInscritos(); // Mostrar la lista de inscritos
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    // Mostrar lista de espera
    public static void mostrarListaEspera(Scanner scanner) {
        System.out.print("Ingrese la clave del curso: ");
        String clave = scanner.nextLine();

        Curso curso = diccionarioCursos.obtener(clave); // Obtener curso por clave
        if (curso != null) {
            System.out.println("Lista de espera:");
            curso.mostrarListaEspera(); // Mostrar la lista de espera
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    // Metodo para rotar el rol en la clase
    public static void rotarRol(Scanner scanner) {
        System.out.print("Ingrese la clave del curso: ");
        String clave = scanner.nextLine();

        Curso curso = diccionarioCursos.obtener(clave);

        CircularSimple<Estudiante> listaEstudiantesConRol = curso.getListaConRoles();

        if (listaEstudiantesConRol.getCabeza() == null) {
            System.out.println("Lista vacía");
            return;
        }

        NodoCircularSimple<Estudiante> actual = listaEstudiantesConRol.getCabeza();
        boolean primeraVuelta = true;

        while (primeraVuelta || actual != listaEstudiantesConRol.getCabeza()) {
            Estudiante estudianteActual = actual.getDato();
            if (estudianteActual.isEsLider()) {
                // Quitar rol actual
                estudianteActual.setEsLider(false);

                // Pasar rol al siguiente
                NodoCircularSimple<Estudiante> siguiente = actual.getSiguiente();
                siguiente.getDato().setEsLider(true);

                System.out.println("El nuevo líder es: " + siguiente.getDato());
                return;
            }
            actual = actual.getSiguiente();
            primeraVuelta = false;
        }

        // Si no había ningún líder asignado, puedes decidir asignárselo al primero
        // Esto depende de tus reglas de negocio
        System.out.println("No se encontró un estudiante con rol de líder.");
    }

    // Enviar solicitud de calificación
    public static void enviarSolicitudCalificacion(Scanner scanner) {
        System.out.print("Matrícula del estudiante: ");
        String matricula = scanner.nextLine();
        System.out.print("Índice de la calificación a modificar: ");
        int indice = scanner.nextInt();
        System.out.print("Nueva calificación: ");
        double calificacion = scanner.nextDouble();
        scanner.nextLine(); // Limpiar buffer

        SolicitudCalificacion solicitud = new SolicitudCalificacion(matricula, indice, calificacion);
        colaSolicitudes.encolar(solicitud);
        System.out.println("Solicitud agregada a la lista de espera.");
    }

    // Procesar siguiente solicitud
    public static void procesarSiguienteSolicitud() {
        if (colaSolicitudes.estaVacia()) {
            System.out.println("No hay solicitudes en espera.");
            return;
        }

        SolicitudCalificacion solicitud = colaSolicitudes.desencolar();
        Estudiante estudiante = arbolEstudiantes.buscarPorMatricula(solicitud.getMatriculaEstudiante());
        if (estudiante != null) {
            double calificacionAnterior;
            if (solicitud.getIndiceCalificacion() < estudiante.getCalificaciones().size()) {
                calificacionAnterior = estudiante.getCalificacion(solicitud.getIndiceCalificacion());
            } else {
                calificacionAnterior = 0.0;
            }
            Accion accion = new Accion(Accion.Tipo.CALIFICACION, calificacionAnterior, solicitud);
            pilaAcciones.apilar(accion);
            estudiante.actualizarCalificacion(solicitud.getIndiceCalificacion(), solicitud.getNuevaCalificacion());
            System.out.println("Calificación actualizada para el estudiante: " + estudiante.getNombreCompleto());
            System.out.println("Calificaciones actuales: " + estudiante.getCalificaciones());
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }

    public static void deshacerUltimaAccion() {
        if (pilaAcciones.esVacia()) {
            System.out.println("No hay acciones para deshacer.");
            return;
        }
        Accion accion = pilaAcciones.desapilar();
        switch (accion.getTipo()) {
            case REGISTRO:
                Estudiante estudiante = (Estudiante) accion.getDatoActual();
                arbolEstudiantes.eliminar(estudiante);
                System.out.println("Registro deshecho: estudiante eliminado (" + estudiante.getNombreCompleto() + ")");
                break;
            case INSCRIPCION:
                // Eliminar inscripción
                Estudiante estudiant = (Estudiante) accion.getDatoActual();
                // Aquí debes buscar el curso correspondiente y eliminar al estudiante
                // curso.eliminarInscripcion(estudiante);
                System.out.println("Inscripción deshecha para: " + estudiant.getNombreCompleto());
                break;
            case CALIFICACION:
                // Restaurar calificación previa
                // datoAnterior: calificación anterior (Double)
                // datoActual: objeto SolicitudCalificacion o datos para identificar estudiante
                // e índice
                if (accion.getDatoActual() instanceof SolicitudCalificacion) {
                    SolicitudCalificacion solicitud = (SolicitudCalificacion) accion.getDatoActual();
                    Estudiante est = arbolEstudiantes.buscarPorMatricula(solicitud.getMatriculaEstudiante());
                    if (est != null) {
                        est.actualizarCalificacion(solicitud.getIndiceCalificacion(),
                                (Double) accion.getDatoAnterior());
                        System.out.println("Calificación restaurada para el estudiante: " + est.getNombreCompleto());
                    } else {
                        System.out.println("No se encontró el estudiante para restaurar la calificación.");
                    }
                } else {
                    System.out.println("No se pudo restaurar la calificación (información insuficiente).");
                }
                break;
            default:
                System.out.println("Tipo de acción no soportado para deshacer.");
        }
    }

    public static void reportePromedios() {
        ArbolAVL avl = new ArbolAVL();
        recorrerEInsertarPromedios(arbolEstudiantes.getRaiz(), avl);
        System.out.println("Estudiantes ordenados por promedio:");
        avl.imprimirInOrden();
    }

    private static void recorrerEInsertarPromedios(Object nodo, ArbolAVL avl) {
        if (nodo == null)
            return;
        // Suponiendo que tu nodo del árbol binario tiene los campos: estudiante,
        // izquierda, derecha
        try {
            java.lang.reflect.Field estudianteField = nodo.getClass().getDeclaredField("estudiante");
            estudianteField.setAccessible(true);
            Estudiante estudiante = (Estudiante) estudianteField.get(nodo);

            java.lang.reflect.Field izqField = nodo.getClass().getDeclaredField("izquierda");
            izqField.setAccessible(true);
            Object izq = izqField.get(nodo);

            java.lang.reflect.Field derField = nodo.getClass().getDeclaredField("derecha");
            derField.setAccessible(true);
            Object der = derField.get(nodo);

            if (estudiante != null) {
                double promedio = estudiante.calcularPromedioRecursivo();
                avl.insertar(promedio, estudiante);
            }
            recorrerEInsertarPromedios(izq, avl);
            recorrerEInsertarPromedios(der, avl);
        } catch (Exception e) {
            // Manejo simple de error de reflexión
        }
    }
}
