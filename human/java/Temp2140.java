import java.util.Arrays;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.BasicCredentialsProvider;

public class Temp2140 {
    public static void main(String[] args) {
        char[] password = "yourpassword".toCharArray();
        String username = "yourusername";

        final Credentials credentials = new UsernamePasswordCredentials(username, null) {
            @Override
            public String getPassword() {
                // AKCTAT-3791: this helps the GC to clear the String from the memory, as it will be used and dismissed immediately
                // Unfortunately Apache HTTP Client does not allow to pass the byte[] directly
                return new String(password);
            }
        };

        BasicCredentialsProvider credentialsProvider = new BasicCredentialsProvider();
        credentialsProvider.setCredentials(AuthScope.ANY, credentials);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCredentialsProvider(credentialsProvider)
                .build();

        try {
            // ... (do stuff with httpClient)
        } finally {
            Arrays.fill(password, '\0');
            try {
                httpClient.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}