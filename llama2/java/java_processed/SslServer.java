import java.io.IOException;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class SslServer {
    public static void main(String[] args) throws IOException, SSLException {
        SSLSocket socket = (SSLSocket) SSLSocketFactory.getDefault().createSocket("localhost", 443);

        // Perform the SSL handshake
        socket.startHandshake();

        // Get the session after the connection is established
        System.out.println("SSL Handshake completed successfully");
    }
}