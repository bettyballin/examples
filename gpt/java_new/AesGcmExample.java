import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.crypto.spec.GCMParameterSpec;

public class AesGcmExample {
    public static void main(String[] args) {
        try {
            SecureRandom random = new SecureRandom();

            // Assuming you want a 96-bit IV, 128-bit key
            byte[] initVector = new byte[12]; // 96 bits for IV
            byte[] key = new byte[16]; // 128 bits for AES key
            random.nextBytes(initVector);
            random.nextBytes(key);

            // Dummy data to encrypt
            byte[] data = "Dummy data to encrypt".getBytes();

            // Initialize cipher
            Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
            SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
            GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(128, initVector); // 128 bit auth tag length

            // Encryption
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, gcmParameterSpec);
            byte[] encryptedData = cipher.doFinal(data);

            // Decryption
            cipher.init(Cipher.DECRYPT_MODE, keySpec, gcmParameterSpec);
            byte[] decryptedData = cipher.doFinal(encryptedData);

            // Just to show it works
            System.out.println(new String(decryptedData)); // Should print "Dummy data to encrypt"
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}