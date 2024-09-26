import java.util.regex.Pattern;

public class UrlValidator {
    private static final String REGEX = "^(https?:\\/\\/?)[^\\s()<>]+(?:\\([\\w\\d]+\\)|([^[:punct:]\\s]|\\?))*$";
    private static Pattern pattern = Pattern.compile(REGEX);

    public boolean isValid(String url) {
        return pattern.matcher(url).matches();
    }

    public static void main(String[] args) {
        UrlValidator validator = new UrlValidator();
        
        // Test cases
        String[] testUrls = {
            "http://example.com",
            "https://example.com",
            "http://example.com/path",
            "https://example.com/path?query=string",
            "ftp://example.com",  // Invalid URL scheme
            "http://example .com" // Invalid space in URL
        };

        for (String url : testUrls) {
            System.out.println("URL: " + url + " is valid: " + validator.isValid(url));
        }
    }
}