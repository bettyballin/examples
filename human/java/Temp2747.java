import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class UserService {

    private Properties properties;

    public UserService() {
        properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("users.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find users.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        System.out.println(userService.getProperty("somePropertyKey"));
    }
}