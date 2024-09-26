import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp2294 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourdatabase"; // Replace with your database URL
        String user = "yourusername"; // Replace with your database username
        String password = "yourpassword"; // Replace with your database password

        String query = "SELECT username, password, true FROM users WHERE username=?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, "someusername"); // Replace with the desired username
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String username = rs.getString(1);
                String userPassword = rs.getString(2);
                boolean isTrue = rs.getBoolean(3);

                System.out.println("Username: " + username);
                System.out.println("Password: " + userPassword);
                System.out.println("True: " + isTrue);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}