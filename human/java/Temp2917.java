import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Temp2917 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/yourDatabase"; // Replace 'yourDatabase' with your database name
        String user = "yourUsername"; // Replace with your MySQL username
        String password = "yourPassword"; // Replace with your MySQL password

        String createTableSQL = "CREATE TABLE oauth_client_details (" +
                "client_id VARCHAR(256) PRIMARY KEY, " +
                "resource_ids VARCHAR(256), " +
                "client_secret VARCHAR(256), " +
                "scope VARCHAR(256), " +
                "authorized_grant_types VARCHAR(256), " +
                "web_server_redirect_uri VARCHAR(256), " +
                "authorities VARCHAR(256), " +
                "access_token_validity INTEGER, " +
                "refresh_token_validity INTEGER, " +
                "additional_information VARCHAR(4096), " +
                "autoapprove VARCHAR(256)" +
                ");";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
            System.out.println("Table created successfully!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}