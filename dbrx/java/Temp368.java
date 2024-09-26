import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.security.Key;
import javax.crypto.spec.SecretKeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Temp368 {
    public static void main(String[] args) {
        // Example secret key for demonstration
        Key secretKey = new SecretKeySpec("secretKeyBytes".getBytes(), "AES");

        // Serialize secret key to byte array
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        byte[] keyBytes = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(secretKey);
            keyBytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        // Assuming you have a table 'keys_table' with a column 'key_column'
        // and a JDBC connection 'connection' properly set up
        String dbURL = "jdbc:mysql://localhost:3306/your_database";
        String username = "your_db_username";
        String password = "your_db_password";

        Connection connection = null;
        PreparedStatement pstmt = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(dbURL, username, password);

            // Store byte array in database
            String sqlInsert = "INSERT INTO keys_table(key_column) VALUES(?)";
            pstmt = connection.prepareStatement(sqlInsert);
            pstmt.setBytes(1, keyBytes);
            int rowsAffected = pstmt.executeUpdate();

            System.out.println("Rows affected: " + rowsAffected);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}