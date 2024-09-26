import javax.net.ssl.*;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp968 {
    public static void main(String[] args) {
        try {
            SSLContext sc = SSLContext.getInstance("TLS");

            // Initialize the SSLContext
            KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
            kmf.init(null, null);
            sc.init(kmf.getKeyManagers(), null, new SecureRandom());

            String[] supportedProtocols = {"TLSv1", "TLSv1.1", "TLSv1.2"};
            SSLServerSocketFactory ssf = sc.getServerSocketFactory();

            // Create a custom SSLParameters object
            SSLParameters params = new SSLParameters();
            params.setProtocols(supportedProtocols);

            String[] enabledCipherSuites = {"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256"};
            params.setCipherSuites(enabledCipherSuites);

            // Create the server socket
            SSLServerSocket serverSocket = (SSLServerSocket) ssf.createServerSocket(12345); // Specify port number
            serverSocket.setEnabledProtocols(supportedProtocols);

            // Set custom SSLParameters
            serverSocket.setSSLParameters(params);

            System.out.println("Socket initialized");
            
            // Accept connections
            while (true) {
                SSLSocket clientSocket = (SSLSocket) serverSocket.accept();
                System.out.println("Client connected");
                // Handle client connection in a separate thread or method
            }

        } catch (NoSuchAlgorithmException | KeyManagementException | Exception e) {
            e.printStackTrace();
        }
    }
}