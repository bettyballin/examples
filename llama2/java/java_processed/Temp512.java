import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Temp512 {
    public static void main(String[] args) {
        String redirectTo = "http://example.com"; // Example URL
        if (redirectTo != null && !redirectTo.isEmpty()) {
            try {
                URL redirectUrl = new URL(redirectTo);
                String protocol = redirectUrl.getProtocol();
                if ("http".equals(protocol) || "https".equals(protocol)) {
                    System.out.println("Redirecting to: " + redirectUrl.toString());
                    // Simulate redirect by opening the URL in the system's default browser
                    Desktop.getDesktop().browse(redirectUrl.toURI());
                } else {
                    // Handle invalid redirects
                    System.err.println("Invalid redirect protocol: " + protocol);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}