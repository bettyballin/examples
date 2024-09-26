import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Temp1714 {
    public static void main(String[] args) {
        String url = "jdbc:jtds:sqlserver://<serverName>:<port>;databaseName=<DBName>;useKerberos=true";
        Connection conn = null;

        try {
            // Load the JTDS driver class
            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            // Establish the connection
            conn = DriverManager.getConnection(url);

            // Perform database operations here

            System.out.println("Connection established successfully.");

        } catch (ClassNotFoundException e) {
            System.out.println("JTDS Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Failed to establish connection.");
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}