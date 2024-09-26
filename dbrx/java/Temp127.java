import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class Temp127 {
    public static void main(String[] args) throws Exception {
        // Generate a key
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(256);
        SecretKey key = keyGen.generateKey();

        // Generate the IV
        byte[] iv = new SecureRandom().generateSeed(12);
        GCMParameterSpec spec = new GCMParameterSpec(128, iv);

        // Get Cipher instance
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.ENCRYPT_MODE, key, spec);

        // Example AAD
        byte[] aad = "ExampleAAD".getBytes();
        cipher.updateAAD(aad); // aad is your additional authenticated data

        // Example data to encrypt
        byte[] data = "ExampleData".getBytes();
        byte[] encryptedData = cipher.doFinal(data);

        System.out.println("Encrypted data: " + bytesToHex(encryptedData));
    }

    // Helper method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}