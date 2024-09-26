import java.sql.*;
import java.security.MessageDigest;

public class OracleConnection {
    public static void main(String[] args) {
        try {
            // Load the Oracle JDBC driver
            Class.forName("oracle.jdbc.OracleDriver");

            // Create a connection with a plain text password (Note: Oracle JDBC does not support hashed passwords directly)
            Connection conn = DriverManager.getConnection(
                "jdbc:oracle:thin:@myserver:port:mySID",
                "myuser",
                "mypassword");

            // Print the connection URL
            DatabaseMetaData metaData = conn.getMetaData();
            System.out.println("Connected to Oracle DB at: " + metaData.getURL());

            // Close the connection
            conn.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Oracle JDBC Driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to Oracle DB failed.");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static byte[] getHashedPassword(String password) throws Exception {
        // Hash the password using a secure hash algorithm such as SHA-256
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        digest.update(password.getBytes());
        byte[] hashedPassword = digest.digest();

        return hashedPassword;
    }
}