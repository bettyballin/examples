import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;

import java.security.Security;
import java.security.interfaces.DSAPublicKey;
import java.security.interfaces.RSAPublicKey;

public class Temp150 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        // PKCS10CertificationRequest csr = ...; // Initialize your CSR here
        PKCS10CertificationRequest csr = null; // Placeholder

        if (csr == null) {
            System.out.println("CSR is null, exiting...");
            return;
        }

        SubjectPublicKeyInfo spki = csr.getSubjectPublicKeyInfo();
        AlgorithmIdentifier algId = spki.getAlgorithm();
        String algoName = algId.getAlgorithm().getId();

        try {
            if (algoName.equals("1.2.840.113549.1.1.1")) { // RSA encryption
                RSAPublicKey rsaPub = (RSAPublicKey) new JcaPEMKeyConverter().setProvider("BC").getPublicKey(spki);
                System.out.println("RSA Public Key: " + rsaPub);
            } else if (algoName.equals("1.3.14.3.2.26")) { // DSA signature
                DSAPublicKey dsaPub = (DSAPublicKey) new JcaPEMKeyConverter().setProvider("BC").getPublicKey(spki);
                System.out.println("DSA Public Key: " + dsaPub);
            } else {
                System.out.println("Unsupported algorithm: " + algoName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}