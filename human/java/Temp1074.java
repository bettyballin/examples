import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Temp1074 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourdatabase";
        String user = "yourusername";
        String password = "yourpassword";

        String username = "exampleUsername"; // Replace with actual username

        String query = "SELECT `passwordHash`, `Salt`, `LockoutStatus` FROM `yourtable` WHERE `username`= ?";

        try (Connection con = DriverManager.getConnection(url, user, password);
             PreparedStatement pst = con.prepareStatement(query)) {

            pst.setString(1, username);

            try (ResultSet rs = pst.executeQuery()) {
                while (rs.next()) {
                    String passwordHash = rs.getString("passwordHash");
                    String salt = rs.getString("Salt");
                    boolean lockoutStatus = rs.getBoolean("LockoutStatus");

                    System.out.println("Password Hash: " + passwordHash);
                    System.out.println("Salt: " + salt);
                    System.out.println("Lockout Status: " + lockoutStatus);
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}