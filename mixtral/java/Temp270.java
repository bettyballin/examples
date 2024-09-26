import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.signers.RSADigestSigner;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.util.PublicKeyFactory;

public class Temp270 {
    public static void main(String[] args) {
        try {
            // Example usage
            byte[] signature = new byte[]{ /* your signature bytes */ };
            byte[] message = "your message".getBytes();
            byte[] keyBytes = new byte[]{ /* your public key bytes */ };
            AsymmetricKeyParameter publicKey = PublicKeyFactory.createKey(keyBytes);
            
            new Temp270().verifySignature(signature, message, publicKey);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void verifySignature(byte[] signature, byte[] message, AsymmetricKeyParameter publicKey) throws Exception {
        RSADigestSigner signer = new RSADigestSigner(new SHA256Digest());
        signer.init(false, publicKey);
        signer.update(message, 0, message.length);
        boolean isValid = signer.verifySignature(signature);
        System.out.println("Signature valid: " + isValid);
    }
}