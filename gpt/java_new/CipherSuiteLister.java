import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class CipherSuiteLister {
    public static void main(String[] args) {
        SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
        try {
            SSLSocket socket = (SSLSocket) factory.createSocket();
            String[] availableCiphers = socket.getSupportedCipherSuites();
            System.out.println("Supported Cipher Suites:");
            for (String cipher : availableCiphers) {
                System.out.println(cipher);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}