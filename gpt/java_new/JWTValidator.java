import com.nimbusds.jwt.SignedJWT;
import java.security.PublicKey;
import java.security.Signature;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.io.ByteArrayInputStream;
import java.util.Base64;

public class JWTValidator {
    public static void main(String[] args) {
        try {
            // Your JWT token
            String jwtToken = "..."; // replace with your JWT token

            // Your X.509 certificate string
            String certString = "-----BEGIN CERTIFICATE-----
" +
                    "... your certificate here ..." + // replace with your certificate details
                    "
-----END CERTIFICATE-----";

            // Remove the first and last lines
            String publicKeyPEM = certString
                    .replace("-----BEGIN CERTIFICATE-----
", "")
                    .replace("
-----END CERTIFICATE-----", "")
                    .replace("
", "");

            // Base64 decode the data
            byte[] encoded = Base64.getDecoder().decode(publicKeyPEM);

            // Create a PublicKey object from certificate data
            CertificateFactory factory = CertificateFactory.getInstance("X.509");
            X509Certificate certificate = (X509Certificate) factory.generateCertificate(new ByteArrayInputStream(encoded));
            PublicKey publicKey = certificate.getPublicKey();

            // Parse the JWT token
            SignedJWT signedJWT = SignedJWT.parse(jwtToken);

            // Create a Signature object and initialize it with the public key
            Signature signature = Signature.getInstance("SHA256withRSA");
            signature.initVerify(publicKey);

            // Update the Signature object with the plaintext
            signature.update(signedJWT.getSigningInput());

            // Verify the signature
            boolean isValid = signature.verify(signedJWT.getSignature().decode());

            System.out.println("Signature is " + (isValid ? "valid" : "invalid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}