import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp2308 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourDatabase"; // Replace with your database URL
        String user = "yourUsername"; // Replace with your database username
        String password = "yourPassword"; // Replace with your database password

        String query = "SELECT name, password FROM users WHERE name = ?";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             PreparedStatement ps = conn.prepareStatement(query)) {

            ps.setString(1, "exampleName"); // Replace with the name you want to query

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    String name = rs.getString("name");
                    String pass = rs.getString("password");
                    System.out.println("Name: " + name + ", Password: " + pass);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}