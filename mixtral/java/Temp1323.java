import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Temp1323 {
    public static void main(String[] args) {
        try {
            // Create a socket connection to a test SSL server
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            try (SSLSocket socket = (SSLSocket) factory.createSocket("www.google.com", 443)) {
                // Sleep for 100 milliseconds
                Thread.sleep(100);
                // Start SSL handshake
                socket.startHandshake();
                System.out.println("Handshake completed successfully.");
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}