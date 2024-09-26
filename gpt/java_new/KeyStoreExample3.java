import java.math.BigInteger;
import java.security.*;
import java.security.cert.X509Certificate;
import java.util.Date;
import javax.security.auth.x500.X500Principal;
import sun.security.x509.*;

public class KeyStoreExample3 {

    public static void main(String[] args) throws Exception {
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("RSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();

        long validity = 365 * 24 * 60 * 60 * 1000; // 1 year
        Date from = new Date();
        Date to = new Date(from.getTime() + validity);
        BigInteger sn = new BigInteger(64, new SecureRandom());
        X500Name owner = new X500Name("CN=Test Certificate");

        X509CertInfo info = new X509CertInfo();
        info.set(X509CertInfo.VALIDITY, new CertificateValidity(from, to));
        info.set(X509CertInfo.SERIAL_NUMBER, new CertificateSerialNumber(sn));
        info.set(X509CertInfo.SUBJECT, owner);
        info.set(X509CertInfo.ISSUER, owner);
        info.set(X509CertInfo.KEY, new CertificateX509Key(keyPair.getPublic()));
        info.set(X509CertInfo.VERSION, new CertificateVersion(CertificateVersion.V3));
        AlgorithmId algo = new AlgorithmId(AlgorithmId.sha256WithRSAEncryption_oid);
        info.set(X509CertInfo.ALGORITHM_ID, new CertificateAlgorithmId(algo));

        // Sign the cert to identify the algorithm that's used.
        X509CertImpl cert = new X509CertImpl(info);
        cert.sign(keyPair.getPrivate(), "SHA256withRSA");

        // Update the algorithm and sign again
        algo = (AlgorithmId)cert.get(X509CertImpl.SIG_ALG);
        info.set(CertificateAlgorithmId.NAME + "." + CertificateAlgorithmId.ALGORITHM, algo);
        cert = new X509CertImpl(info);
        cert.sign(keyPair.getPrivate(), "SHA256withRSA");
        X509Certificate certificate = cert;

        // The rest of the code to use the certificate/keypair goes here
    }
}