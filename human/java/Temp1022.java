import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Temp1022 {
    public static void main(String[] args) {
        String jdbcUrl = "jdbc:your_database_url";
        String username = "your_username";
        String password = "your_password";
        String scriptFilePath = "script.location.sql";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
             Statement statement = connection.createStatement();
             BufferedReader reader = new BufferedReader(new FileReader(scriptFilePath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                statement.execute(line);
            }

            System.out.println("Database initialized successfully.");
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }
}