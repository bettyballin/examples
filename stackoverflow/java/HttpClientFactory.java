import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class HttpClientFactory {

    public static DefaultHttpClient getClient(String username, String password, Integer timeOut) {
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, timeOut);
        HttpConnectionParams.setSoTimeout(httpParams, timeOut);
        DefaultHttpClient retHttpClient = new DefaultHttpClient(httpParams);
        if (username != null && password != null) {
            retHttpClient.getCredentialsProvider().setCredentials(
                    new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
                    new UsernamePasswordCredentials(username, password));
        }

        return retHttpClient;
    }
}