import java.io.*;
import java.math.BigInteger;
import java.security.*;
import java.security.cert.*;
import java.util.Date;

import sun.security.x509.*;

public class CreateJks {
    public static void main(String[] args) throws Exception {
        // Generate a random RSA private key
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(2048, new SecureRandom());
        KeyPair pair = kpg.generateKeyPair();

        // Generate a self-signed certificate
        X500Name owner = new X500Name("CN=Test, L=London, C=GB");
        X509CertInfo info = new X509CertInfo();
        Date from = new Date();
        Date to = new Date(from.getTime() + 365 * 86400000L);
        CertificateValidity interval = new CertificateValidity(from, to);
        BigInteger serialNumber = new BigInteger(64, new SecureRandom());
        info.set(X509CertInfo.VALIDITY, interval);
        info.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(serialNumber));
        info.set(X509CertInfo.SUBJECT, new CertificateSubjectName(owner));
        info.set(X509CertInfo.ISSUER, new CertificateIssuerName(owner));
        info.set(X509CertInfo.KEY, new CertificateX509Key(pair.getPublic()));
        info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
        AlgorithmId algo = new AlgorithmId(AlgorithmId.sha256WithRSAEncryption_oid);
        info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algo));
        X509CertImpl cert = new X509CertImpl(info);
        cert.sign(pair.getPrivate(), "SHA256withRSA");

        // Create a JKS file
        File jksFile = File.createTempFile("jks", "test");
        jksFile.deleteOnExit();

        // Create a KeyStore that contains the private key and the certificate
        KeyStore ks = KeyStore.getInstance("JKS");
        ks.load(null, null);
        ks.setKeyEntry("alias", pair.getPrivate(), "password".toCharArray(), new Certificate[]{cert});

        // Save the KeyStore to a file
        try (OutputStream out = new FileOutputStream(jksFile)) {
            ks.store(out, "password".toCharArray());
        }

        System.out.println("JKS file created at: " + jksFile.getAbsolutePath());
    }
}