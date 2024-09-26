import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Temp128 {
    public static void main(String[] args) throws Exception {
        // Example initialization values for demonstration purposes
        byte[] iv = new byte[12]; // Initialization Vector (IV) - GCM requires 12 bytes
        byte[] keyBytes = new byte[16]; // Secret Key
        byte[] aad = "exampleAAD".getBytes(); // Additional Authenticated Data (AAD)
        byte[] encryptedData = new byte[16]; // Encrypted Data (for demonstration purposes)

        // Initialize IV and Key (in a real application, these should be securely generated)
        GCMParameterSpec spec = new GCMParameterSpec(128, iv); // Use GCMParameterSpec instead of IvParameterSpec
        Key key = new SecretKeySpec(keyBytes, "AES");

        // Initialize Cipher
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        cipher.init(Cipher.DECRYPT_MODE, key, spec);
        cipher.updateAAD(aad); // Set AAD

        // Decrypt Data
        byte[] decryptedData = cipher.doFinal(encryptedData);

        // Print decrypted data (for demonstration purposes)
        System.out.println(new String(decryptedData));
    }
}