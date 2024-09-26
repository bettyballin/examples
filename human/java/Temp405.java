import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Temp405 {
    public static void main(String[] args) {
        String jdbcDriver = "com.mysql.jdbc.Driver"; 
        String dbUrl = "jdbc:mysql://localhost/reportsdb"; 
        String username = "reportsUser"; 
        String password = "G6N718UuyPE5bHyWKyuLQSm02auQPUtm"; // Assuming the password has been decrypted
        
        try {
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(dbUrl, username, password);
            System.out.println("Connection successful!");
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection failed.");
            e.printStackTrace();
        }
    }
}