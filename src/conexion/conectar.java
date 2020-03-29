
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;

public class conectar {
    Connection conectar = null;
    public Connection conexion(){
        try {
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("org.gjt.mm.mysql.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost/testFecha","root","");
        } catch (Exception e) {
            System.out.print(e.getMessage());
        }
        return conectar;
    }
    
}
