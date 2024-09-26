import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;

public class TrustAllHostNameVerifier implements HostnameVerifier {
    @Override
    public boolean verify(String hostname, SSLSession session) {
        return true; // Always returns TRUE - bypassing host name check.
    }

    public static void main(String[] args) {
        TrustAllHostNameVerifier verifier = new TrustAllHostNameVerifier();
        // Example usage
        System.out.println(verifier.verify("example.com", null)); // Should print true
    }
}