import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp1006 {
    public static void main(String[] args) {
        String sanitizedName = "John Doe"; // Example value
        int userAge = 30; // Example value

        String url = "jdbc:mysql://localhost:3306/yourdatabase";
        String user = "yourusername";
        String password = "yourpassword";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);

            String query = "SELECT * FROM users WHERE name=? AND age=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, sanitizedName);
            statement.setInt(2, userAge);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Process the result set
                System.out.println("User ID: " + resultSet.getInt("id"));
                System.out.println("User Name: " + resultSet.getString("name"));
                System.out.println("User Age: " + resultSet.getInt("age"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
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