import java.sql.*;

public class Temp1643 {
    public static void main(String[] args) {
        String query = "SELECT username, password, enabled FROM users WHERE username = ?";
        String username = "exampleUsername"; // replace with actual username to search for

        try {
            usersByUsernameQuery(query, username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void usersByUsernameQuery(String query, String username) throws SQLException {
        // Replace below with your actual database connection details
        String url = "jdbc:mysql://localhost:3306/yourDatabase";
        String user = "yourUsername";
        String password = "yourPassword";

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, username);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    String retrievedUsername = resultSet.getString("username");
                    String retrievedPassword = resultSet.getString("password");
                    boolean enabled = resultSet.getBoolean("enabled");

                    System.out.println("Username: " + retrievedUsername);
                    System.out.println("Password: " + retrievedPassword);
                    System.out.println("Enabled: " + enabled);
                }
            }
        }
    }
}