import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseInputSanitization {

    public static void main(String[] args) {
        String userSuppliedInput = "very nice;) DROP TABLE FOO;"; // Example user input

        String url = "jdbc:yourdatabasetype://host:port/database";
        String username = "yourUsername";
        String password = "yourPassword";

        String sanitizedInput = sanitizeInput(userSuppliedInput);

        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            String sql = "INSERT INTO comments (comment) VALUES (?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, sanitizedInput);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static String sanitizeInput(String userInput) {
        // Sanitization logic here
        // This is a placeholder for actual input sanitization, which would
        // typically involve escaping special characters, removing harmful SQL syntax, etc.
        return userInput.replaceAll(";--", "").replaceAll(";", "\\;");
    }
}