import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Temp1757 {
    public static void main(String[] args) {
        try {
            String dbUsername = System.getenv("DB_USERNAME");
            String dbPassword = System.getenv("DB_PASSWORD");

            Properties props = new Properties();
            props.load(new FileInputStream("/path/to/your-file.properties"));

            String dbUserName = props.getProperty("db_username", "defaultValueIfNotSet");

            System.out.println("Environment DB Username: " + dbUsername);
            System.out.println("Environment DB Password: " + dbPassword);
            System.out.println("Properties File DB Username: " + dbUserName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}