import javax.net.ssl.SSLSocketFactory;
import javax.net.SocketFactory;
import java.io.IOException;
import java.net.Socket;

public class Temp390 {
    public static void main(String[] args) {
        String host = "example.com";
        int port = 443;

        try {
            SocketFactory factory = SSLSocketFactory.getDefault();
            Socket s = factory.createSocket(host, port);
            System.out.println("Connected to " + host + " on port " + port);
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}