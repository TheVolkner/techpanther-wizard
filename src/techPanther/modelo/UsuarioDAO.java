package techPanther.modelo;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

//Clase Data Access Object para Usuario, con los métodos CRUD respectivos.
public class UsuarioDAO {

    //Seleccionar todos los Usuarios de la BBDD.
    public List<Usuario> selectUsuarios() {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String SQL = "select * from Usuario";

            ResultSet rs = s.executeQuery(SQL);

            List<Usuario> listaUsuarios = new ArrayList();

            while (rs.next()) {

                Usuario u = new Usuario();

                u.setId_usuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setUsername(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setDomicilio(rs.getString(5));
                u.setTipo_nivel(rs.getString(6));
                u.setTelefono(rs.getString(7));
                u.setCorreo(rs.getString(8));
                u.setRegistrado_por(rs.getString(9));

                listaUsuarios.add(u);
            }

            return listaUsuarios;

        } catch (Exception e) {

            System.out.println("Ha habido un problema al listar usuarios desde la BBDD");
            e.printStackTrace();
        }
        return null;

    }

    //Agregar un Usuario a la BBDD.
    public void agregarUsuario(Usuario u) {

        try {

            cn = Conexion.conectar();

            String SQL = "insert into Usuario(id_usuario,nombre,username,password,domicilio,tipo_nivel,telefono,correo,registrado_por) "
                    + "values(?,?,?,?,?,?,?,?,?)";

            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setInt(1, u.getId_usuario());
            pst.setString(2, u.getNombre());
            pst.setString(3, u.getUsername());
            pst.setString(4, u.getPassword());
            pst.setString(5, u.getDomicilio());
            pst.setString(6, u.getTipo_nivel());
            pst.setString(7, u.getTelefono());
            pst.setString(8, u.getCorreo());
            pst.setString(9, u.getRegistrado_por());

            pst.executeUpdate();

        } catch (Exception e) {

            System.out.println("Ha habido un problema al agregar un usuario a la BBDD");
            e.printStackTrace();
        }

    }

    //Actualizar un usuario de la BBBD.
    public void updateUsuario(Usuario u) {

        try {

            cn = Conexion.conectar();

            String SQL = "update Usuario set nombre = ?, username = ?, domicilio = ?, tipo_nivel = ?, telefono = ?,"
                    + " correo = ?, registrado_por = ? where id_usuario = ?";

            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setString(1, u.getNombre());
            pst.setString(2, u.getUsername());
            pst.setString(3, u.getDomicilio());
            pst.setString(4, u.getTipo_nivel());
            pst.setString(5, u.getTelefono());
            pst.setString(6, u.getCorreo());
            pst.setString(7, u.getRegistrado_por());
            pst.setInt(8, u.getId_usuario());

            pst.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "¡Usuario actualizado correctamente!");

        } catch (Exception e) {

            System.out.println("Ha habido un problema al actualizar un usuario de la BBDD");
            e.printStackTrace();
        }

    }

    //Borrar un usuario de la BBDD.
    public void deleteUsuario(int id_usuario) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String SQL = "delete from Usuario where id_usuario = '" + id_usuario + "'";

            s.executeUpdate(SQL);

        } catch (Exception e) {

            System.out.println("Ha habido un problema al eliminar un usuario de la BBDD");
            e.printStackTrace();
        }
    }

    //Seleccionar un Usuario de la BBDD según un nombre de usuario y una contraseña.
    public Usuario selectByUserPass(String user, String pass) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String SQL = "Select * from Usuario where username = '" + user + "' and password = '" + pass + "'";

            ResultSet rs = s.executeQuery(SQL);

            Usuario u = new Usuario();

            while (rs.next()) {

                u.setId_usuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setUsername(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setDomicilio(rs.getString(5));
                u.setTipo_nivel(rs.getString(6));
                u.setTelefono(rs.getString(7));
                u.setCorreo(rs.getString(8));
                u.setRegistrado_por(rs.getString(9));

            }

            return u;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ha habido un problema al listar un usuario de la BBDD por User/Password");
            e.printStackTrace();

        }

        return null;
    }

    //seleccionar un usuario de la BBDD según un nombre de usuario.
    public Usuario selectByUser(String user) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String SQL = "Select * from Usuario where username = '" + user + "'";

            ResultSet rs = s.executeQuery(SQL);

            Usuario u = new Usuario();

            while (rs.next()) {

                u.setId_usuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setUsername(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setDomicilio(rs.getString(5));
                u.setTipo_nivel(rs.getString(6));
                u.setTelefono(rs.getString(7));
                u.setCorreo(rs.getString(8));
                u.setRegistrado_por(rs.getString(9));

            }

            return u;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ha habido un problema al listar un usuario de la BBDD por Nombre");
            e.printStackTrace();

        }

        return null;
    }

    //seleccionar un usuario de la BBDD según un nombre de usuario.
    public Usuario selectByID(int id_user) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String SQL = "Select * from Usuario where id_usuario = '" + id_user + "'";

            ResultSet rs = s.executeQuery(SQL);

            Usuario u = new Usuario();

            while (rs.next()) {

                u.setId_usuario(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setUsername(rs.getString(3));
                u.setPassword(rs.getString(4));
                u.setDomicilio(rs.getString(5));
                u.setTipo_nivel(rs.getString(6));
                u.setTelefono(rs.getString(7));
                u.setCorreo(rs.getString(8));
                u.setRegistrado_por(rs.getString(9));

            }

            return u;

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ha habido un problema al listar un usuario de la BBDD por ID");
            e.printStackTrace();

        }

        return null;
    }

    //actualizar contraseña de un usuario de la BBDD según el ID.
    public void updatePasswordByID(String pass, int id_user) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String SQL = "update Usuario set password = '" + pass + "' where id_usuario = '" + id_user + "'";

            s.executeUpdate(SQL);
            
            JOptionPane.showMessageDialog(null, "¡Contraseña actualizada exitosamente!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ha habido un problema al actualizar la contraseña de un Usuario en BBDD por ID");
            e.printStackTrace();

        }

    }

    //Campo para la conexión en todos los métodos.
    private Connection cn;
}
