import java.net.URI;
import java.net.URISyntaxException;

public class Temp2530 {
    public static void main(String[] args) {
        try {
            // Example URL
            String url = "http://www.example.com/test/path?query=123";
            
            // Create a URI object from the URL
            URI uri = new URI(url);
            
            // getPathInfo
            String pathInfo = uri.getPath();
            
            // getRequestURL
            String requestURL = uri.toString();
            
            // getRequestURI
            String requestURI = uri.getRawPath();
            
            System.out.println("Path Info: " + pathInfo);
            System.out.println("Request URL: " + requestURL);
            System.out.println("Request URI: " + requestURI);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}