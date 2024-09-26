import com.sun.jndi.ldap.LdapCtxFactory;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.X509Certificate;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

public class CustomLdapContextFactory extends LdapCtxFactory {
    private SSLContext sslContext;

    public CustomLdapContextFactory() {
        super();

        // Create a custom trust manager that accepts all certificates
        TrustManager[] trustManagers = new TrustManager[]{
            new X509TrustManager() {
                @Override
                public void checkClientTrusted(X509Certificate[] x509Certificates, String s) {
                    // Ignore
                }

                @Override
                public void checkServerTrusted(X509Certificate[] x509Certificates, String s) {
                    // Ignore
                }

                @Override
                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }
        };

        try {
            // Create an SSL context using the custom trust manager
            sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, trustManagers, new java.security.SecureRandom());
        } catch (NoSuchAlgorithmException | KeyManagementException e) {
            e.printStackTrace();
        }
    }

    public SSLContext getSslContext() {
        return sslContext;
    }

    public static void main(String[] args) {
        CustomLdapContextFactory factory = new CustomLdapContextFactory();
        System.out.println("Custom SSLContext created: " + factory.getSslContext());
    }
}