import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;
import java.util.Arrays;

public class Temp2033 {
    private static final int GCM_IV_LENGTH = 12;
    private static final int GCM_TAG_LENGTH = 16;

    public static void main(String[] args) throws Exception {
        // Generate key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey secretKey = keyGen.generateKey();

        // Initialize cipher for encryption
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] iv = new byte[GCM_IV_LENGTH];
        SecureRandom random = new SecureRandom();
        random.nextBytes(iv);
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, iv);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey, gcmParameterSpec);

        // Sample data
        byte[] associatedData = "associatedData".getBytes();
        byte[] plaintext = "Hello, World!".getBytes();

        // Encrypt
        cipher.updateAAD(associatedData);
        byte[] cipherText = cipher.doFinal(plaintext);

        // Concatenate IV and cipherText for transmission
        byte[] ct = concatByteArray(iv, cipherText);

        // Initialize cipher for decryption
        GCMParameterSpec gcmSpec = new GCMParameterSpec(GCM_TAG_LENGTH * 8, Arrays.copyOfRange(ct, 0, GCM_IV_LENGTH));
        cipher.init(Cipher.DECRYPT_MODE, secretKey, gcmSpec);

        // Decrypt
        cipher.updateAAD(associatedData);
        byte[] decryptedText = cipher.doFinal(Arrays.copyOfRange(ct, GCM_IV_LENGTH, ct.length));

        // Output results
        System.out.println("Decrypted text: " + new String(decryptedText));
    }

    private static byte[] concatByteArray(byte[] a, byte[] b) {
        byte[] result = new byte[a.length + b.length];
        System.arraycopy(a, 0, result, 0, a.length);
        System.arraycopy(b, 0, result, a.length, b.length);
        return result;
    }
}