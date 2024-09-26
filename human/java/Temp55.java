import java.io.FileInputStream;
import java.io.InputStream;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.security.KeyStore;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.bouncycastle.openssl.PEMParser;
import java.io.FileReader;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.PrivateKey;
import java.security.Security;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class Temp55 {
    public static void main(String[] args) throws Exception {
        Security.addProvider(new BouncyCastleProvider());

        Hashtable<String, String> env = new Hashtable<String, String>();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        env.put(Context.PROVIDER_URL, "t3s://localhost:7002");
        
        // Uncomment and set these if you need user authentication
        // env.put(Context.SECURITY_PRINCIPAL, "user");
        // env.put(Context.SECURITY_CREDENTIALS, "pass");

        // Load the client certificate and key
        String CERT_KEYFILE = "path/to/your/keyfile.pem";
        String CERT_CERTFILE = "path/to/your/certfile.pem";
        String CERT_KEYPASSWORD = "yourKeyPassword";

        PEMParser keyParser = new PEMParser(new FileReader(CERT_KEYFILE));
        PEMParser certParser = new PEMParser(new FileReader(CERT_CERTFILE));

        // Read the private key
        Object keyObject = keyParser.readObject();
        PrivateKey privateKey = (PrivateKey) keyObject;

        // Read the certificate
        CertificateFactory certFactory = CertificateFactory.getInstance("X.509");
        X509Certificate certificate = (X509Certificate) certFactory.generateCertificate(new FileInputStream(CERT_CERTFILE));

        // Create key store and trust store
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setKeyEntry("privateKey", privateKey, CERT_KEYPASSWORD.toCharArray(), new java.security.cert.Certificate[]{certificate});

        KeyStore trustStore = KeyStore.getInstance(KeyStore.getDefaultType());
        trustStore.load(null, null);
        trustStore.setCertificateEntry("certificate", certificate);

        // Create key manager and trust manager
        KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        keyManagerFactory.init(keyStore, CERT_KEYPASSWORD.toCharArray());

        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
        trustManagerFactory.init(trustStore);

        // Create SSL context
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);

        env.put("java.naming.ldap.factory.socket", "com.sun.jndi.ldap.ext.StartTlsResponse");

        InitialContext context = new InitialContext(env);

        // Use the context here

        keyParser.close();
        certParser.close();
    }
}