import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Temp433 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:sample.db"; // Change this to your database URL

        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            
            // Create users table
            String usersTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "username TEXT COLLATE NOCASE NOT NULL PRIMARY KEY, "
                    + "password TEXT COLLATE NOCASE NOT NULL, "
                    + "enabled BOOLEAN NOT NULL)";
            stmt.execute(usersTable);

            // Create authorities table
            String authoritiesTable = "CREATE TABLE IF NOT EXISTS authorities ("
                    + "username TEXT COLLATE NOCASE NOT NULL, "
                    + "authority TEXT COLLATE NOCASE NOT NULL, "
                    + "CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username))";
            stmt.execute(authoritiesTable);

            // Create unique index on authorities table
            String uniqueIndex = "CREATE UNIQUE INDEX IF NOT EXISTS ix_auth_username ON authorities (username, authority)";
            stmt.execute(uniqueIndex);

            System.out.println("Tables created successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}