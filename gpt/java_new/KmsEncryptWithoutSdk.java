import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class KmsEncryptWithoutSdk {

    public static void main(String[] args) {
        try {
            String kmsPublicKeyBase64 = "YOUR_KMS_PUBLIC_KEY_BASE64";
            byte[] publicBytes = Base64.getDecoder().decode(kmsPublicKeyBase64);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);

            String plaintext = "Your plain text here";
            byte[] plaintextBytes = plaintext.getBytes();
            byte[] cipherTextBytes = cipher.doFinal(plaintextBytes);
            String cipherTextBase64 = Base64.getEncoder().encodeToString(cipherTextBytes);

            System.out.println("Encrypted text: " + cipherTextBase64);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}