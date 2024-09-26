import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import java.io.IOException;

public class Temp524 {
    public static void main(String[] args) {
        SSLSocket socket = null;
        try {
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            socket = (SSLSocket) factory.createSocket("localhost", 443);
            String[] pickedCipher = {"TLS_DHE_RSA_WITH_AES_128_CBC_SHA256"};
            socket.setEnabledCipherSuites(pickedCipher);
            System.out.println("Cipher suite enabled successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}