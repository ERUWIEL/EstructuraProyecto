
package Exception;

/**
 * Representa una clase excepcion generalizada para las estructuras de Datos.
 * @author Sebastian Moreno
 */
public class EstructuraException extends Exception{

    public EstructuraException(String message) {
        super(message);
    }

    public EstructuraException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
