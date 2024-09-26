import java.net.URL;

public class UrlValidator {
    public static void main(String[] args) throws Exception {
        String remoteUrl = getUserProvidedUrl();
        URL url = new URL(remoteUrl);
        validateUrl(url);
    }

    private static void validateUrl(URL url) {
        String protocol = url.getProtocol();
        if (!protocol.equals("http") && !protocol.equals("https")) {
            throw new IllegalArgumentException("Unsupported protocol: " + protocol);
        }
        if (protocol.equals("file")) {
            throw new IllegalArgumentException("Access to local files is forbidden");
        }
        if (url.getHost().equalsIgnoreCase("localhost") || url.getHost().equals("127.0.0.1")) {
            throw new IllegalArgumentException("Access to local addresses is forbidden");
        }
        // Assume this method exists and returns the user provided URL string
        // The implementation of this method is not shown as it's not the focus of the task
    }

    private static String getUserProvidedUrl() {
        // Placeholder for actual user input retrieval logic
        return "http://example.com";
    }
}