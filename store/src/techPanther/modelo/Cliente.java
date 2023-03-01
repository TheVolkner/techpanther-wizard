package techPanther.modelo;


//Objeto Data Transfer Object para la Tabla de la BBDD 'Clientes'
public class Cliente {

    public Cliente() {

    }

    public Cliente(int id_cliente, String nombre, String domicilio, String telefono, String correo, String ultima_modificacion) {

        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.correo = correo;
        this.ultima_modificacion = ultima_modificacion;
    }

    public Cliente(String nombre, String domicilio, String telefono, String correo, String ultima_modificacion) {

        this.nombre = nombre;
        this.domicilio = domicilio;
        this.telefono = telefono;
        this.correo = correo;
        this.ultima_modificacion = ultima_modificacion;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getUltima_modificacion() {
        return ultima_modificacion;
    }

    public void setUltima_modificacion(String ultima_modificacion) {
        this.ultima_modificacion = ultima_modificacion;
    }
    
    
    

    private int id_cliente;
    
    private String nombre, domicilio, telefono, correo, ultima_modificacion;

}
