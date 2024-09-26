import java.util.Arrays;
import java.security.PublicKey;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.ByteArrayInputStream;
import java.util.Base64;

public class Main {
    public static void main(String[] args) throws Exception {

        String ldapKey = "3082010a0282010100da7ce03ec4628d..."; // your LDAP key here
        String certificateString = "MIIDXTCCAkWgAwIBAg..."; // your certificate string here

        byte[] decodedLdapKeyBytes = Base64.getDecoder().decode(ldapKey);

        byte[] decodedCertBytes = Base64.getDecoder().decode(certificateString);
        CertificateFactory certFactory = CertificateFactory.getInstance("X509");
        X509Certificate certificate = (X509Certificate) certFactory.generateCertificate(new ByteArrayInputStream(decodedCertBytes));

        PublicKey pub = certificate.getPublicKey();
        byte[] encodedPubKeyBytes = pub.getEncoded();

        if (Arrays.equals(decodedLdapKeyBytes, encodedPubKeyBytes)) {
            System.out.println("Keys are equal");
        } else {
            System.out.println("Keys do not match");
        }
    }
}