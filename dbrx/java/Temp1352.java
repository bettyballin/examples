import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.security.SecureRandom;

public class Temp1352 {
    public static void main(String[] args) throws Exception {
        // Sample data for illustration purposes
        byte[] cipherText = "SampleCipherText".getBytes();
        byte[] tag = "SampleTag".getBytes();

        byte[] combinedInput = new byte[cipherText.length + tag.length];
        System.arraycopy(cipherText, 0, combinedInput, 0, cipherText.length);
        System.arraycopy(tag, 0, combinedInput, cipherText.length, tag.length);

        // Initialize Cipher for decryption (for illustration purposes, using AES/GCM/NoPadding)
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        SecretKey key = generateKey();
        GCMParameterSpec spec = new GCMParameterSpec(128, new byte[12]); // Example IV (should be the same as used in encryption)
        cipher.init(Cipher.DECRYPT_MODE, key, spec);

        byte[] result = cipher.doFinal(combinedInput, 0, cipherText.length);
        System.out.println(new String(result));
    }

    private static SecretKey generateKey() throws Exception {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        return keyGen.generateKey();
    }
}