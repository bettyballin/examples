import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp2313 {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/yourdatabase"; // Update with your database details
        String username = "yourusername"; // Update with your database username
        String password = "yourpassword"; // Update with your database password
        String query = "SELECT username, CONCAT('ROLE_', role) FROM user_roles WHERE username = ?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "exampleUsername"); // Update with the desired username to search for
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String role = resultSet.getString("CONCAT('ROLE_', role)");
                System.out.println("Username: " + user + ", Role: " + role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}