package techPanther.modelo;

import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

//Clase Data Access Object para Cliente, con los métodos CRUD respectivos.
public class ClienteDAO {

    //Obtener una lista de todos los objetos de tipo cliente 
    public List<Cliente> selectClientes() {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String SQL = "select * from Cliente";

            ResultSet rs = s.executeQuery(SQL);

            List<Cliente> listaClientes = new ArrayList();

            while (rs.next()) {

                Cliente c = new Cliente();

                c.setId_cliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDomicilio(rs.getString(3));
                c.setTelefono(rs.getString(4));
                c.setCorreo(rs.getString(5));
                c.setUltima_modificacion(rs.getString(6));

                listaClientes.add(c);
            }

            return listaClientes;

        } catch (Exception e) {

            System.out.println("Ha habido un problema al listar los Clientes desde la BBDD.");
            e.printStackTrace();
        }
        return null;

    }

    //Seleccionar un Cliente por ID
    public Cliente selectbyID(int id_cliente) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String SQL = "select * from cliente where id_cliente = '" + id_cliente + "'";

            ResultSet rs = s.executeQuery(SQL);

            Cliente c = new Cliente();

            while (rs.next()) {

                c.setId_cliente(rs.getInt(1));
                c.setNombre(rs.getString(2));
                c.setDomicilio(rs.getString(3));
                c.setTelefono(rs.getString(4));
                c.setCorreo(rs.getString(5));
                c.setUltima_modificacion(rs.getString(6));
            }

            return c;

        } catch (Exception e) {

            System.out.println("Ha habido un problema al listar los Clientes desde la BBDD.");
            e.printStackTrace();
        }
        return null;

    }

    //Agrega un objeto cliente a la BBBD
    public void agregarCliente(Cliente c) {

        try {

            cn = Conexion.conectar();

            String SQL = "insert into Cliente(id_cliente,nombre,domicilio,telefono,correo,ultima_modificacion)"
                    + " values(?,?,?,?,?,?)";

            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setInt(1, c.getId_cliente());
            pst.setString(2, c.getNombre());
            pst.setString(3, c.getDomicilio());
            pst.setString(4, c.getTelefono());
            pst.setString(5, c.getCorreo());
            pst.setString(6, c.getUltima_modificacion());

            pst.executeUpdate();

            JOptionPane.showMessageDialog(null, "¡Se ha agregado el cliente correctamente!");

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Ha habido un problema al agregar el Cliente a la BBDD.");
            e.printStackTrace();
        }

    }

    //Actualiza un objeto cliente de la BBDD
    public boolean updateCliente(Cliente c) {

        try {

            cn = Conexion.conectar();

            String SQL = "update Cliente set nombre = ?, domicilio = ?, telefono = ?, correo = ?, ultima_modificacion = ? where id_cliente = ?";

            PreparedStatement pst = cn.prepareStatement(SQL);

            pst.setString(1, c.getNombre());
            pst.setString(2, c.getDomicilio());
            pst.setString(3, c.getTelefono());
            pst.setString(4, c.getCorreo());
            pst.setString(5, c.getUltima_modificacion());
            pst.setInt(6, c.getId_cliente());

            pst.executeUpdate();
            
            return true;

        } catch (Exception e) {

            System.out.println("Ha habido un problema al actualizar el Cliente de la BBDD.");
            e.printStackTrace();
            
            return false;
        }

    }

    //Elimina un cliente de la BBDD segun su ID.
    public void deleteCliente(int id_cliente) {

        try {

            cn = Conexion.conectar();

            Statement s = cn.createStatement();

            String SQL = "delete from Cliente where id_cliente = '" + id_cliente + "'";

            s.executeUpdate(SQL);

        } catch (Exception e) {

            System.out.println("Ha habido un problema al eliminar el Cliente de la BBDD.");
            e.printStackTrace();
        }
    }

    //Campo para la conexión en todos los métodos.
    private Connection cn;

}
