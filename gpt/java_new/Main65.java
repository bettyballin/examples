import kong.unirest.Unirest;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.BasicCookieStore;

public class Main65 {
    public static void main(String[] args) {
        CookieStore cookieStore = new BasicCookieStore();
        CloseableHttpClient httpClient = HttpClients.custom()
                .setDefaultCookieStore(cookieStore)
                .build();
        Unirest.config().httpClient(httpClient);
        
        String jSessionID = "JSESSIONID=123456789; Path=/; HttpOnly"; // Example JSESSIONID from a cookie
        jSessionID = jSessionID.split(";\\s*")[0]; // This regex splits on semicolon followed by any amount of white space.
        Unirest.config().setDefaultHeader("Cookie", jSessionID);
    }
}