import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp2598 {
    public static void main(String[] args) {
        String url = "jdbc:your_database_url";
        String user = "your_database_user";
        String password = "your_database_password";
        String query = "SELECT email as USERNAME, PASSWORD as password, enabled FROM user_account WHERE email=?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, "example@example.com");
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                String email = rs.getString("USERNAME");
                String pass = rs.getString("password");
                boolean enabled = rs.getBoolean("enabled");
                System.out.println("Email: " + email);
                System.out.println("Password: " + pass);
                System.out.println("Enabled: " + enabled);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}