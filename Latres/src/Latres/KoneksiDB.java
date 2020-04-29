
package Latres;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class KoneksiDB {
    public Connection getKoneksi() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        
        String url = "jdbc:mysql://localhost/db_kontak";  // untuk memanggil database
        Connection con = DriverManager.getConnection(url, "root", "");
        
        return con;
        
    }
    
}
