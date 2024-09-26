import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public class Temp1278 {

    private static SecretKey getSecretKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256); // for example
        return keyGen.generateKey();
    }

    public static void main(String[] args) {
        try {
            Cipher c = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKey secretKey = getSecretKey();
            c.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] iv = c.getIV();
            // Save the IV along with your encrypted data
            System.out.println("IV: " + java.util.Arrays.toString(iv));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}