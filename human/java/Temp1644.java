import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp1644 {
    public static void main(String[] args) {
        String username = "example_user"; // Replace with actual username
        String url = "jdbc:mysql://localhost:3306/yourdatabase"; // Replace with your database URL
        String user = "yourusername"; // Replace with your database username
        String password = "yourpassword"; // Replace with your database password

        String query = "SELECT r.role_name FROM role r, users u WHERE u.username = ? AND u.role_id = r.id";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String roleName = rs.getString(1);
                    System.out.println("Role Name: " + roleName);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}