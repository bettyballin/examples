import org.apache.http.auth.UsernamePasswordCredentials;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class CredentialsRefactor {
    public static void main(String[] args) throws Exception {
        UsernamePasswordCredentials creds = new UsernamePasswordCredentials(
            System.getenv("API_USERNAME"),
            System.getenv("API_PASSWORD")
        );

        Properties prop = new Properties();
        try (InputStream input = new FileInputStream("config.properties")) {
            prop.load(input);
            creds = new UsernamePasswordCredentials(
                prop.getProperty("API_USERNAME"),
                prop.getProperty("API_PASSWORD")
            );
        }
    }
}