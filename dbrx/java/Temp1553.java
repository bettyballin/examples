import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class Temp1553 {
    public static void main(String[] args) {
        try {
            String plainText = "Hello, World!";
            String publicKeyString = "YOUR_PUBLIC_KEY_BASE64"; // Replace with your actual public key in Base64 format

            byte[] publicBytes = Base64.getDecoder().decode(publicKeyString);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey pubKey = keyFactory.generatePublic(keySpec);

            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] encryptedData = cipher.doFinal(plainText.getBytes());

            System.out.println(Base64.getEncoder().encodeToString(encryptedData));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}