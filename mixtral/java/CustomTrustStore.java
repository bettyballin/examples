import java.io.InputStream;
import javax.net.ssl.SSLContext;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.ssl.SSLContextBuilder;

public final class CustomTrustStore {

    private static SSLContext sslcontext = null;

    public synchronized static void init(final String truststorePath, final char[] password) throws Exception {
        if (sslcontext == null && !StringUtils.isEmpty(truststorePath)) {

            InputStream isTrustedCertificates = CustomTrustStore
                    .class
                    .getResourceAsStream("/" + truststorePath);

            sslcontext = SSLContextBuilder
                .create()
                .loadTrustMaterial(isTrustedCertificates, password)
                .build();
        }

    }

    public static void main(String[] args) {
        try {
            init("path/to/truststore.jks", "password".toCharArray());
            System.out.println("SSLContext initialized successfully!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}