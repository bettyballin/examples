import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Main36 {
    public static void main(String[] args) {
        Properties props = new Properties();

        try (InputStream input = new FileInputStream("application.properties")) {
            props.load(input);
            String password = props.getProperty("jdbc.password", "");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}