import javax.crypto.Cipher;
import java.util.Base64;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class Temp1351 {
    public static void main(String[] args) {
        try {
            String encodedData = "ENCRYPTED_STRING_HERE";
            String privateKeyPEM = "PRIVATE_KEY_STRING_HERE";

            // Remove the first and last lines
            privateKeyPEM = privateKeyPEM.replace("-----BEGIN PRIVATE KEY-----", "")
                                        .replace("-----END PRIVATE KEY-----", "")
                                        .replaceAll("\\s", "");

            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPEM);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            byte[] encryptedBytes = Base64.getDecoder().decode(encodedData.getBytes());
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedData = cipher.doFinal(encryptedBytes);

            System.out.println(new String(decryptedData));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}