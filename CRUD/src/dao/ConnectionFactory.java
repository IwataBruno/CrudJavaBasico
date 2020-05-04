package dao;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;

/**
 *
 * @author iwata
 */
public class ConnectionFactory {
    
    public java.sql.Connection getConexao(){
        
        try {
            
            return DriverManager.getConnection("jdbc:mysql://localhost/crud","root","123");
            
        } catch (Exception e) {
            
            throw new RuntimeException(e);
        }
    }
}
