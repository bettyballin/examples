import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp1221 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourDatabase"; // Update with your database URL
        String user = "yourUsername"; // Update with your database username
        String password = "yourPassword"; // Update with your database password
        
        String query = "SELECT email, password, prop_was_moderated FROM terminal_user WHERE email = ? AND prop_confirmed = TRUE";
        
        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
             
            preparedStatement.setString(1, "test@example.com"); // Replace with the email you want to search for
            
            ResultSet resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String pwd = resultSet.getString("password");
                boolean propWasModerated = resultSet.getBoolean("prop_was_moderated");
                
                System.out.println("Email: " + email);
                System.out.println("Password: " + pwd);
                System.out.println("Prop Was Moderated: " + propWasModerated);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}