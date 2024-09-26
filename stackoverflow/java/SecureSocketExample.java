import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.net.Socket;
import java.io.IOException;

public class SecureSocketExample {
    public static void main(String[] args) {
        String host = "example.com"; // replace with the actual host
        int port = 443; // replace with the actual port

        try {
            SocketFactory factory = SSLSocketFactory.getDefault();
            Socket socket = factory.createSocket(host, port);
            // Use the socket for communication
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}