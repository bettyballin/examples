import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class Temp692 {
    public static void main(String[] args) {
        // Example usage of getClient method
        DefaultHttpClient client = getClient("user", "pass", 10000);
        // Add your code here to use the client
    }

    public static DefaultHttpClient getClient(String username, String password, Integer timeOut) {
        HttpParams httpParams = new BasicHttpParams();
        HttpConnectionParams.setConnectionTimeout(httpParams, timeOut);
        HttpConnectionParams.setSoTimeout(httpParams, timeOut);
        DefaultHttpClient retHttpClient = new DefaultHttpClient(httpParams);
        if (username != null) {
            retHttpClient.getCredentialsProvider().setCredentials(
                    new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
                    new UsernamePasswordCredentials(username, password)
            );
        }

        return retHttpClient;
    }
}