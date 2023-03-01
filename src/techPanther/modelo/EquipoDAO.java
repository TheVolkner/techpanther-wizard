package techPanther.modelo;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class EquipoDAO {

    public List<Equipo> selectEquipos() {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String sql = "Select * from Equipo";

            ResultSet rs = s.executeQuery(sql);

            List<Equipo> lista = new ArrayList();

            while (rs.next()) {

                Equipo e = new Equipo();

                e.setId_equipo(rs.getInt(1));
                e.setId_cliente(rs.getInt(2));
                e.setTipo_equipo(rs.getString(3));
                e.setMarca(rs.getString(4));
                e.setModelo(rs.getString(5));

                long valorFecha = rs.getDate(6).getTime();

                java.util.Date fecha = new java.util.Date(valorFecha);
                e.setFecha_ingreso(fecha);

                e.setObservaciones(rs.getString(7));
                e.setEstatus(rs.getString(8));
                e.setComentarios_tecnicos(rs.getString(9));
                e.setRevisado_por(rs.getString(10));

                lista.add(e);

            }

            return lista;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ha habido un problema al listar Equipos desde la BBDD.");

            e.printStackTrace();

            return null;
        }

    }

    public boolean agregarEquipo(Equipo e) {

        try {

            cn = Conexion.conectar();

            String sql = "insert into equipo(id_cliente,tipo_equipo,marca,modelo,fecha_ingreso,observaciones,estatus,comentarios_tecnicos,revisado_por)"
                    + "values(?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setInt(1, e.getId_cliente());

            pst.setString(2, e.getTipo_equipo());

            pst.setString(3, e.getMarca());

            pst.setString(4, e.getModelo());

            long valorFecha = e.getFecha_ingreso().getTime();

            java.sql.Date fecha = new java.sql.Date(valorFecha);

            pst.setDate(5, fecha);

            pst.setString(6, e.getObservaciones());

            pst.setString(7, e.getEstatus());

            pst.setString(8, e.getComentarios_tecnicos());

            pst.setString(9, e.getRevisado_por());

            pst.executeUpdate();

            return true;

        } catch (Exception ex) {

            ex.printStackTrace();

            JOptionPane.showMessageDialog(null, "Ha ocurrido un error al agregar el Equipo a la BBDD");

            return false;
        }

    }

    public boolean updateEquipo(Equipo e) {

        try {

            cn = Conexion.conectar();

            String sql = "update Equipo set tipo_equipo = ?, marca = ?, modelo = ?, "
                    + "fecha_ingreso = ?, observaciones = ?, estatus = ?, comentarios_tecnicos = ?, revisado_por = ? where id_equipo = ?";

            PreparedStatement pst = cn.prepareStatement(sql);

            pst.setString(1, e.getTipo_equipo());
            pst.setString(2, e.getMarca());
            pst.setString(3, e.getModelo());

            long valorFecha = e.getFecha_ingreso().getTime();

            java.sql.Date fecha = new java.sql.Date(valorFecha);
            pst.setDate(4, fecha);

            pst.setString(5, e.getObservaciones());
            pst.setString(6, e.getEstatus());
            pst.setString(7, e.getComentarios_tecnicos());
            pst.setString(8, e.getRevisado_por());
            pst.setInt(9, e.getId_equipo());

            pst.executeUpdate();

            return true;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "No se ha podido actualizar el Equipo de la BBDD");

            ex.printStackTrace();

            return false;
        }
    }

    public boolean deleteEquipo(int id_equipo) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String sql = "delete from Equipo where id_equipo = '" + id_equipo + "'";

            s.executeUpdate(sql);

            return true;

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(null, "No se ha podido eliminar el Equipo de la BBDD");

            ex.printStackTrace();

            return false;
        }
    }

    public Equipo selectEquipoById(int id_equipo) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String sql = "Select * from Equipo where id_equipo = '" + id_equipo + "'";

            ResultSet rs = s.executeQuery(sql);

            Equipo e = new Equipo();

            while (rs.next()) {

                e.setTipo_equipo(rs.getString(3));
                e.setMarca(rs.getString(4));
                e.setModelo(rs.getString(5));

                long tiempo = rs.getDate(6).getTime();

                java.util.Date fecha = new java.util.Date(tiempo);

                e.setFecha_ingreso(fecha);

                e.setObservaciones(rs.getString(7));
                e.setEstatus(rs.getString(8));
                e.setComentarios_tecnicos(rs.getString(9));
                e.setRevisado_por(rs.getString(10));
            }

            return e;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar el Equipo de la BBDD");

            ex.printStackTrace();

            return null;

        }
    }

    public List<Equipo> selectEquiposByIdClient(int id_cliente) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String sql = "Select * from Equipo where id_cliente = '" + id_cliente + "'";

            ResultSet rs = s.executeQuery(sql);

            List<Equipo> lista = new ArrayList();

            while (rs.next()) {

                Equipo e = new Equipo();

                e.setId_equipo(rs.getInt(1));
                e.setTipo_equipo(rs.getString(3));
                e.setMarca(rs.getString(4));
                e.setModelo(rs.getString(5));

                long tiempo = rs.getDate(6).getTime();

                java.util.Date fecha = new java.util.Date(tiempo);

                e.setFecha_ingreso(fecha);

                e.setObservaciones(rs.getString(7));
                e.setEstatus(rs.getString(8));
                e.setComentarios_tecnicos(rs.getString(9));
                e.setRevisado_por(rs.getString(10));

                lista.add(e);
            }

            return lista;

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "No se ha podido eliminar el Equipo de la BBDD");

            ex.printStackTrace();

            return null;

        }
    }

    public List<String> selectEstatus() {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String sql = "select estatus from equipo";

            ResultSet rs = s.executeQuery(sql);

            List<String> lista = new ArrayList();

            while (rs.next()) {

                lista.add(rs.getString(1));
            }

            return lista;

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se ha podido listar estatus de los equipos de la BBDD");

            e.printStackTrace();

            return null;

        }
    }
    
    public int limpiarTabla(){
        
        try {
            
         cn = Conexion.conectar();
         
         Statement s = cn.createStatement();
         
         String sql = "DELETE FROM EQUIPOS";
         
         s.executeUpdate(sql);
                             
        return 1;
        } catch (Exception e) {
            
            e.printStackTrace();
            return 0;
        }
    }
    
    

    private Connection cn;
;
}
