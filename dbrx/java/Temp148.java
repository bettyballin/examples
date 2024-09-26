import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.pkcs.PKCS10CertificationRequest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import java.security.Security;

public class Temp148 {
    public static void main(String[] args) {
        Security.addProvider(new BouncyCastleProvider());

        // Replace with your CSR data
        byte[] csrData = ...; // byte array of your CSR data

        try {
            PKCS10CertificationRequest csr = new PKCS10CertificationRequest(csrData);
            SubjectPublicKeyInfo spki = csr.getSubjectPublicKeyInfo();
            AlgorithmIdentifier algId = spki.getAlgorithm();
            ASN1ObjectIdentifier algorithmOid = algId.getAlgorithm();
            String algoName = algorithmOid.getId(); // get the OID for the algorithm

            System.out.println("Algorithm OID: " + algoName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}