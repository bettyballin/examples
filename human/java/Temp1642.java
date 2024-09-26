import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Temp1642 {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:sample.db"; // Use SQLite for demonstration purposes
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {

            String createUsersTable = "CREATE TABLE IF NOT EXISTS users ("
                    + "username TEXT NOT NULL PRIMARY KEY, "
                    + "password TEXT NOT NULL, "
                    + "enabled BOOLEAN NOT NULL);";

            String createAuthoritiesTable = "CREATE TABLE IF NOT EXISTS authorities ("
                    + "username TEXT NOT NULL, "
                    + "authority TEXT NOT NULL, "
                    + "FOREIGN KEY(username) REFERENCES users(username));";

            String createIndex = "CREATE UNIQUE INDEX IF NOT EXISTS ix_auth_username "
                    + "ON authorities (username, authority);";

            stmt.execute(createUsersTable);
            stmt.execute(createAuthoritiesTable);
            stmt.execute(createIndex);

            System.out.println("Tables created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}