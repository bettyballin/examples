import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;
import java.util.Arrays;

public class Temp841 {
    public static void main(String[] args) throws Exception {
        SecureRandom random = new SecureRandom();
        byte[] initVector = new byte[12];
        random.nextBytes(initVector);
        byte[] data = new byte[32];
        random.nextBytes(data);
        byte[] key = new byte[32];
        random.nextBytes(key);

        // Split Part A and B from the original data
        int partALength = 16; // Changed to 16 from 128 / Byte.SIZE
        int partBLength = (data.length - partALength);
        byte[] dataPartA = Arrays.copyOfRange(data, 0, partALength);
        byte[] dataPartB = Arrays.copyOfRange(data, partALength, data.length);

        // Initialize the cipher
        final Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(key, "AES"), new GCMParameterSpec(128, initVector)); // Changed to 128 from 16 * Byte.SIZE

        // Authenticate Part A using updateAAD()
        cipher.updateAAD(dataPartA);

        // Encrypt and tag only Part B
        byte[] encrypted = cipher.doFinal(dataPartB);

        // Print the encrypted data
        System.out.println(Arrays.toString(encrypted));
    }
}