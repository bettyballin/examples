import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DatabaseConnection {

    private static Connection connection = null;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties props = new Properties();
                FileInputStream in = new FileInputStream("db.properties");
                props.load(in);
                in.close();

                String drivers = props.getProperty("jdbc.drivers");
                if (drivers != null) System.setProperty("jdbc.drivers", drivers);

                String url = props.getProperty("jdbc.url");
                String username = props.getProperty("jdbc.username");
                String password = props.getProperty("jdbc.password");

                connection = DriverManager.getConnection(url, username, password);
            } catch (IOException | ClassNotFoundException | SQLException ex) {
                ex.printStackTrace();
            }
        }
        return connection;
    }
}