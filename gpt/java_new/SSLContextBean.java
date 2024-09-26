import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;
import java.security.SecureRandom;

public class SSLContextBean {

   public SSLContext sslContext() throws Exception {
       TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
       trustManagerFactory.init((KeyStore) null);

       SSLContext sslContext = SSLContext.getInstance("TLS");
       sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());
       
       return sslContext;
   }
}