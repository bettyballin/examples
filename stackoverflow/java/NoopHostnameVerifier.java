import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;

public class NoopHostnameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, javax.net.ssl.SSLSession session) {
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
}