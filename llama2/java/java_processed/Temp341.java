import org.bouncycastle.asn1.x509.Certificate;
import org.bouncycastle.cert.jcajce.JcaX509CertificateConverter;
import org.bouncycastle.cert.jcajce.JcaX509CertificateHolder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.FileInputStream;
import java.io.FileReader;
import java.security.PrivateKey;
import java.security.Security;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;

public class Temp341 {
    public static void main(String[] args) {
        try {
            // Add BouncyCastle Provider
            Security.addProvider(new BouncyCastleProvider());

            // Load the certificate
            CertificateFactory cf = CertificateFactory.getInstance("X.509", new BouncyCastleProvider());
            X509Certificate cert = (X509Certificate) cf.generateCertificate(new FileInputStream("path/to/certificate.cer"));

            // Load the private key
            PEMParser pemParser = new PEMParser(new FileReader("path/to/private_key.pem"));
            Object object = pemParser.readObject();
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
            PrivateKey privKey = converter.getPrivateKey((org.bouncycastle.openssl.PEMKeyPair) object);

            // Close the PEM parser
            pemParser.close();

            System.out.println("Certificate: " + cert.toString());
            System.out.println("Private Key: " + privKey.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}