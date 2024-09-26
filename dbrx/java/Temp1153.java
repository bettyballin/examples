import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp1153 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String user = "your_database_user";
        String password = "your_database_password";
        String userName = "someUserName";
        String hashedPassword = "someHashedPassword";

        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            String query = "SELECT * FROM users WHERE name=? AND password=?";
            statement = connection.prepareStatement(query);
            statement.setString(1, userName);
            statement.setString(2, hashedPassword);
            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                // Process the result set
                System.out.println("User found: " + resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) 
                    resultSet.close();
                if (statement != null) 
                    statement.close();
                if (connection != null) 
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}