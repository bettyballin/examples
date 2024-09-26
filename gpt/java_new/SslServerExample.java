import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import javax.net.ssl.SSLSocket;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.io.Serializable;

public class SslServerExample {
    private static final int YOUR_PORT = 12345; // Replace with your port number

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SSLServerSocketFactory sslServerSocketFactory =
                (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
        SSLServerSocket sslServerSocket =
                (SSLServerSocket) sslServerSocketFactory.createServerSocket(YOUR_PORT);

        // Wait for connections
        try (SSLSocket sslSocket = (SSLSocket) sslServerSocket.accept();
             ObjectInputStream objStream = new ObjectInputStream(sslSocket.getInputStream());
             ObjectOutputStream oos = new ObjectOutputStream(sslSocket.getOutputStream())) {

            // The communication here is encrypted by SSL/TLS
            ProxyResponse message = (ProxyResponse) objStream.readObject();

            // Update message
            // ...

            // Send it back to client
            oos.writeObject(message);
        }
    }

    static class ProxyResponse implements Serializable {
        // Implementation of your ProxyResponse
        // ...
    }
}