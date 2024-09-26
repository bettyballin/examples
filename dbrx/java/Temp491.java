import javax.crypto.Cipher;
import java.security.PrivateKey;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;

public class Temp491 {
    public static void main(String[] args) {
        try {
            // Example private key in Base64 format
            String privateKeyPem = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCyF...";
            privateKeyPem = privateKeyPem.replaceAll("\\n", "").replaceAll("\\r", "");
            byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyPem);

            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

            // Example encrypted data in Base64 format
            String encryptedDataBase64 = "f9K3+...";
            encryptedDataBase64 = encryptedDataBase64.replaceAll("\\n", "").replaceAll("\\r", "");
            byte[] encryptedData = Base64.getDecoder().decode(encryptedDataBase64);

            Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWithSHA-256AndMGF1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] decryptedBytes = cipher.doFinal(encryptedData);

            String decryptedText = new String(decryptedBytes, "UTF-8");
            System.out.println("Decrypted text: " + decryptedText);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}