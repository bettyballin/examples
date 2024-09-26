import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.X509Certificate;
import java.util.Collections;

import org.bouncycastle.cert.X509CertificateHolder;
import org.bouncycastle.cert.jcajce.JcaCertStore;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.openssl.jcajce.JcaPEMParser;
import org.bouncycastle.util.Store;
import org.bouncycastle.util.StoreException;

public class Temp119 {
    public static void main(String[] args) {
        try {
            // Add BouncyCastle as a security provider
            Security.addProvider(new BouncyCastleProvider());

            // Load the certificate
            File certFile = new File("cert.pem");
            JcaPEMParser certParser = new JcaPEMParser(Files.newBufferedReader(certFile.toPath()));
            X509CertificateHolder certHolder = (X509CertificateHolder) certParser.readObject();
            certParser.close();
            X509Certificate cert = new JcaX509CertificateConverter().setProvider("BC").getCertificate(certHolder);

            // Load the private key
            File keyFile = new File("private-key.pem");
            JcaPEMParser keyParser = new JcaPEMParser(Files.newBufferedReader(keyFile.toPath()));
            Object keyObject = keyParser.readObject();
            keyParser.close();
            PrivateKey key = new JcaPEMKeyConverter().setProvider("BC").getPrivateKey((PEMKeyPair) keyObject);

            // Create a certificate store
            Store<X509CertificateHolder> certs = new JcaCertStore(Collections.singletonList(certHolder));

            // Dummy usage of cert and key to avoid unused variable warnings
            System.out.println("Certificate: " + cert);
            System.out.println("Private Key: " + key);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}