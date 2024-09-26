import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class CipherSuiteChecker {
    public static void main(String[] args) {
        String hostname = "example.com";
        int port = 443; // Default port for HTTPS

        try {
            // Create an SSLContext that supports all cipher suites
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, null);
            SSLSocketFactory factory = context.getSocketFactory();

            // Create a socket and connect to the server
            try (SSLSocket socket = (SSLSocket) factory.createSocket(hostname, port)) {
                // Get all supported cipher suites
                String[] allCipherSuites = socket.getSupportedCipherSuites();
                socket.setEnabledCipherSuites(allCipherSuites);

                // Start handshake to ensure the connection is established
                socket.startHandshake();

                // Retrieve the enabled cipher suites after the handshake
                String[] enabledCipherSuites = socket.getSession().getCipherSuite();

                // Output the enabled cipher suites
                System.out.println("Enabled Cipher Suites after handshake:");
                for (String cipherSuite : enabledCipherSuites) {
                    System.out.println(cipherSuite);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}