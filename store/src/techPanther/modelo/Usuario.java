package techPanther.modelo;

//Objeto Data Transfer Object para la Tabla de la BBDD 'Usuario'
public class Usuario {

    public Usuario() {

    }

    public Usuario(int id_usuario, String nombre, String username, String password, String domicilio, String tipo_nivel, String telefono, String correo, String registrado_por) {

        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.domicilio = domicilio;
        this.tipo_nivel = tipo_nivel;
        this.telefono = telefono;
        this.correo = correo;
        this.registrado_por = registrado_por;
    }

    public Usuario(String nombre, String username, String password, String domicilio, String tipo_nivel, String telefono, String correo, String registrado_por) {

        this.nombre = nombre;
        this.username = username;
        this.password = password;
        this.domicilio = domicilio;
        this.tipo_nivel = tipo_nivel;
        this.telefono = telefono;
        this.correo = correo;
        this.registrado_por = registrado_por;
    }

    public Usuario(int id_usuario,String nombre, String username, String domicilio, String tipo_nivel, String telefono, String correo, String registrado_por) {

        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.username = username;
        this.domicilio = domicilio;
        this.tipo_nivel = tipo_nivel;
        this.telefono = telefono;
        this.correo = correo;
        this.registrado_por = registrado_por;
    }

    public String toString() {

        return "Usuario = {Nombre:" + nombre + ", Permisos: " + tipo_nivel;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getTipo_nivel() {
        return tipo_nivel;
    }

    public void setTipo_nivel(String tipo_nivel) {
        this.tipo_nivel = tipo_nivel;
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

    public String getRegistrado_por() {
        return registrado_por;
    }

    public void setRegistrado_por(String registrado_por) {
        this.registrado_por = registrado_por;
    }

    private int id_usuario;
    private String nombre, username, password, domicilio, tipo_nivel, telefono,
            correo, registrado_por;

}
