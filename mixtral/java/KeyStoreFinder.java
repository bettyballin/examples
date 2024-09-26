import javax.net.ssl.*;
import java.io.FileInputStream;
import java.security.KeyStore;

public class KeyStoreFinder {
    public static void main(String[] args) throws Exception {
        String truststore = System.getProperty("javax.net.ssl.trustStore");

        if (truststore != null && !truststore.isEmpty()) {
            // The specified JKS is being used
            System.out.println("Using custom Java Key Store: " + truststore);

            TrustManagerFactory tmf =
                TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());

            FileInputStream fis = new FileInputStream(truststore);

            // Load the JKS
            KeyStore ks = KeyStore.getInstance("JKS");

            char[] passwordArray = System.getProperty("javax.net.ssl.keyStorePassword", "changeit").toCharArray();

            ks.load(fis, passwordArray);

            // Initialize the TrustManagerFactory with this JKS
            tmf.init(ks);

        } else {

          System.out.println("Using default Java Key Store.");

          SSLContext sslcontext = SSLContext.getDefault();

          for (TrustManager tm : sslcontext.getTrustManagers()){
            if(tm instanceof X509TrustManager){
              System.out.println("Default TrustStore: " + ((X509TrustManager) tm).getAcceptedIssuers()[0]);

          }
        }
      }
    }
}