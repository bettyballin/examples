import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;

public class ConnectionExample {
    public static void main(String[] args) throws Exception {
        URL url = new URL("https://example.com"); // Replace with your URL
        SSLContext sc = SSLContext.getInstance("TLS"); // Initialize SSLContext
        sc.init(null, null, new java.security.SecureRandom()); // Set up the SSL context

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        if (connection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) connection).setSSLSocketFactory(sc.getSocketFactory());
        }
        // Rest of the code to handle the connection
    }
}