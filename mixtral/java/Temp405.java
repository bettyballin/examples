import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp405 {
    public static void main(String[] args) {
        try {
            // Example encrypted bytes, replace with actual encrypted data
            byte[] encryptedBytes = Base64.getDecoder().decode("encryptedDataInBase64");

            // Example private key in Base64, replace with actual private key
            String privateKeyBase64 = "privateKeyInBase64";
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyBase64);

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            Cipher decipher = Cipher.getInstance("RSA");
            decipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] originalBytes = decipher.doFinal(encryptedBytes);
            System.out.println(new String(originalBytes));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}