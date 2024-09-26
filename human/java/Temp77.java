import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp77 {
    public static void main(String[] args) {
        String email = "example@example.com"; // replace with the desired email
        String url = "jdbc:mysql://localhost:3306/your_database"; // replace with your database URL
        String user = "your_username"; // replace with your database username
        String password = "your_password"; // replace with your database password
        
        String query = "SELECT u.Email, " +
                       "CASE WHEN a.user_id is null then 'Role_User' " +
                       "WHEN a.auth_type = 'S' then 'Role_Admin' " +
                       "WHEN a.auth_type = 'L' then 'Role_Licensee' end as authority " +
                       "FROM users u LEFT JOIN auth_sys a on u.user_id = a.user_id " +
                       "WHERE u.email = ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {
             
            pst.setString(1, email);
            
            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String userEmail = rs.getString(1);
                    String authority = rs.getString(2);
                    System.out.println("Email: " + userEmail + ", Authority: " + authority);
                }
            }
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}