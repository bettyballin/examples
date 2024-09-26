import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class Temp59 {
    public static void main(String[] args) {
        // Define host and port for example purposes
        String host = "example.com";
        int port = 443;

        try {
            SSLSocket sslSocket = (SSLSocket) SSLSocketFactory.getDefault().createSocket(host, port);
            // Connect to the remote host
            sslSocket.startHandshake();
            System.out.println("Connected to " + host + " on port " + port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}