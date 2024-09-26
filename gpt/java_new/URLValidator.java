import java.net.URI;

public class URLValidator {

    public static boolean isValidURL(String url) {
        try {
            URI uri = new URI(url);
            String scheme = uri.getScheme();
            return scheme != null && (scheme.equals("http") || scheme.equals("https"));
        } catch (Exception e) {
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Example usage
        System.out.println(isValidURL("http://www.example.com")); // true
        System.out.println(isValidURL("https://www.example.com")); // true
        System.out.println(isValidURL("ftp://www.example.com")); // false
    }
}