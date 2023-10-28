
package nutricionistag23.accesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;



public class Conexion {
    
    private static final String URL="jdbc:mariadb://localhost/";
    private static final String DB="nutricionista";
    private static final String USR="root";
    private static final String PASS="";
    private static Connection conexion;

    private Conexion() {
    }
    
    public static Connection conectarServidor(){
        if(conexion==null){
            
            try {
                Class.forName("org.mariadb.jdbc.Driver");
                conexion = DriverManager.getConnection(URL+DB, USR, PASS);
                
//                JOptionPane.showMessageDialog(null, "Conexion exitosa");
                
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Conexión fallida"+ex.getMessage());
                
            } catch (SQLException ex) {
                      JOptionPane.showMessageDialog(null, "Error de Driver"+ex.getMessage());
            }
            
        }
        return conexion;
    }

    
    
}
