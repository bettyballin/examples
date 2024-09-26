import java.security.Signature;
import java.security.SignatureException;
import java.security.PublicKey;

public class SignatureValidator {
    public boolean validateSignature(byte[] dataThatWasSigned, byte[] signatureYouReceived, PublicKey publicKey) {
        try {
            Signature sig = Signature.getInstance("SHA256withRSA"); // Adjust as necessary
            sig.initVerify(publicKey);
            sig.update(dataThatWasSigned);
            return sig.verify(signatureYouReceived);
        } catch (Exception e) {
            // Graceful handling belongs here...
            return false;
        }
    }
}