import javax.net.ssl.SSLContext;
import java.security.NoSuchAlgorithmException;

public class Temp587 {
    public static void main(String[] args) {
        try {
            SSLContext context = SSLContext.getInstance("TLSv1.3");
            System.out.println("SSLContext created successfully: " + context.getProtocol());
        } catch (NoSuchAlgorithmException e) {
            System.err.println("Error creating SSLContext: " + e.getMessage());
        }
    }
}