import com.gargoylesoftware.htmlunit.WebClient;

public class WebClientExample {
    public static void main(String[] args) {
        try (final WebClient webClient = new WebClient()) {
            webClient.getOptions().setUseInsecureSSL(true); // bypass SSL verification (not secure)
            webClient.getOptions().setJavaScriptEnabled(true);
            webClient.getOptions().setTimeout(10000); // Set timeout to 10 seconds
            // Add further code to use the configured WebClient instance
        }
    }
}