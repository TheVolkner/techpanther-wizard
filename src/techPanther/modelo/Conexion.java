
package techPanther.modelo;

import java.sql.*;

//Conexión a la BBDD, facilita un método que devuelve la conexión lista.
public class Conexion {
    
    public static Connection conectar(){
        
        try {
            
              Connection cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/panther_wizard", "root", "");
              
              return cn;
            
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
        return null;
        
      
    }
    
}
