import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Temp608 {
    public static void main(String[] args) {
        String url = "jdbc:h2:~/test"; // change this URL as needed
        String user = "sa";
        String password = "";

        String createUsersTable = "CREATE TABLE users (" +
                "username VARCHAR_IGNORECASE(50) NOT NULL PRIMARY KEY, " +
                "password VARCHAR_IGNORECASE(50) NOT NULL, " +
                "enabled BOOLEAN NOT NULL);";

        String createAuthoritiesTable = "CREATE TABLE authorities (" +
                "username VARCHAR_IGNORECASE(50) NOT NULL, " +
                "authority VARCHAR_IGNORECASE(50) NOT NULL, " +
                "CONSTRAINT fk_authorities_users FOREIGN KEY(username) REFERENCES users(username));";

        String createIndex = "CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            stmt.execute(createUsersTable);
            stmt.execute(createAuthoritiesTable);
            stmt.execute(createIndex);

            System.out.println("Tables and index created successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}