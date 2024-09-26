import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp2295 {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:mysql://localhost:3306/your_database";
        String jdbcUser = "your_username";
        String jdbcPassword = "your_password";
        String username = "some_username"; // replace with the username you are looking for

        String query = "SELECT u.username, r.role FROM users u INNER JOIN user_roles r ON (r.id=u.role) WHERE u.username=?";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String user = resultSet.getString("username");
                String role = resultSet.getString("role");
                System.out.println("Username: " + user + ", Role: " + role);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}