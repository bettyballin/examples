import com.google.appengine.api.urlfetch.FetchOptions;
import com.google.appengine.api.urlfetch.HTTPMethod;
import com.google.appengine.api.urlfetch.HTTPRequest;
import com.google.appengine.api.urlfetch.HTTPResponse;
import com.google.appengine.api.urlfetch.URLFetchService;
import com.google.appengine.api.urlfetch.URLFetchServiceFactory;

import java.net.URL;
import java.io.IOException;

public class URLFetchExample {
    public static void main(String[] args) {
        try {
            URLFetchService fetchService = URLFetchServiceFactory.getURLFetchService();
            URL url = new URL("http://your-localhost-server-url:8081/path");
            HTTPRequest request = new HTTPRequest(url, HTTPMethod.GET, FetchOptions.Builder.withDefaults());
            HTTPResponse response = fetchService.fetch(request);
            // Process the response as needed
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}