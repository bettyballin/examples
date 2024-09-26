import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Temp642 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:sample.db"; // SQLite database file
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            // Create users table
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users (" +
                    "username VARCHAR(10) NOT NULL, " +
                    "password VARCHAR(32) NOT NULL, " +
                    "enabled BOOLEAN NOT NULL, " +
                    "PRIMARY KEY (username)" +
                    ");";
            stmt.execute(createUsersTable);

            // Create authorities table
            String createAuthoritiesTable = "CREATE TABLE IF NOT EXISTS authorities (" +
                    "username VARCHAR(10) NOT NULL, " +
                    "authority VARCHAR(10) NOT NULL, " +
                    "FOREIGN KEY (username) REFERENCES users(username)" +
                    ");";
            stmt.execute(createAuthoritiesTable);

            // Insert into users
            String insertUser = "INSERT INTO users(username, password, enabled) VALUES ('abc', '123456', TRUE);";
            stmt.execute(insertUser);

            // Insert into authorities
            String insertAuthority = "INSERT INTO authorities(username, authority) VALUES ('abc', 'ROLE_USER');";
            stmt.execute(insertAuthority);

            System.out.println("Tables created and data inserted successfully.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}