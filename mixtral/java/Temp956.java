import java.io.InputStream;
import java.security.KeyStore;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;

public class Temp956 {
    public static void main(String[] args) {
        try {
            KeyStore truststore = KeyStore.getInstance("BKS");
            InputStream in = Temp956.class.getResourceAsStream("/truststore.bks"); // Adjust the path accordingly
            try {
                truststore.load(in, "password".toCharArray());
            } finally {
                if (in != null) {
                    in.close();
                }
            }

            TrustManagerFactory tmf = TrustManagerFactory.getInstance("X509");
            tmf.init(truststore);

            SSLContext sslcontext = SSLContext.getInstance("TLSv1.2");
            sslcontext.init(null, tmf.getTrustManagers(), null);

            HttpsURLConnection.setDefaultSSLSocketFactory(sslcontext.getSocketFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}