
package entidades;

/**
 *
 * @author Sebastian Moreno
 */
public class Estudiante {
    private String matricula;
    private String nombreCompleto;
    private String telefono;
    private String correoElectronico;
    private Direccion direccion;

    public Estudiante() {
    }
    
    public Estudiante(String matricula, String nombreCompleto, String telefono, String correoElectronico, Direccion direccion) {
        this.matricula = matricula;
        this.nombreCompleto = nombreCompleto;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
        this.direccion = direccion;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Estudiante{" + "matricula=" + matricula + ", nombreCompleto=" + nombreCompleto + ", telefono=" + telefono + ", correoElectronico=" + correoElectronico + ", direccion=" + direccion + '}';
    }
    
    
    
        
}
