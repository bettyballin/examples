import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import org.apache.commons.codec.binary.Base64;
import java.util.Arrays;

public class AES {

    private SecretKey secretKey;

    public void setKey(String myKey) throws NoSuchAlgorithmException, InvalidKeySpecException {
        byte[] salt = new byte[16]; // 16 bytes salt
        SecureRandom random = new SecureRandom();
        random.nextBytes(salt);

        KeySpec keySpec = new PBEKeySpec(myKey.toCharArray(), salt, 65536, 128);

        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");

        byte[] keyBytes = secretKeyFactory.generateSecret(keySpec).getEncoded();
        this.secretKey = new SecretKeySpec(keyBytes, "AES");
    }

    public String encrypt(String strToEncrypt) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
    }

    public String decrypt(String strToDecrypt) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return new String(cipher.doFinal(Base64.decodeBase64(strToDecrypt)));
    }

    public static void main(String[] args) {
        try {
            AES aes = new AES();
            aes.setKey("password");
            
            String originalString = "Hello World";
            String encryptedString = aes.encrypt(originalString);
            String decryptedString = aes.decrypt(encryptedString);

            System.out.println("Original String: " + originalString);
            System.out.println("Encrypted String: " + encryptedString);
            System.out.println("Decrypted String: " + decryptedString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}