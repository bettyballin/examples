import java.io.FileOutputStream;
import java.security.KeyPairGenerator;
import java.security.KeyPair;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.security.SecureRandom;
import java.security.cert.X509CertSelector;
import java.security.cert.CertPathBuilder;
import java.security.cert.PKIXBuilderParameters;
import java.security.cert.CertPathBuilderResult;
import java.security.cert.CertStore;
import java.security.cert.CollectionCertStoreParameters;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;
import java.io.ByteArrayInputStream;
import java.security.cert.CertificateEncodingException;
import sun.security.x509.X509CertImpl;
import sun.security.x509.X509CertInfo;
import sun.security.x509.CertificateIssuerName;
import sun.security.x509.CertificateSubjectName;
import sun.security.x509.CertificateValidity;
import sun.security.x509.CertificateSerialNumber;
import sun.security.x509.CertificateAlgorithmId;
import sun.security.x509.AlgorithmId;
import sun.security.x509.CertificateX509Key;
import sun.security.x509.X500Name;
import java.security.PublicKey;
import java.security.PrivateKey;
import sun.security.x509.CertificateVersion;

public class KeyStoreExample1 {

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();
        PublicKey publicKey = keyPair.getPublic();
        PrivateKey privateKey = keyPair.getPrivate();

        X509Certificate certificate = generateSelfSignedCertificate(publicKey, privateKey);

        KeyStore keyStore = KeyStore.getInstance("PKCS12");
        keyStore.load(null, null);
        keyStore.setKeyEntry("alias", privateKey, "password".toCharArray(), new Certificate[]{certificate});

        try (FileOutputStream fos = new FileOutputStream("keystore.p12")) {
            keyStore.store(fos, "password".toCharArray());
        }
    }