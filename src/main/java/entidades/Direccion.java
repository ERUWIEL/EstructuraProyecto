package entidades;

/**
 * Clase que representa una dirección física compuesta por calle, número,
 * colonia y ciudad. Es utilizada como parte de los datos de un estudiante u otra entidad.
 * 
 * Esta clase encapsula los datos básicos de una ubicación urbana en México o similar.
 * 
 * @author Sebastian Moreno
 */
public class Direccion {

    /** Nombre de la calle. */
    private String calle;

    /** Número exterior o interior. */
    private String numero;

    /** Colonia o barrio de la dirección. */
    private String colonia;

    /** Ciudad correspondiente a la dirección. */
    private String ciudad;

    /**
     * Constructor que inicializa todos los campos de la dirección.
     *
     * @param calle   Nombre de la calle.
     * @param numero  Número del domicilio.
     * @param colonia Colonia o barrio.
     * @param ciudad  Ciudad de residencia.
     */
    public Direccion(String calle, String numero, String colonia, String ciudad) {
        this.calle = calle;
        this.numero = numero;
        this.colonia = colonia;
        this.ciudad = ciudad;
    }

    public Direccion() {
    }

    /** @return El nombre de la calle. */
    public String getCalle() {
        return calle;
    }

    /** @param calle Nuevo nombre de la calle. */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /** @return El número del domicilio. */
    public String getNumero() {
        return numero;
    }

    /** @param numero Nuevo número del domicilio. */
    public void setNumero(String numero) {
        this.numero = numero;
    }

    /** @return El nombre de la colonia. */
    public String getColonia() {
        return colonia;
    }

    /** @param colonia Nueva colonia. */
    public void setColonia(String colonia) {
        this.colonia = colonia;
    }

    /** @return La ciudad correspondiente a la dirección. */
    public String getCiudad() {
        return ciudad;
    }

    /** @param ciudad Nueva ciudad. */
    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    /**
     * Devuelve una representación en cadena de la dirección.
     * 
     * @return Cadena con los datos de la dirección formateada.
     */
    @Override
    public String toString() {
        return calle + " " + numero + ", " + colonia + ", " + ciudad;
    }
}
