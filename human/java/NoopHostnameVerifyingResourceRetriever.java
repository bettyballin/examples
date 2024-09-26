import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

class DefaultResourceRetriever {
    private int connectTimeout;
    private int readTimeout;

    public DefaultResourceRetriever(int connectTimeout, int readTimeout) {
        this.connectTimeout = connectTimeout;
        this.readTimeout = readTimeout;
    }

    protected HttpURLConnection openConnection(URL url) throws IOException {
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setConnectTimeout(connectTimeout);
        connection.setReadTimeout(readTimeout);
        return connection;
    }
}

class NoopHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        return true;
    }
}

public class NoopHostnameVerifyingResourceRetriever extends DefaultResourceRetriever {

    public NoopHostnameVerifyingResourceRetriever(int connectTimeout, int readTimeout) {
        super(connectTimeout, readTimeout);
    }

    @Override
    protected HttpURLConnection openConnection(URL url) throws IOException {
        HttpURLConnection connection = super.openConnection(url);

        if (connection instanceof HttpsURLConnection) {
            ((HttpsURLConnection) connection).setHostnameVerifier(new NoopHostnameVerifier());
        }

        return connection;
    }

    public static void main(String[] args) {
        // Example usage
        NoopHostnameVerifyingResourceRetriever retriever = new NoopHostnameVerifyingResourceRetriever(5000, 5000);
        try {
            HttpURLConnection connection = retriever.openConnection(new URL("https://example.com"));
            System.out.println("Connection opened successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}