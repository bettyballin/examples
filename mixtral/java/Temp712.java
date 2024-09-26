import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

public class Temp712 {
    public static void main(String[] args) {
        try {
            String[] pickedCipher = {"TLS_DHE-RSA-AES256-SHA", "TLS_ECDH-RSA-AES128-GCM-SHA256"};

            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            SSLSocket socket = (SSLSocket) factory.createSocket("localhost", 443);
            socket.setEnabledCipherSuites(pickedCipher);

            System.out.println("Enabled cipher suites set successfully.");
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}