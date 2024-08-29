package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLConnect {
    
    private Connection conn;  
   
    public SQLConnect() {
        String driver = "com.mysql.cj.jdbc.Driver";
        String userdb = "root";
        String passdb = "Admin0101";
        String url = "jdbc:mysql://localhost:3306/usuarios";

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, userdb, passdb);
            if (conn != null) {
                System.out.println("Conexión establecida exitosamente***********");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Conexión Fallida:\n\n" + ex);
        }
    }
    
    public Connection getConnection() {
        return conn;
    }

    public void close() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }
}

