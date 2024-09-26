import java.util.HashMap;
import java.util.Map;

public class HttpHeadersRefactor {
    public static void main(String[] args) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Cache-Control", "no-cache, no-store, max-age=0, must-revalidate");
        headers.put("Pragma", "no-cache");
        headers.put("Expires", "0");
        headers.put("X-Content-Type-Options", "nosniff");
        headers.put("Strict-Transport-Security", "max-age=31536000 ; includeSubDomains");
        headers.put("X-Frame-Options", "DENY");
        headers.put("X-XSS-Protection", "1; mode=block");

        // Example of using the headers map
        for (Map.Entry<String, String> header : headers.entrySet()) {
            System.out.println(header.getKey() + ": " + header.getValue());
        }
    }
}