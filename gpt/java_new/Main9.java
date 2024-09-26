import org.bouncycastle.jce.provider.BouncyCastleProvider;
import java.security.Security;
import java.security.Signature;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.security.KeyFactory;

public class Main9 {
    public static void main(String[] args) {
        try {
            Security.addProvider(new BouncyCastleProvider());
            byte[] publicKeyBytes = // ... your public key bytes
            byte[] signatureToVerify = // ... your signature bytes
            byte[] data = // ... your data bytes

            X509EncodedKeySpec publicKeySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA", "BC");
            PublicKey publicKey = keyFactory.generatePublic(publicKeySpec);

            Signature signature = Signature.getInstance("SHA256withRSA", "BC");
            signature.initVerify(publicKey);
            signature.update(data);

            boolean isSignatureValid = signature.verify(signatureToVerify);
            System.out.println("Signature valid: " + isSignatureValid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}