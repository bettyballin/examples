import java.util.Base64;
import java.security.PublicKey;
import java.security.Signature;

public class SignatureVerifier {

    public boolean verify(String signedBase64, PublicKey publicKey, String originalMessage) {
        try {
            Signature publicSignature = Signature.getInstance("SHA256withRSA");
            publicSignature.initVerify(publicKey);
            publicSignature.update(originalMessage.getBytes(StandardCharsets.UTF_8));

            byte[] signatureBytes = Base64.getDecoder().decode(signedBase64);

            return publicSignature.verify(signatureBytes);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}