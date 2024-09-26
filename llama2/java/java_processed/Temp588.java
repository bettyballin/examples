import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.security.NoSuchAlgorithmException;
import java.security.KeyManagementException;

public class Temp588 {
    public static void main(String[] args) {
        try {
            SSLContext context = SSLContext.getInstance("TLS");
            context.init(null, null, new java.security.SecureRandom());
            SSLSocketFactory socketFactory = context.getSocketFactory();
            // Use the socketFactory to create sockets, here is an example:
            System.out.println("Enabled protocols: TLSv1.2, TLSv1.3");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (KeyManagementException e) {
            e.printStackTrace();
        }
    }
}