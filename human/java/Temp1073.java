import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp1073 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourdatabase"; // Replace with your database URL
        String user = "yourusername"; // Replace with your database username
        String password = "yourpassword"; // Replace with your database password
        String username = "targetusername"; // Replace with the username you want to query

        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String query = "SELECT `passwordHash`, `Salt` FROM `--database--` WHERE `username`= ?";
            try (PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                try (ResultSet rs = stmt.executeQuery()) {
                    while (rs.next()) {
                        String passwordHash = rs.getString("passwordHash");
                        String salt = rs.getString("Salt");
                        System.out.println("Password Hash: " + passwordHash);
                        System.out.println("Salt: " + salt);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}