import javax.net.ssl.*;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.spec.PKCS8EncodedKeySpec;

public class SSLClientCert {

    public static void main(String[] args) throws Exception {
        // Load the client certificate
        FileInputStream certInputStream = new FileInputStream("path/to/certificate.crt");
        CertificateFactory cf = CertificateFactory.getInstance("X.509");
        X509Certificate clientCert = (X509Certificate) cf.generateCertificate(certInputStream);
        certInputStream.close();

        // Load the client's private key
        byte[] privateKeyBytes = Files.readAllBytes(Paths.get("path/to/private/key.pkcs8"));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // Create a KeyStore with our private key and certificate
        KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        keyStore.load(null, null);
        keyStore.setCertificateEntry("client-cert", clientCert);
        keyStore.setKeyEntry("client-private-key", privateKey, "password".toCharArray(), new java.security.cert.Certificate[]{clientCert});

        // Use the key and certificate to create an SSLContext
        KeyManagerFactory kmf = KeyManagerFactory.getInstance(KeyManagerFactory.getDefaultAlgorithm());
        kmf.init(keyStore, "password".toCharArray());
        SSLContext sslContext = SSLContext.getInstance("TLS");
        sslContext.init(kmf.getKeyManagers(), null, new SecureRandom());

        // Use the SSLContext to create an SSLSocketFactory
        SSLSocketFactory socketFactory = sslContext.getSocketFactory();
        SSLSocket socket = (SSLSocket) socketFactory.createSocket(new URL("https://example.com").getHost(), 443);

        // Use the socket...
    }
}