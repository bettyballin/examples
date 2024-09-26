import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;
import java.util.Arrays;

public class Temp2359 {
    public static void main(String[] args) {
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket("example.com", 443);
            socket.startHandshake();
            String[] protocols = socket.getEnabledProtocols();
            System.out.println(Arrays.toString(protocols));
            // This will print the enabled TLS versions e.g [TLSv1.2, TLSv1.3]
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}