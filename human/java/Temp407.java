import javax.net.SocketFactory;
import java.io.IOException;
import java.net.Socket;

public class Temp407 {
    public static void main(String[] args) {
        final String host = "localhost"; // Replace with your host
        final int port = 8080; // Replace with your port
        
        try {
            final SocketFactory factory = SocketFactory.getDefault();
            final Socket socket = factory.createSocket(host, port);
            System.out.println("Connected to " + host + " on port " + port);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}