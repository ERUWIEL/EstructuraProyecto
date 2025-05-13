package Exception;

/**
 * Excepción personalizada utilizada para representar errores relacionados 
 * con estructuras de datos dentro de la aplicación.
 * 
 * Esta clase extiende de {@link Exception} y permite manejar de forma específica
 * condiciones excepcionales que puedan ocurrir durante el uso de estructuras como árboles,
 * listas, diccionarios, etc.
 * 
 * @author Sebastian Moreno
 */
public class EstructuraException extends Exception {

    /**
     * Crea una nueva instancia de {@code EstructuraException} con un mensaje descriptivo.
     *
     * @param message Descripción del error.
     */
    public EstructuraException(String message) {
        super(message);
    }

    /**
     * Crea una nueva instancia de {@code EstructuraException} con un mensaje y una causa.
     *
     * @param message Descripción del error.
     * @param cause La causa original de la excepción (otra excepción).
     */
    public EstructuraException(String message, Throwable cause) {
        super(message, cause);
    }
}
