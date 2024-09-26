import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

public class RefactoredSnippet4 {
    public static void main(String[] args) throws Exception {
        byte[] publicKeyBytes = {/* public key bytes here */};
        X509EncodedKeySpec publicKeySpec1 = new X509EncodedKeySpec(publicKeyBytes);

        KeyFactory kf1 = KeyFactory.getInstance("RSA");
        PublicKey pkPublic1 = kf1.generatePublic(publicKeySpec1);

        Cipher pkCipher1 = Cipher.getInstance("RSA/ECB/PKCS1PADDING");
        pkCipher1.init(Cipher.DECRYPT_MODE, pkPublic1);
    }
}