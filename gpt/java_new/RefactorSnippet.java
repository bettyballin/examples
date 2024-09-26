import org.apache.http.auth.UsernamePasswordCredentials;
import java.util.Arrays;

public class RefactorSnippet {
    public static void main(String[] args) {
        char[] passwordCharArray = ...; // Your password as char array
        String passwordString = new String(passwordCharArray);

        try {
            UsernamePasswordCredentials credentials = new UsernamePasswordCredentials("username", passwordString);
            // Use the credentials with HttpClient
        } finally {
            // Attempt to minimize password String lifetime
            passwordString = null;
            Arrays.fill(passwordCharArray, ' ');
        }
    }
}