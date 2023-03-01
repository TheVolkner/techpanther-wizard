package techPanther.modelo;

//Objeto Data Transfer Object para la Tabla de la BBDD 'Equipo'

import java.util.Date;

public class Equipo {

    public Equipo() {

    }

    public Equipo(int id_equipo, int id_cliente, String tipo_equipo, String marca, String modelo, Date fecha_ingreso, String observaciones,
            String estatus, String comentarios_tecnicos, String revisado_por) {

        this.id_equipo = id_equipo;
        this.id_cliente = id_cliente;
        this.tipo_equipo = tipo_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.fecha_ingreso = fecha_ingreso;
        this.observaciones = observaciones;
        this.estatus = estatus;
        this.comentarios_tecnicos = comentarios_tecnicos;
        this.revisado_por = revisado_por;

    }

    public Equipo(int id_cliente,String tipo_equipo, String marca, String modelo, Date fecha_ingreso, String observaciones,
            String estatus, String comentarios_tecnicos, String revisado_por) {

        this.id_cliente = id_cliente;
        this.tipo_equipo = tipo_equipo;
        this.marca = marca;
        this.modelo = modelo;
        this.fecha_ingreso = fecha_ingreso;
        this.observaciones = observaciones;
        this.estatus = estatus;
        this.comentarios_tecnicos = comentarios_tecnicos;
        this.revisado_por = revisado_por;

    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getTipo_equipo() {
        return tipo_equipo;
    }

    public void setTipo_equipo(String tipo_equipo) {
        this.tipo_equipo = tipo_equipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Date getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(Date fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    public String getComentarios_tecnicos() {
        return comentarios_tecnicos;
    }

    public void setComentarios_tecnicos(String comentarios_tecnicos) {
        this.comentarios_tecnicos = comentarios_tecnicos;
    }

    public String getRevisado_por() {
        return revisado_por;
    }

    public void setRevisado_por(String revisado_por) {
        this.revisado_por = revisado_por;
    }
    
    
    

    private int id_equipo, id_cliente;
    private String tipo_equipo, marca, modelo, observaciones, estatus,
            comentarios_tecnicos, revisado_por;
    private Date fecha_ingreso;

}
