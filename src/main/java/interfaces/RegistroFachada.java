package interfaces;

import Estructuras.ArbolAVL.ArbolAVL;
import Estructuras.ArbolBST.ArbolBinarioBusqueda;
import Estructuras.Cola.ColaGenerica;
import Estructuras.Diccionario.DiccionarioGenerico;
import Estructuras.ListaEnlazadaCircular.CircularSimple;
import Estructuras.ListaEnlazadaCircular.NodoCircularSimple;
import Estructuras.Pila.PilaGenerica;
import Exception.EstructuraException;
import entidades.*;

/**
 * Clase principal que gestiona el sistema de registro de estudiantes, cursos,
 * inscripciones y otros procesos asociados a la gestión académica.
 *
 * Utiliza diversas estructuras de datos como: - ArbolBinarioBusqueda para
 * almacenar estudiantes. - DiccionarioGenerico para almacenar cursos. -
 * ListaEnlazadaSimple para manejar listas relacionadas (aunque no utilizada en
 * su totalidad en este ejemplo).
 *
 * @author Sebastian Moreno, Erubiel, Luis Enrique
 */
public class RegistroFachada {

    // Estructuras de datos globales
    private static ArbolBinarioBusqueda arbolEstudiantes; // Árbol para almacenar estudiantes
    private static DiccionarioGenerico<String, Curso> diccionarioCursos; // Diccionario para cursos
    //private static ListaEnlazadaSimple listaEnlazada; // Lista enlazada (por si se utiliza más adelante)
    private static ColaGenerica<SolicitudCalificacion> colaSolicitudes;
    private static PilaGenerica<Accion> pilaAcciones;

    /**
     * MEtodo constructor de la fachada
     */
    public RegistroFachada(){
        arbolEstudiantes = new ArbolBinarioBusqueda();
        diccionarioCursos = new DiccionarioGenerico<>(20);
        //listaEnlazada = new ListaEnlazadaSimple();
        colaSolicitudes = new ColaGenerica<>();
        pilaAcciones = new PilaGenerica<>();
    }

    //METODOS SOBRE ESTUDUANTES
    /**
     * Metodo que permite agregar un estudiante a un arbol binario de busqueda
     * 
     * @param estudiante
     * @param arbol
     * @throws EstructuraException
     */
    public void registrarEstudiante(Estudiante estudiante)
            throws EstructuraException {
        try {
            arbolEstudiantes.insertar(estudiante); // Insertar estudiante en el árbol
            // Registrar la acción en la pila
            Accion accion = new Accion(Accion.Tipo.REGISTRO, null, estudiante);
            pilaAcciones.apilar(accion);
        } catch (EstructuraException ex) {
            throw new EstructuraException(
                    "Ocurrió un error registrando un nuevo estudiante." + ex.getLocalizedMessage());
        }
        System.out.println("Estudiante registrado exitosamente.");
    }
    /**
     * Metodo que permite mostrar la informacion de un estudiante
     * @param matricula
     * @param arbol
     */
    public void mostrarEstudiante(String matricula) {
        Estudiante estudiante = arbolEstudiantes.buscarPorMatricula(matricula); // Buscar estudiante en el árbol
        if (estudiante != null) {
            System.out.println("=== Estudiante encontrado ===");
            System.out.println(estudiante);
        } else {
            System.out.println("Estudiante no encontrado.");
        }
    }


    //METODOS SOBRE CURSOS
    /**
     * Metod que permite agregar un curso nuevo en un diccionario generico
     * @param cursoNuevo
     * @param diccionarioCursos
     */
    public void agregarCurso(Curso cursoNuevo) {
        diccionarioCursos.agregar(cursoNuevo.getClave(), cursoNuevo); // Agregar curso al diccionario
        System.out.println("Curso agregado con éxito.");
    }
    /**
     * Metodo que permite eliminar un curso existente
     * @param claveEliminar
     * @param diccionarioCursos
     */
    public void eliminarCurso(String claveEliminar) {
        diccionarioCursos.eliminar(claveEliminar); // Eliminar el curso del diccionario
    }
    /**
     * Metodo que permite consultar los cursos deisponibles
     * @param diccionarioCursos
     */
    public void listarCursos() {
        System.out.println("Listado de todos los cursos registrados:");
        diccionarioCursos.mostrar(); // Mostrar todos los cursos en el diccionario
    }
    /**
     * metodo que permite inscribir un estudiante a un curso
     * @param matricula
     * @param claveCurso
     */
    public void inscribirEstudianteACurso(String matricula, String claveCurso) {
        Estudiante estudiante = arbolEstudiantes.buscarPorMatricula(matricula);
        Curso curso = diccionarioCursos.obtener(claveCurso);

        if (estudiante== null) {
            System.out.println("Estudiante no encontrado.");
            return;
        }
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


    public void mostrarListaInscritos(String clave) {
        Curso curso = diccionarioCursos.obtener(clave); // Obtener curso por clave
        if (curso != null) {
            System.out.println("Estudiantes inscritos:");
            curso.mostrarInscritos(); // Mostrar la lista de inscritos
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    public void mostrarListaEspera(String clave) {
        Curso curso = diccionarioCursos.obtener(clave); // Obtener curso por clave
        if (curso != null) {
            System.out.println("Lista de espera:");
            curso.mostrarListaEspera(); // Mostrar la lista de espera
        } else {
            System.out.println("Curso no encontrado.");
        }
    }

    // Metodo para rotar el rol en la clase
    public void rotarRol(String clave) {
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
    public void enviarSolicitudCalificacion(SolicitudCalificacion solicitud) {
        colaSolicitudes.encolar(solicitud);
        System.out.println("Solicitud agregada a la lista de espera.");
    }

    // Procesar siguiente solicitud
    public void procesarSiguienteSolicitud() {
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

    public void deshacerUltimaAccion() {
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

    public void reportePromedios() {
        ArbolAVL avl = new ArbolAVL();
        recorrerEInsertarPromedios(arbolEstudiantes.getRaiz(), avl);
        System.out.println("Estudiantes ordenados por promedio:");
        avl.imprimirInOrden();
    }

    private void recorrerEInsertarPromedios(Object nodo, ArbolAVL avl) {
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
