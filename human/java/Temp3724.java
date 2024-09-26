import java.util.Properties;
import java.io.InputStream;
import java.io.IOException;

public class Temp3724 {
    public static void main(String[] args) {
        String value = SpringUtil.getProperty("myapp.home-org");
        System.out.println("Property value: " + value);
    }
}

class SpringUtil {
    private static Properties properties = new Properties();

    static {
        try (InputStream input = SpringUtil.class.getClassLoader().getResourceAsStream("application.properties")) {
            if (input == null) {
                System.out.println("Sorry, unable to find application.properties");
                return;
            }
            properties.load(input);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}


To make this code executable, you need to create an `application.properties` file in the `resources` directory of your project and add the property `myapp.home-org` with an appropriate value.