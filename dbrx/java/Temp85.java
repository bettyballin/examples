Here is the corrected Java code:


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.cookie.BasicClientCookie;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CookieValidator {

    private String serverUrl = "http://yourserver.com/";
    private String cookieDomain = "yourdomain.com";
    private String cookiePath = "/";

    public boolean isCookieValid(String token) {
        boolean valid = false;
        try {
            String requestUrl = serverUrl + "gettoken";
            System.out.println("requestUrl is : " + requestUrl);

            HttpClient httpClient = HttpClientBuilder.create().build();
            HttpContext localContext = new BasicHttpContext();

            // Create a cookie store and add your cookies to it
            CookieStore cookieStore = new BasicCookieStore();
            BasicClientCookie basicClientCookie = new BasicClientCookie("cookieName", token);
            basicClientCookie.setDomain(cookieDomain);
            basicClientCookie.setPath(cookiePath);
            cookieStore.addCookie(basicClientCookie);

            // Set the context to use your custom cookie store
            localContext.setAttribute("http.cookie-store", cookieStore);

            HttpGet getRequest = new HttpGet(requestUrl.trim());
            getRequest.addHeader("accept", "text/html");

            HttpResponse response = httpClient.execute(getRequest, localContext);

            System.out.println("call success : " + response.getStatusLine().getStatusCode());
            if (response.getStatusLine().getStatusCode() != 200) {
                return false;
            }

            HttpEntity entity = response.getEntity();
            if (entity != null) {
                String cookieToken = EntityUtils.toString(entity);
                System.out.println("Cookie Token : " + cookieToken);
                if (token.equalsIgnoreCase(cookieToken)) {
                    valid = true;
                }
            }
            httpClient.close();
        } catch (IOException e) {
            System.out.println("IOException in reading cookies: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Exception in reading cookies: " + e.getMessage());
        }

        return valid;
    }

    public static void main(String[] args) {
        CookieValidator validator = new CookieValidator();
        boolean result = validator.isCookieValid("yourTokenHere");
        System.out.println("Is cookie valid? " + result);
    }
}

Note: `org.apache.httpcomponents:httpclient` should be in your project dependencies. If not, add it to your `pom.xml` file if you're using Maven or to your `build.gradle` file if you're using Gradle.