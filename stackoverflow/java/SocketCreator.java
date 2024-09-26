import javax.net.SocketFactory;
import java.io.IOException;
import java.net.Socket;

public class SocketCreator {
    public static void main(String[] args) {
        final String host = "localhost"; // Replace with actual host
        final int port = 80; // Replace with actual port
        try {
            final SocketFactory factory = SocketFactory.getDefault();
            final Socket socket = factory.createSocket(host, port);
            // Use the socket for communication
            socket.close(); // Remember to close the socket
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}