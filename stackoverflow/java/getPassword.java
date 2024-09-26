import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import java.util.Arrays;
import org.apache.http.client.HttpClient;
import static org.apache.http.auth.AuthScope.ANY;

// Assuming 'username', 'httpClient', and 'auth' variables are declared and initialized appropriately.
char[] password = /* your password char array */;
final Credentials credentials = new UsernamePasswordCredentials(username, new String(password)) {
    @Override
    public String getPassword() {
        return new String(password);
    }
}