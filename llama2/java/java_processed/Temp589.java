import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.net.InetSocketAddress;

public class Temp589 {
    public static void main(String[] args) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket sslSocket = (SSLSocket) factory.createSocket();
            InetSocketAddress serverAddress = new InetSocketAddress("www.example.com", 443);
            sslSocket.connect(serverAddress);
            System.out.println("Connected to server!");
            sslSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}