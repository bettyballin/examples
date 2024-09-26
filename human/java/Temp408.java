import javax.net.SocketFactory;
import javax.net.ssl.SSLSocketFactory;
import java.net.Socket;
import java.io.IOException;

public class Temp408 {
    public static void main(String[] args) {
        String host = "your_host_here";
        int port = your_port_here;

        try {
            final SocketFactory factory = SSLSocketFactory.getDefault();
            final Socket socket = factory.createSocket(host, port);
            System.out.println("Connected to " + host + " on port " + port);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}